package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import jdbc.ConnectionPool;

public class QueryDao {

    public boolean add(String name, String email, String msg) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
            String sql = "Insert into query(name,email,message) values(?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, name);
                smt.setString(2, email);
                smt.setString(3, msg);
                int n = smt.executeUpdate();

                if (n > 0) {
                    status = true;
                    System.out.println("Record Inserted in query table...");
                }

                cp.releaseConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return status;
    }

}
