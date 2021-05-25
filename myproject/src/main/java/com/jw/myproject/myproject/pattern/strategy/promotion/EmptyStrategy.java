package com.jw.myproject.myproject.pattern.strategy.promotion;

/**
 * @author lijw
 * @date 2020/11/18 19:29
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
