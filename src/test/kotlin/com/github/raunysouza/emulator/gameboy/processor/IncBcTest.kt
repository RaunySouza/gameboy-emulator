package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class IncBcTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should increment`() {
        val registers = Registers(b = 0, c = 0)
        val result = IncBc().run(bus, registers)
        assertThat(registers.b, equalTo(1))
        assertThat(registers.c, equalTo(1))
        assertThat(result, equalTo(1))
    }

    @Test
    fun `should overflow`() {
        val registers = Registers(b = 255, c = 255)
        val result = IncBc().run(bus, registers)
        assertThat(registers.b, equalTo(0))
        assertThat(registers.c, equalTo(0))
        assertThat(result, equalTo(1))
    }
}
