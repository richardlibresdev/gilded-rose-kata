package strategy;

import com.gildedrose.Item;

public class BackstageStrategy implements ItemStrategy {

    int INCREASE_RATE = 1;

    @Override
    public void update(Item item) {


        if (item.sellIn < 11) {
            INCREASE_RATE = 2;
        }
        if (item.sellIn < 6) {
            INCREASE_RATE = 3;
        }

        QualityRules.increase(item,INCREASE_RATE);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = QualityRules.MIN_QUALITY;
        }
    }
}
