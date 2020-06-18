package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class DecBTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should decrement`() {
        val registers = Registers(b = 1)
        val result = DecB().run(bus, registers)

        assertThat(registers.b, equalTo(0))
        assertThat(registers.f, equalTo(0xC0))
        assertThat(result, equalTo(1))
    }

    @Test
    fun `should decrement underflow`() {
        val registers = Registers(b = 0)
        val result = DecB().run(bus, registers)

        assertThat(registers.b, equalTo(0xFF))
        assertThat(registers.f, equalTo(0x40))
        assertThat(result, equalTo(1))
    }
}
