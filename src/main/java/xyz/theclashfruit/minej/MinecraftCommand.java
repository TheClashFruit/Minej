package xyz.theclashfruit.minej;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.ArrayList;
import java.util.Objects;

public class MinecraftCommand extends BukkitCommand {
    public MinecraftCommand(String name, String permission, String description, ArrayList<String> aliases) {
        super(name);

        this.description = description;
        this.usageMessage = "/" + name;
        this.setPermission(permission);
        this.setAliases(aliases);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender.hasPermission(Objects.requireNonNull(this.getPermission()))) {
            System.out.println("A command has ran.");

            return true;
        } else {
            commandSender.sendMessage(ChatColor.RED + "You don't have permission.");

            return true;
        }
    }
}
