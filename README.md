<h1 align="center">✈️ ỨNG DỤNG ĐẶT VÉ MÁY BAY</h1>

<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/34/34627.png" width="100" alt="plane icon" />
</p>

<p align="center"><strong>Trải nghiệm đặt vé nhanh chóng – chính xác – tiện lợi</strong></p>

<p align="center">
  <a href="#giới-thiệu">📘 Giới thiệu</a> • 
  <a href="#chức-năng">⚙️ Chức năng</a> • 
  <a href="#công-nghệ">💻 Công nghệ</a> • 
  <a href="#hướng-dẫn">📥 Hướng dẫn</a> • 
  <a href="#tác-giả">👤 Tác giả</a>
</p>

---

## 🎯 Mục tiêu chính

* Xây dựng ứng dụng đặt vé máy bay thân thiện với người dùng.
* Hỗ trợ quản lý chuyến bay, hành khách, và vé một cách dễ dàng.
* Phù hợp với các hệ thống demo học tập hoặc phòng vé nhỏ.

---

## 📘 Giới thiệu

**Ứng dụng Đặt Vé Máy Bay** là phần mềm được phát triển bằng Java Spring Boot nhằm hỗ trợ quản lý hành khách, chuyến bay, tuyến bay và vé máy bay một cách **hiện đại, chính xác, dễ sử dụng**.
Hệ thống hướng đến người dùng tại các phòng vé vừa và nhỏ hoặc phục vụ mục tiêu học tập tại các trường đại học.

---

## ⚙️ Các chức năng chính <a name="chức-năng"></a>

✅ **Quản lý hành khách**

* Nhập, sửa, xoá và hiển thị thông tin khách hàng (Họ tên, Email, SĐT, Mã KH).
* Kiểm tra hợp lệ định dạng email, số điện thoại, mã khách hàng.

✅ **Quản lý chuyến bay**

* Thêm, xoá, cập nhật chuyến bay (Mã, tên, ngày giờ, số ghế, điểm đi - đến).
* Kiểm tra định dạng ngày giờ theo chuẩn `dd-MM-yyyy HH:mm`.
* Hỗ trợ test đơn vị với `TestQuanLyChuyenBay`.

✅ **Quản lý vé**

* Tạo, sửa, xoá vé cho từng hành khách.
* Thông tin vé gồm: Mã vé, tên hành khách, ngày đặt vé, giá vé.
* Kiểm tra mã vé hợp lệ theo định dạng `^[A-Z]{2}\d{5}$`.
* Hỗ trợ hiển thị vé với định dạng ngày và tiền Việt (`Locale vi_VN`).

✅ **Hiển thị & Test**

* Mỗi đối tượng (Vé, Chuyến bay, Khách hàng) có lớp hiển thị định dạng rõ ràng.
* Các test case `TestQuanLyVe`, `TestQuanLyChuyenBay`, `TestKhachHang`, `Test_Ve` đã triển khai kiểm thử chức năng thêm, hiển thị, và xóa dữ liệu.

---

## 💻 Công nghệ sử dụng <a name="công-nghệ"></a>

| Thành phần           | Công nghệ sử dụng              |
| -------------------- | ------------------------------ |
| Ngôn ngữ chính       | `Java`                         |
| Framework Backend    | `Spring Boot`                  |
| Giao diện người dùng | `Spring MVC + Thymeleaf`       |
| Cơ sở dữ liệu        | `MySQL`                        |
| Kết nối CSDL         | `Spring Data JPA`, `Hibernate` |
| Unit Test            | `JUnit`, `Mockito`             |
| Quản lý dự án        | `Maven`                        |

---

## 📥 Hướng dẫn sử dụng <a name="hướng-dẫn"></a>

1. Clone project từ GitHub:

   ```bash
   git clone https://github.com/zatalav/OOP_N03_Term3_2025_K17_Group1.git
   ```

2. Import project vào **IntelliJ IDEA** hoặc **Eclipse**.

3. Cài đặt MySQL và cấu hình `application.properties`.

4. Chạy project bằng Spring Boot (`App.java` hoặc `MainController`).

5. Sử dụng trình duyệt để truy cập các chức năng: `/KhachHang`, `/ChuyenBay`, `/Ve`...

---

## 👤 Tác giả <a name="tác-giả"></a>

| MSSV     | Họ và Tên             | Vai trò           |
| -------- | --------------------- | ----------------- |
| 23010772 | Lê Đức Duy            |  |
| 23010123 | Lê Mạnh Hùng          |     |
| 23016112 | Nguyễn Thị Khánh Linh |     |

📍 **Đại học Phenikaa**
📧 Mọi góp ý vui lòng gửi về: [Github Group](https://github.com/zatalav/OOP_N03_Term3_2025_K17_Group1.git)

---

## 📊 Hình ảnh hệ thống

![UML Class Diagram](<Ảnh chụp màn hình 2025-05-23 080633.png>)

![Activity Diagram - Thêm](<Ảnh chụp màn hình 2025-05-23 080430.png>)

![Activity Diagram - Sửa](<Ảnh chụp màn hình 2025-05-23 080347-1.png>)

![Activity Diagram - Xóa](<Ảnh chụp màn hình 2025-05-23 080600.png>)

