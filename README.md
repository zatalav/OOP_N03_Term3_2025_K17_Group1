<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <title>Ứng dụng Đặt Vé Máy Bay ✈️</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
  <style>
    body {
      background: #f0f4f8;
      font-family: "Segoe UI", sans-serif;
      margin: 0;
      padding: 0;
      line-height: 1.6;
      color: #222;
    }
    .container {
      max-width: 960px;
      margin: 0 auto;
      padding: 20px;
    }
    header {
      position: relative;
      text-align: center;
      background: linear-gradient(to right, #00b4d8, #0077b6);
      color: white;
      padding: 60px 20px 100px;
      border-radius: 0 0 20px 20px;
      overflow: hidden;
    }
    header h1 {
      font-size: 3em;
      font-weight: 700;
      margin: 0;
      z-index: 2;
    }
    header p {
      font-size: 1.2em;
      font-weight: 300;
      z-index: 2;
    }
    .plane {
      position: absolute;
      width: 100px;
      top: 60%;
      left: -100px;
      animation: flyAcross 6s ease-in-out infinite;
      z-index: 1;
    }
    @keyframes flyAcross {
      0% {
        transform: translateX(0) translateY(0) rotate(0deg);
        opacity: 0;
      }
      10% {
        opacity: 1;
      }
      50% {
        transform: translateX(600px) translateY(-40px) rotate(10deg);
      }
      100% {
        transform: translateX(1100px) translateY(0) rotate(0deg);
        opacity: 0;
      }
    }
    section {
      background: white;
      margin: 40px 0;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.06);
    }
    section h2 {
      font-size: 1.8em;
      color: #1e3a8a;
      border-left: 6px solid #1e90ff;
      padding-left: 12px;
    }
    ul, ol {
      padding-left: 20px;
    }
    li {
      margin-bottom: 10px;
    }
    code {
      background: #e0f2ff;
      padding: 2px 6px;
      border-radius: 4px;
    }
    .cart-icon {
      position: fixed;
      top: 20px;
      right: 20px;
      font-size: 2em;
      color: #ff6f61;
      cursor: pointer;
      animation: bling 2s infinite;
    }
    @keyframes bling {
      0%, 100% { transform: scale(1); }
      50% { transform: scale(1.2); }
    }
  </style>
</head>
<body>
  <div class="container">
    <header>
      <h1>Ứng dụng Đặt Vé Máy Bay ✈️</h1>
      <p>Trải nghiệm đặt vé nhanh chóng và tiện lợi</p>
      <img src="https://cdn-icons-png.flaticon.com/512/34/34627.png" class="plane" alt="plane icon">
    </header>

    <section class="intro">
      <h2>📘 Giới thiệu</h2>
      <p><strong>Ứng dụng Đặt Vé Máy Bay</strong> hỗ trợ quản lý hành khách, chuyến bay và vé một cách hiện đại, nhanh chóng. Giao diện đơn giản, dễ sử dụng và dễ mở rộng cho các hãng hàng không.</p>
    </section>

    <section class="features">
      <h2>⚙️ Các chức năng chính</h2>
      <ul>
        <li><strong>Quản lý hành khách:</strong> Thêm, sửa, xoá, tìm kiếm hành khách.</li>
        <li><strong>Quản lý chuyến bay:</strong> Mã chuyến, giờ khởi hành, tuyến bay, số ghế, giá vé.</li>
        <li><strong>Quản lý tuyến bay:</strong> Quãng đường, nơi đi - nơi đến, thời gian bay.</li>
        <li><strong>Quản lý vé:</strong> Tạo, huỷ, tra cứu vé; in vé cho hành khách.</li>
        <li><strong>Quản lý nhân viên:</strong> Phân quyền, cập nhật thông tin cá nhân.</li>
        <li><strong>Thống kê:</strong> Doanh thu, lượt đặt vé, biểu đồ trực quan.</li>
      </ul>
    </section>

    <section class="technology">
      <h2>💻 Công nghệ sử dụng</h2>
      <p>Phát triển bằng <strong>Java</strong>, <strong>JavaFX</strong> và <strong>MySQL</strong>. Giao diện đẹp mắt và linh hoạt với FontAwesome, SceneBuilder và JDBC.</p>
    </section>

    <section class="install">
      <h2>📥 Hướng dẫn sử dụng</h2>
      <ol>
        <li>Tải source từ GitHub hoặc tải bản .jar phát hành.</li>
        <li>Mở bằng IntelliJ hoặc Eclipse.</li>
        <li>Chạy file <code>Main.java</code> hoặc file <code>.jar</code>.</li>
        <li>Sử dụng menu để quản lý vé, chuyến bay, hành khách.</li>
      </ol>
    </section>

    <section class="author">
      <h2>👤 Tác giả</h2>
      <p>Phát triển bởi <strong>Nhóm 1 - OOP N03</strong>, Đại học Phenikaa. Mọi phản hồi xin gửi qua email hoặc GitHub.</p>
    </section>
  </div>

  <div class="cart-icon">
    <i class="fas fa-shopping-cart"></i>
  </div>
</body>
</html>
