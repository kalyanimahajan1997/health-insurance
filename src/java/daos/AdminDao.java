/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.ConnectionPool;

/**
 *
 * @author AKSHAY
 */
public class AdminDao {
    public Admin getDetailsByLogin(String userid, String password) {
        Admin admin = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from admin where username=? and password=?";
                PreparedStatement smt = con.prepareStatement(sql);
               smt.setString(1, userid);
               smt.setString(2,password);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    admin = new Admin();
                    admin.setImage(rs.getString("image"));
                    admin.setName(rs.getString("name"));
                  //  admin.setUserid(rs.getString("userid"));
                //   admin.setPassword(rs.getString("password"));
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return admin;
    }
     
}
