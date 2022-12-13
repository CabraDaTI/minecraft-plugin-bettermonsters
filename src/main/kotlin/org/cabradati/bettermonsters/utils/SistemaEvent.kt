package org.cabradati.bettermonsters.utils

interface SistemaEvent<T> {

    fun on(event: T)

}