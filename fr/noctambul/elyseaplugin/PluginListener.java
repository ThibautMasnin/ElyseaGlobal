package ElyseaGlobal.fr.noctambul.elyseaplugin;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PluginListener implements Listener {
	
	
// LOOT D'OS SUR LES ANIMAUX ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@EventHandler
	public void onAnimalDeath(EntityDeathEvent e) {
		Entity mob = e.getEntity();
		Random rand = new Random();
		if(mob.getType() == EntityType.COW || mob.getType() == EntityType.HORSE || mob.getType() == EntityType.DONKEY || mob.getType() == EntityType.SHEEP || mob.getType() == EntityType.MUSHROOM_COW ||
				mob.getType() == EntityType.MULE || mob.getType() == EntityType.PIG || mob.getType() == EntityType.LLAMA || mob.getType() == EntityType.PANDA || mob.getType() == EntityType.POLAR_BEAR) {
			e.getDrops().add(new ItemStack(Material.BONE, rand.nextInt(3)));
		}
		else if(mob.getType() == EntityType.WOLF || mob.getType() == EntityType.SQUID || mob.getType() == EntityType.DOLPHIN || mob.getType() == EntityType.FOX || mob.getType() == EntityType.VILLAGER ||
				mob.getType() == EntityType.WANDERING_TRADER || mob.getType() == EntityType.WITCH) {
			e.getDrops().add(new ItemStack(Material.BONE, rand.nextInt(2)));		
		}
	}
	
	

// EFFETS DE POTION AU RESPAWN ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		Bukkit.getScheduler().runTask(ElyseaPlugin.getThis(), () -> {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 600, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 150, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 10, 0));
			p.setHealth(0.1);
		});
	}
	
	
	
// LOOT MINERAI DE DIAMANT //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Block b = event.getBlock();
		if(b.getType().equals(Material.DIAMOND_ORE)) {
			event.setCancelled(true);
			b.setType(Material.AIR);
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.DIAMOND_ORE));
		}
	}
	
	
	
// CHAT RP /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e) {
		e.setCancelled(true);
		String rawMsg = e.getMessage();
		Location playerLocation = e.getPlayer().getLocation();
		int seul=0;
		
		//parler RP
		if(rawMsg.substring(0,1).equals("*")) {
			for(Player p : e.getRecipients()) {
				if(p.getWorld()==e.getPlayer().getWorld() && p.getLocation().distance(playerLocation) <= 12) {
					p.sendMessage("§8[§2RP§8]§f"+e.getPlayer().getDisplayName() + "§8 dit §f" + rawMsg.substring(1));
					seul++;
				}
			}
		}
		//chuchoter RP
		else if(rawMsg.substring(0,1).equals("-")) {
			for(Player p : e.getRecipients()) {
				if(p.getWorld()==e.getPlayer().getWorld() && p.getLocation().distance(playerLocation) <= 5) {
					p.sendMessage("§8[§2RP§8]§f"+e.getPlayer().getDisplayName() + "§8 murmure §f" + rawMsg.substring(1));
					seul++;
				}
			}
		}
		//crier RP
		else if(rawMsg.substring(0,1).equals("+")) {
			for(Player p : e.getRecipients()) {
				if(p.getWorld()==e.getPlayer().getWorld() && p.getLocation().distance(playerLocation) <= 25) {
					p.sendMessage("§8[§2RP§8]§f"+e.getPlayer().getDisplayName() + "§8 crie §f" + rawMsg.substring(1));
					seul++;
				}
			}
		}
		//global HRP
		else {
			for(Player p : e.getRecipients()) {
				p.sendMessage("§8[§3HRP§8]§f"+e.getPlayer().getDisplayName() +"§8 : §f"+ rawMsg);
				seul++;
			}	
		}
		if(seul<=1) {
			e.getPlayer().sendMessage("§f[§6ELYSEA§f] §cPersonne ne t'entend !");
		}
	}
	
	

