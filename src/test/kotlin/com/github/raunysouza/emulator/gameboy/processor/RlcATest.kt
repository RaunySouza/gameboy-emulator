package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RlcATest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should rotate a into carry`() {
        val registers = Registers(a = 0xE0)
        val result = RlcA().run(bus, registers)

        assertThat(registers.f, equalTo(0x10))
        assertThat(registers.a, equalTo(0xC1))
        assertThat(result, equalTo(1))
    }
}
