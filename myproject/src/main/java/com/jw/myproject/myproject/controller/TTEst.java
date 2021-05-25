//package test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.itextpdf.awt.geom.Rectangle2D.Float;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.parser.ImageRenderInfo;
//import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
//import com.itextpdf.text.pdf.parser.RenderListener;
//import com.itextpdf.text.pdf.parser.TextRenderInfo;
//
//public class Test {
//
//    // 指定关键字
//    public static String KEY_WORD = "总计:";
//    // PDF当前页数
//    public static int curPage = 0;
//    // 集合里放了多少条数据
//    public static int count = 0;
//    // 坐标信息集合
//    public static List<float[]> arrays = new ArrayList<float[]>();
//    // 关键字字符数组
//    public static char[] charArray = KEY_WORD.toCharArray();
//
//    /**
//     * 获取指定PDF文件中指定关键字的坐标
//     *
//     * @param filePath
//     * @return
//     * @throws Exception
//     */
//    public static List<float[]> getKeyWordCoordinate(String filePath) throws Exception {
//        if (charArray.length < 2) {
//            throw new Exception("关键字长度不能小于2");
//        }
//        PdfReader pdfReader = null;
//        try {
//            pdfReader = new PdfReader(filePath);
//            int pageNum = pdfReader.getNumberOfPages();
//            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);
//            for (curPage = 1; curPage <= pageNum; curPage++) {
//                pdfReaderContentParser.processContent(curPage, new RenderListener() {
//                    // 关键字标志
//                    boolean isKeyWord = false;
//                    // PDF读出来的文字与截取关键字的第index位对比，如果在关键字的长度里
//                    /**
//                     * 这里从PDF中是一个一个读取文字的，把读取出来的PDF文字先和关键字的第一个字比较看是否相同：
//                     * 如果相同，则假设已经找到关键字（将isKeyWord设为true），把这个关键字的坐标存到集合里面，并计算集合里存放了多少个数据（count++）、设置进入到一个循环（loop
//                     * = true一个循环即为关键字从第一个字到最后一个字依次和读取的PDF文字比较的过程）；
//                     * 如果在这个比较过程中发现有的字符和关键字不匹配，则移除与之对应的集合里的数据。
//                     */
//                    // 关键字的第几位
//                    int index = 0;
//                    // 对比关键字是否进入到一个循环
//                    boolean loop = false;
//
//                    // 处理数据
//                    public void renderText(TextRenderInfo textRenderInfo) {
//                        String text = textRenderInfo.getText();
//                        if (text.equals(new String(charArray, 0, 1)) && text != null) {
//                            // 把当前从PDF文件中读取的文字横坐标、纵坐标和当前页存到集合里面
//                            Float boundingRectange = textRenderInfo.getBaseline().getBoundingRectange();
//                            float[] resu = new float[3];
//                            resu[0] = boundingRectange.x;
//                            resu[1] = boundingRectange.y;
//                            resu[2] = curPage;
//                            arrays.add(resu);
//                            count++;
//
//                            isKeyWord = true;
//                            loop = true;
//                            return;
//                        }
//
//                        if (isKeyWord) {
//                            // 获取关键字中下一个字符和读取文字比较
//                            index++;
//
//                            if (index < charArray.length) {
//                                if (text.equalsIgnoreCase(new String(charArray, index, 1)) && text != null) {
//                                    isKeyWord = true;
//                                    return;
//                                } else {
//                                    isKeyWord = false;
//                                    // 如果在一个循环中比较时，发现有字符和关键字不匹配，则移除与之对应的集合里的数据
//                                    if (loop) {
//                                        count--;
//                                        arrays.remove(count);
//                                    }
//                                }
//                            } else {
//                                // 如果index大于关键字字符数组的长度，则该循环结束
//                                loop = false;
//                            }
//                        }
//
//                        index = 0;
//                    }
//
//                    public void renderImage(ImageRenderInfo arg0) {
//
//                    }
//
//                    public void endTextBlock() {
//
//                    }
//
//                    public void beginTextBlock() {
//
//                    }
//                });
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (pdfReader != null) {
//                pdfReader.close();
//            }
//        }
//
//        return arrays;
//    }
//
//    //测试
//    public static void main(String[] args) throws Exception {
//        String filePath = "F:/test.pdf";
//        List<float[]> list = getKeyWordCoordinate(filePath);
//        for (float[] f : list) {
//            System.out.println("x坐标：" + f[0] + "，y坐标：" + f[1] + "， 关键字所在页：" + f[2]);
//        }
//    }
//
//}
