package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleEntityPassengers;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.packet.middleimpl.IPacketData;
import protocolsupport.utils.recyclable.RecyclableArrayList;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableEmptyList;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class EntityPassengers extends MiddleEntityPassengers {

	public EntityPassengers(ConnectionImpl connection) {
		super(connection);
	}

	protected final Int2IntOpenHashMap vehiclePassenger = new Int2IntOpenHashMap();
	{
		vehiclePassenger.defaultReturnValue(-1);
	}

	@Override
	public RecyclableCollection<? extends IPacketData> toData() {
		if (cache.getWatchedEntityCache().getWatchedEntity(vehicleId) == null) {
			return RecyclableEmptyList.get();
		}
		if (passengersIds.length == 0) {
			int passengerId = vehiclePassenger.remove(vehicleId);
			if (passengerId != vehiclePassenger.defaultReturnValue()) {
				return RecyclableSingletonList.create(create(passengerId, -1));
			}
		} else {
			int newPassengerId = passengersIds[0];
			int oldPassengerId = vehiclePassenger.put(vehicleId, newPassengerId);
			if (oldPassengerId == vehiclePassenger.defaultReturnValue()) {
				return RecyclableSingletonList.create(create(newPassengerId, vehicleId));
			} else if (newPassengerId != oldPassengerId) {
				RecyclableArrayList<ClientBoundPacketData> packets = RecyclableArrayList.create();
				packets.add(create(oldPassengerId, -1));
				packets.add(create(newPassengerId, vehicleId));
				return packets;
			}
		}
		return RecyclableEmptyList.get();
	}

	protected static ClientBoundPacketData create(int passengerId, int vehicleId) {
		ClientBoundPacketData serializer = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ENTITY_LEASH);
		serializer.writeInt(passengerId);
		serializer.writeInt(vehicleId);
		return serializer;
	}

}
