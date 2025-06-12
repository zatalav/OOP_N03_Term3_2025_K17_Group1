package src.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class JDBC {
    public static Connection getConnection(){
        Connection c = null;

        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/java";
            String username = "root";
            String password = "CSDL2021";
            c = DriverManager.getConnection(url, username, password);

    }catch (SQLException e){
        e.printStackTrace();
    }



        return c;
    }

    public static void closeConnection(Connection c){
        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c){
            try {
                if (c != null){
                    DatabaseMetaData mtd = c.getMetaData();
                    System.out.println(mtd.getDatabaseProductVersion());
                } 
            }catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

