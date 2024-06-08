
package qltv.model;

import java.util.Date;
import java.util.GregorianCalendar;
import qltv.util.CalendarAdapter;


public class DocGia {
    private String maDocGia;
    private String tenDocGia;
    private Date hanSuDung;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String gioiTinh;

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public DocGia(){};

    public DocGia(String maDocGia, String tenDocGia, Date hanSuDung, Date ngaySinh, 
                  String diaChi, String soDienThoai, String gioiTinh) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.hanSuDung = hanSuDung;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
    }

    public DocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }
   
    
    
}
