package com.github.raunysouza.emulator.gameboy.bus

import java.io.File

interface Attachable {

    fun attach(bus: Bus)
}

interface Addressable : Attachable {

    fun accept(address: Int): Boolean

    fun read(address: Int): Int

    fun write(address: Int, value: Int)
}

interface Bus {

    fun attach(attachable: Attachable)

    fun write(address: Int, value: Int)

    fun read(address: Int): Int
}

class GameBoyBus : Bus {

    private val devices = mutableListOf<Addressable>()

    override fun attach(attachable: Attachable) {
        attachable.attach(this)
        if (attachable is Addressable) {
            devices += attachable
        }
    }

    override fun write(address: Int, value: Int) {
        devices.find { it.accept(address) }?.write(address, value) ?: throw Exception("Address could not be handled")
    }

    override fun read(address: Int): Int {
        return devices.find { it.accept(address) }?.read(address) ?: throw Exception("Address could not be handled")
    }
}
