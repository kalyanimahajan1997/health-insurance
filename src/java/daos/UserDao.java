package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.ConnectionPool;
import beans.PolicyHolder;
import java.util.ArrayList;
import beans.User;

public class UserDao {

     public boolean addUser(User user) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "insert into user(name,email,password,contact) values(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getContact());
                int n = ps.executeUpdate();

                if (n > 0) {
                    status = true;
                    con.close();
                    System.out.println("Record Inserted...");
                }
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        }

        return status;
    }

     public boolean setPassword(int userid,String password) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "update user set password=? where id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, password);
                ps.setInt(2, userid);
                int n = ps.executeUpdate();

                if (n > 0) {
                    status = true;
                    con.close();
                    System.out.println("successfully updated...");
                }
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        }

        return status;
    }

     
    
    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from user";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setContact(rs.getString("contact"));

                    userList.add(user);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return userList;
    }

    public User getUserByUserId(int userid) {
        User user = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from user where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, userid);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setContact(rs.getString("contact"));
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return user;
    }

     public User getUserByEmailId(String emailId) {
        User user = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from user where email=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, emailId);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setContact(rs.getString("contact"));
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return user;
    }

    public boolean update(User user) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "update user set name=?,email=?,password=?,contact=? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, user.getName());
                smt.setString(2, user.getEmail());
                smt.setString(3, user.getPassword());
                smt.setString(4, user.getContact());
                smt.setInt(5, user.getId());
                if (smt.executeUpdate() > 0) {
                    status = true;
                }
                smt.close();
                cp.releaseConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return status;
    }

    
    public int isValid(String email, String password) {
        int status = -1;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from user where email=? and password=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, email);
                smt.setString(2, password);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = rs.getInt("id");
                }
                smt.close();
                cp.releaseConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }
        //System.out.println("id:"+status);
        return status;
    }
    
    public boolean isUserExist(int userid) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from user where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, userid);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = true;
                }
                smt.close();
                cp.releaseConnection(con);
            } catch (Exception e) {
                System.out.println("Error :" + e.getMessage());
            }
        }

        return status;
    }

    
}









