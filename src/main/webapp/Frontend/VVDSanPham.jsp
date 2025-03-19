<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CuaHangDAO" %>
<%@ page import="Model.SanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Danh Sách Sản Phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
    .product-card img { 
    width: 100%; 
    height: 200px; 
    object-fit: cover; /* Hiển thị đầy đủ ảnh, tránh bị méo */
    border-radius: 5px; 
    background: #f8f8f8; /* Giữ nền sáng nếu ảnh có nền trong suốt */
    display: block; /* Tránh lỗi ảnh bị lệch */
}
    
        .bg-pink { background-color: #E91E63; }
        .text-pink { color: #E91E63; }
        .section-title { text-align: center; color: #E91E63; font-weight: bold; margin-bottom: 20px; }
        .product-container { display: flex; flex-wrap: wrap; justify-content: center; gap: 20px; padding: 20px; }
        .product-card { background: #fff; border-radius: 8px; padding: 15px; width: 280px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); text-align: center; }
        .product-card img { width: 100%; height: 220px; object-fit: contain; border-radius: 5px; background: #f8f8f8; }
        .product-card h3 { color: #007bff; margin-top: 10px; font-size: 18px; }
        .product-card p { margin: 5px 0; font-size: 14px; color: #555; }
        .view-btn { background: #E91E63; color: #fff; padding: 8px 12px; border-radius: 5px; text-decoration: none; transition: 0.3s; display: inline-block; }
        .view-btn:hover { background: #d81b60; }
    </style>
</head>
<body>
    <%@ include file="VVDheader.jsp" %>

    <div class="container mt-4">
        <h1 class="section-title">Danh Sách Sản Phẩm</h1>
        <div class="product-container">
            <% 
            CuaHangDAO dao = new CuaHangDAO();
            List<SanPham> sanPhamList = null;
            try {
                sanPhamList = dao.getAllSanPham();
            } catch (Exception e) {
                out.println("<p class='text-danger text-center'>⚠ Lỗi khi lấy dữ liệu: " + e.getMessage() + "</p>");
            }

            if (sanPhamList != null && !sanPhamList.isEmpty()) {
                for (SanPham sp : sanPhamList) {
            %>
                <div class="product-card">
                    <!-- Hiển thị hình ảnh sản phẩm -->
                    <img src="${pageContext.request.contextPath}/images/<%= sp.getHinhAnh() %>" alt="<%= sp.getTenSanPham() %>">
                    
                    <!-- Tên sản phẩm -->
                    <h3>
                        <a href="VVDChitietsanpham.jsp?maSanPham=<%= sp.getMaSanPham() %>" class="text-decoration-none text-dark">
                            <%= sp.getTenSanPham() %>
                        </a>
                    </h3>
                    
                    <!-- Thông tin sản phẩm -->
                    <p><strong>Giá:</strong> <span class="text-danger fw-bold"><%= sp.getGia() %> VND</span></p>
                    <p><strong>Màu sắc:</strong> <%= sp.getMauSac() %></p>

                    <!-- Nút xem chi tiết -->
                    <a href="VVDChitietsanpham.jsp?maSanPham=<%= sp.getMaSanPham() %>" class="view-btn">Xem Chi Tiết</a>
                </div>
            <% 
                }
            } else { 
            %>
                <p class="text-center text-danger">Không có sản phẩm nào để hiển thị.</p>
            <% 
            } 
            %>
        </div>
    </div>

    <%@ include file="VVDfooter.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
