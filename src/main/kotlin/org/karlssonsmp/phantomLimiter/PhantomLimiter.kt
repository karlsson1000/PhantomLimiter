package org.karlssonsmp.phantomLimiter

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.entity.EntityType
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import java.util.concurrent.ThreadLocalRandom
import org.bstats.bukkit.Metrics

class PhantomLimiter : JavaPlugin(), Listener {

    @Volatile
    private var spawnRate: Double = 0.25

    private val prefix = "§9§lᴘʜᴀɴᴛᴏᴍʟɪᴍɪᴛᴇʀ §7» §r"

    override fun onEnable() {
        saveDefaultConfig()

        spawnRate = config.getDouble("phantom-spawn-rate", 0.25).coerceIn(0.0, 1.0)
        val metricsEnabled = config.getBoolean("metrics", true)

        server.pluginManager.registerEvents(this, this)

        if (metricsEnabled) {
            val pluginId = 26883
            Metrics(this, pluginId)
        }

        logger.info("PhantomLimiter enabled! Phantom spawn rate set to ${(spawnRate * 100).toInt()}%.")
    }

    override fun onDisable() {
        logger.info("PhantomLimiter disabled!")
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    fun onPhantomSpawn(event: CreatureSpawnEvent) {
        if (event.entityType != EntityType.PHANTOM) return

        val validReasons = setOf(
            CreatureSpawnEvent.SpawnReason.NATURAL,
            CreatureSpawnEvent.SpawnReason.PATROL
        )

        if (event.spawnReason !in validReasons) return

        if (ThreadLocalRandom.current().nextDouble() > spawnRate) {
            event.isCancelled = true
        }
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (command.name.equals("phantomlimiter", ignoreCase = true)) {
            if (args.isNotEmpty() && args[0].equals("reload", ignoreCase = true)) {
                if (!sender.hasPermission("phantomlimiter.reload")) {
                    sender.sendMessage("${prefix}§cYou don't have permission to do that.")
                    return true
                }

                reloadConfig()
                spawnRate = config.getDouble("phantom-spawn-rate", 0.25).coerceIn(0.0, 1.0)
                sender.sendMessage("${prefix}§aConfig reloaded! Spawn rate: ${(spawnRate * 100).toInt()}%")
                return true
            } else {
                sender.sendMessage("${prefix}§7Usage: /phantomlimiter reload")
                return true
            }
        }
        return false
    }
}