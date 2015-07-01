//Din Ferizovic, 2015! This code is licensed under the MIT license.
//If you're going to use this plugin on your server, please tell me. You don't have to but I would like it.
//Contact info: Github : dinferizovic , reddit:dinbored , or check out the contact section on http://ferizovic.me
//TODO:Finish the basics and make it better. Way better!
//A big thanks to google for existing. Without it, this wouldn't have been possible.
package me.ferizovic.squash;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Squash extends JavaPlugin implements Listener{

	@Override
	    public void onEnable() {
		 getServer().getPluginManager().registerEvents(this, this);
		 getServer().getPluginManager().registerEvents(new GameMasterCheck(), this);
		 getServer().getPluginManager().registerEvents(new Arena_1(), this);
		 this.getCommand("joinarena").setExecutor(new SquashCommands(this));
	    }
}
