package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.nhaarman.mockitokotlin2.any
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
class LdBNTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should load`() {
        whenever(bus.read(eq(0))).thenReturn(4)

        val registers = Registers()
        val result = LdBN().run(bus, registers)

        assertThat(registers.b, equalTo(4))
        assertThat(registers.pc, equalTo(1))
        assertThat(result, equalTo(2))
    }
}
