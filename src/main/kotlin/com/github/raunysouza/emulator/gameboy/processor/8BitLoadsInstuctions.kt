package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus

/**
 * Put value nn (immediate) into r8 (8-bit register)
 */
class LoadNnR8(
    val consumer: (Registers, Int) -> Unit
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        consumer(registers, bus.read(registers.pc++))
        return 8
    }
}

/**
 * OP - 3E
 */
class LoadAN : Instruction by LoadNnR8({ r, v -> r.a = v })

/**
 * OP - 06
 */
class LoadBN : Instruction by LoadNnR8({ r, v -> r.b = v })

/**
 * OP - 0E
 */
class LoadCN : Instruction by LoadNnR8({ r, v -> r.c = v })

/**
 * OP - 16
 */
class LoadDN : Instruction by LoadNnR8({ r, v -> r.d = v })

/**
 * OP - 1E
 */
class LoadEN : Instruction by LoadNnR8({ r, v -> r.e = v })

/**
 * OP - 26
 */
class LoadHN : Instruction by LoadNnR8({ r, v -> r.h = v })

/**
 * OP - 2E
 */
class LoadLN : Instruction by LoadNnR8({ r, v -> r.l = v })


/**
 * Put value R8 (8-bit register) into R8 (8-bit register)
 */
class LoadR8R8(
    val consumer: (Registers) -> Unit
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        consumer(registers)
        return 4
    }
}

/**
 * OP - 7F
 */
class LoadAA : Instruction by LoadR8R8({ })

/**
 * OP - 78
 */
class LoadAB : Instruction by LoadR8R8({ r -> r.a = r.b })

/**
 * OP - 79
 */
class LoadAC : Instruction by LoadR8R8({ r -> r.a = r.c })

/**
 * OP - 7A
 */
class LoadAD : Instruction by LoadR8R8({ r -> r.a = r.d })

/**
 * OP - 7B
 */
class LoadAE : Instruction by LoadR8R8({ r -> r.a = r.e })

/**
 * OP - 7C
 */
class LoadAH : Instruction by LoadR8R8({ r -> r.a = r.h })

/**
 * OP - 7D
 */
class LoadAL : Instruction by LoadR8R8({ r -> r.a = r.l })

/**
 * OP - 47
 */
class LoadBA : Instruction by LoadR8R8({ r -> r.b = r.a })

/**
 * OP - 40
 */
class LoadBB : Instruction by LoadR8R8({ })

/**
 * OP - 41
 */
class LoadBC : Instruction by LoadR8R8({ r -> r.b = r.c })

/**
 * OP - 42
 */
class LoadBD : Instruction by LoadR8R8({ r -> r.b = r.d })

/**
 * OP - 43
 */
class LoadBE : Instruction by LoadR8R8({ r -> r.b = r.e })

/**
 * OP - 44
 */
class LoadBH : Instruction by LoadR8R8({ r -> r.b = r.h })

/**
 * OP - 45
 */
class LoadBL : Instruction by LoadR8R8({ r -> r.b = r.l })

/**
 * OP - 4F
 */
class LoadCA : Instruction by LoadR8R8({ r -> r.c = r.a })

/**
 * OP - 48
 */
class LoadCB : Instruction by LoadR8R8({ r -> r.c = r.b })

/**
 * OP - 49
 */
class LoadCC : Instruction by LoadR8R8({ })

/**
 * OP - 4A
 */
class LoadCD : Instruction by LoadR8R8({ r -> r.c = r.d })

/**
 * OP - 4B
 */
class LoadCE : Instruction by LoadR8R8({ r -> r.c = r.e })

/**
 * OP - 4C
 */
class LoadCH : Instruction by LoadR8R8({ r -> r.c = r.h })

/**
 * OP - 4D
 */
class LoadCL : Instruction by LoadR8R8({ r -> r.c = r.l })

/**
 * OP - 57
 */
class LoadDA : Instruction by LoadR8R8({ r -> r.d = r.a })

/**
 * OP - 50
 */
class LoadDB : Instruction by LoadR8R8({ r -> r.d = r.b })

/**
 * OP - 51
 */
class LoadDC : Instruction by LoadR8R8({ r -> r.d = r.c })

/**
 * OP - 52
 */
class LoadDD : Instruction by LoadR8R8({ })

/**
 * OP - 53
 */
class LoadDE : Instruction by LoadR8R8({ r -> r.d = r.e })

