package com.jw.myproject.pattern.strategy.promotion;

/**
 * 团购策略
 * @author lijw
 * @date 2020/11/18 19:31
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人开团，全团享受团购价格");
    }
}
