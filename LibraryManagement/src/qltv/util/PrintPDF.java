package qltv.util;


import java.io.IOException;
import java.util.Date;

import com.itextpdf.io.font.*;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintPDF {

    // search_key : tim kiem theo ..(MaSach,...)
    // search_con : tfTimKiem
    // name : ten bang
    // hearder : colName
    // data : Du lieu trong table
    public static void main(String[] args) {
        PrintPDF p = new PrintPDF();
        p.test("G:\\t1.pdf");

    }

    public void test(String filePath) {
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document report = new Document(pdf, PageSize.A4.rotate());
            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
            PdfFont rfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\Calibri.ttf", PdfEncodings.IDENTITY_H, true);
            float fontSize = 14;
            float fontSizes = 16;
            report.setMargins(20, 20, 50, 20);
            // Write start content
            report.add(new Paragraph("Tôi muốn tắt nắng đi cho mà đừng nhạt mất \n Tôi muốn buộc gió lại cho hương đừng  bay đi").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(fontSizes).setBold());
            report.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();

            } catch (IOException ex) {
                Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void printSearchReport(String filePath, String name, String[] header, String[][] data, String search_key, String search_con, String ten) throws IOException {
        //LicenseKey.loadLicenseFile("res/itextkey14773129677280.xml");
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document report = new Document(pdf, PageSize.A4.rotate());
        PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
        PdfFont rfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\Calibri.ttf", PdfEncodings.IDENTITY_H, true);
        float fontSize = 14;
        float fontSizes = 16;

        report.setMargins(20, 20, 50, 20);

        report.add(new Paragraph("THƯ VIỆN UTC2").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(fontSizes).setBold());
        float[] colWidth;

        switch (name) {
            case "Sach":
                colWidth = new float[]{2, 2, 2, 2, 2, 2, 2};
                break;
            case "DocGia":
                colWidth = new float[]{2, 2, 2, 2, 2, 2, 2};
                break;
            case "MuonTra":
                colWidth = new float[]{2, 2, 2, 2, 2, 2};
                break;
            case "ChiTietMuon":
                colWidth = new float[]{2, 2};
                break;
            default:
                colWidth = new float[header.length];
        }

        Table table = new Table(colWidth);
        table.setWidthPercent(100);
        for (String s : header) {
            table.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            boolean empty = true;
            for (String o : data[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : data[i]) {
                if (o == null) {
                    table.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table.addCell(new Paragraph(o).setFont(rfont));
                }
            }
            counter++;
        }
        report.add(table);

        String[] dates = new String[3];
        String s = CalendarAdapter.DateToString(new Date());
        dates = s.split("-");
        report.add(new Paragraph("TP HCM, Ngày " + dates[0] + ", tháng " + dates[1] + ", năm " + dates[2]).setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(10));
        report.add(new Paragraph("Thủ thư").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(70));
        report.add(new Paragraph("(Ký, ghi rõ họ tên)").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setItalic().setMarginRight(40));

        report.close();
    }

    /// print chi tiet phieu muon
    public void printChiTietPhieuMuon(String filePath, String[] header, String[][] data) throws IOException {
        //LicenseKey.loadLicenseFile("res/itextkey14773129677280.xml");
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document report = new Document(pdf, PageSize.A4.rotate());
        PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
        PdfFont rfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\Calibri.ttf", PdfEncodings.IDENTITY_H, true);
        float fontSize = 14;
        float fontSizes = 16;

        report.setMargins(20, 20, 50, 20);

        report.add(new Paragraph("THƯ VIỆN TẠ QUANG BỬU").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(fontSizes).setBold());
        report.add(new Paragraph("CHI TIẾT PHIẾU MƯỢN").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        report.add(new Paragraph("").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        report.add(new Paragraph("").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        float[] colWidth = new float[]{2, 2, 2, 2, 2, 2, 2};

        Table table = new Table(colWidth);
        table.setWidthPercent(100);
        for (String s : header) {
            table.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            boolean empty = true;
            for (String o : data[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : data[i]) {
                if (o == null) {
                    table.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table.addCell(new Paragraph(o).setFont(rfont));
                }
            }
            counter++;
        }
        report.add(table);

        String[] dates = new String[3];
        String s = CalendarAdapter.DateToString(new Date()); // lay ngay hien tai
        dates = s.split("-");
        report.add(new Paragraph("").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        report.add(new Paragraph("").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        report.add(new Paragraph("TP HCM, Ngày " + dates[0] + ", tháng " + dates[1] + ", năm " + dates[2]).setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(10));
        report.add(new Paragraph("Thủ thư").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(70));
        report.add(new Paragraph("(Ký, ghi rõ họ tên)").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setItalic().setMarginRight(40));

        report.close();
    }

    // thong ke sach.. , String[] genre , String[] tg
    public void printBookStats(String filePath, int total1, int total2, String[] hTacGia, String[][] tacGia, String[] hTheLoai, String[][] theLoai, String[] hNhaXuatBan, String[][] nhaXuatBan) throws IOException {
        //LicenseKey.loadLicenseFile("res/itextkey14773129677280.xml");
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document report = new Document(pdf, PageSize.A4.rotate());
        PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
        PdfFont rfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\Calibri.ttf", PdfEncodings.IDENTITY_H, true);
        float fontSize = 14;

        report.setMargins(20, 20, 50, 20);

        // Write start content
        report.add(new Paragraph("THƯ VIỆN UTC2").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(18).setBold());

        report.add(new Paragraph("THỐNG KÊ THÔNG TIN SÁCH").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(15).setBold());
        report.add(new Paragraph("*  Tổng số sách trong thư viện : " + total1).setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize));
        report.add(new Paragraph("*  Tổng số mã sách : " + total2).setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize));

        Paragraph pub = new Paragraph("*  Số sách theo nhà xuất bản :\n\n").setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        report.add(pub);

        float[] colWidth = new float[]{2, 2};

        Table table = new Table(colWidth);
        table.setWidthPercent(50).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER);
        for (String s : hNhaXuatBan) {
            table.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        for (int i = 0; i < nhaXuatBan.length; i++) {
            boolean empty = true;
            for (String o : nhaXuatBan[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : nhaXuatBan[i]) {
                if (o == null) {
                    table.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table.addCell(new Paragraph(o).setFont(rfont));
                }
            }
        }
        report.add(table);
        ///////////////
        Paragraph str = new Paragraph("*  Số sách theo tác giả :\n\n").setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        Table table2 = new Table(colWidth);
        table2.setWidthPercent(50).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER);
        for (String s : hTacGia) {
            table2.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        for (int i = 0; i < tacGia.length; i++) {
            boolean empty = true;
            for (String o : tacGia[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : tacGia[i]) {
                if (o == null) {
                    table2.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table2.addCell(new Paragraph(o).setFont(rfont));
                }
            }
        }
        report.add(str);
        report.add(table2);

        /////////
        Paragraph str1 = new Paragraph("*  Số sách theo thể loại :\n").setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        Table table3 = new Table(colWidth);
        table3.setWidthPercent(50).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER);
        for (String s : hTheLoai) {
            table3.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        for (int i = 0; i < theLoai.length; i++) {
            boolean empty = true;
            for (String o : theLoai[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : theLoai[i]) {
                if (o == null) {
                    table3.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table3.addCell(new Paragraph(o).setFont(rfont));
                }
            }
        }
        report.add(str1);
        report.add(table3);

        String[] dates = new String[3];
        String s = CalendarAdapter.DateToString(new Date());
        dates = s.split("-");
        report.add(new Paragraph("").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        report.add(new Paragraph("TP HCM, Ngày " + dates[0] + ", tháng " + dates[1] + ", năm " + dates[2]).setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(10));
        report.add(new Paragraph("Thủ thư ").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(70));
        report.add(new Paragraph("(Ký, ghi rõ họ tên)").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setItalic().setMarginRight(40));

        report.close();
    }

    // thong ke doc gia , int male, int female, int[] age_group
    public void printReaderStats(String filePath, int total, String nam, String nu, String[] hDiaChi, String[][] diaChi) throws IOException {

        //LicenseKey.loadLicenseFile("res/itextkey14773129677280.xml");
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document report = new Document(pdf, PageSize.A4.rotate());
        PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
        PdfFont rfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\Calibri.ttf", PdfEncodings.IDENTITY_H, true);
        float fontSize = 14;

        report.setMargins(20, 20, 50, 20);

        // Write start content
        report.add(new Paragraph("THƯ VIỆN UTC2").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(25).setBold());
//        report.add(new Paragraph("Ä�á»‹a chá»‰: Sá»‘ 1 - Ä�áº¡i Cá»“ Viá»‡t - Hai BÃ  TrÆ°ng - HÃ  Ná»™i").setFont(hfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize).setBold());
//        report.add(new Paragraph("Sá»‘ Ä‘iá»‡n thoáº¡i: 0438694242").setFont(hfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize).setBold());

        report.add(new Paragraph("THỐNG KÊ THÔNG TIN ĐỘC GIẢ ").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(18).setBold());
        //Paragraph age = new Paragraph("Sá»‘ Ä‘á»™c giáº£ trong thÃ¡ng:\n").setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        report.add(new Paragraph("*  Tổng số độc giả : " + total).setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize));

        report.add(new Paragraph("+ Số độc giả nam: " + nam + "\n" + "+ Số độc giả nữ : " + nu).setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize));

        Paragraph address = new Paragraph("*  Số độc giả theo địa chỉ :\n").setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);

        float[] colWidth = new float[]{2, 2};

        Table table = new Table(colWidth);
        table.setWidthPercent(50).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER);
        for (String s : hDiaChi) {
            table.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        for (int i = 0; i < diaChi.length; i++) {
            boolean empty = true;
            for (String o : diaChi[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : diaChi[i]) {
                if (o == null) {
                    table.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table.addCell(new Paragraph(o).setFont(rfont));
                }
            }
        }
        report.add(address);
        report.add(table);

        String[] dates = new String[3];
        String s = CalendarAdapter.DateToString(new Date());
        dates = s.split("-");
        report.add(new Paragraph("").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        report.add(new Paragraph("TP HCM, Ngày " + dates[0] + ", Tháng " + dates[1] + ", năm " + dates[2]).setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(10));
        report.add(new Paragraph("Thủ thư").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(70));
        report.add(new Paragraph("(Ký, ghi rõ họ tên )").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setItalic().setMarginRight(40));

        report.close();
    }

    // thong ke muontra
    public void printCheckingStats(String filePath, int totalS, int totalDG, int quaHan, String[] hDGMuonSach, String[][] dGMuonSach, String[] hSachMuonNhieuNhat, String[][] sachMuonNhieuNhat) throws IOException {
        //LicenseKey.loadLicenseFile("res/itextkey14773129677280.xml");
        PdfWriter writer = new PdfWriter(filePath);
        PdfDocument pdf = new PdfDocument(writer);
        Document report = new Document(pdf, PageSize.A4.rotate());
        PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H, true);
        PdfFont rfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\Calibri.ttf", PdfEncodings.IDENTITY_H, true);
        float fontSize = 14;

        report.setMargins(20, 20, 50, 20);

        // Write start content
        report.add(new Paragraph("THƯ VIỆN UTC2").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(25).setBold());
//        report.add(new Paragraph("Ä�á»‹a chá»‰: Sá»‘ 1 - Ä�áº¡i Cá»“ Viá»‡t - Hai BÃ  TrÆ°ng - HÃ  Ná»™i").setFont(hfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize).setBold());
//        report.add(new Paragraph("Sá»‘ Ä‘iá»‡n thoáº¡i: 0438694242").setFont(hfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize).setBold());

        report.add(new Paragraph("THỐNG KÊ THÔNG TIN MƯỢN TRẢ SÁCH").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(18).setBold());

        Paragraph str1 = new Paragraph("*  Tổng số sách đang mượn : " + totalS).setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        report.add(str1);

        Paragraph str2 = new Paragraph("*  Tổng số độc giả đang mượn sách : " + totalDG).setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        report.add(str2);

        Paragraph str = new Paragraph("*  Tổng số độc giả mượn quá hạn : " + quaHan).setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        report.add(str);

        Paragraph str4 = new Paragraph("*  Danh sách độc giả đang mượn sách : \n").setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        float[] colWidth = new float[]{2, 2, 2, 2, 2};

        Table table1 = new Table(colWidth);
        table1.setWidthPercent(70).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER);
        for (String s : hDGMuonSach) {
            table1.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        for (int i = 0; i < dGMuonSach.length; i++) {
            boolean empty = true;
            for (String o : dGMuonSach[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : dGMuonSach[i]) {
                if (o == null) {
                    table1.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table1.addCell(new Paragraph(o).setFont(rfont));
                }
            }
        }
        report.add(str4);
        report.add(table1);

        /////
        Paragraph str5 = new Paragraph("*  3 tên sách được mượn nhiều nhất : \n").setFont(rfont).setTextAlignment(TextAlignment.LEFT).setFontSize(fontSize);
        float[] colWidth2 = new float[]{2, 2, 2};

        Table table2 = new Table(colWidth2);
        table2.setWidthPercent(70).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER);
        for (String s : hSachMuonNhieuNhat) {
            table2.addHeaderCell(new Paragraph(s).setFont(rfont).setBold().setTextAlignment(TextAlignment.CENTER));
        }

        for (int i = 0; i < sachMuonNhieuNhat.length; i++) {
            boolean empty = true;
            for (String o : sachMuonNhieuNhat[i]) {
                if (o != null) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                continue;
            }

            for (String o : sachMuonNhieuNhat[i]) {
                if (o == null) {
                    table2.addCell(new Paragraph("").setFont(rfont));
                } else {
                    table2.addCell(new Paragraph(o).setFont(rfont));
                }
            }
        }
        report.add(str5);
        report.add(table2);

        String[] dates = new String[3];
        String s = CalendarAdapter.DateToString(new Date());
        dates = s.split("-");
        report.add(new Paragraph("").setFont(hfont).setTextAlignment(TextAlignment.CENTER).setFontSize(14).setBold());
        report.add(new Paragraph("TP HCM, Ngày " + dates[0] + ", tháng " + dates[1] + ", năm " + dates[2]).setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(10));
        report.add(new Paragraph("Thủ thư").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setMarginRight(70));
        report.add(new Paragraph("(Ký, ghi rõ họ tên)").setFont(rfont).setTextAlignment(TextAlignment.RIGHT).setFontSize(fontSize).setItalic().setMarginRight(40));

        report.close();
    }
}
