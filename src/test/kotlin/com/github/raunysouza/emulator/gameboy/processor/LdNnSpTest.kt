package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LdNnSpTest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should load into sp`() {
        val registers = Registers(sp = 0x6AA5)
        val result = LdNnSp().run(bus, registers)

        val spCaptor = argumentCaptor<Int>()
        verify(bus, times(2)).write(any(), spCaptor.capture())

        assertThat(spCaptor.firstValue, equalTo(0xA5))
        assertThat(spCaptor.secondValue, equalTo(0x6A))
        assertThat(registers.pc, equalTo(2))

        assertThat(result, equalTo(3))
    }
}
