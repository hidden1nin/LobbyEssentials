package com.hiddentech.lobbyessentials.bukkit.chat;

import com.hiddentech.lobbyessentials.bukkit.ConfigHandler;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class JoinChat implements Listener {
    private ConfigHandler config;
    private final ArrayList<String> defaultText = new ArrayList<String>(){{
        add("&7Welcome to our server!");
        add("&7We are making more features!");
    }};

    public JoinChat(ConfigHandler config){
        this.config = config;
    }
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event){
        for(String line: (ArrayList<String>)this.config.getValue("WelcomeMSG",this.defaultText)){
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',line));
        }
    }
}
