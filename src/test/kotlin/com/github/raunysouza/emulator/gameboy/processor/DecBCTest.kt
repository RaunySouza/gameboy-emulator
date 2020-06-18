package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class DecBCTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should decrement bc`() {
        val registers = Registers(b = 0x2A, c = 0)
        DecBC().run(bus, registers)
        assertThat(registers.b, equalTo(0x29))
        assertThat(registers.c, equalTo(0xFF))
    }
}
