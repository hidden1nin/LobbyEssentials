package com.hiddentech.lobbyessentials;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.hiddentech.lobbyessentials.bukkit.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new EventManager(this);
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void sendPlayerToServer(Player player, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);
        player.sendPluginMessage(this,"BungeeCord",out.toByteArray());
    }
}
