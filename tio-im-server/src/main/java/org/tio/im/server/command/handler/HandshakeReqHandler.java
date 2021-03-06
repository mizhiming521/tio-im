package org.tio.im.server.command.handler;

import org.tio.core.Aio;
import org.tio.core.ChannelContext;
import org.tio.im.common.ImPacket;
import org.tio.im.common.packets.Command;
import org.tio.im.server.command.AbCmdHandler;
import org.tio.im.server.command.handler.proc.ProCmdHandlerIntf;
import org.tio.im.server.command.handler.proc.handshake.HandshakeProCmdHandlerIntf;

public class HandshakeReqHandler extends AbCmdHandler {
	
	@Override
	public ImPacket handler(ImPacket packet, ChannelContext channelContext) throws Exception {
		ProCmdHandlerIntf proCmdHandler = this.getProcCmdHandler(channelContext);
		if(proCmdHandler == null){
			Aio.remove(channelContext, "没有对应的握手协议处理器HandshakeProCmd...");
			return null;
		}
		HandshakeProCmdHandlerIntf handShakeProCmdHandler = (HandshakeProCmdHandlerIntf)proCmdHandler;
		ImPacket handShakePacket = handShakeProCmdHandler.handshake(packet, channelContext);
		if (handShakePacket == null) {
			Aio.remove(channelContext, "业务层不同意握手");
		}
		return handShakePacket;
	}

	@Override
	public Command command() {
		return Command.COMMAND_HANDSHAKE_REQ;
	}
}
