package strategy;

import com.gildedrose.Item;

public class AgingStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        item.sellIn = item.sellIn - 1;

        QualityRules.increase(item);
        if (item.sellIn < 0) {
            QualityRules.increase(item);
        }
    }
}
