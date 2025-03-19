<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Khuyến Mãi</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .section-title { text-align: center; color: #E91E63; font-weight: bold; margin-bottom: 20px; }
        .product-container { display: flex; flex-wrap: wrap; justify-content: center; gap: 20px; padding: 20px; }
        .product-card { background: #fff; border-radius: 8px; padding: 15px; width: 280px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); text-align: center; }
        .product-card img { width: 100%; height: 220px; object-fit: contain; border-radius: 5px; background: #f8f8f8; }
        .product-card h3 { color: #007bff; margin-top: 10px; font-size: 18px; }
        .product-card p { margin: 5px 0; font-size: 14px; color: #555; }
        .discount { color: red; font-weight: bold; }
        .view-btn { background: #E91E63; color: #fff; padding: 8px 12px; border-radius: 5px; text-decoration: none; transition: 0.3s; display: inline-block; }
        .view-btn:hover { background: #d81b60; }
    </style>
</head>
<body>
    <%@ include file="VVDheader.jsp" %>

    <div class="container mt-4">
        <h1 class="section-title">Chương Trình Khuyến Mãi</h1>
        <div class="product-container">
            <div class="product-card">
                <img src="images/aothun1.jpg" alt="Áo thun bé trai">
                <h3>Áo thun bé trai</h3>
                <p><strong>Giá gốc:</strong> <del>200,000 VND</del></p>
                <p><strong>Giá khuyến mãi:</strong> <span class="discount">180,000 VND</span></p>
                <p><strong>Giảm:</strong> <span class="discount">10%</span></p>
                <p><strong>Màu sắc:</strong> Xanh</p>
                <a href="VVDChitietsanpham.jsp?maSanPham=1" class="view-btn">Xem Chi Tiết</a>
            </div>

            <div class="product-card">
                <img src="images/damcongchua.jpg" alt="Đầm công chúa">
                <h3>Đầm công chúa</h3>
                <p><strong>Giá gốc:</strong> <del>350,000 VND</del></p>
                <p><strong>Giá khuyến mãi:</strong> <span class="discount">297,500 VND</span></p>
                <p><strong>Giảm:</strong> <span class="discount">15%</span></p>
                <p><strong>Màu sắc:</strong> Hồng</p>
                <a href="VVDChitietsanpham.jsp?maSanPham=2" class="view-btn">Xem Chi Tiết</a>
            </div>

            <div class="product-card">
                <img src="images/quanjeans.jpg" alt="Quần jeans bé trai">
                <h3>Quần jeans bé trai</h3>
                <p><strong>Giá gốc:</strong> <del>250,000 VND</del></p>
                <p><strong>Giá khuyến mãi:</strong> <span class="discount">237,500 VND</span></p>
                <p><strong>Giảm:</strong> <span class="discount">5%</span></p>
                <p><strong>Màu sắc:</strong> Xanh đậm</p>
                <a href="VVDChitietsanpham.jsp?maSanPham=3" class="view-btn">Xem Chi Tiết</a>
            </div>

            <div class="product-card">
                <img src="images/bothethao.jpg" alt="Bộ đồ thể thao">
                <h3>Bộ đồ thể thao</h3>
                <p><strong>Giá gốc:</strong> <del>300,000 VND</del></p>
                <p><strong>Giá khuyến mãi:</strong> <span class="discount">240,000 VND</span></p>
                <p><strong>Giảm:</strong> <span class="discount">20%</span></p>
                <p><strong>Màu sắc:</strong> Đỏ</p>
                <a href="VVDChitietsanpham.jsp?maSanPham=4" class="view-btn">Xem Chi Tiết</a>
            </div>

            <div class="product-card">
                <img src="images/aokhoac.jpg" alt="Áo khoác mùa đông">
                <h3>Áo khoác mùa đông</h3>
                <p><strong>Giá gốc:</strong> <del>500,000 VND</del></p>
                <p><strong>Giá khuyến mãi:</strong> <span class="discount">350,000 VND</span></p>
                <p><strong>Giảm:</strong> <span class="discount">30%</span></p>
                <p><strong>Màu sắc:</strong> Xám</p>
                <a href="VVDChitietsanpham.jsp?maSanPham=5" class="view-btn">Xem Chi Tiết</a>
            </div>
        </div>
    </div>

    <%@ include file="VVDfooter.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
