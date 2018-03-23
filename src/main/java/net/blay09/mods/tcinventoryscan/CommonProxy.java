package net.blay09.mods.tcinventoryscan;

import net.blay09.mods.tcinventoryscan.net.MessageHello;
import net.blay09.mods.tcinventoryscan.net.NetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CommonProxy {

    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void receivedHello(EntityPlayer entityPlayer) {
    }

    @SubscribeEvent
    public void playerJoined(PlayerEvent.PlayerLoggedInEvent event) {
        NetworkHandler.instance.sendTo(new MessageHello(NetworkHandler.PROTOCOL_VERSION), (EntityPlayerMP) event.player);
    }
}
