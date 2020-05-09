package fr.noctambul.elyseaplugin.armorRun.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandInfo implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			player.sendMessage("§ela version du plugin armorRun est : §41.0");
			
		}else {
		sender.sendMessage("la version du plugin armorRun est 1.0");
		}
		return false;
	}
	
}
