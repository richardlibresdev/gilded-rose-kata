package strategy;

import com.gildedrose.Item;

public class BackstageStrategy implements ItemStrategy {

    @Override
    public void update(Item item) {
        QualityRules.increase(item);

        if (item.sellIn < 11) {
            QualityRules.increase(item,2);
        }
        if (item.sellIn < 6) {
            QualityRules.increase(item,3);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = QualityRules.MIN_QUALITY;
        }
    }
}
