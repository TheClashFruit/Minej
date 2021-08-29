package xyz.theclashfruit.minej;

import org.bukkit.plugin.java.JavaPlugin;

public class MinejJavaInterface extends JavaPlugin {
    public void main(String[] args) {

    }

    public void sendConsoleMessage(String msg) {
        getLogger().info(msg);
    }
}
