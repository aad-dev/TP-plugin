package me.aaddev.teleportPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender; // Object for Player who executes the command

            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Je moet wel een naam invullen achterlijke mongool.");
                player.sendMessage(ChatColor.YELLOW + "Dus: /tp <speler>");
                player.sendMessage(ChatColor.YELLOW + "Of:, /tp <speler> <andere_speler>");

            } else if (args[0].equalsIgnoreCase("all")) {
                // Teleport all online players to the sender
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!p.equals(player)) {
                        p.teleport(player.getLocation());
                    }
                }
                player.sendMessage(ChatColor.GREEN + "Alle spelers zijn naar jou geteleporteerd!");
                return true;
            }

            else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]); // make a new player object (bukkit.getplayer = instance of
                                                           // their name)

                player.teleport(target.getLocation());
            }
        } else if (args.length == 2) {
            // Instance of first player
            Player playerToSend = Bukkit.getPlayer(args[0]);

            // Target player
            Player target = Bukkit.getPlayer(args[1]);

            // Teleport player to target
            playerToSend.teleport(target.getLocation());
        }

        return true;
    }
}
