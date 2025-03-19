<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header style="background-color: #E91E63; color: white; padding: 10px 0;">
    <div style="max-width: 1200px; margin: auto; display: flex; justify-content: space-between; align-items: center;">
        <div>
            <span>📞 Điện thoại: <strong>0932 064 588</strong> (8h - 17h)</span>
            <a href="#" style="color: white; margin-left: 15px; text-decoration: none;">Liên hệ</a>
        </div>
        <div>
            <a href="#" style="color: white; margin-right: 15px; text-decoration: none;">🔔 Thông báo của tôi</a>
            <a href="#" style="color: white; margin-right: 15px; text-decoration: none;">🔍</a>
            <a href="#" style="color: white; text-decoration: none;">👤</a>
            <a href="#" style="color: white; margin-left: 10px; text-decoration: none;">🛒 (0)</a>
        </div>
    </div>
</header>

<nav style="background-color: #f8f9fa; padding: 10px 0; border-bottom: 1px solid #ddd;">
    <div style="max-width: 1200px; margin: auto; display: flex; justify-content: space-between; align-items: center;">
        <a href="index.jsp" style="font-weight: bold; color: #E91E63; text-decoration: none; font-size: 22px;">
            <img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Fashion Kids" height="40">Fashion Kids
        </a>
        <button onclick="toggleMenu()" style="background: none; border: none; font-size: 24px; cursor: pointer; display: none;">
            ☰
        </button>
        <ul id="navMenu" style="list-style: none; padding: 0; margin: 0; display: flex; gap: 20px;">
            <li><a href="VVDtrangchu.jsp" style="text-decoration: none; color: black;">Trang chủ</a></li>
            <li><a href="VVDSanPham.jsp" style="text-decoration: none; color: black;">Sản Phẩm Của Bé</a></li>
            <li><a href="VVDKhuyenMai.jsp" style="text-decoration: none; color: black;">Khuyến Mãi</a></li>
            <li><a href="#" style="text-decoration: none; color: black;">Đồ dùng Mẹ & Bé</a></li>
            <li><a href="#" style="text-decoration: none; color: black;">Thời trang trẻ em</a></li>
        </ul>
    </div>
</nav>

<script>
    function toggleMenu() {
        var menu = document.getElementById("navMenu");
        if (menu.style.display === "none" || menu.style.display === "") {
            menu.style.display = "flex";
        } else {
            menu.style.display = "none";
        }
    }
</script>
