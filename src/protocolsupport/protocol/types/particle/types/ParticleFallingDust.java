package protocolsupport.protocol.types.particle.types;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.types.particle.Particle;

public class ParticleFallingDust extends Particle {

	protected int blockdata;

	public ParticleFallingDust() {
	}

	public ParticleFallingDust(float offsetX, float offsetY, float offsetZ, float data, int count, int blockdata) {
		super(offsetX, offsetY, offsetZ, data, count);
		this.blockdata = blockdata;
	}

	public int getBlockData() {
		return blockdata;
	}

	@Override
	public void readData(ByteBuf buf) {
		blockdata = VarNumberSerializer.readVarInt(buf);
	}

}
