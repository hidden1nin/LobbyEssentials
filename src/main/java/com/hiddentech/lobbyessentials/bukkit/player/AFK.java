package com.hiddentech.lobbyessentials.bukkit.player;

import com.hiddentech.lobbyessentials.LobbyEssentials;
import com.hiddentech.lobbyessentials.bukkit.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class AFK extends BukkitRunnable implements Listener {
    private final LobbyEssentials plugin;
    private final Long afkTime;
    private final String serverName;
    private final Boolean serverEnabled;

    public AFK(LobbyEssentials plugin, ConfigHandler config){
        this.plugin = plugin;
        this.afkTime = Long.valueOf((Integer) config.getValue("AFKTime",30L));
        this.serverName = (String) config.getValue("AFKServerName","limbo");
        this.serverEnabled = (Boolean) config.getValue("AFKServerEnabled",true);
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }
    HashMap<UUID, TimedLocation> locations = new HashMap<>();
    @Override
    public void run() {
        for(Player player:Bukkit.getServer().getOnlinePlayers()){
            if(!locations.containsKey(player.getUniqueId())){
                locations.put(player.getUniqueId(),new TimedLocation(player.getLocation(),System.currentTimeMillis()));
                continue;
            }
            TimedLocation time = locations.get(player.getUniqueId());
            if(!time.getLocation().equals(player.getLocation())){
                time.setLocation(player.getLocation());
                time.setMillis(System.currentTimeMillis());
            }
            if((System.currentTimeMillis()-time.getMillis())>(this.afkTime*1000)&&this.serverEnabled){
                player.sendMessage(ChatColor.RED+"You are being sent to Limbo!");
                plugin.sendPlayerToServer(player,serverName);
                locations.remove(player.getUniqueId());
            }
        }
    }
    @EventHandler
    public void PlayerLeave(PlayerQuitEvent event){
        locations.remove(event.getPlayer().getUniqueId());
    }
}

class TimedLocation{
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getMillis() {
        return millis;
    }

    public void setMillis(Long millis) {
        this.millis = millis;
    }

    Location location;
    Long millis;
    public TimedLocation(Location location,Long millis){
        this.location = location;
        this.millis = millis;
    }
}
