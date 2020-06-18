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

interface Processor : Attachable {

    fun execute()
}

class GameBoyZ80Processor : Processor {

    private val registers = Registers()

    private var clock = 0

    private lateinit var bus: Bus

    override fun attach(bus: Bus) {
        this.bus = bus
    }

    override fun execute() {
        while (true) {
            val instruction = bus.read(registers.pc++)
            registers.pc = registers.pc.and(0xFFFF)
            clock += OpCodes[instruction].run(bus, registers)
        }
    }
}
