package org.ofdrw.converter.export;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class PDFExporterITextTest {

    /**
     * 测试转换全部页面为PDF
     */
    @Test
    void export() throws Exception {
        Path ofdPath = Paths.get("src/test/resources/999.ofd");
        Path pdfPath = Paths.get("target/999.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdPath, pdfPath)) {
            exporter.export();
        }
        System.out.println(">> " + pdfPath.toAbsolutePath());
    }


    /**
     * 忽略无法解析图片
     * @throws IOException 
     */
    @Test
    void testErrImgResource() throws IOException {
        Path ofdIn = Paths.get("src/test/resources/testImageNotFound.ofd");
        Path pdfOut = Paths.get("target/testImageNotFound.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdIn, pdfOut)) {
            exporter.export();
        }
        System.out.println(">> " + pdfOut.toAbsolutePath());
    }

    /**
     * 图片覆盖整个页面
     * @throws IOException 
     */
    @Test
    void testImageOverridePage() throws IOException {
        Path ofdIn = Paths.get("src/test/resources/testImageOverridePage.ofd");
        Path pdfOut = Paths.get("target/testImageOverridePage.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdIn, pdfOut)) {
            exporter.export();
        }
        System.out.println(">> " + pdfOut.toAbsolutePath());
    }

    /**
     * 增加Path裁剪逻辑
     * @throws IOException 
     */
    @Test
    void testPathClip() throws IOException {
        Path ofdIn = Paths.get("src/test/resources/testPathClip.ofd");
        Path pdfOut = Paths.get("target/testPathClip.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdIn, pdfOut)) {
            exporter.export();
        }
        System.out.println(">> " + pdfOut.toAbsolutePath());
    }

    /**
     * 补充填充规则逻辑
     * @throws IOException 
     */
    @Test
    void testFillRule() throws IOException {
        Path ofdIn = Paths.get("src/test/resources/testImageNotFound.ofd");
        Path pdfOut = Paths.get("target/testFillRule.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdIn, pdfOut)) {
            exporter.export();
        }
        System.out.println(">> " + pdfOut.toAbsolutePath());
    }

    /**
     * 优化Path颜色逻辑(国徽处)
     * @throws IOException 
     */
    @Test
    void testFillColor() throws IOException {
        Path ofdIn = Paths.get("src/test/resources/testPathClip.ofd");
        Path pdfOut = Paths.get("target/testPathColor.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdIn, pdfOut)) {
            exporter.export();
        }
        System.out.println(">> " + pdfOut.toAbsolutePath());
    }

    /**
     * 优化线宽和文字的比例(印章处)
     * @throws IOException 
     */
    @Test
    void testScaleOfLineWidthAndTextPoint() throws IOException {
        Path ofdIn = Paths.get("src/test/resources/SignScaleError.ofd");
        Path pdfOut = Paths.get("target/testScaleOfLineWidthAndTextPoint.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdIn, pdfOut)) {
            exporter.export();
        }
        System.out.println(">> " + pdfOut.toAbsolutePath());
    }

    /**
     * 测试嵌入字体(裁剪)的加载问题
     * @throws IOException 
     */
    @Test
    void testErrEmbeddedFont() throws IOException {
        Path ofdIn = Paths.get("src/test/resources/testImageNotFound.ofd");
        Path pdfOut = Paths.get("target/testErrEmbeddedFont.pdf");
        try (OFDExporter exporter = new PDFExporterIText(ofdIn, pdfOut)) {
            exporter.export();
        }
        System.out.println(">> " + pdfOut.toAbsolutePath());
    }

}