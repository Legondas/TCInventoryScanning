package net.blay09.mods.tcinventoryscan.net;

import net.blay09.mods.tcinventoryscan.TCInventoryScanning;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class HandlerHello implements IMessageHandler<MessageHello, IMessage> {

    @Override
    public IMessage onMessage(MessageHello message, MessageContext ctx) {
        TCInventoryScanning.proxy.receivedHello(ctx.side == Side.SERVER ? ctx.getServerHandler().playerEntity : null);
        return ctx.side == Side.CLIENT ? new MessageHello(NetworkHandler.PROTOCOL_VERSION) : null;
    }

}