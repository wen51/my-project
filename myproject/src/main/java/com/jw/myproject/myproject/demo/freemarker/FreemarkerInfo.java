package com.jw.myproject.myproject.demo.freemarker;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lijw
 * @date 2021/11/3 18:06
 */
@Data
public class FreemarkerInfo {

    private Receipt receiptInfo;
    private Receive receiveInfo;
    private Prepaid prepaidInfo;
    private GoodsTab goodsTab;

    @Data
    public static class Receipt {
        private String name;
        private Date createTime;
        private String id;
        private String printName;
        private String remark;
        private Date printTime;
    }

    @Data
    public static class Receive {
        private String consignee;
        private String mobileNumber;
        private String address;
    }

    @Data
    public static class Prepaid {
        private String paidAccount;
        private String paidType;
        private Long billing;
    }

    @Data
    public static class GoodsTab {
        private Integer goodsCount;
        private Integer count;
        private Integer freigt;
        private Integer amount;
        private List<Goods> goodsList;
    }

    @Data
    public static class Goods {
        private String goodsName;
        private String categoryId;
        private String brandId;
        private String goodsNo;
        private String unit;
        private String remark;
        private int quantity;
        private Long finalPurchasePrice;
    }
}
