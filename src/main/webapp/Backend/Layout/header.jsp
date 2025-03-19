<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<header>
    <style>
        .header-container {
            background-color: #333;
            color: white;
            padding: 15px;
            text-align: center;
        }
        .header-container h1 {
            margin: 0;
        }
        nav ul {
            list-style: none;
            padding: 0;
            margin-top: 10px;
        }
        nav ul li {
            display: inline;
            margin: 0 15px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
    </style>
    <div class="header-container">
        <h1>Hệ Thống Quản Lý</h1>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/Backend/VVDHome.jsp">Trang chủ</a></li>
                <li><a href="${pageContext.request.contextPath}/Backend/NhanVien/VVDlistNhanVien.jsp">Quản lý Nhân Viên</a></li>
                <li><a href="${pageContext.request.contextPath}/Backend/SanPham/VVDlistSanPham.jsp">Quản lý Sản Phẩm</a></li>
                <li><a href="${pageContext.request.contextPath}/Backend/KhachHang/VVDlistKhachHang.jsp">Quản lý Khách Hàng</a></li>
                <li><a href="${pageContext.request.contextPath}/Backend/login.jsp">Đăng nhập</a></li>
            </ul>
        </nav>
    </div>
</header>
