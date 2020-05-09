package ElyseaGlobal.fr.noctambul.elyseaplugin;

import java.util.Arrays;
import java.util.UUID;

import bukkit.Material;
import bukkit.attribute.Attribute;
import bukkit.attribute.AttributeModifier;
import bukkit.event.Listener;
import bukkit.inventory.EquipmentSlot;
import bukkit.inventory.ItemStack;
import bukkit.inventory.RecipeChoice;
import bukkit.inventory.ShapedRecipe;
import bukkit.inventory.ShapelessRecipe;
import bukkit.inventory.meta.ItemMeta;
import bukkit.plugin.java.JavaPlugin;

public class ElyseaPlugin extends JavaPlugin  implements Listener {

	static ElyseaPlugin ep;
	
	public ElyseaPlugin() {
		ep=this;
	}
	
	public static ElyseaPlugin getThis() {
		return ep;
	}
	
	@Override
	public void onEnable() {
		System.out.println("§4Le plugin demarre");
		getServer().getPluginManager().registerEvents(new PluginListener(), this);
		ajouterCrafts();
	}

	@Override
	public void onDisable() {
		System.out.println("§4Le plugin s'arrete");
	}
	
	
	public void ajouterCrafts() {
		/*
			ItemStack armor = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
			ItemMeta armorM = armor.getItemMeta();
			AttributeModifier defense = new AttributeModifier(UUID.randomUUID(), "DefenseModifier", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
			armorM.addAttributeModifier(Attribute.GENERIC_ARMOR, defense);
			armor.setItemMeta(armorM);
		*/

		ItemStack cCelte = new ItemStack(Material.TURTLE_HELMET, 1);
		ItemMeta cCelteM = cCelte.getItemMeta();
		cCelteM.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "DefenseModifier", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
		cCelteM.setDisplayName("§3Couronne celte");
		cCelteM.setUnbreakable(true);
		cCelteM.setLore(Arrays.asList(""));
		cCelte.setItemMeta(cCelteM);
		ShapedRecipe couronneCelte = new ShapedRecipe(cCelte);
		couronneCelte.shape(new String[] {"sss","sis","sss"});
		couronneCelte.setIngredient('s', Material.BEDROCK);
		couronneCelte.setIngredient('i', Material.CYAN_BANNER);
		getServer().addRecipe(couronneCelte);
		
		ItemStack cChine = new ItemStack(Material.TURTLE_HELMET, 1);
		ItemMeta cChineM = cChine.getItemMeta();
		cChineM.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "DefenseModifier", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
		cChineM.setDisplayName("§aCouronne chinoise");
		cChineM.setUnbreakable(true);
		cChineM.setLore(Arrays.asList(""));
		cChine.setItemMeta(cChineM);
		ShapedRecipe couronneChine = new ShapedRecipe(cChine);
		couronneChine.shape(new String[] {"sss","sis","sss"});
		couronneChine.setIngredient('s', Material.BEDROCK);
		couronneChine.setIngredient('i', Material.LIME_BANNER);
		getServer().addRecipe(couronneChine);
		
		ItemStack cRome = new ItemStack(Material.TURTLE_HELMET, 1);
		ItemMeta cRomeM = cRome.getItemMeta();
		cRomeM.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "DefenseModifier", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
		cRomeM.setDisplayName("§4Couronne romaine");
		cRomeM.setUnbreakable(true);
		cRomeM.setLore(Arrays.asList(""));
		cRome.setItemMeta(cRomeM);
		ShapedRecipe couronneRome = new ShapedRecipe(cRome);
		couronneRome.shape(new String[] {"sss","sis","sss"});
		couronneRome.setIngredient('s', Material.BEDROCK);
		couronneRome.setIngredient('i', Material.RED_BANNER);
		getServer().addRecipe(couronneRome);
		
		
		ShapelessRecipe pepiteFer = new ShapelessRecipe(new ItemStack(Material.SCUTE, 9));
		pepiteFer.addIngredient(1, Material.DIAMOND);
		getServer().addRecipe(pepiteFer);
			
		ShapelessRecipe lingotFer = new ShapelessRecipe(new ItemStack(Material.DIAMOND, 1));
		lingotFer.addIngredient(9, Material.SCUTE);
		getServer().addRecipe(lingotFer);
			
		ShapedRecipe bottesMaille1 = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_BOOTS));
		bottesMaille1.shape(new String[] {"   ","i i","i i"});
		bottesMaille1.setIngredient('i', Material.SCUTE);
		getServer().addRecipe(bottesMaille1);
			
		ShapedRecipe bottesMaille2 = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_BOOTS));
		bottesMaille2.shape(new String[] {"i i","i i","   "});
		bottesMaille2.setIngredient('i', Material.SCUTE);
		getServer().addRecipe(bottesMaille2);
		
		ShapedRecipe casqueMaille1 = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_HELMET));
		casqueMaille1.shape(new String[] {"iii","i i","   "});
		casqueMaille1.setIngredient('i', Material.SCUTE);
		getServer().addRecipe(casqueMaille1);
		
		ShapedRecipe casqueMaille2 = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_HELMET));
		casqueMaille2.shape(new String[] {"   ","iii","i i"});
		casqueMaille2.setIngredient('i', Material.SCUTE);
		getServer().addRecipe(casqueMaille2);
		
		ShapedRecipe jambeMaille = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		jambeMaille.shape(new String[] {"iii","i i","i i"});
		jambeMaille.setIngredient('i', Material.SCUTE);
		getServer().addRecipe(jambeMaille);
		
		ShapedRecipe plastronMaille = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		plastronMaille.shape(new String[] {"i i","iii","iii"});
		plastronMaille.setIngredient('i', Material.SCUTE);
		getServer().addRecipe(plastronMaille);
		
		ShapelessRecipe marron = new ShapelessRecipe(new ItemStack(Material.BROWN_DYE, 2));
		marron.addIngredient(1, Material.BLACK_DYE);
		marron.addIngredient(1, Material.ORANGE_DYE);
		getServer().addRecipe(marron);
		
		ShapedRecipe echafaudage = new ShapedRecipe(new ItemStack(Material.SCAFFOLDING, 1));
		echafaudage.shape(new String[] {"ini","i i","i i"});
		echafaudage.setIngredient('n', Material.STRING);
		echafaudage.setIngredient('i', Material.STICK);
		getServer().addRecipe(echafaudage);
		
		ShapedRecipe cloche = new ShapedRecipe(new ItemStack(Material.BELL, 1));
		cloche.shape(new String[] {" i ","ini","i i"});
		cloche.setIngredient('i', Material.GOLD_INGOT);
		cloche.setIngredient('n', Material.GOLD_NUGGET);
		getServer().addRecipe(cloche);
		
		ShapedRecipe trident = new ShapedRecipe(new ItemStack(Material.TRIDENT, 1));
		trident.shape(new String[] {" dd"," sd","s  "});
		trident.setIngredient('d', Material.DIAMOND);
		trident.setIngredient('s', Material.STICK);
		getServer().addRecipe(trident);
		
		ShapelessRecipe etiquette = new ShapelessRecipe(new ItemStack(Material.NAME_TAG, 1));
		etiquette.addIngredient(1, Material.PAPER);
		etiquette.addIngredient(1, Material.STRING);
		etiquette.addIngredient(1, Material.INK_SAC);
		getServer().addRecipe(etiquette);
		
		ShapelessRecipe dragon = new ShapelessRecipe(new ItemStack(Material.DRAGON_BREATH, 1));
		dragon.addIngredient(1, Material.POTION);
		dragon.addIngredient(1, Material.GHAST_TEAR);
		dragon.addIngredient(1, Material.NETHER_WART);
		getServer().addRecipe(dragon);
		
		ShapedRecipe selle = new ShapedRecipe(new ItemStack(Material.SADDLE, 1));
		selle.shape(new String[] {"lll","l l","i i"});
		selle.setIngredient('l', Material.LEATHER);
		selle.setIngredient('i', Material.IRON_INGOT);
		getServer().addRecipe(selle);
		
		ShapedRecipe laisse = new ShapedRecipe(new ItemStack(Material.LEAD, 1));
		laisse.shape(new String[] {" ss"," is","s  "});
		laisse.setIngredient('s', Material.STRING);
		laisse.setIngredient('i', Material.IRON_INGOT);
		getServer().addRecipe(laisse);
		
		ShapelessRecipe ficelle = new ShapelessRecipe(new ItemStack(Material.STRING, 3));
		ficelle.addIngredient(new RecipeChoice.MaterialChoice(Material.WHITE_WOOL, Material.BLACK_WOOL, Material.BLUE_WOOL, Material.BROWN_WOOL, Material.CYAN_WOOL, 
				Material.GRAY_WOOL, Material.GREEN_WOOL, Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_WOOL, Material.LIME_WOOL, Material.MAGENTA_WOOL, 
				Material.ORANGE_WOOL, Material.PINK_WOOL, Material.PURPLE_WOOL, Material.RED_WOOL, Material.YELLOW_WOOL));
		getServer().addRecipe(ficelle);
		
		ShapedRecipe chevalOr = new ShapedRecipe(new ItemStack(Material.GOLDEN_HORSE_ARMOR, 1));
		chevalOr.shape(new String[] {"i i","iii","i i"});
		chevalOr.setIngredient('i', Material.GOLD_INGOT);
		getServer().addRecipe(chevalOr);
		
		ShapedRecipe chevalCuivre = new ShapedRecipe(new ItemStack(Material.IRON_HORSE_ARMOR, 1));
		chevalCuivre.shape(new String[] {"i i","iii","i i"});
		chevalCuivre.setIngredient('i', Material.IRON_INGOT);
		getServer().addRecipe(chevalCuivre);
		
		ShapedRecipe chevalFer = new ShapedRecipe(new ItemStack(Material.DIAMOND_HORSE_ARMOR, 1));
		chevalFer.shape(new String[] {"i i","iii","i i"});
		chevalFer.setIngredient('i', Material.DIAMOND);
		getServer().addRecipe(chevalFer);
	}
}
