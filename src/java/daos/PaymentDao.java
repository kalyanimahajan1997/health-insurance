package daos;

import beans.Payment;
import beans.Policy;
import beans.PolicyHolder;
import beans.PolicyHolderAddress;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbc.ConnectionPool;

public class PaymentDao {

    public String generateTransId(int len) {
        // ASCII range - alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of loop choose a character randomly from the given ASCII range
        // and append it to StringBuilder instance
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public int addPaymentDetails(int amount, String payDate, String tId, String sts,String mode) {
        int payId = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            con.setAutoCommit(false);
            if (con != null) {
                String sql = "insert into payment (amount,payment_date,transaction_id,status,mode) values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, amount);
                ps.setString(2, payDate);
                ps.setString(3, tId);
                ps.setString(4, sts);
                ps.setString(5, mode);
                int n = ps.executeUpdate();

                if (n > 0) {
                    sql = "select id from payment order by id desc limit 1";
                    ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        payId = rs.getInt("id");
                    }
                    con.commit();
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return payId;
    }

    public boolean addUserPaymentDetails(int uId, int payId, int pId) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
             if (con != null) {
                String sql = "insert into user_payment(user_id,payment_id,policyholder_id) values(?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, uId);
                ps.setInt(2, payId);
                ps.setInt(3, pId);
                int n = ps.executeUpdate();

                if (n > 0) {
                    status = true;
                    System.out.println("renewed");
                }

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    
    public ArrayList<Payment> getAllPayments(){
        ArrayList<Payment> payments = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from payment";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setId(rs.getInt("id"));
                    payment.setAmount(Integer.parseInt(rs.getString("amount")));
                    payment.setTransaction_id(rs.getString("transaction_id"));
                    payment.setPayment_date(rs.getString("payment_date"));
                    payment.setStatus(rs.getString("status"));
                    payment.setMode(rs.getString("mode"));
                    
                    payments.add(payment);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
 
        return payments;
    }
 
    
    public ArrayList<Payment> getAllPaymentsByUserId(int userId){
        ArrayList<Payment> payments = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from payment where id in(select payment_id from user_payment where user_id=?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setId(rs.getInt("id"));
                    payment.setAmount(Integer.parseInt(rs.getString("amount")));
                    payment.setTransaction_id(rs.getString("transaction_id"));
                    payment.setPayment_date(rs.getString("payment_date"));
                    payment.setStatus(rs.getString("status"));
                    payment.setMode(rs.getString("mode"));
                    
                    payments.add(payment);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
 
        return payments;
    }
 
    
    public ArrayList<Payment> getAllPaymentsByPhId(int phId){
        ArrayList<Payment> payments = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from payment where id in(select payment_id from user_payment where policyholder_id=?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, phId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setId(rs.getInt("id"));
                    payment.setAmount(Integer.parseInt(rs.getString("amount")));
                    payment.setTransaction_id(rs.getString("transaction_id"));
                    payment.setPayment_date(rs.getString("payment_date"));
                    payment.setStatus(rs.getString("status"));
                    payment.setMode(rs.getString("mode"));
                    
                    payments.add(payment);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
 
        return payments;
    }
 
    public String getUserEmailByPaymentId(int pId){
        String uEmail = "";
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select email from user where id in(select user_id from user_payment where payment_id=?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,pId);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    uEmail = rs.getString("email");
                }
            }
        }catch(Exception e){
            System.out.println("dbError:"+e.getMessage());
        }
        
        return uEmail;
    }
    
    public int getTotalSum(int phId){
        int sum = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select sum(amount) from payment where id in(select payment_id from user_payment where policyholder_id=?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,phId);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    sum = rs.getInt(1);
                }
            }
        }catch(Exception e){
            System.out.println("dbError:"+e.getMessage());
        }
         return sum;
    }
    
    public static void main(String[] args) {
        PaymentDao pyd = new PaymentDao();
        System.out.println("payment:"+pyd.getTotalSum(101));
    }
}
