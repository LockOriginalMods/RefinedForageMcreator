package com.LockOriginalMods.refinedforagelibs;



import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = RefinedForageLibs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

    public static final ItemGroup ITEM_GROUP = new ItemGroup("refinedforagelibstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.COAL_GENERATOR.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event) {
        Networking.registerMessages();



        event.enqueueWork(() -> {

        });
    }


}
