package com.willfp.libreforge.api.triggers

import org.bukkit.block.Block
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

data class TriggerData(
    val player: Player? = null,
    val victim: LivingEntity? = null,
    val block: Block? = null,
    val event: WrappedEvent<*>? = null
)