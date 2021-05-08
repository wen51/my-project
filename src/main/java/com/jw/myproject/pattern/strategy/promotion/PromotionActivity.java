package com.jw.myproject.pattern.strategy.promotion;

/**
 * 优惠活动
 * @author lijw
 * @date 2020/11/18 19:32
 */
public class PromotionActivity {

    PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }
    /**
     * 优惠
     */
    public void execute() {
        this.promotionStrategy.doPromotion();
    }
}
