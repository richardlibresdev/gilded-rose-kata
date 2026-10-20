package strategy;

import com.gildedrose.Item;

public class ConjuredStrategy implements ItemStrategy {

    private static final int DEGRADE_RATE = 2;

    @Override
    public void update(Item item) {
        item.sellIn = item.sellIn - 1;

        QualityRules.decrease(item, DEGRADE_RATE);
        if (item.sellIn < 0) {
            QualityRules.decrease(item, DEGRADE_RATE);
        }
    }
}
