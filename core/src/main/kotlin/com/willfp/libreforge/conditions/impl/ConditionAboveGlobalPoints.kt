package com.willfp.libreforge.conditions.impl

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.libreforge.NoCompileData
import com.willfp.libreforge.arguments
import com.willfp.libreforge.conditions.Condition
import com.willfp.libreforge.globalPoints
import org.bukkit.entity.Player

object ConditionAboveGlobalPoints : Condition<NoCompileData>("above_global_points") {
    override val arguments = arguments {
        require("type", "You must specify the type of points!")
        require("amount", "You must specify the minimum amount of points!")
    }

    override fun isMet(player: Player, config: Config, compileData: NoCompileData): Boolean {
        return globalPoints[config.getString("type")] >= config.getDoubleFromExpression("amount", player)
    }
}
