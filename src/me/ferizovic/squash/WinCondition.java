package me.ferizovic.squash;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WinCondition {
	//TODO : Remove Hard-coded coordinates.Make it modular, so multiple arenas can use it
	//Add tags so only users that joined get teleported ( included in the functions)
	public static void setWin(String arena,Player player,World world) {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "broadcast "+ player.getName()+ " won a round in arena "+arena) ;
		for (Player plist : Bukkit.getOnlinePlayers()) {
			  plist.teleport(world.getBlockAt(3,13,-32).getLocation());
		  }
		loopThrough(world.getBlockAt(0,1,29).getLocation(), world.getBlockAt(6,8,-35).getLocation(), world);
		Random random = new Random();
		  Player randomPlayer = (Player) Bukkit.getOnlinePlayers().toArray()[random.nextInt(Bukkit.getOnlinePlayers().size())];
		  randomPlayer.teleport(world.getBlockAt(3,10,-32).getLocation());
	}

//Black box code. I didn't write this. If it doesn't work, don't be lazy and fix it - /end note to self
private static void loopThrough(Location loc1, Location loc2,World world) {
    int minx = Math.min(loc1.getBlockX(), loc2.getBlockX()),
        minz = Math.min(loc1.getBlockZ(), loc2.getBlockZ()),
        maxx = Math.max(loc1.getBlockX(), loc2.getBlockX()),
        maxz = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
    for(int x = minx; x<=maxx;x++) {
        for(int y = 1; y<loc2.getBlockY();y++) {
            for(int z = minz; z<=maxz;z++) {
                if (world.getBlockAt(x,y,z).getType()==Material.BEDROCK){
                	world.getBlockAt(x,y,z).setType(Material.AIR);
                }
                
            }
        }
    }
} }