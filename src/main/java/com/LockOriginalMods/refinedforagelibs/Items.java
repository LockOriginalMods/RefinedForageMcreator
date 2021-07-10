package com.LockOriginalMods.refinedforagelibs;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RefinedForageLibs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.COAL_GENERATOR_ITEM.get().getRegistryName().getPath(), new ResourceLocation(RefinedForageLibs.MOD_ID, "block/coal_generator"));
    }
}
