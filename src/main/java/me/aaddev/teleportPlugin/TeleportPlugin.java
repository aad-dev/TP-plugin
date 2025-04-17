package me.aaddev.teleportPlugin;

import me.aaddev.teleportPlugin.commands.Teleport;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("tp").setExecutor(new Teleport());
    }

}
