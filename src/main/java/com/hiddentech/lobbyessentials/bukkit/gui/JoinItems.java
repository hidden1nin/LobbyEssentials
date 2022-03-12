package com.hiddentech.lobbyessentials.bukkit.gui;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinItems implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        event.getPlayer().getInventory().setContents(new ItemStack[0]);
        event.getPlayer().setCanPickupItems(false);
        event.getPlayer().getInventory().setItem(4,new ItemStack(Material.SPONGE));
        event.getPlayer().getInventory().setHeldItemSlot(4);
    }
}
