package com.willfp.libreforge.internal.integrations.aureliumskills

import com.willfp.eco.core.integrations.Integration
import com.willfp.libreforge.api.effects.Effect

object AureliumSkillsIntegration : Integration {
    private lateinit var ADD_STAT: Effect

    fun load() {
        ADD_STAT = EffectAddStat()
    }

    override fun getPluginName(): String {
        return "AureliumSkills"
    }
}