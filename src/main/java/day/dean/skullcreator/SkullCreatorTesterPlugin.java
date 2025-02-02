package day.dean.skullcreator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author deanveloper on 12/28/2016.
 */
public class SkullCreatorTesterPlugin extends JavaPlugin {

	private static final String TEST_SKULL = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDllY2NjNWMxYzc5YWE3ODI2YTE1YTdmNWYxMmZiNDAzMjgxNTdjNTI0MjE2NGJhMmFlZjQ3ZTVkZTlhNWNmYyJ9fX0=";

	@Override
	public void onEnable() {
		// Entferne die Überprüfung, um das Plugin ausführen zu können
		Bukkit.getLogger().info("SkullCreatorTesterPlugin loaded!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String lbl, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be executed by a player.");
			return false;
		}

		Player p = (Player) sender;

		if (args.length == 0) {
			p.sendMessage("Usage: /skulltest <item|block>");
			return false;
		}

		if (args[0].equals("item")) {
			// Erstellt einen benutzerdefinierten Kopf mit einer URL
			ItemStack skull = SkullCreator.itemFromUrl("http://textures.minecraft.net/texture/de48039e196d03ceff62fe97684e712f8d31b6e7b1a6cb1c955a86755b847b17");
			p.getInventory().setItemInMainHand(skull);
			p.sendMessage("Custom skull item created and added to your hand!");
		} else if (args[0].equals("block")) {
			// Setzt einen benutzerdefinierten Kopf als Block
			SkullCreator.blockWithBase64(p.getLocation().getBlock(), TEST_SKULL);
			p.sendMessage("Custom skull block placed at your location!");
		} else {
			p.sendMessage("Invalid argument. Usage: /skulltest <item|block>");
			return false;
		}

		return true;
	}
}