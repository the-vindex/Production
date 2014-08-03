package vswe.production;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import vswe.production.block.ModBlocks;
import vswe.production.gui.GuiHandler;
import vswe.production.network.PacketHandler;

@Mod(modid = "StevesProduction", name = "Steve's Production", version = "inDev")
public class StevesProduction {
    public static String CHANNEL = "SProd";

    public static FMLEventChannel packetHandler;

    @Mod.Instance("StevesProduction")
    public static StevesProduction instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        packetHandler = NetworkRegistry.INSTANCE.newEventDrivenChannel(CHANNEL);
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        packetHandler.register(new PacketHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
