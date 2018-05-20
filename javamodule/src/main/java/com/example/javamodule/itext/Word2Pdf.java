package com.example.javamodule.itext;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by steven on 2018/1/31.
 */

public class Word2Pdf {

    static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。
    static final int wdFormatPDF = 17;// word转PDF 格式
    static final int ppSaveAsPDF = 32;// ppt 转PDF 格式

    public static void main(String[] args) throws IOException {
        String source1 = "e:\\test.doc";
        String source2 = "e:\\asd.xlsx";
        String source3 = "e:\\aa.ppt";
        String target1 = "e:\\test1.pdf";
        String target2 = "e:\\test2.pdf";
        String target3 = "e:\\test3.pdf";

        Word2Pdf pdf = new Word2Pdf();
//  pdf.word2pdf(source1, target1);
//  pdf.excel2pdf(source2, target2);
//  pdf.ppt2pdf(source3, target3);
  pdf.imgToPdf("e:/12345.jpg","e:/zq.pdf");
    }

    public void word2pdf(String source,String target){
        System.out.println("启动Word");
        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        try {
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", false);

            Dispatch docs = app.getProperty("Documents").toDispatch();
            System.out.println("打开文档" + source);
            Dispatch doc = Dispatch.call(docs,//
                    "Open", //
                    source,// FileName
                    false,// ConfirmConversions
                    true // ReadOnly
            ).toDispatch();

            System.out.println("转换文档到PDF " + target);
            File tofile = new File(target);
            if (tofile.exists()) {
                tofile.delete();
            }
            Dispatch.call(doc,//
                    "SaveAs", //
                    target, // FileName
                    wdFormatPDF);

            Dispatch.call(doc, "Close", false);
            long end = System.currentTimeMillis();
            System.out.println("转换完成..用时：" + (end - start) + "ms.");
        } catch (Exception e) {
            System.out.println("========Error:文档转换失败：" + e.getMessage());
        } finally {
            if (app != null)
                app.invoke("Quit", wdDoNotSaveChanges);
        }
    }

    public void ppt2pdf(String source,String target){
        System.out.println("启动PPT");
        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        try {
            app = new ActiveXComponent("Powerpoint.Application");
            Dispatch presentations = app.getProperty("Presentations").toDispatch();
            System.out.println("打开文档" + source);
            Dispatch presentation = Dispatch.call(presentations,//
                    "Open",
                    source,// FileName
                    true,// ReadOnly
                    true,// Untitled 指定文件是否有标题。
                    false // WithWindow 指定文件是否可见。
            ).toDispatch();

            System.out.println("转换文档到PDF " + target);
            File tofile = new File(target);
            if (tofile.exists()) {
                tofile.delete();
            }
            Dispatch.call(presentation,//
                    "SaveAs", //
                    target, // FileName
                    ppSaveAsPDF);

            Dispatch.call(presentation, "Close");
            long end = System.currentTimeMillis();
            System.out.println("转换完成..用时：" + (end - start) + "ms.");
        } catch (Exception e) {
            System.out.println("========Error:文档转换失败：" + e.getMessage());
        } finally {
            if (app != null) app.invoke("Quit");
        }
    }

    public void excel2pdf(String source, String target) {
        System.out.println("启动Excel");
        long start = System.currentTimeMillis();
        ActiveXComponent app = new ActiveXComponent("Excel.Application"); // 启动excel(Excel.Application)
        try {
            app.setProperty("Visible", false);
            Dispatch workbooks = app.getProperty("Workbooks").toDispatch();
            System.out.println("打开文档" + source);
            Dispatch workbook = Dispatch.invoke(workbooks, "Open", Dispatch.Method, new Object[]{source, new Variant(false),new Variant(false)}, new int[3]).toDispatch();
            Dispatch.invoke(workbook, "SaveAs", Dispatch.Method, new Object[] {
                    target, new Variant(57), new Variant(false),
                    new Variant(57), new Variant(57), new Variant(false),
                    new Variant(true), new Variant(57), new Variant(true),
                    new Variant(true), new Variant(true) }, new int[1]);
            Variant f = new Variant(false);
            System.out.println("转换文档到PDF " + target);
            Dispatch.call(workbook, "Close", f);
            long end = System.currentTimeMillis();
            System.out.println("转换完成..用时：" + (end - start) + "ms.");
        } catch (Exception e) {
            System.out.println("========Error:文档转换失败：" + e.getMessage());
        }finally {
            if (app != null){
                app.invoke("Quit", new Variant[] {});
            }
        }
    }



    public boolean imgToPdf(String imgFilePath, String pdfFilePath)throws IOException {
        File file=new File(imgFilePath);
        if(file.exists()){
            Document document = new Document();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(pdfFilePath);
                PdfWriter.getInstance(document, fos);

                // 添加PDF文档的某些信息，比如作者，主题等等
                document.addAuthor("arui");
                document.addSubject("test pdf.");
                // 设置文档的大小
                document.setPageSize(PageSize.A4);
                // 打开文档
                document.open();
                // 写入一段文字
                //document.add(new Paragraph("JUST TEST ..."));
                // 读取一个图片
                Image image = Image.getInstance(imgFilePath);
                float imageHeight=image.getScaledHeight();
                float imageWidth=image.getScaledWidth();
                int i=0;
                while(imageHeight>500||imageWidth>500){
                    image.scalePercent(100-i);
                    i++;
                    imageHeight=image.getScaledHeight();
                    imageWidth=image.getScaledWidth();
                    System.out.println("imageHeight->"+imageHeight);
                    System.out.println("imageWidth->"+imageWidth);
                }

                image.setAlignment(Image.ALIGN_CENTER);
//        //设置图片的绝对位置
                // image.setAbsolutePosition(0, 0);
                // image.scaleAbsolute(500, 400);
                // 插入一个图片
                document.add(image);
            } catch (DocumentException de) {
                System.out.println(de.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            document.close();
            fos.flush();
            fos.close();
            return true;
        }else{
            return false;
        }
    }
}
