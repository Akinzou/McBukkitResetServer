package d0001.reset;


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
    public String cmd3 = "say";
    public int TimeToReset = 5;
    public int TimeToShutDown = 5;

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args)
    {
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

        if(cmd.getName().equalsIgnoreCase(cmd2))
        {
            while (TimeToShutDown >= 0)
            {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    player.sendMessage(ChatColor.RED + "Wylaczenie serwera za " + TimeToShutDown + "s");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TimeToShutDown -= 1;
            }
            TimeToShutDown = 5;
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.kickPlayer("Turning off server");
            }
            Bukkit.savePlayers();
            Bukkit.shutdown();
        }

        if(cmd.getName().equalsIgnoreCase(cmd3))
        {
            if(args.length == 0)
            {
                commandSender.sendMessage(ChatColor.GOLD+ "Not enough args!");
                return false;
            }
            else
            {
                for (Player player : Bukkit.getServer().getOnlinePlayers())
                {
                    String ToSend = "";
                    for (String arg : args)
                    {
                        ToSend += arg + " ";
                    }
                    player.sendMessage(ChatColor.RED + "ADMIN: ");
                    player.sendMessage(ChatColor.YELLOW + ToSend);
                }
            }
        }


        return true;
    }

}
