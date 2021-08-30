package xyz.theclashfruit.minej;

import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.script.ScriptException;
import java.io.File;

public final class Minej extends JavaPlugin {

    FileConfiguration serverConfig = this.getConfig();

    @Override
    public void onEnable() {
        getLogger().info("onEnable has been invoked!");

        serverConfig.addDefault("sandBoxMaxMemory", 512);
        serverConfig.options().copyDefaults(true);

        File scriptsDir = new File(getDataFolder().getAbsolutePath() + "/scripts");
        if (!scriptsDir.exists()){
            scriptsDir.mkdirs();
        }

        saveConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("minej")) {
            NashornSandbox sandBox = NashornSandboxes.create();
            sandBox.allow(MinejJavaInterface.class);
            sandBox.allow(JavaPlugin.class);

            //sandBox.setMaxMemory(serverConfig.getInt("sandBoxMaxMemory"));

            try {
                sandBox.eval("var JavaPluginInterface = Java.type('xyz.theclashfruit.minej.MinejJavaInterface'); JavaPluginInterface.registerCommand('jscmd', 'js.cmd', 'Registered a new command with JavaScript.');");
            } catch (ScriptException e) {
                e.printStackTrace();
            }

            return true;
        }

        return false;
    }
}
