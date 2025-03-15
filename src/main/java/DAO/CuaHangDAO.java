package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.HoaDon;
import Model.KhachHang;
import Model.KhoHang;
import Model.NhaCungCap;
import Model.NhanVien;
import Model.SanPham;

@WebServlet("/CuaHangDAO")
public class CuaHangDAO extends HttpServlet {
	private String url = "jdbc:mysql://localhost:3306/project3_vuongvandinh_2210900012"; 
    private String username = "root"; 
    private String password = ""; 

    public Connection connect() throws SQLException {
        try {
            // Đăng ký Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver MySQL", e);
        }
        return DriverManager.getConnection(url, username, password);
    }
    
    public void addSanPham(SanPham sp) {
        String query = "INSERT INTO SanPham (TenSanPham, LoaiSanPham, KichCo, MauSac, ChatLieu, HinhAnh, Gia, SoLuongTonKho, MaNhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sp.getTenSanPham());
            stmt.setString(2, sp.getLoaiSanPham());
            stmt.setString(3, sp.getKichCo());
            stmt.setString(4, sp.getMauSac());
            stmt.setString(5, sp.getChatLieu());
            stmt.setString(6, sp.getHinhAnh());
            stmt.setFloat(7, sp.getGia());
            stmt.setInt(8, sp.getSoLuongTonKho());
            stmt.setInt(9, sp.getMaNhaCungCap());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSanPham(int maSanPham) {
        String query = "DELETE FROM SanPham WHERE MaSanPham = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSanPham);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> danhSach = new ArrayList<>();
        String query = "SELECT * FROM SanPham";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maSanPham = rs.getInt("MaSanPham");
                String tenSanPham = rs.getString("TenSanPham");
                String loaiSanPham = rs.getString("LoaiSanPham");
                String kichCo = rs.getString("KichCo");
                String mauSac = rs.getString("MauSac");
                String chatLieu = rs.getString("ChatLieu");
                String hinhAnh = rs.getString("HinhAnh");
                float gia = rs.getFloat("Gia");
                int soLuongTonKho = rs.getInt("SoLuongTonKho");
                int maNhaCungCap = rs.getInt("MaNhaCungCap");
                
                SanPham sp = new SanPham(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, chatLieu, hinhAnh, gia, soLuongTonKho, maNhaCungCap);
                danhSach.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public SanPham getSanPhamById(int maSanPham) {
        String query = "SELECT * FROM SanPham WHERE MaSanPham = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSanPham);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenSanPham = rs.getString("TenSanPham");
                    String loaiSanPham = rs.getString("LoaiSanPham");
                    String kichCo = rs.getString("KichCo");
                    String mauSac = rs.getString("MauSac");
                    String chatLieu = rs.getString("ChatLieu");
                    String hinhAnh = rs.getString("HinhAnh");
                    float gia = rs.getFloat("Gia");
                    int soLuongTonKho = rs.getInt("SoLuongTonKho");
                    int maNhaCungCap = rs.getInt("MaNhaCungCap");
                    
                    return new SanPham(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, chatLieu, hinhAnh, gia, soLuongTonKho, maNhaCungCap);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSanPham(SanPham sp) {
        String query = "UPDATE SanPham SET TenSanPham = ?, LoaiSanPham = ?, KichCo = ?, MauSac = ?, ChatLieu = ?, HinhAnh = ?, Gia = ?, SoLuongTonKho = ?, MaNhaCungCap = ? WHERE MaSanPham = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sp.getTenSanPham());
            stmt.setString(2, sp.getLoaiSanPham());
            stmt.setString(3, sp.getKichCo());
            stmt.setString(4, sp.getMauSac());
            stmt.setString(5, sp.getChatLieu());
            stmt.setString(6, sp.getHinhAnh());
            stmt.setFloat(7, sp.getGia());
            stmt.setInt(8, sp.getSoLuongTonKho());
            stmt.setInt(9, sp.getMaNhaCungCap());
            stmt.setInt(10, sp.getMaSanPham());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addNhanVien(NhanVien nv) {
        String query = "INSERT INTO NhanVien (HoTen, SoDienThoai, Email, ChucVu, Luong, NgayVaoLam) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nv.getHoTen());
            stmt.setString(2, nv.getSoDienThoai());
            stmt.setString(3, nv.getEmail());
            stmt.setString(4, nv.getChucVu());
            stmt.setDouble(5, nv.getLuong());
            stmt.setString(6, nv.getNgayVaoLam());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNhanVien(int maNhanVien) {
        String query = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNhanVien);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maNhanVien = rs.getInt("MaNhanVien");
                String hoTen = rs.getString("HoTen");
                String soDienThoai = rs.getString("SoDienThoai");
                String email = rs.getString("Email");
                String chucVu = rs.getString("ChucVu");
                double luong = rs.getDouble("Luong");
                String ngayVaoLam = rs.getString("NgayVaoLam");

                NhanVien nv = new NhanVien(maNhanVien, hoTen, soDienThoai, email, chucVu, luong, ngayVaoLam);
                danhSach.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public NhanVien getNhanVienById(int maNhanVien) {
        String query = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNhanVien);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hoTen = rs.getString("HoTen");
                    String soDienThoai = rs.getString("SoDienThoai");
                    String email = rs.getString("Email");
                    String chucVu = rs.getString("ChucVu");
                    double luong = rs.getDouble("Luong");
                    String ngayVaoLam = rs.getString("NgayVaoLam");

                    return new NhanVien(maNhanVien, hoTen, soDienThoai, email, chucVu, luong, ngayVaoLam);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateNhanVien(NhanVien nv) {
        String query = "UPDATE NhanVien SET HoTen = ?, SoDienThoai = ?, Email = ?, ChucVu = ?, Luong = ?, NgayVaoLam = ? WHERE MaNhanVien = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nv.getHoTen());
            stmt.setString(2, nv.getSoDienThoai());
            stmt.setString(3, nv.getEmail());
            stmt.setString(4, nv.getChucVu());
            stmt.setDouble(5, nv.getLuong());
            stmt.setString(6, nv.getNgayVaoLam());
            stmt.setInt(7, nv.getMaNhanVien());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addKhachHang(KhachHang kh) {
        String query = "INSERT INTO KhachHang (HoTen, SoDienThoai, Email, DiaChi, NgayThamGia) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, kh.getHoTen());
            stmt.setString(2, kh.getSoDienThoai());
            stmt.setString(3, kh.getEmail());
            stmt.setString(4, kh.getDiaChi());
            stmt.setDate(5, kh.getNgayThamGia() != null ? java.sql.Date.valueOf(kh.getNgayThamGia()) : null);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void deleteKhachHang(int maKhachHang) {
        String query = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maKhachHang);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức đăng nhập
    public NhanVien dangNhap(String email, String soDienThoai) {
        NhanVien nhanVien = null;
        String sql = "SELECT * FROM NhanVien WHERE email = ? AND soDienThoai = ?";

        try {Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, soDienThoai);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nhanVien = new NhanVien(
                    rs.getInt("maNhanVien"),
                    rs.getString("hoTen"),
                    rs.getString("soDienThoai"),
                    rs.getString("email"),
                    rs.getString("chucVu"),
                    rs.getDouble("luong"),
                    rs.getString("ngayVaoLam")
                );
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien; // Nếu không tìm thấy, trả về null
    }
    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> danhSach = new ArrayList<>();
        String query = "SELECT * FROM KhachHang";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maKhachHang = rs.getInt("MaKhachHang");
                String hoTen = rs.getString("HoTen");
                String soDienThoai = rs.getString("SoDienThoai");
                String email = rs.getString("Email");
                String diaChi = rs.getString("DiaChi");
                LocalDate ngayThamGia = rs.getDate("NgayThamGia") != null ? rs.getDate("NgayThamGia").toLocalDate() : null;
                
                KhachHang kh = new KhachHang(maKhachHang, hoTen, soDienThoai, email, diaChi, ngayThamGia);
                danhSach.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }


    public KhachHang getKhachHangById(int maKhachHang) {
        String query = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maKhachHang);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hoTen = rs.getString("HoTen");
                    String soDienThoai = rs.getString("SoDienThoai");
                    String email = rs.getString("Email");
                    String diaChi = rs.getString("DiaChi");
                    LocalDate ngayThamGia = rs.getDate("NgayThamGia") != null ? rs.getDate("NgayThamGia").toLocalDate() : null;
                    
                    return new KhachHang(maKhachHang, hoTen, soDienThoai, email, diaChi, ngayThamGia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateKhachHang(KhachHang kh) {
        String query = "UPDATE KhachHang SET HoTen = ?, SoDienThoai = ?, Email = ?, DiaChi = ?, NgayThamGia = ? WHERE MaKhachHang = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, kh.getHoTen());
            stmt.setString(2, kh.getSoDienThoai());
            stmt.setString(3, kh.getEmail());
            stmt.setString(4, kh.getDiaChi());
            stmt.setDate(5, kh.getNgayThamGia() != null ? java.sql.Date.valueOf(kh.getNgayThamGia()) : null);
            stmt.setInt(6, kh.getMaKhachHang());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 // Lấy danh sách Kho Hàng
    public List<KhoHang> getAllKhoHang() {
        List<KhoHang> danhSach = new ArrayList<>();
        String query = "SELECT * FROM KhoHang";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maKho = rs.getInt("MaKho");
                int maSanPham = rs.getInt("MaSanPham");
                int soLuong = rs.getInt("SoLuong");
                Date ngayCapNhat = rs.getDate("NgayCapNhat");

                KhoHang kho = new KhoHang(maKho, maSanPham, soLuong, ngayCapNhat);
                danhSach.add(kho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy danh sách Nhà Cung Cấp
    public List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> danhSach = new ArrayList<>();
        String query = "SELECT * FROM NhaCungCap";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maNhaCungCap = rs.getInt("MaNhaCungCap");
                String tenNhaCungCap = rs.getString("TenNhaCungCap");
                String soDienThoai = rs.getString("SoDienThoai");
                String email = rs.getString("Email");
                String diaChi = rs.getString("DiaChi");

                NhaCungCap ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, soDienThoai, email, diaChi);
                danhSach.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // Lấy danh sách Hóa Đơn
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> danhSach = new ArrayList<>();
        String query = "SELECT * FROM HoaDon";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maHoaDon = rs.getInt("MaHoaDon");
                int maKhachHang = rs.getInt("MaKhachHang");
                int maNhanVien = rs.getInt("MaNhanVien");
                Date ngayLap = rs.getDate("NgayLap");
                double tongTien = rs.getDouble("TongTien");

                HoaDon hd = new HoaDon(maHoaDon, maKhachHang, maNhanVien, ngayLap, tongTien);
                danhSach.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}
