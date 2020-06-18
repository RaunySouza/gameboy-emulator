package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class AddHlBcTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should add bc to hl`() {
        val registers = Registers(h = 0x42, l = 0x42, b = 0x11, c = 0x11)
        val result = AddHlBc().run(bus, registers)
        assertThat(registers.h, equalTo(0x53))
        assertThat(registers.l, equalTo(0x53))
        assertThat(registers.f, equalTo(0x0))
    }

    @Test
    fun `should overflow`() {
        val registers = Registers(h = 0xFF, l = 0xFF, b = 0x1, c = 0x1)
        val result = AddHlBc().run(bus, registers)
        assertThat(registers.h, equalTo(0x1))
        assertThat(registers.l, equalTo(0x0))
        assertThat(registers.f, equalTo(0x10))
    }
}
