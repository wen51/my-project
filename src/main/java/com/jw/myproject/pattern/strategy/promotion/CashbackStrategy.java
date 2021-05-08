package com.jw.myproject.pattern.strategy.promotion;

/**
 * 返现策略
 * @author lijw
 * @date 2020/11/18 19:30
 */
public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额直接转到支付宝");
    }
}
