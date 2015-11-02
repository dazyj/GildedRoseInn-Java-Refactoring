package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest 
{
	@Test
	public void scenario1()
	{
		ArrayList<Item> items = new ArrayList<Item>();
		Item item = new Item("item", 5, 7);
		int saveSellInItem = item.getSellIn();
		int saveQualityItem = item.getQuality();
		items.add(item);
		GildedRose.updateShop(items);
		Assert.assertEquals(item.getSellIn(), saveSellInItem - 1);
		Assert.assertEquals(item.getQuality(), saveQualityItem - 1);
	}
	
	
}
