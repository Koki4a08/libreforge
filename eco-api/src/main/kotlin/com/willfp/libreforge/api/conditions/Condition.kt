package com.willfp.libreforge.api.conditions

import com.willfp.eco.core.config.interfaces.JSONConfig
import com.willfp.libreforge.api.ConfigurableProperty
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import java.util.Objects

abstract class Condition(
    id: String
) : ConfigurableProperty(id), Listener {
    init {
        postInit()
    }

    private fun postInit() {
        Conditions.addNewCondition(this)
    }

    /**
     * Get if condition is met for a player.
     *
     * @param player The player.
     * @param config The config of the condition.
     * @return If met.
     */
    abstract fun isConditionMet(
        player: Player,
        config: JSONConfig
    ): Boolean
}