package com.jw.myproject.pattern.strategy.promotion;

/**
 * 优惠券策略
 * @author lijw
 * @date 2020/11/18 19:29
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程的价格就直接减去优惠券面值");
    }
}
