package com.hiddentech.lobbyessentials.bukkit.chat;

import com.hiddentech.lobbyessentials.LobbyEssentials;
import com.hiddentech.lobbyessentials.bukkit.ConfigHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawn implements CommandExecutor {
    private ConfigHandler config;

    public SetSpawn(LobbyEssentials plugin, ConfigHandler config){

        this.config = config;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player))return false;
        if(!sender.isOp())return false;
        Player player = (Player) sender;
        config.saveValue("spawn",player.getLocation());
        return false;
    }
}
