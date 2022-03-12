package com.hiddentech.lobbyessentials.bukkit.player;

import com.hiddentech.lobbyessentials.bukkit.ConfigHandler;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class JoinTP implements Listener {
    private final Location spawn;


    public JoinTP(Location spawn){
        this.spawn = spawn;
    }
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event){
        event.getPlayer().teleport(spawn);
        event.getPlayer().setFoodLevel(20);
    }
}
