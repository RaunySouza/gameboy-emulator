package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus

interface Instruction {

    fun run(bus: Bus, registers: Registers): Int
}

class Nop : Instruction {

    override fun run(bus: Bus, registers: Registers): Int = 1
}

class LdBcNn : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.b = bus.read(registers.pc++)
        registers.c = bus.read(registers.pc++)
        return 3
    }
}

class LdBcA : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        val b = registers.b
        val c = registers.c
        val address = b.shl(8).or(c)
        bus.write(address, registers.a)
        return 2
    }
}

class IncBc : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.b = registers.b.inc().and(0xFF)
        registers.c = registers.c.inc().and(0xFF)
        return 1
    }
}

class IncB : Instruction {
    override fun run(bus: Bus, registers: Registers): Int {
        registers.b = registers.b.inc().and(0xFF)
        registers.setFlags(registers.b)
        return 1
    }
}

class DecB : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.b = registers.b.dec().and(0xFF)
        registers.setFlags(registers.b, true)
        return 1
    }
}

class LdBN : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.b = bus.read(registers.pc++)
        return 2
    }
}

class RlcA : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        val shiftedOutBit = registers.a.and(0x80).shr(7)
        registers.a = registers.a.shl(1).or(shiftedOutBit).and(0xFF)
        val carryBit = registers.a.and(0x40)
        registers.f = registers.f.or(carryBit.shr(2))
        return 1
    }
}

//XXX Not sure if it is the correct implementation
class LdNnSp : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        bus.write(registers.pc++, registers.sp.and(0xFF))
        bus.write(registers.pc++, registers.sp.shr(8))
        return 3
    }
}

class AddHlBc : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        var hl = registers.h.shl(8) + registers.l
        hl += registers.b.shl(8) + registers.c
        registers.f = if (hl > 0xFFFF) {
            registers.f.or(0x10)
        } else {
            registers.f.and(0xEF)
        }
        registers.h = hl.shr(8).and(0xFF)
        registers.l = hl.and(0xFF)
        return 3
    }
}

class LdABC : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a = bus.read(registers.b.shl(8) + registers.c)
        return 2
    }
}

class DecBC : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        var bc = registers.b.shl(8) + registers.c
        bc -= 1
        registers.b = bc.shr(8).and(0xFF)
        registers.c = bc.and(0xFF)
        return 1
    }
}
