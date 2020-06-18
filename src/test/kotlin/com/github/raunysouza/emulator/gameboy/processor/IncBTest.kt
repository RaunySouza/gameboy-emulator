package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class IncBTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should increment`() {
        val registers = Registers(b = 1)
        val result = IncB().run(bus, registers)

        assertThat(registers.b, equalTo(2))
        assertThat(registers.f, equalTo(0))
        assertThat(result, equalTo(1))
    }

    @Test
    fun `should increment overflow`() {
        val registers = Registers(b = 255)
        val result = IncB().run(bus, registers)

        assertThat(registers.b, equalTo(0))
        assertThat(registers.f, equalTo(0x80))
        assertThat(result, equalTo(1))
    }
}
