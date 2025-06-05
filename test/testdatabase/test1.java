package btl.test;
import java.sql.Connection;
import java.sql.Statement;
import btl.database.JDBC;

public class test1 {
    public static void main(String[] args) {

        try {
                // B1: tạo kết nối đến CSDL
            Connection connection = btl.database.JDBC.getConnection();

                // B2: tạo đối tượng Statement để thực hiện câu lệnh SQL
            Statement st = connection.createStatement();

                //B3: thực hiện câu lệnh SQL
            String sql = "INSERT INTO persons (last_name, first_name, gender, dod, income) VALUES "
                   + "(\"nguyen\", \"hihi\", \"M\", \"2023-12-09\", 20000), "
                   + "(\"dong\", \"he he\", \"F\", \"2023-06-09\", 90000)";
            int check= st.executeUpdate(sql);

                //B4: xử lý kết quả trả về
            System.out.println("Số dong thay doi: " + check);
            if (check > 0) {
                System.out.println("Thêm thành công");
            } else {
                System.out.println("Thêm thất bại");
            }

                //b5: ngắt kết nối
            JDBC.closeConnection(connection);           
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
