package me.ferizovic.squash;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class GameMasterCheck implements Listener {
	//TODO Find a better way to spawn the falling sand entity. Preferably, one without spamming the fuck out of my log
	@EventHandler
	public void onGameMasterClick(PlayerInteractEvent event) {
		if(event.getAction()==Action.RIGHT_CLICK_BLOCK) {
			Block clickedBlock = event.getClickedBlock();
			World world = clickedBlock.getWorld();
			if (clickedBlock.getType()==Material.BARRIER) {
				if (world.getBlockAt(clickedBlock.getX(),(clickedBlock.getY()-2),clickedBlock.getZ()).getType()==Material.AIR){
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "summon FallingSand "+ clickedBlock.getX() + " " + (clickedBlock.getY()-2) + " " + clickedBlock.getZ() + " {Block:bedrock,Data:1,Time:1,HurtEntities:1,FallHurtAmount:100,FallHurtMax:100,DropItem:0}");
				} 	
			} 
		}
	}
}