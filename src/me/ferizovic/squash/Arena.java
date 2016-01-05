package me.ferizovic.squash;


import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
@SuppressWarnings("unused") //Temporary, until I use all fields :D
public class Arena {
	private Location lobby;
	private Location arenaBottomCorner;
	private Location arenaTopCorner;
	private Location initialPositionPlayers;
	private Location initialPositionMaster;
	private ArrayList<Player> playersInArena = new ArrayList<Player>();
	private Location[] objectives;
	private String arenaName;
	
	public Arena(String arn,Location lobby,Location abc, Location atc, Location ipp, Location ipm,  Location[] objs){
		this.arenaName = arn;
		this.lobby = lobby;
		this.arenaBottomCorner = abc;
		this.arenaTopCorner = atc;
		this.initialPositionPlayers = ipp;
		this.initialPositionMaster = ipm;
		this.objectives = objs;
	}
	
	public void addPlayer(Player p){
		if (!playersInArena.contains(p)){
			playersInArena.add(p);
			p.sendMessage("You have joined " + arenaName); }
		else
			p.sendMessage("You are already in "+ arenaName);
			
	}
	
	public void removePlayer(Player p){
		if (playersInArena.contains(p)){
			playersInArena.remove(p);
			p.sendMessage("You've been removed from " + arenaName); }
	}
	
	public void startGame() {
		Bukkit.broadcastMessage(arenaName + " is starting!");
		for (Player p:playersInArena){
			p.teleport(initialPositionPlayers); }
	}
	
	public void setWin(Player p) {
		Bukkit.broadcastMessage(p.getName() + " won in "+ arenaName);
		for (Player pp:playersInArena)
			pp.teleport(lobby);
	}
	

	
}
