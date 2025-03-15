package Model;
import java.sql.Date;
import java.time.LocalDate;

//Model cho bảng Khách Hàng
public class KhachHang {
 private int maKhachHang;
 private String hoTen;
 private String soDienThoai;
 private String email;
 private String diaChi;
 private LocalDate ngayThamGia; // Dùng LocalDate thay vì java.sql.Date

 public KhachHang() {}
 public KhachHang(int maKhachHang, String hoTen, String soDienThoai, String email, String diaChi, LocalDate ngayThamGia) {
     this.maKhachHang = maKhachHang;
     this.hoTen = hoTen;
     this.soDienThoai = soDienThoai;
     this.email = email;
     this.diaChi = diaChi;
     this.ngayThamGia = ngayThamGia;
 }
 public int getMaKhachHang() { return maKhachHang; }
 public void setMaKhachHang(int maKhachHang) { this.maKhachHang = maKhachHang; }
 public String getHoTen() { return hoTen; }
 public void setHoTen(String hoTen) { this.hoTen = hoTen; }
 public String getSoDienThoai() { return soDienThoai; }
 public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
 public String getEmail() { return email; }
 public void setEmail(String email) { this.email = email; }
 public String getDiaChi() { return diaChi; }
 public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
 public LocalDate getNgayThamGia() { return ngayThamGia; }
 public void setNgayThamGia(LocalDate ngayThamGia) { this.ngayThamGia = ngayThamGia; }
}