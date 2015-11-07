package protocolsupport.server.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import protocolsupport.api.ProtocolSupportAPI;
import protocolsupport.api.ProtocolVersion;

public class PlayerListener implements Listener {

	@EventHandler
	public void onShift(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		if (player.isInsideVehicle() && ProtocolSupportAPI.getProtocolVersion(player) == ProtocolVersion.MINECRAFT_1_5_2) {
			player.leaveVehicle();
		}
	}

	@EventHandler(ignoreCancelled = true)
	public void onVehicleInteract(PlayerInteractEntityEvent event) {
		if (event.getPlayer().isInsideVehicle()) {
			if (event.getPlayer().getVehicle().equals(event.getRightClicked())) {
				event.getPlayer().leaveVehicle();
			}
		}
	}

}
