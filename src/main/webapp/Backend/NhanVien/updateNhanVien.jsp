<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Nhân Viên</title>
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
    <form class="form" action="updateNhanVien" method="post">
        <h2>Cập Nhật Nhân Viên</h2>

        <input type="hidden" name="maNhanVien" value="${nhanVien.maNhanVien}">

        <label for="hoTen">Họ và Tên:</label>
        <input type="text" name="hoTen" value="${nhanVien.hoTen}" required>

        <label for="soDienThoai">Số Điện Thoại:</label>
        <input type="text" name="soDienThoai" value="${nhanVien.soDienThoai}" required>

        <label for="email">Email:</label>
        <input type="email" name="email" value="${nhanVien.email}" required>

        <label for="chucVu">Chức Vụ:</label>
        <input type="text" name="chucVu" value="${nhanVien.chucVu}" required>

        <label for="luong">Lương:</label>
        <input type="number" step="0.01" name="luong" value="${nhanVien.luong}" required>

        <label for="ngayVaoLam">Ngày Vào Làm:</label>
        <input type="date" name="ngayVaoLam" value="${nhanVien.ngayVaoLam}" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="listNhanVien.jsp" class="back-link">Về Trang Danh Sách Nhân Viên</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
