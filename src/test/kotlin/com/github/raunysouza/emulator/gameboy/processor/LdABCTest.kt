package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LdABCTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should load bc into a`() {
        whenever(bus.read(eq(0x4418))).thenReturn(0x10)
        val registers = Registers(b = 0x44, c = 0x18)
        val result = LdABC().run(bus, registers)
        assertThat(registers.a, equalTo(0x10))
        assertThat(result, equalTo(2))
    }
}
