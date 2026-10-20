package com.gildedrose;

import strategy.*;

class GildedRose {
    Item[] items;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            strategyFor(item).update(item);
        }
    }

    private ItemStrategy strategyFor(Item item) {
        if (item.name.equals(SULFURAS)) {
            return new LegendaryStrategy();
        }
        if (item.name.equals(AGED_BRIE)) {
            return new AgingStrategy();
        }
        if (item.name.equals(BACKSTAGE_PASS)) {
            return new BackstageStrategy();
        }
        if (item.name.contains(CONJURED)) {
            return new ConjuredStrategy();
        }
        return new DecreaseStrategy();
    }

    public void legacyUpdate(Item item) {
        //normal quality decrease
        if (!item.name.equals("Aged Brie")
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            //aging items, quality increase
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                //Backstage quality increase
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }
        //general sellIn decrease
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
