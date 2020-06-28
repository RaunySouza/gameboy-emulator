package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus

/**
 * Add n to A.
 */
class AddNA(
    val supplier: Registers.() -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a += supplier(registers)
        registers.setFlags(registers.a)
        registers.a = registers.a and 0xFF
        return 4
    }
}

/**
 * OP - 87
 */
class AddAA : Instruction by AddNA({ a })

/**
 * OP - 80
 */
class AddBA : Instruction by AddNA({ b })

/**
 * OP - 81
 */
class AddCA : Instruction by AddNA({ c })

/**
 * OP - 82
 */
class AddDA : Instruction by AddNA({ d })

/**
 * OP - 83
 */
class AddEA : Instruction by AddNA({ e })

/**
 * OP - 84
 */
class AddHA : Instruction by AddNA({ h })

/**
 * OP - 85
 */
class AddLA : Instruction by AddNA({ l })

/**
 * Add n address to A
 */
class AddNnA(
    val supplier: Registers.() -> Int
) : Instruction {
    override fun run(bus: Bus, registers: Registers): Int {
        registers.a += bus.read(supplier(registers))
        registers.setFlags(registers.a)
        return 8
    }
}

/**
 * OP - 86
 */
class AddHlA : Instruction by AddNnA({ getHl() })

/**
 * OP - C6
 */
class AddPcA : Instruction by AddNnA({ pc++ })
