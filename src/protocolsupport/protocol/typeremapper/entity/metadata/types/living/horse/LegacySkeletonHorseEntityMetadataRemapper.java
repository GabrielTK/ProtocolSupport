package protocolsupport.protocol.typeremapper.entity.metadata.types.living.horse;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.typeremapper.entity.metadata.FirstDataWatcherUpdateObjectAddRemapper;
import protocolsupport.protocol.types.networkentity.metadata.objects.NetworkEntityMetadataObjectByte;
import protocolsupport.protocol.types.networkentity.metadata.objects.NetworkEntityMetadataObjectVarInt;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class LegacySkeletonHorseEntityMetadataRemapper extends BattleHorseEntityMetadataRemapper {

	public LegacySkeletonHorseEntityMetadataRemapper() {
		addRemap(new FirstDataWatcherUpdateObjectAddRemapper(14, new NetworkEntityMetadataObjectVarInt(4)), ProtocolVersion.MINECRAFT_1_10);
		addRemap(new FirstDataWatcherUpdateObjectAddRemapper(13, new NetworkEntityMetadataObjectVarInt(4)), ProtocolVersionsHelper.ALL_1_9);
		addRemap(new FirstDataWatcherUpdateObjectAddRemapper(19, new NetworkEntityMetadataObjectByte((byte) 4)), ProtocolVersion.getAllBetween(ProtocolVersion.MINECRAFT_1_6_1, ProtocolVersion.MINECRAFT_1_8));
	}

}
