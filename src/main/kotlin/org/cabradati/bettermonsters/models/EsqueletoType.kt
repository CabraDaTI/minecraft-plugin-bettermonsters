package org.cabradati.bettermonsters.models

enum class EsqueletoType(
    val tipo: String
) {
    NORMAL("normal"),
    TORRE_DE_OSSOS("torre_de_ossos");

    companion object {
        fun entryOf(valor: String): EsqueletoType {
            return values().first { item ->
                item.tipo == valor
            }
        }
    }
}