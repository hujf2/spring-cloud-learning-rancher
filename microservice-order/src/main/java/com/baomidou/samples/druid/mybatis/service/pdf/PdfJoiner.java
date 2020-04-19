//package com.baomidou.samples.druid.mybatis.service.pdf;
////
////import java.io.FileOutputStream;
////import java.io.IOException;
////
////import com.itextpdf.io.source.RandomAccessFileOrArray;
////import com.itextpdf.kernel.pdf.PdfReader;
////import com.itextpdf.layout.Document;
////import com.itextpdf.text.Document;
////import com.itextpdf.text.DocumentException;
////import com.itextpdf.text.pdf.PdfCopy;
////import com.itextpdf.text.pdf.PdfImportedPage;
////import com.itextpdf.text.pdf.PdfReader;
////import com.itextpdf.text.pdf.RandomAccessFileOrArray;
////import sun.plugin.dom.exception.WrongDocumentException;
////
////
////public class PdfJoiner {
////
////    public void join(String outputPath, String... inputPaths) {
////        Document document = null;
////        PdfCopy copy = null;
////
////        try {
////            for (String inputPath : inputPaths) {
////                PdfReader reader = new PdfReader(new RandomAccessFileOrArray(inputPath), null); // ここがポイント
////                reader.consolidateNamedDestinations();
////
////                if (document == null) {
////                    document = new Document(reader.getPageSizeWithRotation(1));
////                    copy = new PdfCopy(document, new FileOutputStream(outputPath));
////                    document.open();
////                }
////
////                PdfImportedPage page;
////                int numberOfPages = reader.getNumberOfPages();
////                for (int i = 1; i <= numberOfPages; i++) {
////                    page = copy.getImportedPage(reader, i);
////                    copy.addPage(page);
////                }
////                reader.close();
////            }
////            copy.close();
////            document.close();
////
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////
////        } catch (WrongDocumentException e) {
////            throw new RuntimeException(e);
////
////        } finally {
////            if (document != null) {
////                document.close();
////            }
////            if (copy != null) {
////                copy.close();
////            }
////        }
////    }
////}