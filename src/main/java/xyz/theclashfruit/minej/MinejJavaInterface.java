package xyz.theclashfruit.minej;

import org.bukkit.plugin.java.JavaPlugin;

public class MinejJavaInterface extends JavaPlugin {
    public static String sendConsole(String msg) {
        System.out.println(msg);

        return msg;
    }
}
