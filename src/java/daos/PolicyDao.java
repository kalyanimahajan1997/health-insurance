 package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbc.ConnectionPool;
import beans.Policy;
import daos.PolicyDao;
 public class PolicyDao {
 
      public boolean  add(Policy policy){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "Insert into policy(name,type,min_sum_assured,min_time_duration,description) values(?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, policy.getName());
           smt.setString(2, policy.getType());
           smt.setString(3, policy.getMin_sum_assured());
           smt.setString(4, policy.getMin_time_duration());
           smt.setString(5, policy.getDescription());
           
            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
    return status;
   }
   
   
     
     public ArrayList<Policy> getAllPolicy() {
        ArrayList<Policy> AllPolicy = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from policy";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Policy policy = new Policy();
                    policy.setId(rs.getInt("id"));
                    policy.setName(rs.getString("name"));
                    policy.setMin_sum_assured(rs.getString("min_sum_assured"));
                    policy.setMin_time_duration(rs.getString("min_time_duration"));
                    policy.setType(rs.getString("type"));
                    policy.setDescription(rs.getString("description"));
                    
                    AllPolicy.add(policy);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return AllPolicy;
    }

     
     public ArrayList<Policy> getAllPolicyByUserId(int userid) {
        ArrayList<Policy> AllPolicy = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from policy where id in(select policy_id from user_policy_policyholder where user_id=?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,userid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Policy policy = new Policy();
                    policy.setId(rs.getInt("id"));
                    policy.setName(rs.getString("name"));
                    policy.setMin_sum_assured(rs.getString("min_sum_assured"));
                    policy.setMin_time_duration(rs.getString("min_time_duration"));
                    policy.setType(rs.getString("type"));
                    policy.setDescription(rs.getString("description"));
                    
                    AllPolicy.add(policy);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return AllPolicy;
    }

     
      public boolean  remove(int policy_id){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "Delete from policy where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, policy_id);
            
            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
    return status;
   }
  
     public Policy  getPolicyById(int policy_id){
      Policy policy=null;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from policy where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, policy_id);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                policy =new Policy();
                policy.setId(rs.getInt("id"));
                policy.setName(rs.getString("name"));
                policy.setMin_sum_assured(rs.getString("min_sum_assured"));
                policy.setMin_time_duration(rs.getString("min_time_duration"));
                policy.setType(rs.getString("type"));
                policy.setDescription(rs.getString("description"));                 
            }
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
    return policy;
   }
  
        public Policy  getPolicyByPolicyHolderId(int policyHolder_id){
      Policy policy=null;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from policy where id in(select policy_id from user_policy_policyholder where id=?)";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, policyHolder_id);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                policy =new Policy();
                policy.setId(rs.getInt("id"));
                policy.setName(rs.getString("name"));
                policy.setMin_sum_assured(rs.getString("min_sum_assured"));
                policy.setMin_time_duration(rs.getString("min_time_duration"));
                policy.setType(rs.getString("type"));
                policy.setDescription(rs.getString("description"));                 
            }
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
    return policy;
   }
  
     
       public int  getPolicyCount(){
    
       int total=0;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select count(*) from policy";
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
    return total;
   }
 
        public boolean  update(Policy policy){
       boolean status=false;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "update policy set name=?,type=?,min_sum_assured=?,min_time_duration=?,description=? where id=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, policy.getName());
            smt.setString(2, policy.getType());
            smt.setString(3, policy.getMin_sum_assured());
            smt.setString(4, policy.getMin_time_duration());
            smt.setString(5, policy.getDescription());
            smt.setInt(6, policy.getId());
            if(smt.executeUpdate()>0)
                status=true;
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
    return status;
   }
  
        public boolean  isPolicyExist(String policy_name){
       boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from policy where name=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, policy_name);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                status=true;
            }
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("Error :"+e.getMessage());
        }
       }
       
       return status;
   }
   
   
       public int getSumByPolicyId(int pId) {
        int sum_assured = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select sum_assured from user_policy_policyholder where policy_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, pId);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    sum_assured = rs.getInt("sum_assured");
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return sum_assured;

    }
     
       
       public int getSumByPolicyHolderId(int phId) {
        int sum_assured = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select sum_assured from user_policy_policyholder where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, phId);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    sum_assured = rs.getInt("sum_assured");
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return sum_assured;

    }
     
         public int getTimeByPolicyId(int userId) {
        int time_duration = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select time_duration from user_policy_policyholder where policy_id in(select policy_id from user_policy_policyHolder where user_id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, userId);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    time_duration = rs.getInt("time_duration");
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return time_duration;

    }
         
     public static void main(String[] args) {
         PolicyDao pd = new PolicyDao();
         System.out.println("policy:"+pd.getPolicyByPolicyHolderId(101));
     }
         
}
