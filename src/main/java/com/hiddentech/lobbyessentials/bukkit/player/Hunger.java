package com.hiddentech.lobbyessentials.bukkit.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Hunger implements Listener {
    public Hunger(){}
    @EventHandler
    public void playerHunger(FoodLevelChangeEvent event){
        event.getEntity().setFoodLevel(20);
    }
}
