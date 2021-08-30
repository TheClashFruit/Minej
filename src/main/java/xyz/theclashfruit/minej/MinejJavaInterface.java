package xyz.theclashfruit.minej;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MinejJavaInterface extends JavaPlugin {
    public static String sendConsole(String msg) {
        System.out.println(msg);

        return msg;
    }

    public static void registerCommand(String name, String description, String permission, ArrayList<String> aliases) throws NoSuchFieldException, IllegalAccessException {
        MinecraftCommand myCommand = new MinecraftCommand(name, permission, description, new ArrayList<String>());

        final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

        bukkitCommandMap.setAccessible(true);
        CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

        commandMap.register(name, myCommand);
    }
}
