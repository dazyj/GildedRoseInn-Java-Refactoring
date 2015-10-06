package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateShop();
	}
	
	//updateShop
	public static void updateShop()
	{
		
		for (int i = 0; i < items.size(); i++)
		{
			
			
			if ((!"Aged Brie".equals(items.get(i).getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
			{
				//We find this block 2 times.
				//TODO new method
				testQualityPositiveAndDecrement(i);
			}
			
			
			else
			{
				if (items.get(i).getQuality() < 50)
				{
					items.get(i).setQuality(items.get(i).getQuality() + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
					{
						if (items.get(i).getSellIn() < 11)
						{
							testQualityInf50AndIncrement(i);
						}

						if (items.get(i).getSellIn() < 6)
						{
							testQualityInf50AndIncrement(i);
						}
					}
				}
			}

			
			
			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
			{
				items.get(i).setSellIn(items.get(i).getSellIn() - 1);
			}

			
			
			if (items.get(i).getSellIn() < 0)
			{
				if (!"Aged Brie".equals(items.get(i).getName()))
				{
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
					{
						testQualityPositiveAndDecrement(i);
					}
					else
					{
						items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
					}
				}
				
				
				else
				{
					testQualityInf50AndIncrement(i);
				}
			}
		}
	}

	private static void testQualityInf50AndIncrement(int i) {
		if (items.get(i).getQuality() < 50)
		{
			items.get(i).setQuality(items.get(i).getQuality() + 1);
		}
	}

	private static void testQualityPositiveAndDecrement(int i) {
		if (items.get(i).getQuality() > 0)
		{
			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
			{
				items.get(i).setQuality(items.get(i).getQuality() - 1);
			}
		}
	}

}