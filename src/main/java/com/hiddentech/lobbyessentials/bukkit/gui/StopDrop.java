package com.hiddentech.lobbyessentials.bukkit.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class StopDrop implements Listener {
    @EventHandler
    public void playerDropItem(PlayerDropItemEvent event){
        event.setCancelled(true);
    }
}
