<!-- addSanPham.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
     <style>
    /* Định dạng chung cho toàn bộ trang */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
    text-align: center;
}

/* Container chính của form */
.form-container {
    width: 50%;
    margin: 50px auto;
    background: white;
    padding: 20px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
}

h2 {
    color: #333;
}

/* Định dạng chung cho form */
.form {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

label {
    font-weight: bold;
    text-align: left;
}

input, button {
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

input:focus {
    border-color: #007bff;
    outline: none;
}

/* Nút bấm */
button {
    background-color: #007bff;
    color: white;
    cursor: pointer;
    border: none;
}

button:hover {
    background-color: #0056b3;
}

/* Liên kết trở về danh sách */
.back-link {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    color: #007bff;
    font-weight: bold;
}

.back-link:hover {
    text-decoration: underline;
}
    </style>
</head>
<body>
<%@ include file="../Layout/header.jsp" %>


<section class="form-container">
    <form class="form" action="addSanPham" method="post">
        <h2>Thêm Sản Phẩm Mới</h2>

        <label for="tenSanPham">Tên Sản Phẩm:</label>
        <input type="text" name="tenSanPham" required>

        <label for="loaiSanPham">Loại Sản Phẩm:</label>
        <input type="text" name="loaiSanPham" required>

        <label for="kichCo">Kích Cỡ:</label>
        <input type="text" name="kichCo" required>

        <label for="mauSac">Màu Sắc:</label>
        <input type="text" name="mauSac" required>

        <label for="chatLieu">Chất Liệu:</label>
        <input type="text" name="chatLieu" required>

        <label for="hinhAnh">Hình Ảnh (URL):</label>
        <input type="text" name="hinhAnh" required>

        <label for="gia">Giá:</label>
        <input type="number" step="0.01" name="gia" required>

        <label for="soLuongTonKho">Số Lượng Tồn Kho:</label>
        <input type="number" name="soLuongTonKho" required>

        <label for="maNhaCungCap">Mã Nhà Cung Cấp:</label>
        <input type="text" name="maNhaCungCap" required>

        <button type="submit">Thêm Sản Phẩm</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/SanPham/listSanPham.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
