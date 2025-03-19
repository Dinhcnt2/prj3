<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DAO.CuaHangDAO" %>
<%@ page import="Model.SanPham" %>
<%@ page import="java.util.*" %>

<%
    String maSanPhamStr = request.getParameter("maSanPham");
    int maSanPham = 0;
    
    try {
        if (maSanPhamStr != null) {
            maSanPham = Integer.parseInt(maSanPhamStr);
        }
    } catch (NumberFormatException e) {
        out.println("<p class='text-danger text-center'>⚠ Lỗi: Mã sản phẩm không hợp lệ!</p>");
        return;
    }

    CuaHangDAO dao = new CuaHangDAO();
    SanPham sp = dao.getSanPhamById(maSanPham);

    if (sp == null) {
        out.println("<p class='text-danger text-center'>⚠ Không tìm thấy sản phẩm với mã: " + maSanPham + "</p>");
        return;
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Sản Phẩm - <%= sp.getTenSanPham() %></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .bg-pink { background-color: #E91E63; }
        .text-pink { color: #E91E63; }
        .product-container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .product-img {
            max-width: 100%;
            height: auto;
            max-height: 400px;
            border-radius: 10px;
            object-fit: contain;
        }
        .product-details {
            text-align: left;
            margin-top: 15px;
        }
        .btn-custom {
            background: #E91E63;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
        }
        .btn-custom:hover {
            background: #C2185B;
        }
        .btn-secondary {
            padding: 10px 15px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <%@ include file="VVDheader.jsp" %>

    <div class="container mt-4">
        <div class="product-container">
            <h2 class="text-pink"><%= sp.getTenSanPham() %></h2>
            <!-- Hình ảnh sản phẩm -->
            <img src="${pageContext.request.contextPath}/images/<%= sp.getHinhAnh() %>" class="product-img" alt="<%= sp.getTenSanPham() %>">
            
            <!-- Thông tin chi tiết sản phẩm -->
            <div class="product-details">
                <p><strong>Loại:</strong> <%= sp.getLoaiSanPham() %></p>
                <p><strong>Kích cỡ:</strong> <%= sp.getKichCo() %></p>
                <p><strong>Màu sắc:</strong> <%= sp.getMauSac() %></p>
                <p><strong>Chất liệu:</strong> <%= sp.getChatLieu() %></p>
                <p><strong>Giá:</strong> <span class="text-danger fw-bold"><%= sp.getGia() %> VND</span></p>
                <p><strong>Số lượng tồn:</strong> <%= sp.getSoLuongTonKho() %></p>
            </div>

            <!-- Nút hành động -->
            <div class="mt-4">
                <a href="themGioHang.jsp?maSanPham=<%= sp.getMaSanPham() %>" class="btn btn-custom">🛒 Thêm vào giỏ hàng</a>
                <a href="VVDSanPham.jsp" class="btn btn-secondary">🔙 Quay lại</a>
            </div>
        </div>
    </div>

    <%@ include file="VVDfooter.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
