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

/**
 * Add n + Carry flag to A.
 */
class AdcNA(
    val supplier: Registers.() -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a += supplier(registers)
        registers.a += if (registers.f and 0x10 == 0) 0 else 1
        registers.setFlags(registers.a)
        return 4
    }
}

/**
 * OP - 8F
 */
class AdcAA : Instruction by AdcNA({ a })

/**
 * OP - 88
 */
class AdcBA : Instruction by AdcNA({ b })

/**
 * OP - 89
 */
class AdcCA : Instruction by AdcNA({ c })

/**
 * OP - 8A
 */
class AdcDA : Instruction by AdcNA({ d })

/**
 * OP - 8B
 */
class AdcEA : Instruction by AdcNA({ e })

/**
 * OP - 8C
 */
class AdcHA : Instruction by AdcNA({ h })

/**
 * OP - 8D
 */
class AdcLA : Instruction by AdcNA({ l })

/**
 * Add nn to A with carry
 */
class AdcNnA(
    val supplier: Registers.() -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a += bus.read(supplier(registers))
        registers.a += if (registers.f and 0x10 == 0) 0 else 1
        registers.setFlags(registers.a)
        return 8
    }
}

/**
 * OP - 8E
 */
class AdcHlA : Instruction by AdcNnA({ getHl() })

/**
 * OP - CE
 */
class AdcPcA : Instruction by AdcNnA({ pc++ })
