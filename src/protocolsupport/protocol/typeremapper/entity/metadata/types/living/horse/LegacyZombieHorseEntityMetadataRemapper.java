package protocolsupport.protocol.typeremapper.entity.metadata.types.living.horse;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.typeremapper.entity.metadata.FirstDataWatcherUpdateObjectAddRemapper;
import protocolsupport.protocol.types.networkentity.metadata.objects.NetworkEntityMetadataObjectByte;
import protocolsupport.protocol.types.networkentity.metadata.objects.NetworkEntityMetadataObjectVarInt;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class LegacyZombieHorseEntityMetadataRemapper extends BattleHorseEntityMetadataRemapper {

	public LegacyZombieHorseEntityMetadataRemapper() {
		addRemap(new FirstDataWatcherUpdateObjectAddRemapper(14, new NetworkEntityMetadataObjectVarInt(3)), ProtocolVersion.MINECRAFT_1_10);
		addRemap(new FirstDataWatcherUpdateObjectAddRemapper(13, new NetworkEntityMetadataObjectVarInt(3)), ProtocolVersionsHelper.ALL_1_9);
		addRemap(new FirstDataWatcherUpdateObjectAddRemapper(19, new NetworkEntityMetadataObjectByte((byte) 3)), ProtocolVersion.getAllBetween(ProtocolVersion.MINECRAFT_1_6_1, ProtocolVersion.MINECRAFT_1_8));
	}

}
