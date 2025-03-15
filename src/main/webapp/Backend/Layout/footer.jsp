<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<footer>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            display: flex;
            flex-direction: column;
        }
        .container {
            flex: 1; /* Đẩy footer xuống đáy khi nội dung ít */
        }
        .footer-container {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
            width: 100%;
            position: fixed;
            bottom: 0;
            left: 0;
        }
    </style>
    <div class="footer-container">
        <p>&copy; 2025 Hệ Thống Quản Lý Cửa Hàng Thời Trang Trẻ Em</p>
        <p>Vương Văn Định</p>
    </div>
</footer>