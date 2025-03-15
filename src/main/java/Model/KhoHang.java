package Model;

import java.util.Date;

public class KhoHang {
    private int maKho;
    private int maSanPham;
    private int soLuong;
    private Date ngayCapNhat;

    // Constructor không tham số
    public KhoHang() {
    }

    // Constructor có tham số
    public KhoHang(int maKho, int maSanPham, int soLuong, Date ngayCapNhat) {
        this.maKho = maKho;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.ngayCapNhat = ngayCapNhat;
    }

    // Getter và Setter
    public int getMaKho() {
        return maKho;
    }

    public void setMaKho(int maKho) {
        this.maKho = maKho;
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
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }


}
