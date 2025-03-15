<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.NhanVien" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sess = request.getSession();
    NhanVien nhanVien = (NhanVien) sess.getAttribute("nhanVien");

    if (nhanVien == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String loginMessage = (String) sess.getAttribute("loginMessage");
    if (loginMessage != null) {
        sess.removeAttribute("loginMessage"); // Xóa thông báo sau khi hiển thị
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .dashboard {
        text-align: center;
        padding: 40px 20px;
    }

    .dashboard h1 {
        font-size: 28px;
        color: #333;
        margin-bottom: 20px;
    }

    .dashboard-container {
        display: flex;
        justify-content: center;
        gap: 20px;
        flex-wrap: wrap;
    }

    .dashboard-item {
        background: #fff;
        padding: 20px;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        text-decoration: none;
        color: #333;
        width: 250px;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .dashboard-item:hover {
        transform: translateY(-5px);
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
    }

    .dashboard-item img {
        width: 80px;
        height: 80px;
        object-fit: contain;
        margin-bottom: 10px;
    }

    .dashboard-item h2 {
        font-size: 20px;
        margin: 10px 0;
    }

    .dashboard-item p {
        font-size: 14px;
        color: #666;
    }

    .login-message {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        text-align: center;
        margin-bottom: 20px;
        border-radius: 5px;
    }

    </style>
</head>
<body>
    <%@ include file="Layout/header.jsp" %>
    
    <% if (loginMessage != null) { %>
        <div class="login-message"><%= loginMessage %></div>
    <% } %>

    <section class="dashboard">
        <h1>Quản Lý Cửa Hàng</h1>
        <div class="dashboard-container">
            <a href="listKhoHang.jsp" class="dashboard-item">
                <img src="${pageContext.request.contextPath}/images/khohang.jpg" alt="Kho Hàng">
                <h2>Kho Hàng</h2>
                <p>Quản lý sản phẩm trong kho.</p>
            </a>
            <a href="listHoaDon.jsp" class="dashboard-item">
                <img src="${pageContext.request.contextPath}/images/hoadon.jpg" alt="Hóa Đơn">
                <h2>Hóa Đơn</h2>
                <p>Quản lý hóa đơn bán hàng.</p>
            </a>
            <a href="listNhaCungCap.jsp" class="dashboard-item">
                <img src="${pageContext.request.contextPath}/images/nhacungcap.jpg" alt="Nhà Cung Cấp">
                <h2>Nhà Cung Cấp</h2>
                <p>Danh sách nhà cung cấp.</p>
            </a>
        </div>
    </section>

    <%@ include file="Layout/footer.jsp" %>
</body>
</html>
