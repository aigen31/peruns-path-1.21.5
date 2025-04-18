package com.perunspath.items;

import java.util.function.Function;

import com.perunspath.PerunsPathClient;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class TestItems {
  public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
    RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM,Identifier.of(PerunsPathClient.MOD_ID, name));

    Item item = itemFactory.apply(settings.registryKey(itemKey));

    Registry.register(Registries.ITEM, itemKey, item);

    return item;
  }

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
      itemGroup.add(TestItems.TEST_ITEM);
    });
  }

  public static final Item TEST_ITEM = register("test_item", Item::new, new Item.Settings());
}
