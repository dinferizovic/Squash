package me.ferizovic.squash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SquashCommands implements CommandExecutor {
	@SuppressWarnings("unused")
	private final Squash plugin;
	 
	public SquashCommands(Squash plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("joinarena")) {
			Player player =  (Player) sender;
			player.sendMessage("My squidward is itchy");//TODO : Actually teleport the user to the desinated arena	
			return true;
		}
		return false; 
	}
}
