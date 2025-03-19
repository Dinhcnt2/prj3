<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cửa Hàng Thời Trang Trẻ Em</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .bg-pink { background-color: #E91E63; }
        .text-pink { color: #E91E63; }
        .banner img { width: 100%; height: 350px; object-fit: cover; border-radius: 10px; }
        .section-title { color: #E91E63; font-weight: bold; text-align: center; margin-bottom: 20px; }
    </style>
</head>
<body>
    <%@ include file="VVDheader.jsp" %>

    <!-- Giới thiệu cửa hàng -->
    <div class="container mt-4 text-center">
        <h1 class="section-title">Chào mừng đến với Fashion Kids</h1>
        <p class="lead">Fashion Kids là thương hiệu chuyên cung cấp quần áo thời trang cao cấp cho trẻ em. 
            Chúng tôi cam kết mang đến những bộ trang phục đẹp mắt, chất liệu an toàn, phù hợp với mọi phong cách của bé.</p>
        <p>Khám phá bộ sưu tập thời trang mới nhất của chúng tôi với nhiều thiết kế độc đáo dành riêng cho bé yêu.</p>
    </div>

    <!-- Danh mục sản phẩm chính -->
    <div class="container mt-4">
        <div class="row">
            <div class="col-md-6 text-center">
                <img src="${pageContext.request.contextPath}/images/tre4.jpg" class="banner" alt="Thời trang bé gái">
                <h2 class="mt-3 text-pink">Thời trang bé gái</h2>
                <p>Tập hợp những mẫu quần áo thời trang bé gái mới nhất, đa phong cách: sành điệu, năng động, đáng yêu.</p>
                <a href="#" class="btn btn-outline-primary">Mua ngay</a>
            </div>
            <div class="col-md-6 text-center">
                <img src="${pageContext.request.contextPath}/images/ytre5.jpg" class="banner" alt="Quần áo bé trai">
                <h2 class="mt-3 text-pink">Quần áo bé trai</h2>
                <p>Những bộ đồ bé trai cực chất, luôn cập nhật xu hướng thời trang mới nhất.</p>
                <a href="#" class="btn btn-outline-primary">Mua ngay</a>
            </div>
        </div>
    </div>

    <%@ include file="VVDfooter.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
