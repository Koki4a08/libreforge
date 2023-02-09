package com.willfp.libreforge.triggers.impl

import com.willfp.libreforge.triggers.Trigger
import com.willfp.libreforge.triggers.TriggerData
import com.willfp.libreforge.triggers.TriggerParameter
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.inventory.CraftItemEvent

object TriggerCraft : Trigger("craft") {
    override val parameters = setOf(
        TriggerParameter.PLAYER,
        TriggerParameter.LOCATION,
        TriggerParameter.ITEM
    )

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    fun handle(event: CraftItemEvent) {
        if (event.result == Event.Result.DENY) {
            return
        }

        val player = event.whoClicked as? Player ?: return
        val item = event.recipe.result

        this.dispatch(
            player,
            TriggerData(
                player = player,
                item = item
            )
        )
    }
}