/**
 * OP - 54
 */
class LoadDH : Instruction by LoadR8R8({ r -> r.d = r.h })

/**
 * OP - 55
 */
class LoadDL : Instruction by LoadR8R8({ r -> r.d = r.l })

/**
 * OP - 5F
 */
class LoadEA : Instruction by LoadR8R8({ r -> r.e = r.a })

/**
 * OP - 58
 */
class LoadEB : Instruction by LoadR8R8({ r -> r.e = r.b })

/**
 * OP - 59
 */
class LoadEC : Instruction by LoadR8R8({ r -> r.e = r.c })

/**
 * OP - 5A
 */
class LoadED : Instruction by LoadR8R8({ r -> r.e = r.d })

/**
 * OP - 5B
 */
class LoadEE : Instruction by LoadR8R8({ })

/**
 * OP - 5C
 */
class LoadEH : Instruction by LoadR8R8({ r -> r.e = r.h })

/**
 * OP - 5D
 */
class LoadEL : Instruction by LoadR8R8({ r -> r.e = r.l })

/**
 * OP - 67
 */
class LoadHA : Instruction by LoadR8R8({ r -> r.h = r.a })

/**
 * OP - 60
 */
class LoadHB : Instruction by LoadR8R8({ r -> r.h = r.b })

/**
 * OP - 61
 */
class LoadHC : Instruction by LoadR8R8({ r -> r.h = r.c })

/**
 * OP - 62
 */
class LoadHD : Instruction by LoadR8R8({ r -> r.h = r.d })

/**
 * OP - 63
 */
class LoadHE : Instruction by LoadR8R8({ r -> r.h = r.e })

/**
 * OP - 64
 */
class LoadHH : Instruction by LoadR8R8({ })

/**
 * OP - 65
 */
class LoadHL : Instruction by LoadR8R8({ r -> r.h = r.l })

/**
 * OP - 6F
 */
class LoadLA : Instruction by LoadR8R8({ r -> r.l = r.a })

/**
 * OP - 68
 */
class LoadLB : Instruction by LoadR8R8({ r -> r.l = r.b })

/**
 * OP - 69
 */
class LoadLC : Instruction by LoadR8R8({ r -> r.l = r.c })

/**
 * OP - 6A
 */
class LoadLD : Instruction by LoadR8R8({ r -> r.l = r.d })

/**
 * OP - 6B
 */
class LoadLE : Instruction by LoadR8R8({ r -> r.l = r.e })

/**
 * OP - 6C
 */
class LoadLH : Instruction by LoadR8R8({ r -> r.l = r.h })

/**
 * OP - 6D
 */
class LoadLL : Instruction by LoadR8R8({ })

/**
 * Put value R16 into R8 (8-bit register)
 */
class LoadR16R8(
    val consumer: (Registers, Int) -> Unit,
    val lSupplier: (Registers) -> Int,
    val rSupplier: (Registers) -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        consumer(registers, bus.read(lSupplier(registers).shl(8) + rSupplier(registers)))
        return 8
    }
}

/**
 * OP - 7E
 */
class LoadAHl : Instruction by LoadR16R8({ r, v -> r.a = v }, Registers::h, Registers::l)

/**
 * OP - 0A
 */
class LoadABc : Instruction by LoadR16R8({ r, v -> r.a = v }, Registers::b, Registers::c)

/**
 * OP - 1A
 */
class LoadADe : Instruction by LoadR16R8({ r, v -> r.a = v }, Registers::d, Registers::e)

/**
 * OP - F2
 */
class LoadANc : Instruction by LoadR16R8({ r, v -> r.a = v }, { 0xFF }, Registers::c)

/**
 * OP - 46
 */
class LoadBHl : Instruction by LoadR16R8({ r, v -> r.b = v }, Registers::h, Registers::l)

/**
 * OP - 4E
 */
class LoadCHl : Instruction by LoadR16R8({ r, v -> r.c = v }, Registers::h, Registers::l)

/**
 * OP - 56
 */
class LoadDHl : Instruction by LoadR16R8({ r, v -> r.d = v }, Registers::h, Registers::l)

/**
 * OP - 5E
 */
class LoadEHl : Instruction by LoadR16R8({ r, v -> r.e = v }, Registers::h, Registers::l)

/**
 * OP - 66
 */
