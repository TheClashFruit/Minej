package xyz.theclashfruit.minej;

import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public final class Minej extends JavaPlugin {

    FileConfiguration serverConfig = this.getConfig();

    @Override
    public void onEnable() {
        getLogger().info("onEnable has been invoked!");

        serverConfig.addDefault("sandBoxMaxMemory", 512);
        serverConfig.options().copyDefaults(true);

        saveConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("minej")) {
            sender.sendMessage("Minej Go Brrr!");

            NashornSandbox sandBox = NashornSandboxes.create();
            sandBox.allow(MinejJavaInterface.class);

            //sandBox.setMaxMemory(serverConfig.getInt("sandBoxMaxMemory"));

            try {
                sandBox.eval("print('hello form js');");
                getLogger().info((String) sandBox.eval("return MinejJavaInterface;"));
            } catch (ScriptException e) {
                e.printStackTrace();
            }

            return true;
        }

        return false;
    }
}
