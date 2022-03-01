import java.sql.*;

public class Sample {
    
    public static void main(String args[]){
        String res = "";
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/babariya", "root", "1234");
            st = c.createStatement();
            rs = st.executeQuery("SELECT * FROM thirdcse");
            while(rs.next()){
                res = "Student name : "+rs.getString(2)+" Marks : "+rs.getInt(4);
            }
            System.out.println(res);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
