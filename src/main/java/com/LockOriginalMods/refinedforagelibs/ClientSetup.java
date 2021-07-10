package com.LockOriginalMods.refinedforagelibs;


import com.LockOriginalMods.refinedforagelibs.blocks.CoalGeneratorScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;



@Mod.EventBusSubscriber(modid = RefinedForageLibs.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
        ScreenManager.register(Registration.COAL_GENERATOR_CONTAINER.get(), CoalGeneratorScreen::new);

        event.enqueueWork(() -> {
        });
    }
    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event) {
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(RefinedForageLibs.MOD_ID)) {
            event.setMaxWidth(200);
        }
    }
}
