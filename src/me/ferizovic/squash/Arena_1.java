package me.ferizovic.squash;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Arena_1 implements Listener {
//TODO Make it work
//TODO Add customizable arena points
	@EventHandler
	public void arena1_win(PlayerInteractEvent event){
		if (event.getAction()==Action.RIGHT_CLICK_BLOCK){
			Block clickedBlock = event.getClickedBlock();
			if (clickedBlock.getType()==Material.GOLD_BLOCK){
				WinCondition.setWin("1", event.getPlayer(),event.getPlayer().getWorld());
			}
		}	
	}	
}
