package com.hiddentech.lobbyessentials.bukkit.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Health implements Listener {
    public Health(){}
    @EventHandler
    public void playerDamage(EntityDamageEvent event){
        event.setCancelled(true);
    }
}
