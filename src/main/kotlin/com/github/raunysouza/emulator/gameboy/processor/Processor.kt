package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Attachable
import com.github.raunysouza.emulator.gameboy.bus.Bus

data class Registers(
    var a: Int = 0,
    var b: Int = 0,
    var c: Int = 0,
    var d: Int = 0,
    var e: Int = 0,
    var h: Int = 0,
    var l: Int = 0,
    var f: Int = 0, // Flags
    var pc: Int = 0, // Program counter
    var sp: Int = 0 // Stack counter
) {

    fun getBc() = b.shl(8) + c

    fun setBc(bc: Int) {
        b = bc.shr(8).and(0xFF)
        c = bc.and(0xFF)
    }

    fun getDe() = d.shl(8) + e

    fun setDe(de: Int) {
        d = de.shr(8).and(0xFF)
        e = de.and(0xFF)
    }

    fun getHl() = h.shl(8) + l

    fun setHl(hl: Int) {
        h = hl.shr(8).and(0xFF)
        l = hl.and(0xFF)
    }

    fun setFlags(value: Int, subtraction: Boolean = false) {
        f = 0
        if (value == 0) {
            f = f.or(0x80)
        }

        if (subtraction) {
            f = f.or(0x40)
        }
    }
}

data class Clock(
    var cycle: Int = 0,
    var timing: Int = 0
)

interface Processor : Attachable {

    fun execute()
}

class GameBoyZ80Processor : Processor {

    private val registers = Registers()

    private var clock = Clock()

    private lateinit var bus: Bus

    override fun attach(bus: Bus) {
        this.bus = bus
    }

    override fun execute() {
        while (true) {
            val instruction = bus.read(registers.pc++)
            registers.pc = registers.pc.and(0xFFFF)
            clock.cycle += OpCodes[instruction].run(bus, registers)
        }
    }
}
