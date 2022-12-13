package org.cabradati.bettermonsters

import org.bukkit.plugin.java.JavaPlugin
import org.cabradati.bettermonsters.monstros.esqueletos.EsqueletoContainer
import org.cabradati.bettermonsters.utils.MonsterContainer

class App : JavaPlugin() {

    companion object {
        const val ATIVAR_PLUGIN = "plugin.enabled"
        const val ATIVAR_DEBUG = "plugin.debug"
        const val MONSTRO_PREFIX = "monsters."
        const val NAMESPACEKEY_MONSTRO = "plugin.bettermonsters.type"
    }

    override fun onEnable() {

        config.addDefault(ATIVAR_PLUGIN, true)
        config.addDefault(ATIVAR_DEBUG, false)
        config.options().copyDefaults(true)

        val diContainer = DIContainer(
            this,
            server,
            config,
            logger
        )

        val listaContainer = listOf<MonsterContainer>(
            EsqueletoContainer(diContainer)
        )

        listaContainer.forEach { config ->
            config.registerConfig()
        }

        if (config.getBoolean(ATIVAR_PLUGIN)) {

            listaContainer.forEach { config ->
                config.registerEvents()
                config.registerScheculers()
            }

        }

        super.onEnable()
    }

}