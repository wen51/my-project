package com.jw.myproject.myproject.utils;

import com.itextpdf.text.pdf.BaseFont;
import com.jw.myproject.myproject.demo.freemarker.FreemarkerInfo;
import com.lowagie.text.DocumentException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.util.ResourceUtils;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.*;

/**
 * 通过freemarker生成pdf
 * @author lijw
 * @date 2021/11/4 17:25
 */
public class PdfUtil2 {

    private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
    private static ITextRenderer renderer = new ITextRenderer();

    static {
//        renderer.setDocumentFromString(htmlContent);
        ITextFontResolver fontResolver = renderer.getFontResolver();
        // 解决中文支持问题,需要所需字体(ttc)文件
        try {
            fontResolver.addFont("templates/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String freemarkerRender(Map<String, Object> dataMap, String ftlFilePath) {
        Writer out = new StringWriter();
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        try {
            configuration.setDirectoryForTemplateLoading(new File(getParent(ftlFilePath)));
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
            Template template = configuration.getTemplate(getFileName(ftlFilePath));
            template.process(dataMap, out);
            out.flush();
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static ByteArrayOutputStream htmlToPdf(String htmlContent) {
        try {
//            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
//            ITextFontResolver fontResolver = renderer.getFontResolver();
//            // 解决中文支持问题,需要所需字体(ttc)文件
//            fontResolver.addFont(getAbsolutePath(fontPath), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.layout();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            renderer.createPDF(outputStream);
            return outputStream;
        } catch (Exception e) {
            throw new RuntimeException("html转换pdf失败!", e);
        }
    }

    /**
     * 获取资源文件
     *
     * @param relativePath 资源文件相对路径(相对于 resources路径,路径 + 文件名)
     *                     eg: "templates/pdf_export_demo.ftl"
     * @return
     * @throws FileNotFoundException
     */
    public static File getFile(String relativePath) throws FileNotFoundException {
        if (relativePath == null || relativePath.length() == 0) {
            return null;
        }
        if (relativePath.startsWith("/")) {
            relativePath = relativePath.substring(1);
        }
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX
                + relativePath);

        return file;
    }

    /**
     * 获取资源父级目录
     *
     * @param relativePath 资源文件相对路径(相对于 resources路径,路径 + 文件名)
     *                     eg: "templates/pdf_export_demo.ftl"
     * @return
     * @throws FileNotFoundException
     */
    public static String getParent(String relativePath) throws FileNotFoundException {
        return getFile(relativePath).getParent();
    }

    /**
     * 获取资源文件名
     *
     * @param relativePath 资源文件相对路径(相对于 resources路径,路径 + 文件名)
     *                     eg: "templates/pdf_export_demo.ftl"
     * @return
     * @throws FileNotFoundException
     */
    public static String getFileName(String relativePath) throws FileNotFoundException {
        return getFile(relativePath).getName();
    }

    public static String getAbsolutePath(String relativePath) throws FileNotFoundException {
        return getFile(relativePath).getAbsolutePath();
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = new HashMap<>();
        List<FreemarkerInfo> dataInfos = new ArrayList<>();
        ;
        for (int i = 0; i < 20; i++) {
            dataInfos.add(geneInfo());
        }
        data.put("dataInfos", dataInfos);


        ByteArrayOutputStream byteArrayOutputStream = genePdf(data);

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.pdf");
        fos.write(byteArrayOutputStream.toByteArray());

    }

    private static ByteArrayOutputStream genePdf(Map<String, Object> data) {
        String htmlStr = freemarkerRender(data, "templates/purchase.ftl");
        return htmlToPdf(htmlStr);
    }


    public static FreemarkerInfo geneInfo() {
        FreemarkerInfo info = new FreemarkerInfo();
        FreemarkerInfo.Receipt receipt = new FreemarkerInfo.Receipt();
        receipt.setId("CGDD1234567890");
        receipt.setName("烦躁公司");
        receipt.setCreateTime(new Date());
        receipt.setPrintName("张三");
        receipt.setPrintTime(new Date());
        receipt.setRemark("备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注");
        info.setReceiptInfo(receipt);

        FreemarkerInfo.Prepaid Prepaid = new FreemarkerInfo.Prepaid();
        Prepaid.setBilling(1000000012L);
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
        for (int i = 0; i < 5; i++) {
            FreemarkerInfo.Goods Goods = new FreemarkerInfo.Goods();
            Goods.setBrandId("品牌品牌品牌品牌品牌品牌" + i);
            Goods.setCategoryId("品类品类品类品类" + i);
            Goods.setFinalPurchasePrice(1000000L + i);
            Goods.setGoodsName("商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称" + i);
            Goods.setGoodsNo("SPBH234567890" + i);
            Goods.setQuantity(5000 + i);
            Goods.setRemark(i + "备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注");
            Goods.setUnit("个" + i);
            GoodsTab.getGoodsList().add(Goods);
        }
        return info;
    }
}