class LoadHHl : Instruction by LoadR16R8({ r, v -> r.h = v }, Registers::h, Registers::l)

/**
 * OP - 6E
 */
class LoadLHl : Instruction by LoadR16R8({ r, v -> r.l = v }, Registers::h, Registers::l)


/**
 * Put value R8 into R16
 */
class LoadR8R16(
    val supplier: (Registers) -> Int,
    val lSupplier: (Registers) -> Int,
    val rSupplier: (Registers) -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        bus.write(lSupplier(registers).shl(8) + rSupplier(registers), supplier(registers))
        return 8
    }
}

/**
 * OP - 77
 */
class LoadHlA : Instruction by LoadR8R16(Registers::a, Registers::h, Registers::l)

/**
 * OP - 70
 */
class LoadHlB : Instruction by LoadR8R16(Registers::b, Registers::h, Registers::l)

/**
 * OP - 71
 */
class LoadHlC : Instruction by LoadR8R16(Registers::c, Registers::h, Registers::l)

/**
 * OP - 72
 */
class LoadHlD : Instruction by LoadR8R16(Registers::d, Registers::h, Registers::l)

/**
 * OP - 73
 */
class LoadHlE : Instruction by LoadR8R16(Registers::e, Registers::h, Registers::l)

/**
 * OP - 74
 */
class LoadHlH : Instruction by LoadR8R16(Registers::h, Registers::h, Registers::l)

/**
 * OP - 75
 */
class LoadHlL : Instruction by LoadR8R16(Registers::l, Registers::h, Registers::l)

/**
 * OP - 02
 */
class LoadBcA : Instruction by LoadR8R16(Registers::a, Registers::b, Registers::c)

/**
 * OP - E2
 */
class LoadNcA : Instruction by LoadR8R16(Registers::a, { 0xFF }, Registers::c)

/**
 * OP - 12
 */
class LoadDeA : Instruction by LoadR8R16(Registers::a, Registers::d, Registers::e)

/**
 * Put value nn (immediate) into R16
 *
 * OP - 36
 */
class LoadNnR16 : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        bus.write(registers.h.shl(8) + registers.l, bus.read(registers.pc++))
        return 12
    }
}

/**
 * Put value from nn (immediate) address into A.
 * Increments PC twice
 *
 * OP - FA
 */
class LoadNnA : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a = bus.read(bus.read(registers.pc++))
        registers.pc++
        return 16
    }
}

/**
 * Put value from A into nn (immediate) address.
 * Increments PC twice
 *
 * OP - EA
 */
class LoadANn : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        bus.write(bus.read(registers.pc++), registers.a)
        registers.pc++
        return 16
    }
}

/**
 * Put value at address HL into A. Decrement HL.
 *
 * OP - 3A
 */
class LoadHlADec : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        var hl = registers.h.shl(8) + registers.l
        registers.a = bus.read(hl--)
        registers.h = hl.shr(8).and(0xFF)
        registers.l = hl.and(0xFF)
        return 8
    }
}

/**
 * Put A into memory address HL. Decrement HL.
 *
 * OP - 32
 */
class LoadAHlDec : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        var hl = registers.h.shl(8) + registers.l
        bus.write(hl--, registers.a)
        registers.h = hl.shr(8).and(0xFF)
        registers.l = hl.and(0xFF)
        return 8
    }
}

/**
 * Put value at address HL into A. Increment HL.
 *
 * OP - 2A
 */
class LoadHlAInc : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        var hl = registers.h.shl(8) + registers.l
        registers.a = bus.read(hl++)
        registers.h = hl.shr(8).and(0xFF)
        registers.l = hl.and(0xFF)
        return 8
    }
}

/**
 * Put A into memory address HL. Decrement HL.
 *
 * OP - 22
 */
class LoadAHlInc : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        var hl = registers.h.shl(8) + registers.l
        bus.write(hl++, registers.a)
        registers.h = hl.shr(8).and(0xFF)
        registers.l = hl.and(0xFF)
        return 8
    }
}

/**
 * Put A into memory address $FF00+n
 *
 * OP - E0
 */
class LoadAHn : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        bus.write(bus.read(0xFF00 + registers.pc), registers.a)
        registers.pc++
        return 12
    }
}

/**
 * Put memory address $FF00+n into A.
 *
 * OP - F0
 */
class LoadHnA : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a = bus.read(0xFF00 + registers.pc)
        registers.pc++
        return 12
    }
}
