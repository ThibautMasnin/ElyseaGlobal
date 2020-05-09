package fr.xana.elyseaPlugin.armorRun;

import org.bukkit.Material;
import org.bukkit.entity.Player; 
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class armorLisener implements Listener {
	
	@EventHandler
	 void onSetArmor1(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		ItemStack helmet = player.getInventory().getHelmet();
		ItemStack chestPlate = player.getInventory().getChestplate();
		ItemStack leggings = player.getInventory().getLeggings();
		ItemStack boots = player.getInventory().getBoots();
		int oneStack = 0;
		int pices = 4;
		if (helmet != null && (helmet.getType() == Material.GOLDEN_HELMET || helmet.getType()  == Material.LEATHER_HELMET || helmet.getType() == Material.CHAINMAIL_HELMET)) {
			oneStack += 1;
		}else if(helmet == null) {
			pices -= 1;
		}if (chestPlate != null && (chestPlate.getType().equals(Material.GOLDEN_CHESTPLATE) || chestPlate.getType() == Material.LEATHER_CHESTPLATE || chestPlate.getType() == Material.CHAINMAIL_CHESTPLATE)) {
			oneStack += 1;
		}else if(chestPlate == null) {
			pices -= 1;
		}if (leggings != null && ( leggings.getType() == Material.GOLDEN_LEGGINGS || leggings.getType() == Material.LEATHER_LEGGINGS || leggings.getType() == Material.CHAINMAIL_LEGGINGS)) {
			oneStack += 1;
		}else if(leggings == null) {
			pices -= 1;
		}if (boots != null && ( boots.getType().equals(Material.GOLDEN_BOOTS) || boots.getType().equals(Material.LEATHER_BOOTS) ||boots.getType().equals(Material.CHAINMAIL_BOOTS))) {
			oneStack += 1;
		}else if(boots == null) {
			pices -= 1;
		}
		if(pices == 0) {
			player.removePotionEffect(PotionEffectType.SLOW);
			
		}else if(pices == oneStack) {
			player.removePotionEffect(PotionEffectType.SLOW);
		}else {
			player.removePotionEffect(PotionEffectType.SLOW);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,0));
		}		
	}	
	
	@EventHandler
	void onSetArmor2(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		ItemStack helmet = player.getInventory().getHelmet();
		ItemStack chestPlate = player.getInventory().getChestplate();
		ItemStack leggings = player.getInventory().getLeggings();
		ItemStack boots = player.getInventory().getBoots();
		int oneStack = 0;
		int pices = 4;
		if (helmet != null && (helmet.getType() == Material.GOLDEN_HELMET || helmet.getType()  == Material.LEATHER_HELMET || helmet.getType() == Material.CHAINMAIL_HELMET)) {
			oneStack += 1;
		}else if(helmet == null) {
			pices -= 1;
		}if (chestPlate != null && (chestPlate.getType().equals(Material.GOLDEN_CHESTPLATE) || chestPlate.getType() == Material.LEATHER_CHESTPLATE || chestPlate.getType() == Material.CHAINMAIL_CHESTPLATE)) {
			oneStack += 1;
		}else if(chestPlate == null) {
			pices -= 1;
		}if (leggings != null && ( leggings.getType() == Material.GOLDEN_LEGGINGS || leggings.getType() == Material.LEATHER_LEGGINGS || leggings.getType() == Material.CHAINMAIL_LEGGINGS)) {
			oneStack += 1;
		}else if(leggings == null) {
			pices -= 1;
		}if (boots != null && ( boots.getType().equals(Material.GOLDEN_BOOTS) || boots.getType().equals(Material.LEATHER_BOOTS) ||boots.getType().equals(Material.CHAINMAIL_BOOTS))) {
			oneStack += 1;
		}else if(boots == null) {
			pices -= 1;
		}
		if(pices == 0) {
			player.removePotionEffect(PotionEffectType.SLOW);
			
		}else if(pices == oneStack) {
			player.removePotionEffect(PotionEffectType.SLOW);
		}else {
			player.removePotionEffect(PotionEffectType.SLOW);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,0));
		}
	
	}
	@EventHandler
	 void onSetArmor3(InventoryCloseEvent event) {
		
		Player player = (Player) event.getPlayer();
		ItemStack helmet = player.getInventory().getHelmet();
		ItemStack chestPlate = player.getInventory().getChestplate();
		ItemStack leggings = player.getInventory().getLeggings();
		ItemStack boots = player.getInventory().getBoots();
		int oneStack = 0;
		int pices = 4;
		if (helmet != null && (helmet.getType() == Material.GOLDEN_HELMET || helmet.getType()  == Material.LEATHER_HELMET || helmet.getType() == Material.CHAINMAIL_HELMET)) {
			oneStack += 1;
		}else if(helmet == null) {
			pices -= 1;
		}if (chestPlate != null && (chestPlate.getType().equals(Material.GOLDEN_CHESTPLATE) || chestPlate.getType() == Material.LEATHER_CHESTPLATE || chestPlate.getType() == Material.CHAINMAIL_CHESTPLATE)) {
			oneStack += 1;
		}else if(chestPlate == null) {
			pices -= 1;
		}if (leggings != null && ( leggings.getType() == Material.GOLDEN_LEGGINGS || leggings.getType() == Material.LEATHER_LEGGINGS || leggings.getType() == Material.CHAINMAIL_LEGGINGS)) {
			oneStack += 1;
		}else if(leggings == null) {
			pices -= 1;
		}if (boots != null && ( boots.getType().equals(Material.GOLDEN_BOOTS) || boots.getType().equals(Material.LEATHER_BOOTS) ||boots.getType().equals(Material.CHAINMAIL_BOOTS))) {
			oneStack += 1;
		}else if(boots == null) {
			pices -= 1;
		}
		if(pices == 0) {
			player.removePotionEffect(PotionEffectType.SLOW);
			
		}else if(pices == oneStack) {
			player.removePotionEffect(PotionEffectType.SLOW);
		}else {
			player.removePotionEffect(PotionEffectType.SLOW);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,0));
		}		
	}
	 void onSetArmor4(PlayerRespawnEvent event) {
			
		 	Player player = (Player) event.getPlayer();
		 	player.sendMessage("respawn");
		 	ItemStack helmet = player.getInventory().getHelmet();
			ItemStack chestPlate = player.getInventory().getChestplate();
			ItemStack leggings = player.getInventory().getLeggings();
			ItemStack boots = player.getInventory().getBoots();
			int oneStack = 0;
			int pices = 4;
			if (helmet != null && (helmet.getType() == Material.GOLDEN_HELMET || helmet.getType()  == Material.LEATHER_HELMET || helmet.getType() == Material.CHAINMAIL_HELMET)) {
				oneStack += 1;
			}else if(helmet == null) {
				pices -= 1;
			}if (chestPlate != null && (chestPlate.getType().equals(Material.GOLDEN_CHESTPLATE) || chestPlate.getType() == Material.LEATHER_CHESTPLATE || chestPlate.getType() == Material.CHAINMAIL_CHESTPLATE)) {
				oneStack += 1;
			}else if(chestPlate == null) {
				pices -= 1;
			}if (leggings != null && ( leggings.getType() == Material.GOLDEN_LEGGINGS || leggings.getType() == Material.LEATHER_LEGGINGS || leggings.getType() == Material.CHAINMAIL_LEGGINGS)) {
				oneStack += 1;
			}else if(leggings == null) {
				pices -= 1;
			}if (boots != null && ( boots.getType().equals(Material.GOLDEN_BOOTS) || boots.getType().equals(Material.LEATHER_BOOTS) ||boots.getType().equals(Material.CHAINMAIL_BOOTS))) {
				oneStack += 1;
			}else if(boots == null) {
				pices -= 1;
			}
			if(pices == 0) {
				player.removePotionEffect(PotionEffectType.SLOW);
				
			}else if(pices == oneStack) {
				player.removePotionEffect(PotionEffectType.SLOW);
			}else {
				player.removePotionEffect(PotionEffectType.SLOW);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,0));
			}		
		}

}