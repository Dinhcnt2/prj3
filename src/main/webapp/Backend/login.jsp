<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
        form { width: 300px; margin: auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; }
        input { width: 100%; padding: 10px; margin: 10px 0; }
        button { width: 100%; padding: 10px; background-color: blue; color: white; }
        .error { color: red; }
    </style>
</head>
<body>
    <h2>Đăng nhập</h2>

    <%-- Hiển thị thông báo lỗi nếu có --%>
    <% String errorMessage = (String) request.getAttribute("errorMessage");
       if (errorMessage != null) { %>
        <p class="error"><%= errorMessage %></p>
    <% } %>

    <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
        <input type="text" name="email" placeholder="Nhập Email" required>
        <input type="text" name="soDienThoai" placeholder="Nhập Số Điện Thoại" required>
        <button type="submit">Đăng nhập</button>
    </form>
</body>
</html>
