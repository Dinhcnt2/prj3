<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CuaHangDAO" %>
<%@ page import="Model.NhanVien" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhân Viên</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
    }
    
    h2 {
        text-align: center;
        color: #333;
    }

    .cards-container {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
        gap: 20px;
        padding: 20px;
    }

    .card {
        background: #fff;
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .card h3 {
        color: #007bff;
    }

    .action-buttons {
        margin-top: 10px;
    }

    .edit-btn, .delete-btn, .add-button, .back-button {
        display: inline-block;
        padding: 8px 12px;
        text-decoration: none;
        border-radius: 5px;
        transition: background 0.2s;
    }

    .edit-btn { background: #ffc107; color: #fff; }
    .delete-btn { background: #dc3545; color: #fff; }
    .add-button { background: #28a745; color: #fff; padding: 10px 15px; }
    .back-button { background: #6c757d; color: #fff; padding: 10px 15px; }

    .edit-btn:hover { background: #e0a800; }
    .delete-btn:hover { background: #c82333; }
    .add-button:hover { background: #218838; }
    .back-button:hover { background: #5a6268; }

    </style>
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <h2>Danh Sách Nhân Viên</h2>
    <div class="cards-container">
        <% 
        CuaHangDAO dao = new CuaHangDAO();
        List<NhanVien> nhanVienList = null;
        try {
            nhanVienList = dao.getAllNhanVien();
        } catch (Exception e) {
            out.println("Có lỗi khi lấy dữ liệu: " + e.getMessage());
        }

        if (nhanVienList != null && !nhanVienList.isEmpty()) {
            for (NhanVien nv : nhanVienList) {
        %>
            <div class="card">
                <h3><%= nv.getHoTen() %></h3>
                <p>Mã Nhân Viên: <%= nv.getMaNhanVien() %></p>
                <p>Số Điện Thoại: <%= nv.getSoDienThoai() %></p>
                <p>Email: <%= nv.getEmail() %></p>
                <p>Chức Vụ: <%= nv.getChucVu() %></p>
                <p>Lương: <%= nv.getLuong() %> VND</p>
                <p>Ngày Vào Làm: <%= nv.getNgayVaoLam() %></p>
                <div class="action-buttons">
                    <a href="updateNhanVien?maNhanVien=<%= nv.getMaNhanVien() %>" class="edit-btn">Sửa</a>
                    <a href="deleteNhanVien?maNhanVien=<%= nv.getMaNhanVien() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p>Không có nhân viên nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
    
    <div style="text-align: center;">
        <a href="VVDaddNhanVien.jsp" class="add-button">Thêm Nhân Viên</a>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
