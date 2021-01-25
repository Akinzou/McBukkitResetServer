package d0001.reset;


import net.minecraft.server.v1_16_R3.CommandExecute;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements Listener, CommandExecutor {
    public String cmd1 = "reset";
    public String cmd2 = "shutdown";
    public int TimeToReset = 5;

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {
        if(cmd.getName().equalsIgnoreCase(cmd1))
        {
            while (TimeToReset >= 0)
            {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    player.sendMessage(ChatColor.RED + "Reset serwera za " + TimeToReset + "s");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TimeToReset -= 1;
            }
            TimeToReset = 5;
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.kickPlayer("Reset serwera");
            }
            Bukkit.savePlayers();
            Bukkit.shutdown();
        }
        return true;
    }
}