// MENU VISITEUR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		//if(p.hasPlayedBefore()) {
			p.getInventory().clear(0);
			ItemStack star = new ItemStack(Material.NETHER_STAR);
			ItemMeta starM = star.getItemMeta();
			starM.setDisplayName("§9Menu visiteur");
			starM.setLore(Arrays.asList("§6Cliquez sur les bannières", "§6pour visiter les factions."));
			star.setItemMeta(starM);
			p.getInventory().setItem(0, star);
		//}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		ItemStack it = event.getItem();
		if (it==null) return;
		if(it.getType()==Material.NETHER_STAR && it.hasItemMeta() && it.getItemMeta().getDisplayName().equals("§9Menu visiteur")) {
			Inventory inv = Bukkit.createInventory(null, 9, "§0Menu visiteur");
			
			//Map Build
			ItemStack build = new ItemStack(Material.IRON_PICKAXE);
			ItemMeta buildM = build.getItemMeta();
			buildM.setDisplayName("§6Build");
			build.setItemMeta(buildM);
			inv.setItem(0, build);
			//Bannière romaine
			ItemStack rome = new ItemStack(Material.RED_BANNER);
			ItemMeta romeM = rome.getItemMeta();
			romeM.setDisplayName("§4Rome");
			rome.setItemMeta(romeM);
			inv.setItem(3, rome);
			//Bannière celte (TheNordiX)
			ItemStack albroga = new ItemStack(Material.LIGHT_GRAY_BANNER);
			ItemMeta albrogaM = albroga.getItemMeta();
			albrogaM.setDisplayName("§7Celtes (Albroga)");
			albroga.setItemMeta(albrogaM);
			inv.setItem(5, albroga);
			//Bannière celte (Enarrion)
			ItemStack hafeld = new ItemStack(Material.CYAN_BANNER);
			ItemMeta hafeldM = hafeld.getItemMeta();
			hafeldM.setDisplayName("§3Celtes (Hafeld)");
			hafeld.setItemMeta(hafeldM);
			inv.setItem(6, hafeld);
			//Bannière chinoise
			ItemStack chine = new ItemStack(Material.LIME_BANNER);
			ItemMeta chineM = chine.getItemMeta();
			chineM.setDisplayName("§aChine");
			chine.setItemMeta(chineM);
			inv.setItem(8, chine);
			
			p.openInventory(inv);
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player p = (Player)event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if (item==null) return;
		if(event.getView().getTitle().equals("§0Menu visiteur")) {			
			if(item.getType()==Material.IRON_PICKAXE && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§6Build")) {
				p.closeInventory();
				Location loc = new Location(Bukkit.getWorld("Build"), 35, 4, 67);
				p.teleport(loc);
			}	
			else if(item.getType()==Material.RED_BANNER && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§4Rome")) {
				p.closeInventory();
				Location loc = new Location(Bukkit.getWorld("Server"), -1987, 65, -1805);
				p.teleport(loc);
			}	
			else if(item.getType()==Material.LIGHT_GRAY_BANNER && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§7Celtes (Albroga)")) {
				p.closeInventory();
				Location loc = new Location(Bukkit.getWorld("Server"), -7492, 66, -5733);
				p.teleport(loc);
			}	
			else if(item.getType()==Material.CYAN_BANNER && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§3Celtes (Hafeld)")) {
				p.closeInventory();
				Location loc = new Location(Bukkit.getWorld("Server"), 660, 79, -5328);
				p.teleport(loc);
			}	
			else if(item.getType()==Material.LIME_BANNER && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§aChine")) {
				p.closeInventory();
				Location loc = new Location(Bukkit.getWorld("Server"), 8000, 84, -5000);
				p.teleport(loc);
			}	
			else if(item.getType()==Material.NETHER_STAR && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§9Menu visiteur")) {
				event.setCancelled(true);
			}
		}
		else {
			if(item.getType()==Material.NETHER_STAR && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§9Menu visiteur")) {
				p.closeInventory();
				Inventory inv = Bukkit.createInventory(null, 9, "§0Menu visiteur");
				
				//Map Build
				ItemStack build = new ItemStack(Material.IRON_PICKAXE);
				ItemMeta buildM = build.getItemMeta();
				buildM.setDisplayName("§6Build");
				build.setItemMeta(buildM);
				inv.setItem(0, build);
				//Bannière romaine
				ItemStack rome = new ItemStack(Material.RED_BANNER);
				ItemMeta romeM = rome.getItemMeta();
				romeM.setDisplayName("§4Rome");
				rome.setItemMeta(romeM);
				inv.setItem(3, rome);
				//Bannière celte (TheNordiX)
				ItemStack albroga = new ItemStack(Material.LIGHT_GRAY_BANNER);
				ItemMeta albrogaM = albroga.getItemMeta();
				albrogaM.setDisplayName("§7Celtes (Albroga)");
				albroga.setItemMeta(albrogaM);
				inv.setItem(5, albroga);
				//Bannière celte (Enarrion)
				ItemStack hafeld = new ItemStack(Material.CYAN_BANNER);
				ItemMeta hafeldM = hafeld.getItemMeta();
				hafeldM.setDisplayName("§3Celtes (Hafeld)");
				hafeld.setItemMeta(hafeldM);
				inv.setItem(6, hafeld);
				//Bannière chinoise
				ItemStack chine = new ItemStack(Material.LIME_BANNER);
				ItemMeta chineM = chine.getItemMeta();
				chineM.setDisplayName("§aChine");
				chine.setItemMeta(chineM);
				inv.setItem(8, chine);
				
				p.openInventory(inv);			
			}
		}
	}
}
