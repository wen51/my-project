package com.jw.myproject.myproject;

import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过freemarker生成PDF文件
 * @author lijw
 * @date 2021/10/26 18:17
 */
public class FreemarkerPdfController {

    public static void main(String[] args) {
        /**
         * 初始化freemarker配置
         * templateRoot：模板文件根目录
         */
        Configuration freemarkerCfg = initFreemarkerCfg("classpath:/templates/sale.ftl");

//        Map<String, Object> data = new HashMap<>();
//        data.put("name", "撒旦飞洒发生");

        FreemarkerInfo info = new FreemarkerInfo();
        FreemarkerInfo.Receipt receipt = new FreemarkerInfo.Receipt();
        receipt.setId("CGDD1234567890");
        receipt.setName("烦躁公司");
//        receipt.setCreateTime(LocalDateTime.now());
//        receipt.setPrintName("张三");
//        receipt.setPrintTime(LocalDateTime.now());
        info.setReceiptInfo(receipt);

        FreemarkerInfo.Prepaid Prepaid = new FreemarkerInfo.Prepaid();
        Prepaid.setBilling(1000000000L);
        Prepaid.setPaidAccount("6228482345678");
        Prepaid.setPaidType("现金");
        info.setPrepaidInfo(Prepaid);

        FreemarkerInfo.Receive Receive = new FreemarkerInfo.Receive();
        Receive.setAddress("杭州市西湖区西斗门路");
        Receive.setConsignee("王二");
        Receive.setMobileNumber("18812349876");
        info.setReceiveInfo(Receive);

        FreemarkerInfo.GoodsTab GoodsTab = new FreemarkerInfo.GoodsTab();
        GoodsTab.setGoodsCount(3);
        GoodsTab.setCount(1000);
        GoodsTab.setAmount(586472004);
        GoodsTab.setFreigt(2400);
        GoodsTab.setGoodsList(new ArrayList<>());
        info.setGoodsTab(GoodsTab);
        for (int i = 0; i < 20; i++) {
            FreemarkerInfo.Goods Goods = new FreemarkerInfo.Goods();
            Goods.setBrandId("品牌品牌品牌品牌品牌品牌" + i);
            Goods.setCategoryId("品类品类品类品类" + i);
            Goods.setFinalPurchasePrice(1000000L + i);
            Goods.setGoodsName("商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称" + i);
            Goods.setGoodsNo("SPBH234567890" + i);
            Goods.setQuantity(5000 + i);
            Goods.setUnit("个" + i);
            GoodsTab.getGoodsList().add(Goods);
        }

        /**
         * 将模板转换为HTML字符串
         */
        String content = freeMarkerRender(info, freemarkerCfg, "sale.ftl", "UTF-8");
        htmlToPdf(content, null);
    }


    private static Configuration initFreemarkerCfg(String templateRoot) {
        Configuration freemarkerCfg = new Configuration();
        try {
            freemarkerCfg.setDirectoryForTemplateLoading(new File(templateRoot));
        } catch (IOException e) {
//            log.error("模板根路径获取失败!" + templateRoot, e);
            throw new RuntimeException("模板根路径获取失败!" + templateRoot,e);
        }
        return freemarkerCfg;
    }

    /**
     * data 需要注入模板的数据
     * freemarkerCfg freemarker配置
     * htmlTmp 模板名称
     * charSet 字符集 linux下使用UTF-8,windows下使用GBK，否则会出现中文乱码，模板文件的文件编码和声明编码同样需要保持一致
     */
    private static String freeMarkerRender(Object data, Configuration freemarkerCfg, String htmlTmp, String charSet) {
        try (Writer out = new StringWriter();) {
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding(charSet);
            template.process(data, out);
            out.flush();
            return out.toString();
        } catch (Exception e) {
//            log.error("HTML加载数据失败!", e);
            throw new RuntimeException("HTML加载数据失败!", e);
        }
    }

    /**
     * htmlContent 通过freemarker生成的html
     * fontPath 字体文件路径
     * ByteArrayOutputStream pdf文件流
     */
    private static ByteArrayOutputStream htmlToPdf(String htmlContent, String fontPath) {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ITextRenderer render = new ITextRenderer();
//            ITextFontResolver fontResolver = render.getFontResolver();
//            fontResolver.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            render.setDocumentFromString(htmlContent);
//            render.getSharedContext().setBaseURL(BASE_URL);
            render.layout();
            render.createPDF(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\sale.pdf")));
            return output;
        } catch (Exception e) {
//            log.debug("html转换pdf失败!", e);
            throw new RuntimeException("html转换pdf失败!", e);
        }
    }
}
