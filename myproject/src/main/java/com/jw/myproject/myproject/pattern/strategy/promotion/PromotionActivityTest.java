package com.jw.myproject.myproject.pattern.strategy.promotion;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lijw
 * @date 2020/11/18 19:34
 */
public class PromotionActivityTest {

//    public static void main(String[] args) {
//        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
//        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());
//
//        activity618.execute();
//        activity1111.execute();
//    }

    public static void main(String[] args) {
        PromotionActivity promotionActivity = null;

        String promotionKey = "COUPON";

        if (StringUtils.equals(promotionKey, "COUPON")) {
            promotionActivity = new PromotionActivity(new CouponStrategy());
        } else if (StringUtils.equals(promotionKey, "CASHBACK")) {
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }// .........
        promotionActivity.execute();
    }
}
