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
        registers.sp = registers.h.shl(8) + registers.l
        return 8
    }
}
