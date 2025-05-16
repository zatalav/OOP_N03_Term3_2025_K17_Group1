<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Ứng dụng Quản lý Đặt vé Máy bay</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            background: #f0f0f0;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            line-height: 1.6;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
        }
        header {
            text-align: center;
            background: #005f73;
            color: white;
            padding: 30px 20px;
            border-radius: 8px;
        }
        header h1 {
            margin: 0;
            font-size: 2.5em;
        }
        header p {
            margin-top: 10px;
            font-size: 1.2em;
        }
        section {
            margin: 20px 0;
            padding: 20px;
            border-radius: 8px;
        }
        .intro {
            background: #e0fbfc;
        }
        .features {
            background: #fffbdb;
        }
        .technology {
            background: #e7fbff;
        }
        .install {
            background: #fff8f0;
        }
        .author {
            background: #fce8f1;
        }
        section h2 {
            margin-top: 0;
        }
        section h2 span {
            margin-left: 8px;
        }
        ul, ol {
            margin: 0;
            padding-left: 20px;
        }
        li {
            margin-bottom: 10px;
        }
        code {
            background: #eee;
            padding: 2px 4px;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>Ứng dụng Quản lý Đặt vé Máy bay <span>✈️</span></h1>
            <p>Hệ thống quản lý bán vé máy bay chuyên nghiệp</p>
        </header>
        <section class="intro">
            <h2>Giới thiệu <span>🗂️</span></h2>
            <p><strong>Ứng dụng Quản lý Đặt vé Máy bay</strong> là một hệ thống hỗ trợ quản lý các hoạt động bán vé và đặt vé máy bay của hãng hàng không. Ứng dụng cho phép nhân viên hệ thống dễ dàng quản lý thông tin về hành khách, chuyến bay, vé và các hoạt động liên quan. Giao diện thân thiện và tính năng đầy đủ giúp tối ưu hóa quy trình bán vé, nâng cao hiệu quả làm việc.</p>
        </section>
        <section class="features">
            <h2>Các chức năng chính <span>⚙️</span></h2>
            <ul>
                <li><i class="fas fa-user-friends"></i> <strong>Quản lý hành khách:</strong> Thêm, sửa, xóa và tìm kiếm thông tin hành khách (tên, CMND/CCCD, giới tính, địa chỉ, liên hệ, v.v.).</li>
                <li><i class="fas fa-plane"></i> <strong>Quản lý chuyến bay:</strong> Thêm, sửa, xóa và tìm kiếm thông tin chuyến bay (mã chuyến bay, tuyến bay, máy bay, ngày giờ khởi hành, giờ đến, số ghế, giá vé, v.v.).</li>
                <li><i class="fas fa-route"></i> <strong>Quản lý tuyến bay:</strong> Thêm, sửa, xóa và tìm kiếm thông tin tuyến bay (mã tuyến, nơi đi, nơi đến, quãng đường, thời gian bay, giá vé, v.v.).</li>
                <li><i class="fas fa-money-check-alt"></i> <strong>Quản lý vé máy bay:</strong> Tạo mới, hủy bỏ và in vé cho hành khách, hiển thị đầy đủ thông tin (số vé, hành khách, chuyến bay, ngày giờ bay, nơi đi đến, giá tiền, v.v.).</li>
                <li><i class="fas fa-user-cog"></i> <strong>Quản lý nhân viên:</strong> Thêm, sửa, xóa thông tin nhân viên và phân quyền truy cập hệ thống (mã NV, tên, giới tính, ngày sinh, quyền hạn, v.v.).</li>
                <li><i class="fas fa-chart-line"></i> <strong>Báo cáo thống kê:</strong> Cung cấp báo cáo doanh thu, số vé đã bán, thống kê theo thời gian và biểu đồ giúp đánh giá hiệu quả kinh doanh.</li>
            </ul>
        </section>
        <section class="technology">
            <h2>Công nghệ sử dụng <span>💻</span></h2>
            <p>Ứng dụng được phát triển với ngôn ngữ lập trình <strong>Java</strong> và sử dụng thư viện <strong>Swing</strong> để xây dựng giao diện đồ họa. Phần dữ liệu được lưu trữ trên cơ sở dữ liệu <strong>MySQL</strong>, kết nối bằng <strong>JDBC</strong>. Ứng dụng có thể chạy trên nền tảng Windows hoặc Linux.</p>
            <p>Các công cụ và thư viện khác: VS Code / Eclipse (IDE), FontAwesome (biểu tượng), và các thư viện hỗ trợ tương tác với cơ sở dữ liệu.</p>
        </section>
        <section class="install">
            <h2>Hướng dẫn sử dụng <span>📥</span></h2>
            <ol>
                <li>Tải xuống tệp cài đặt hoặc mã nguồn của ứng dụng từ GitHub.</li>
                <li>Chạy tập tin cài đặt hoặc biên dịch và chạy mã nguồn (nếu là bản dành cho lập trình viên).</li>
                <li>Mở ứng dụng và đăng nhập bằng tài khoản nhân viên (nếu cần).</li>
                <li>Sử dụng các menu chức năng để quản lý hành khách, chuyến bay, vé... theo nhu cầu.</li>
            </ol>
        </section>
        <section class="author">
            <h2>Tác giả <span>👤</span></h2>
            <p>Được phát triển bởi <strong>Nhóm Sinh viên A</strong>, Đại học XYZ. Để biết thêm chi tiết hoặc góp ý, vui lòng liên hệ qua email hoặc GitHub của nhóm.</p>
        </section>
    </div>
</body>
</html>
