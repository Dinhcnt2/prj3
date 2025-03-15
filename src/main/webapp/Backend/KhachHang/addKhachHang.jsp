<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Khách Hàng</title>
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
    <form class="form" action="addKhachHang" method="post">
    <h2>Thêm Khách Hàng</h2>

    <label for="hoTen">Họ và Tên:</label>
    <input type="text" name="hoTen" required>

    <label for="soDienThoai">Số Điện Thoại:</label>
    <input type="text" name="soDienThoai" required>

    <label for="email">Email:</label>
    <input type="email" name="email" required>

    <label for="diaChi">Địa Chỉ:</label>
    <input type="text" name="diaChi" required>

    <label for="ngayThamGia">Ngày Tham Gia:</label>
    <input type="date" name="ngayThamGia" required>

    <button type="submit">Thêm Khách Hàng</button>
</form>

</section>

<a href="listKhachHang.jsp" class="back-link">Về Trang Danh Sách Khách Hàng</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
