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
  <a href="#phân-công">🧑‍💻 Phân công</a> • 
  <a href="#yêu-cầu-6">🛡️ Yêu cầu 6</a> • 
  <a href="#tác-giả">👤 Tác giả</a>
</p>

---

## 📘 Giới thiệu <a name="giới-thiệu"></a>

**Ứng dụng Đặt Vé Máy Bay** là phần mềm được phát triển bằng Java Spring Boot nhằm hỗ trợ quản lý hành khách, chuyến bay, tuyến bay và vé máy bay một cách **hiện đại, chính xác, dễ sử dụng**.

Hệ thống hướng đến người dùng tại các phòng vé vừa và nhỏ hoặc phục vụ mục tiêu học tập tại các trường đại học.

---

## ⚙️ Các chức năng chính <a name="chức-năng"></a>

✅ **Quản lý hành khách**

- Nhập, sửa, xoá và hiển thị thông tin khách hàng (Họ tên, Email, SĐT, Mã KH).
- Kiểm tra hợp lệ định dạng email, số điện thoại, mã khách hàng.

✅ **Quản lý chuyến bay**

- Thêm, xoá, cập nhật chuyến bay (Mã, tên, ngày giờ, số ghế, điểm đi - đến).
- Kiểm tra định dạng ngày giờ theo chuẩn `dd-MM-yyyy HH:mm`.
- Hỗ trợ test đơn vị với `TestQuanLyChuyenBay`.

✅ **Quản lý vé**

- Tạo, sửa, xoá vé cho từng hành khách.
- Thông tin vé gồm: Mã vé, tên hành khách, ngày đặt vé, giá vé.
- Kiểm tra mã vé hợp lệ theo định dạng `^[A-Z]{2}\d{5}$`.
- Hỗ trợ hiển thị vé với định dạng ngày và tiền Việt (`Locale vi_VN`).

✅ **Hiển thị & Test**

- Mỗi đối tượng (Vé, Chuyến bay, Khách hàng) có lớp hiển thị định dạng rõ ràng.
- Các test case `TestQuanLyVe`, `TestQuanLyChuyenBay`, `TestKhachHang`, `Test_Ve` đã triển khai kiểm thử chức năng thêm, hiển thị, và xóa dữ liệu.

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
   Import project vào IntelliJ IDEA hoặc Eclipse.
   ```

Cài đặt MySQL và cấu hình application.properties.

Chạy project bằng Spring Boot (VeAppApplication.java).

Mở trình duyệt, truy cập:
http://localhost:8080/Ve – Quản lý Vé
http://localhost:8080/KhachHang – Quản lý Hành khách
http://localhost:8080/ChuyenBay – Quản lý Chuyến bay

## 🧑‍💻 Phân công công việc <a name="phân-công"></a>

Dựa trên chức năng cốt lõi của hệ thống là **Quản lý Vé Máy Bay**, nhóm đã phân chia từng phần theo mô hình MVC như sau:

| MSSV     | Họ và Tên             | Nhiệm vụ MVC cụ thể                                            |
| -------- | --------------------- | -------------------------------------------------------------- |
| 23010772 | **Lê Đức Duy**        | Xây dựng phần **Quản lý Vé** (Model, Controller, View)         |
| 23010123 | Lê Mạnh Hùng          | Xây dựng phần **Quản lý Khách hàng** (Model, Controller, View) |
| 23016112 | Nguyễn Thị Khánh Linh | Xây dựng phần **Quản lý Chuyến bay** (Model, Controller, View) |

📌 Mỗi thành viên đều chịu trách nhiệm một chức năng không trùng nhau, theo đúng mô hình MVC, và thực hiện riêng biệt phần `Controller`, `Model`, `View` tương ứng.

## 🛡️ Yêu cầu số 6 – Thêm try-catch-finally <a name="yêu-cầu-6"></a>

Tất cả các thành viên trong nhóm đã thêm khối `try { ... } catch (Exception e) { ... } finally { ... }` vào phần xử lý chính mà mình đảm nhận trong bài tập lớn.

Việc này giúp:

- Bắt lỗi chương trình trong lúc chạy thực tế.
- Đảm bảo ứng dụng không bị crash khi có lỗi.
- Ghi log/hiển thị thông báo khi lỗi xảy ra.

### 🔍  (Lê Đức Duy – Phần Vé):

File: `VeAppApplication.java`

```java
public static void main(String[] args) {
    try {
        SpringApplication.run(VeAppApplication.class, args);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        System.out.println("Ứng dụng Quản lý Vé đã khởi chạy.");
    }
}
```
💻 Giao diện
Truy cập: http://localhost:8080/ves
Chức năng: Hiển thị danh sách vé đã đặt

🧠 Mô tả chức năng chính
Chuyển từ giao diện console sang web UI
Dựa trên bài thực hành Practice 6
Có try-catch-finally đầy đủ (Yêu cầu số 6)
👨‍👩‍👧 Phân công công việc
Thành viên	Chức năng thực hiện
TienLE	UI cho chức năng Quản lý Vé
🚀 Cách chạy
mvn spring-boot:run
# Truy cập tại: http://localhost:8080/ves
📸 Ảnh minh họa:

![try-catch-finally](src/main/java/com/example/veapp/img/try-catch-example.png)

