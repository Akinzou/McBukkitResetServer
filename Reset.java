package d0001.reset;


import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Reset extends JavaPlugin {
    private Commands commands = new Commands();
    @Override
    public void onEnable()
    {
        getCommand(commands.cmd1).setExecutor(commands);
        getCommand(commands.cmd2).setExecutor(commands);
        getCommand(commands.cmd3).setExecutor(commands);
        getLogger().info("Reset server has been runned!");
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
