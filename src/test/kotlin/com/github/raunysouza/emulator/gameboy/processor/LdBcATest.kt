package com.github.raunysouza.emulator.gameboy.processor

import com.github.raunysouza.emulator.gameboy.bus.Bus
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LdBcATest {

    @Mock
    lateinit var bus: Bus

    @Test
    fun `should save a at bc address`() {
        val result = LdBcA().run(bus, Registers(a = 0x7F, b = 0xFF, c = 0xff))

        val addressCaptor = argumentCaptor<Int>()
        val valueCaptor = argumentCaptor<Int>()
        verify(bus).write(addressCaptor.capture(), valueCaptor.capture())

        assertThat(addressCaptor.firstValue, equalTo(0xFFFF))
        assertThat(valueCaptor.firstValue, equalTo(0x7F))
        assertThat(result, equalTo(2))
    }
}
