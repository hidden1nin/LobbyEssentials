package com.hiddentech.lobbyessentials.bukkit;

import com.hiddentech.lobbyessentials.LobbyEssentials;
import com.hiddentech.lobbyessentials.bukkit.chat.JoinChat;
import com.hiddentech.lobbyessentials.bukkit.chat.SetSpawn;
import com.hiddentech.lobbyessentials.bukkit.chat.Spawn;
import com.hiddentech.lobbyessentials.bukkit.gui.JoinItems;
import com.hiddentech.lobbyessentials.bukkit.gui.StopDrop;
import com.hiddentech.lobbyessentials.bukkit.player.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class EventManager {
    private final LobbyEssentials plugin;

    public EventManager(LobbyEssentials plugin){
        this.plugin = plugin;
        registerEvents(plugin);
    }

    private void registerEvents(LobbyEssentials plugin) {
        ConfigHandler config = new ConfigHandler(plugin);
        plugin.getServer().getPluginManager().registerEvents(new Health(),this.plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinChat(config),this.plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinItems(),this.plugin);
        plugin.getServer().getPluginManager().registerEvents(new StopDrop(),this.plugin);
        plugin.getServer().getPluginManager().registerEvents(new JoinTP((Location)config.getValue("spawn",new Location(Bukkit.getWorld("world"),0,0,0))),this.plugin);
        AFK AFKTask =new AFK(plugin,config);
        AFKTask.runTaskTimer(plugin,50,100);
        VoidCatch VoidTask = new VoidCatch((Location) config.getValue("spawn",new Location(Bukkit.getWorld("world"),0,0,0)));
        VoidTask.runTaskTimer(plugin,15,40);

        plugin.getCommand("setspawn").setExecutor(new SetSpawn(plugin,config));
        plugin.getCommand("spawn").setExecutor(new Spawn((Location) config.getValue("spawn",new Location(Bukkit.getWorld("world"),0,0,0))));
    }
}
