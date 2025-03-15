package Model;

public class ChiTietHoaDon {
    private int maChiTietHoaDon;
    private int maHoaDon;
    private int maSanPham;
    private int soLuong;
    private double giaBan;
    private double thanhTien;

    // Constructor không tham số
    public ChiTietHoaDon() {
    }

    // Constructor có tham số
    public ChiTietHoaDon(int maChiTietHoaDon, int maHoaDon, int maSanPham, int soLuong, double giaBan) {
        this.maChiTietHoaDon = maChiTietHoaDon;
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = soLuong * giaBan; // Tính thành tiền
    }

    // Getter và Setter
    public int getMaChiTietHoaDon() {
        return maChiTietHoaDon;
    }

    public void setMaChiTietHoaDon(int maChiTietHoaDon) {
        this.maChiTietHoaDon = maChiTietHoaDon;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = this.soLuong * this.giaBan; // Cập nhật thành tiền khi thay đổi số lượng
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
        this.thanhTien = this.soLuong * this.giaBan; // Cập nhật thành tiền khi thay đổi giá bán
    }

    public double getThanhTien() {
        return thanhTien;
    }

}