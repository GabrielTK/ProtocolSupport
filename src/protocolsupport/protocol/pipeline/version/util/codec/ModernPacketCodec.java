package protocolsupport.protocol.pipeline.version.util.codec;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.pipeline.IPacketCodec;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public abstract class ModernPacketCodec extends IPacketCodec {

	@Override
	public int readPacketId(ByteBuf from) {
		return VarNumberSerializer.readVarInt(from);
	}

	@Override
	protected void writePacketId(ByteBuf to, int packetId) {
		VarNumberSerializer.writeVarInt(to, packetId);
	}

}
