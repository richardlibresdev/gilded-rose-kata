package strategy;

import com.gildedrose.Item;

public final class QualityRules {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    private QualityRules() {

    }

    public static void increase(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    public static void increase(Item item, int amount) {
        for (int i = 0; i < amount; i++) {
            increase(item);
        }
    }

    public static void decrease(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }
    public static void decrease(Item item, int amount) {
        for (int i = 0; i < amount; i++) {
            decrease(item);
        }
    }
}
