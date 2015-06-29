//Din Ferizovic, 2015! This code is licensed under the MIT license.
//TODO : Replace the hacky "summon" code with a bukkit/spigot equivalent
package me.ferizovic.squash;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Squash extends JavaPlugin implements Listener{

	@Override
	    public void onEnable() {
		 getServer().getPluginManager().registerEvents(this, this);
	    }

	@EventHandler
	  public void onInteract(PlayerInteractEvent event) {
		  if (event.getAction()==Action.RIGHT_CLICK_BLOCK){ 
			  Block clickedB = event.getClickedBlock();
			  
			  if (clickedB.getType()==Material.BARRIER) { 
				  World world= clickedB.getWorld();
				  Block uBlock = world.getBlockAt(clickedB.getX(),clickedB.getY()-2,clickedB.getZ());
			  
			  if (uBlock.getType()==Material.AIR)  {
			  	  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "summon FallingSand "+ uBlock.getX() + " " + uBlock.getY() + " " + uBlock.getZ() + " {Block:bedrock,Data:1,Time:1,HurtEntities:1,FallHurtAmount:100,FallHurtMax:100,DropItem:0}");
			  	
			  }}}}}
