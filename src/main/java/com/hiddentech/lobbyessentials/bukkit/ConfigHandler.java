package com.hiddentech.lobbyessentials.bukkit;

import com.hiddentech.lobbyessentials.LobbyEssentials;

import java.util.HashMap;

public class ConfigHandler {
    HashMap<String,Object> values = new HashMap<>();
    private LobbyEssentials plugin;

    public ConfigHandler(LobbyEssentials plugin){
        this.plugin = plugin;
    }
    public Object getValue(String name,Object defaultValue){
        if(values.containsKey(name)) return values.get(name);
        if(this.plugin.getConfig().get(name)==null){
            saveValue(name,defaultValue);
            return defaultValue;
        }
        return this.plugin.getConfig().get(name);
    }

    public void saveValue(String name, Object defaultValue) {
        if(defaultValue==null)throw new NullPointerException();
        this.plugin.getConfig().set(name,defaultValue);
        this.plugin.saveConfig();
    }
}
