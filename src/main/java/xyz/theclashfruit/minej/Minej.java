package xyz.theclashfruit.minej;

import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class Minej extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("onEnable has been invoked!");
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("minej")) {
            sender.sendMessage("Minej Go Brrr!");

            //ScriptEngine sEngine = new ScriptEngineManager().getEngineByName("nashorn");

            NashornSandbox sandBox = NashornSandboxes.create();
            sandBox.allow(MinejJavaInterface.class);

            try {
                sandBox.eval("print('hello form js');");
            } catch (ScriptException e) {
                e.printStackTrace();
            }

            return true;
        }

        return false;
    }
}
