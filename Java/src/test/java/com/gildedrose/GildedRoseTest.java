package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void quality_decreases_by_one_after_a_day() {
        Item[] items = new Item[] { new Item("Basic Sword", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 19;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }

    @Test
    void sellIn_decreases_by_one_after_a_day() {
        Item[] items = new Item[] { new Item("Basic Sword", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedSellIn = 9;
        app.updateQuality();
        assertEquals(expectedSellIn,app.items[0].sellIn);
    }

    @Test
    void quality_decreases_by_two_if_sellIn_is_lower_than_zero() {
        Item[] items = new Item[] { new Item("Basic Sword", 0, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 18;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }

    @Test
    void aged_brie_quality_increases_after_a_day() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 21;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }
    @Test
    void aged_brie_quality_increases_by_two_if_sell_day_is_lower_than_zero() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 22;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }

    @Test
    void sulfuras_quality_does_not_change() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 20;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }

    @Test
    void sulfuras_sell_day_does_not_change() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedSellIn = 10;
        app.updateQuality();
        assertEquals(expectedSellIn,app.items[0].sellIn);
    }

    @Test
    void backstagePass_quality_increases_by_one_if_sell_day_greater_than_ten() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 21;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }

    @Test
    void backstagePass_quality_increases_by_two_when_sell_days_ten_or_less() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 22;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }

    @Test
    void backstagePass_quality_increases_by_three_when_sell_days_five_or_less() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 23;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }

    @Test
    void backstagePass_quality_turns_zero_when_sell_days_less_than_zero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();
        assertEquals(expectedQuality,app.items[0].quality);
    }
}
