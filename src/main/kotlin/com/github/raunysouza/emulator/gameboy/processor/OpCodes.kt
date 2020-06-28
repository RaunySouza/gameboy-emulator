package com.github.raunysouza.emulator.gameboy.processor

object OpCodes {

    private val instructions: Array<Instruction> = arrayOf(
        // 0
        Nop(), LoadBcNn(), LoadBcA(), IncBc(), IncB(), DecB(), LoadBN(), RlcA(), LoadSpNn(), AddHlBc(), LoadABc(), Nop(), Nop(), Nop(), LoadCN(), Nop(),
        // 1
        Nop(), LoadDeNn(), LoadDeA(), Nop(), Nop(), Nop(), LoadDN(), Nop(), Nop(), Nop(), LoadADe(), Nop(), Nop(), Nop(), LoadEN(), Nop(),
        // 2
        Nop(), LoadHlNn(), LoadAHlInc(), Nop(), Nop(), Nop(), LoadHN(), Nop(), Nop(), Nop(), LoadHlAInc(), Nop(), Nop(), Nop(), LoadLN(), Nop(),
        // 3
        Nop(), Nop(), LoadAHlDec(), Nop(), Nop(), Nop(), LoadNnR16(), Nop(), Nop(), Nop(), LoadHlADec(), Nop(), Nop(), Nop(), LoadAN(), Nop(),
        // 4
        LoadBB(), LoadBC(), LoadBD(), LoadBE(), LoadBH(), LoadBL(), LoadBHl(), LoadBA(), LoadCB(), LoadCC(), LoadCD(), LoadCE(), LoadCH(), LoadCL(), LoadCHl(), LoadCA(),
        // 5
        LoadDB(), LoadDC(), LoadDD(), LoadDE(), LoadDH(), LoadDL(), LoadDHl(), LoadDA(), LoadEB(), LoadEC(), LoadED(), LoadEE(), LoadEH(), LoadEL(), LoadEHl(), LoadEA(),
        // 6
        LoadHB(), LoadHC(), LoadHD(), LoadHE(), LoadHH(), LoadHL(), LoadHHl(), LoadHA(), LoadLB(), LoadLC(), LoadLD(), LoadLE(), LoadLH(), LoadLL(), LoadLHl(), LoadLA(),
        // 7
        LoadHlB(), LoadHlC(), LoadHlD(), LoadHlE(), LoadHlH(), LoadHlL(), Nop(), LoadHlA(), LoadAB(), LoadAC(), LoadAD(), LoadAE(), LoadAH(), LoadAL(), LoadAHl(), LoadAA(),
        // 8
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // 9
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // A
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // B
        Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // C
        Nop(), PopBC(), Nop(), Nop(), Nop(), PushBC(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // D
        Nop(), PopDE(), Nop(), Nop(), Nop(), PushDE(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // E
        LoadAHn(), PopHL(), LoadNcA(), Nop(), Nop(), PushHL(), Nop(), Nop(), Nop(), Nop(), LoadANn(), Nop(), Nop(), Nop(), Nop(), Nop(),
        // F
        LoadHnA(), PopAF(), LoadANc(), Nop(), Nop(), PushAF(), Nop(), Nop(), LoadSpnHl(), LoadHlSp(), LoadNnA(), Nop(), Nop(), Nop(), Nop(), Nop()
    )

    operator fun get(code: Int): Instruction {
        println("Loading instruction 0x${Integer.toHexString(code)}")
        return instructions[code]
    }
}
