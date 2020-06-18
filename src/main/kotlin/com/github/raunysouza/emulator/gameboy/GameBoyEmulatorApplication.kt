package com.github.raunysouza.emulator.gameboy

import com.github.raunysouza.emulator.gameboy.bus.GameBoyBus
import com.github.raunysouza.emulator.gameboy.memory.RomMemory
import com.github.raunysouza.emulator.gameboy.processor.GameBoyZ80Processor
import java.io.File

fun main() {
    val bus = GameBoyBus()
    val processor = GameBoyZ80Processor()
    bus.attach(processor)
    val memory = RomMemory(File("/Users/raunysouza/Downloads/cpu_instrs.gb").readBytes())
    bus.attach(memory)
    processor.execute()
}
