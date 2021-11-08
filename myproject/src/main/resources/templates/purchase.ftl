<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>飞象企服</title>
    <style>
        body{background:#fff;color:#2E3133;font-family:SimSun}.table-content{margin-top:15px;}table{font-size:12px;width:100%;border-collapse: collapse;table-layout:fixed; word-break:break-strict;border:1px solid}table td,table th{border-left:0;border-right:0;border-bottom:1px solid;}
        table th{background:#ededed;color:#000;height:28px;font-size: 12px;border-bottom: 0!important;}table td{padding:9px 0;}.t-right{text-align: right;}.t-center{text-align: center}.t-left{text-align: left}
        .print-content{margin-bottom:45px;page-break-after:always;}.print-content:last-child{page-break-after: auto;}
        .voucher-head {border: 0;padding-top: 20px;border-bottom: 1px solid #2E3133;}
        tbody tr {page-break-inside:avoid;}td{word-wrap:break-word;word-break: break-all;}
        .mb10 {margin-bottom: 10px;}.border0{border: 0;}.f14{font-size:14px;}.f18{font-size:18px;}.pr20{padding-right: 20px;}
        @page {
            counter-increment: page;
            counter-reset: page 1;
            @bottom-center {
                content: counter(page) " / " counter(pages);
            };
        };  
    </style>
</head>
<body>
<#list dataInfos as dataInfo>
<div class="print-content">
    <div class="f18 t-center">采购订单</div>
    <div class="f14 t-center">${dataInfo.receiptInfo.name?html}</div>
    <table class="voucher-head">
        <tr class="border0">
            <td class="border0">制单时间：${dataInfo.receiptInfo.createTime?string("yyyy-MM-dd HH:MM:ss")}</td>
	        <td class="border0">制单人：</td>
            <td class="border0 t-right">单据编号：${dataInfo.receiptInfo.id?html}</td>
        </tr>
    </table>
    <table class="voucher-head">
        <tr class="border0">
            <td class="border0">
                <p class="f14">收货信息</p>
                <p>联系人：${dataInfo.receiveInfo.consignee?html}</p>
                <p>联系方式：${dataInfo.receiveInfo.mobileNumber?html}</p>
                <p>收货地址：${dataInfo.receiveInfo.address?html}</p>
            </td>
	        <td class="border0">
                <p class="f14">预付货款</p>
                <p>付款账户：${dataInfo.prepaidInfo.paidAccount?html}</p>
                <p>付款方式：${dataInfo.prepaidInfo.paidType?html}</p>
                <p>付款金额：￥${(dataInfo.prepaidInfo.billing/100)?default(0.00)?string('##0.00')!}</p>
            </td>
        </tr>
    </table>
    <div class="table-content">
        <div class="mb10 f14">
            商品共${dataInfo.goodsTab.goodsCount?html}种，总数${dataInfo.goodsTab.count?html}，运费总计：￥${(dataInfo.goodsTab.freigt/100)?default(0.00)?string('##0.00')!}，采购总金额：￥${(dataInfo.goodsTab.amount/100)?default(0.00)?string('##0.00')!}
        </div>
        <table>
            <thead>
                <td class="t-center" style="width:5%">序号</td>
                <td class="t-center" style="width:20%">商品名称</td>
                <td class="t-center" style="width:10%">所属品类</td>
                <td class="t-center" style="width:10%">商品品牌</td>
                <td class="t-center" style="width:10%">规格货号</td>
                <td class="t-center" style="width:8%">单位</td>
                <td class="t-center" style="width:10%">采购数量</td>
                <td class="t-center" style="width:10%">含税单价</td>
                <td class="t-center" style="width:12%">商品备注</td>
            </thead>
            <tbody>
            <#list dataInfo.goodsTab.goodsList as item>
                <tr>
                    <td class="t-center">${item_index + 1}</td>
                    <td class="t-left">${item.goodsName?html}</td>
                    <td class="t-center">${item.categoryId?html}</td>
                    <td class="t-center">${item.brandId?html}</td>
                    <td class="t-center">${item.goodsNo?html}</td>
                    <td class="t-center">${item.unit?html}</td>
                    <td class="t-center">${item.quantity?html}</td>
                    <td class="t-center">￥${(item.finalPurchasePrice/100)?default(0.00)?string('##0.00')!}</td>
                    <td class="t-center">${item.remark?html}</td>
                </tr>
            </#list>
            </tbody>
        </table>
        <table class="voucher-info border0">
            <tr class="border0">
                <td class="border0">单据备注：${dataInfo.receiptInfo.remark?html}</td>
            </tr>
        </table>
        <table class="voucher-info border0 f-14" style="position: fixed;bottom: 0;color:#2E3133">
            <tr class="border0">
                <td class="border0 t-right">
                    <span class="pr20" style="color:#2E3133;">打印人：${dataInfo.receiptInfo.printName?html}</span>
                    <span style="color:#2E3133;">打印时间：${dataInfo.receiptInfo.printTime?string("yyyy-MM-dd HH:MM:ss")}</span>
                </td>
            </tr>
        </table>
    </div>
</div>
</#list>
</body>
</html>
