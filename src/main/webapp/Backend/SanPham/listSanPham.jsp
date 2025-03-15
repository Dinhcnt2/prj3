<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CuaHangDAO" %>
<%@ page import="Model.SanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
    body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
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
    justify-content: center;
}

.card {
    background: #fff;
    padding: 15px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    transition: transform 0.2s ease-in-out;
    text-align: center;
}

.card:hover {
    transform: translateY(-5px);
}

.card h3 {
    color: #007bff;
    margin-bottom: 10px;
}

.card p {
    margin: 5px 0;
    font-size: 14px;
    color: #555;
}

.action-buttons {
    margin-top: 15px;
}

.edit-btn, .delete-btn, .add-button, .back-button {
    display: inline-block;
    padding: 8px 12px;
    text-decoration: none;
    font-size: 14px;
    border-radius: 5px;
    transition: background 0.2s;
}

.edit-btn {
    background: #ffc107;
    color: #fff;
}

.delete-btn {
    background: #dc3545;
    color: #fff;
}

.add-button {
    background: #28a745;
    color: #fff;
    padding: 10px 15px;
    font-size: 16px;
}

.back-button {
    background: #6c757d;
    color: #fff;
    padding: 10px 15px;
    font-size: 16px;
}

.edit-btn:hover {
    background: #e0a800;
}

.delete-btn:hover {
    background: #c82333;
}

.add-button:hover {
    background: #218838;
}

.back-button:hover {
    background: #5a6268;
}
    
    </style>
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

    <section>
    <h2 style="text-align: center;">Danh Sách Sản Phẩm</h2>
    <div class="cards-container">
        <% 
        CuaHangDAO dao = new CuaHangDAO();
        List<SanPham> sanPhamList = null;
        try {
            sanPhamList = dao.getAllSanPham();
        } catch (Exception e) {
            out.println("Có lỗi trong quá trình lấy dữ liệu: " + e.getMessage());
        }

        if (sanPhamList != null && !sanPhamList.isEmpty()) {
            for (SanPham sp : sanPhamList) {
        %>
            <div class="card">
                <h3><%= sp.getTenSanPham() %></h3>
                <p>Mã Sản Phẩm: <%= sp.getMaSanPham() %></p>
                <p>Loại: <%= sp.getLoaiSanPham() %></p>
                <p>Kích Cỡ: <%= sp.getKichCo() %></p>
                <p>Màu Sắc: <%= sp.getMauSac() %></p>
                <p>Chất Liệu: <%= sp.getChatLieu() %></p>
                <p>Giá: <%= sp.getGia() %> VND</p>
                <p>Số Lượng Tồn: <%= sp.getSoLuongTonKho() %></p>
                <div class="action-buttons">
                    <a href="updateSanPham?maSanPham=<%= sp.getMaSanPham() %>" class="edit-btn">Sửa</a>
                    <a href="deleteSanPham?maSanPham=<%= sp.getMaSanPham() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p>Không có sản phẩm nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
    <br>
    <div style="text-align: center;">
        <a href="addSanPham.jsp" class="add-button">Thêm Sản Phẩm</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/Backend/trangchu.jsp" class="back-button">Quay lại trang chủ</a>
    </div>
</section>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
