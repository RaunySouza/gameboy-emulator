package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus

/**
 * Put value nn (16 bit immediate value) into n (BC, DE, HL)
 */
class LdNnN(
    val lConsumer: (Registers, Int) -> Unit,
    val rConsumer: (Registers, Int) -> Unit
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        lConsumer(registers, bus.read(registers.pc++))
        rConsumer(registers, bus.read(registers.pc++))
        return 3
    }
}

/**
 * OP - 01
 */
class LoadBcNn : Instruction by LdNnN({ r, v -> r.b = v }, { r, v -> r.c = v })

/**
 * OP - 11
 */
class LoadDeNn : Instruction by LdNnN({ r, v -> r.d = v }, { r, v -> r.e = v })

/**
 * OP - 21
 */
class LoadHlNn : Instruction by LdNnN({ r, v -> r.h = v }, { r, v -> r.l = v })

/**
 * Put HL into Stack Pointer (SP).
 *
 * OP - F9
 */
class LoadHlSp : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.sp = registers.getHl()
        return 8
    }
}

/**
 * Put SP + n effective address into HL.
 *
 * OP - F8
 */
class LoadSpnHl : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        var n = bus.read(registers.pc++)
        if (n > 0x7F) {
            n = -((n.inv() + 1) and 0xFF)
        }
        n += registers.sp
        registers.setHl(n)
        return 12
    }
}

/**
 * Put Stack Pointer (SP) at address n.
 *
 * OP - 08
 */
class LoadSpNn : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        bus.write(registers.pc++, registers.sp.and(0xFF))
        bus.write(registers.pc++, registers.sp.shr(8))
        return 20
    }
}

/**
 * Push register pair nn onto stack.
 * Decrement Stack Pointer (SP) twice.
 */
class PushNn(
    val lSupplier: Registers.() -> Int,
    val rSupplier: Registers.() -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        bus.write(--registers.sp, lSupplier(registers))
        bus.write(--registers.sp, rSupplier(registers))
        return 16
    }
}

/**
 * OP - F5
 */
class PushAF : Instruction by PushNn({ a }, { f })

/**
 * OP - C5
 */
class PushBC : Instruction by PushNn({ b }, { c })

/**
 * OP - D5
 */
class PushDE : Instruction by PushNn({ d }, { e })

/**
 * OP - E5
 */
class PushHL : Instruction by PushNn({ h }, { l })

/**
 * Pop two bytes off stack into register pair nn.
 * Increment Stack Pointer (SP) twice.
 */
class PopNn(
    val lConsumer: (Registers, Int) -> Unit,
    val rConsumer: (Registers, Int) -> Unit
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        lConsumer(registers, bus.read(registers.sp++))
        rConsumer(registers, bus.read(registers.sp++))
        return 12
    }
}

/**
 * OP - F1
 */
class PopAF : Instruction by PopNn({ r, v -> r.a = v }, { r, v -> r.f = v })

/**
 * OP - C1
 */
class PopBC : Instruction by PopNn({ r, v -> r.b = v }, { r, v -> r.c = v })

/**
 * OP - D1
 */
class PopDE : Instruction by PopNn({ r, v -> r.d = v }, { r, v -> r.e = v })

/**
 * OP - E1
 */
class PopHL : Instruction by PopNn({ r, v -> r.h = v }, { r, v -> r.l = v })
