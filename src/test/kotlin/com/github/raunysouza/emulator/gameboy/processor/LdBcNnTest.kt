package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.whenever
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LdBcNnTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should load`() {
        whenever(bus.read(eq(0))).thenReturn(1)
        whenever(bus.read(eq(1))).thenReturn(2)

        val registers = Registers()
        val result = LdBcNn().run(bus, registers)

        assertThat(registers.b, equalTo(1))
        assertThat(registers.c, equalTo(2))
        assertThat(registers.pc, equalTo(2))
        assertThat(result, equalTo(3))
    }
}
