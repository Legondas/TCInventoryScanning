package net.blay09.mods.tcinventoryscan.net;

import net.blay09.mods.tcinventoryscan.TCInventoryScanning;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {

    public static final SimpleNetworkWrapper instance = new SimpleNetworkWrapper(TCInventoryScanning.MOD_ID);
    public static final int PROTOCOL_VERSION = 1;

    public static void init() {
        instance.registerMessage(HandlerScanSlot.class, MessageScanSlot.class, 0, Side.SERVER);
        instance.registerMessage(HandlerScanSelf.class, MessageScanSelf.class, 1, Side.SERVER);
        instance.registerMessage(HandlerHello.class, MessageHello.class, 2, Side.SERVER);
        instance.registerMessage(HandlerHello.class, MessageHello.class, 3, Side.CLIENT);
    }

}
