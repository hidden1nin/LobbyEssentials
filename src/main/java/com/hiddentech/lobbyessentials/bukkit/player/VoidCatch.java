package com.hiddentech.lobbyessentials.bukkit.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class VoidCatch extends BukkitRunnable {
    private final Location spawn;
    private final double minY;

    public VoidCatch(Location spawn){
        this.spawn = spawn;
        minY = spawn.getY()-50;
    }
    @Override
    public void run() {
        for(Player player: Bukkit.getOnlinePlayers()){
            if(player.getLocation().getY()<this.minY){
                player.teleport(this.spawn);
            }
        }
    }
}
