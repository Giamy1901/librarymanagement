package qltv.model;
import java.util.Date;

public class MuonTra {
    private int maMuon;
    private String maDocGiaMuon;
    private String tenDocGiaMuon;
    private Date ngayMuon;
    private Date hanTra;
    private Date ngayTra;
    private String trangThai;
    private float tienPhat;
    private String maSachMuon;
    private String tenSachMuon;

    public int getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
    }

    public String getMaDocGiaMuon() {
        return maDocGiaMuon;
    }

    public void setMaDocGiaMuon(String maDocGiaMuon) {
        this.maDocGiaMuon = maDocGiaMuon;
    }

    public String getTenDocGiaMuon() {
        return tenDocGiaMuon;
    }

    public void setTenDocGiaMuon(String tenDocGiaMuon) {
        this.tenDocGiaMuon = tenDocGiaMuon;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public float getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getMaSachMuon() {
        return maSachMuon;
    }

    public void setMaSachMuon(String maSachMuon) {
        this.maSachMuon = maSachMuon;
    }

    public String getTenSachMuon() {
        return tenSachMuon;
    }

    public void setTenSachMuon(String tenSachMuon) {
        this.tenSachMuon = tenSachMuon;
    }

    public MuonTra() {
    }

    public MuonTra(int maMuon) {
        this.maMuon = maMuon;
    }

    public MuonTra(int maMuon, String maDocGiaMuon, String tenDocGiaMuon, Date ngayMuon, Date hanTra, Date ngayTra, String trangThai, float tienPhat) {
        this.maMuon = maMuon;
        this.maDocGiaMuon = maDocGiaMuon;
        this.tenDocGiaMuon = tenDocGiaMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
        this.tienPhat = tienPhat;
    }

    public MuonTra(int maMuon, String maSachMuon) {
        this.maMuon = maMuon;
        this.maSachMuon = maSachMuon;
    }

    public MuonTra(int maMuon, String maDocGiaMuon, String tenDocGiaMuon, Date ngayMuon, Date hanTra, Date ngayTra, String trangThai, float tienPhat, String maSachMuon, String tenSachMuon) {
        this.maMuon = maMuon;
        this.maDocGiaMuon = maDocGiaMuon;
        this.tenDocGiaMuon = tenDocGiaMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
        this.tienPhat = tienPhat;
        this.maSachMuon = maSachMuon;
        this.tenSachMuon = tenSachMuon;
    }
    
    
}
