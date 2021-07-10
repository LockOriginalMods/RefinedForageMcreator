package com.LockOriginalMods.refinedforagelibs;

import com.LockOriginalMods.refinedforagelibs.blocks.CoalGenerator;
import com.LockOriginalMods.refinedforagelibs.blocks.CoalGeneratorContainer;
import com.LockOriginalMods.refinedforagelibs.blocks.CoalGeneratorTile;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.LockOriginalMods.refinedforagelibs.RefinedForageLibs.MOD_ID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<CoalGenerator> COAL_GENERATOR = BLOCKS.register("coal_generator", CoalGenerator::new);
    public static final RegistryObject<Item> COAL_GENERATOR_ITEM = ITEMS.register("coal_generator", () -> new BlockItem(COAL_GENERATOR.get(), new Item.Properties().tab(ModSetup.ITEM_GROUP)));


    public static final RegistryObject<TileEntityType<CoalGeneratorTile>> COAL_GENERATOR_TILE = TILES.register("coal_generator", () -> TileEntityType.Builder.of(CoalGeneratorTile::new, COAL_GENERATOR.get()).build(null));

    public static final RegistryObject<ContainerType<CoalGeneratorContainer>> COAL_GENERATOR_CONTAINER = CONTAINERS.register("coal_generator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getCommandSenderWorld();
        return new CoalGeneratorContainer(windowId, world, pos, inv, inv.player);
    }));


}
