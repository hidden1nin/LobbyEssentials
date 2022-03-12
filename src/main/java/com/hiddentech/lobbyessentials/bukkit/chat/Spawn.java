package com.hiddentech.lobbyessentials.bukkit.chat;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Spawn implements CommandExecutor {
    private final Location spawn;

    public Spawn(Location spawn){
        this.spawn = spawn;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        sender.sendMessage(ChatColor.GREEN+"Taking you to spawn.");
        ((Player) sender).teleport(spawn);
        return false;
    }
}
