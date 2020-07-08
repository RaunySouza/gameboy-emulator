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
        registers.setFlags(registers.a, carry = CarryFlagType.ADD)
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
        registers.setFlags(registers.a, carry = CarryFlagType.ADD)
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
        registers.setFlags(registers.a, carry = CarryFlagType.ADD)
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
        registers.setFlags(registers.a, carry = CarryFlagType.ADD)
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

/**
 * Subtract n from A
 */
class SubNA(
    val supplier: Registers.() -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a -= supplier(registers)
        registers.setFlags(registers.a, subtraction = true, carry = CarryFlagType.SUB)
        registers.a = registers.a and 0xFF
        return 4
    }
}

/**
 * OP - 97
 */
class SubAA : Instruction by SubNA({ a })

/**
 * OP - 90
 */
class SubBA : Instruction by SubNA({ b })

/**
 * OP - 91
 */
class SubCA : Instruction by SubNA({ c })

/**
 * OP - 92
 */
class SubDA : Instruction by SubNA({ d })

/**
 * OP - 93
 */
class SubEA : Instruction by SubNA({ e })

/**
 * OP - 94
 */
class SubHA : Instruction by SubNA({ h })

/**
 * OP - 95
 */
class SubLA : Instruction by SubNA({ l })

/**
 * Subtract n address from A
 */
class SubNnA(
    val supplier: Registers.() -> Int
) : Instruction {
    override fun run(bus: Bus, registers: Registers): Int {
        registers.a -= bus.read(supplier(registers))
        registers.setFlags(registers.a, carry = CarryFlagType.SUB)
        return 8
    }
}

/**
 * OP - 96
 */
class SubHlA : Instruction by SubNnA({ getHl() })

/**
 * OP - D6
 */
class SubPcA : Instruction by SubNnA({ pc++ })

/**
 * Subtract n + Carry flag from A.
 */
class SubcNA(
    val supplier: Registers.() -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a -= supplier(registers)
        registers.a -= if (registers.f and 0x10 == 0) 0 else 1
        registers.setFlags(registers.a, carry = CarryFlagType.SUB)
        return 4
    }
}

/**
 * OP - 9F
 */
class SubcAA : Instruction by SubcNA({ a })

/**
 * OP - 98
 */
class SubcBA : Instruction by SubcNA({ b })

/**
 * OP - 99
 */
class SubcCA : Instruction by SubcNA({ c })

/**
 * OP - 9A
 */
class SubcDA : Instruction by SubcNA({ d })

/**
 * OP - 9B
 */
class SubcEA : Instruction by SubcNA({ e })

/**
 * OP - 9C
 */
class SubcHA : Instruction by SubcNA({ h })

/**
 * OP - 9D
 */
class SubcLA : Instruction by SubcNA({ l })

/**
 * Subtract nn from A with carry
 */
class SubcNnA(
    val supplier: Registers.() -> Int
) : Instruction {

    override fun run(bus: Bus, registers: Registers): Int {
        registers.a -= bus.read(supplier(registers))
        registers.a -= if (registers.f and 0x10 == 0) 0 else 1
        registers.setFlags(registers.a, carry = CarryFlagType.SUB)
        return 8
    }
}

/**
 * OP - 9E
 */
class SubcHlA : Instruction by SubcNnA({ getHl() })

/**
 * OP - DE
 */
class SubcPcA : Instruction by SubcNnA({ pc++ })

/**
 * Logically AND n with A, result in A
 */
class AndNA(
    val supplier: Registers.() -> Int
) : Instruction {
    override fun run(bus: Bus, registers: Registers): Int {
        registers.a = registers.a and supplier(registers)
        registers.a = registers.a and 0xFF
        registers.setFlags(registers.a)
        return 4
    }
}

/**
 * OP - A7
 */
class AndAA : Instruction by AndNA({ a })

/**
 * OP - A0
 */
class AndBA : Instruction by AndNA({ b })

/**
 * OP - A1
 */
class AndCA : Instruction by AndNA({ c })

/**
 * OP - A2
 */
class AndDA : Instruction by AndNA({ d })

/**
 * OP - A3
 */
class AndEA : Instruction by AndNA({ e })

/**
 * OP - A4
 */
class AndHA : Instruction by AndNA({ h })

/**
 * OP - A5
 */
class AndLA : Instruction by AndNA({ l })

/**
 * Logically AND n address with A, result in A
 */
class AndNnA(
    val supplier: Registers.() -> Int
) : Instruction {
    override fun run(bus: Bus, registers: Registers): Int {
        registers.a = registers.a and bus.read(supplier(registers))
        registers.a = registers.a and 0xFF
        registers.setFlags(registers.a)
        return 8
    }
}

/**
 * OP - A6
 */
class AndHlA : Instruction by AndNnA({ getHl() })

/**
 * OP - E6
 */
class AndPcA : Instruction by AndNnA({ pc++ })

/**
 * Logically OR n with A, result in A
 */
class OrNA(
    val supplier: Registers.() -> Int
) : Instruction {
    override fun run(bus: Bus, registers: Registers): Int {
        registers.a = registers.a or supplier(registers)
        registers.a = registers.a and 0xFF
        registers.setFlags(registers.a)
        return 4
    }
}

/**
 * OP - B7
 */
class OrAA : Instruction by OrNA({ a })

/**
 * OP - B0
 */
class OrBA : Instruction by OrNA({ b })

/**
 * OP - B1
 */
class OrCA : Instruction by OrNA({ c })

/**
 * OP - B2
 */
class OrDA : Instruction by OrNA({ d })

/**
 * OP - B3
 */
class OrEA : Instruction by OrNA({ e })

/**
 * OP - B4
 */
class OrHA : Instruction by OrNA({ h })

/**
 * OP - B5
 */
class OrLA : Instruction by OrNA({ l })

/**
 * Logically AND n address with A, result in A
 */
class OrNnA(
    val supplier: Registers.() -> Int
) : Instruction {
    override fun run(bus: Bus, registers: Registers): Int {
        registers.a = registers.a or bus.read(supplier(registers))
        registers.a = registers.a and 0xFF
        registers.setFlags(registers.a)
        return 8
    }
}

/**
 * OP - B6
 */
class OrHlA : Instruction by OrNnA({ getHl() })

/**
 * OP - F6
 */
class OrPcA : Instruction by OrNnA({ pc++ })
