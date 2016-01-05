package me.ferizovic.squash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class Squash extends JavaPlugin {
	public static Arena arena_one;
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new SquashListener(),this);
		arenaInit();
	}
	

	@Override
	public void onDisable() {
		
	}
	
	public void arenaInit() {
		World world = Bukkit.getWorld("world");
		Location lobby = new Location(world, 769, 4, -696);
		Location arenaBottomCorner = new Location(world, 754, 4, -694);
		Location arenaTopCorner = new Location(world, 760, 9 , -700);
		Location initialPositionPlayers = new Location(world, 757,4,-697);
		Location initialPositionMaster = new Location(world, 757, 14, -697);
		Location[] objectives = {
				new Location(world, 767 , 11 ,-697),
				new Location(world, 757 , 11 ,-707),
				new Location(world, 747 , 11 ,-697),
				new Location(world, 757 , 11 ,-687)
				
		}; 
		
		arena_one = new Arena("Arena One", lobby, arenaBottomCorner, arenaTopCorner, initialPositionPlayers, initialPositionMaster, objectives);
		
	}
	
	
}
