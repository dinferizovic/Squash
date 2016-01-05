package me.ferizovic.squash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SquashListener implements Listener {
	
	@EventHandler
	public void barrierClick(PlayerInteractEvent e){
		if (e.getAction()==Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType()==Material.BARRIER/* && e.getPlayer().hasPermission("arenamaster")*/){
				Block cb = e.getClickedBlock();
				Location underBlock = new Location(e.getPlayer().getWorld(), cb.getX(),cb.getY()-3,cb.getZ());	
				if (e.getPlayer().getWorld().getBlockAt(underBlock).getType()==Material.AIR)
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "summon FallingSand "+ cb.getX() + " " + (cb.getY()-2) + " " + cb.getZ() + " {Block:bedrock,Data:1,Time:1,HurtEntities:1,FallHurtAmount:100,FallHurtMax:100,DropItem:0}"); }
	}
			
		
	@EventHandler
	public void goldClick(PlayerInteractEvent e){
		if (e.getAction()==Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType()==Material.GOLD_BLOCK /*&& e.getPlayer().hasPermission("arenaplayer")*/){
			Squash.arena_one.setWin(e.getPlayer());
		}
		
	}
	
	//TEMPONARY SOLUTION FOR ARENA CONTROL! TODO: REPLACE WITH COMMANDS
	@EventHandler
	public void arenaJoin(PlayerInteractEvent e){
		if (e.getAction()==Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType()==Material.EMERALD_BLOCK){
			Squash.arena_one.addPlayer(e.getPlayer());
		}
		else if (e.getAction()==Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType()==Material.REDSTONE_BLOCK){
			Squash.arena_one.removePlayer(e.getPlayer());
		}
		
	}
	
	//START THE GAME
	@EventHandler
	public void bedrockClick(PlayerInteractEvent e){
		if (e.getAction()==Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType()==Material.BEDROCK /*&& e.getPlayer().hasPermission("arenaplayer")*/){
			Squash.arena_one.startGame();
		}
		
	}
	
	}
	

