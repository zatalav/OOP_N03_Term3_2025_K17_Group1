package com.example.servingwebcontent.documents;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class WriteToFile {

    public void writeDoanhThuToFile(int thang, int nam, double doanhThu) {
        try {
            String folderPath = "./complete/File/ThongKe/";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs(); // Tạo thư mục nếu chưa có
            }

            String filePath = folderPath + "DoanhThu.txt"; // luôn ghi vào 1 file duy nhất

            FileWriter writer = new FileWriter(filePath); // Ghi đè (không có "true" nghĩa là xóa nội dung cũ)
            writer.write("=== Thống kê doanh thu ===\n");
            writer.write("Tháng: " + thang + "\n");
            writer.write("Năm: " + nam + "\n");
            writer.write("Tổng doanh thu: " + doanhThu + " VND\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Lỗi ghi file thống kê doanh thu!");
            e.printStackTrace();
        }
    }
}
