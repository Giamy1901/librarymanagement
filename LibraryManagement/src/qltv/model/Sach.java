package qltv.model;


public class Sach {
    private String maSach;
    private String tenSach;
    private String nxb;
    private String tacGia;
    private String theLoai;
    private float donGia;
    private int soLuong;

    

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Sach() {
    }

    public Sach(String maSach) {
        this.maSach = maSach;
    }

    
    public Sach(String maSach, String tenSach, String nxb, String tacGia, String theLoai, float donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nxb = nxb;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
}
