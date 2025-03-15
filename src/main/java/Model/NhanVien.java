package Model;

public class NhanVien {
    private int maNhanVien;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String chucVu;
    private double luong;
    private String ngayVaoLam;

    // Constructor không tham số
    public NhanVien() {
    }

    // Constructor có tham số
    public NhanVien(int maNhanVien, String hoTen, String soDienThoai, String email, String chucVu, double luong, String ngayVaoLam) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.chucVu = chucVu;
        this.luong = luong;
        this.ngayVaoLam = ngayVaoLam;
    }

    // Getter và Setter
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }


}
