package fr.xana.elyseaPlugin.armorRun;

import org.bukkit.plugin.java.JavaPlugin;

import fr.xana.armorRun.commands.CommandInfo;

public class armorRun extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("pour le moment tout va bien");
		getCommand("arinfo").setExecutor(new CommandInfo());
		getServer().getPluginManager().registerEvents(new armorLisener(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("tout c'est bien passé");
	}

}
