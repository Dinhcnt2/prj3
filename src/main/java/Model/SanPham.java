package Model;

public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private String loaiSanPham;
    private String kichCo;
    private String mauSac;
    private String chatLieu;
    private String hinhAnh;
    private float gia;
    private int soLuongTonKho;
    private int maNhaCungCap;

    public SanPham() {}
    public SanPham(int maSanPham, String tenSanPham, String loaiSanPham, String kichCo, String mauSac, String chatLieu, String hinhAnh, float gia, int soLuongTonKho, int maNhaCungCap) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.loaiSanPham = loaiSanPham;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.hinhAnh = hinhAnh;
        this.gia = gia;
        this.soLuongTonKho = soLuongTonKho;
        this.maNhaCungCap = maNhaCungCap;
    }
    public int getMaSanPham() { return maSanPham; }
    public void setMaSanPham(int maSanPham) { this.maSanPham = maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }
    public String getLoaiSanPham() { return loaiSanPham; }
    public void setLoaiSanPham(String loaiSanPham) { this.loaiSanPham = loaiSanPham; }
    public String getKichCo() { return kichCo; }
    public void setKichCo(String kichCo) { this.kichCo = kichCo; }
    public String getMauSac() { return mauSac; }
    public void setMauSac(String mauSac) { this.mauSac = mauSac; }
    public String getChatLieu() { return chatLieu; }
    public void setChatLieu(String chatLieu) { this.chatLieu = chatLieu; }
    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }
    public float getGia() { return gia; }
    public void setGia(float gia) { this.gia = gia; }
    public int getSoLuongTonKho() { return soLuongTonKho; }
    public void setSoLuongTonKho(int soLuongTonKho) { this.soLuongTonKho = soLuongTonKho; }
    public int getMaNhaCungCap() { return maNhaCungCap; }
    public void setMaNhaCungCap(int maNhaCungCap) { this.maNhaCungCap = maNhaCungCap; }
}
