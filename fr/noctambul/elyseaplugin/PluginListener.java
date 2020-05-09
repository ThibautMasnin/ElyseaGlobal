package ElyseaGlobal.fr.noctambul.elyseaplugin;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PluginListener implements Listener {

//LOOT D'OS SUR LES ANIMAUX
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
}
