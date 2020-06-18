package com.github.raunysouza.emulator.gameboy.processor

object OpCodes {

    private val instructions: Array<Instruction> = arrayOf(
        // 0
        Nop(), LdBcNn(), LdBcA(), IncBc(), IncB(), DecB(), LdBN(), RlcA(), LdNnSp(), AddHlBc(), LdABC(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 1
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 2
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 3
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 4
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 5
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 6
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 7
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 8
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 9
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // A
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // B
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // C
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // D
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // E
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // F
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop()
    )

    operator fun get(code: Int): Instruction {
        println("Loading instruction 0x${Integer.toHexString(code)}")
        return instructions[code]
    }
}
