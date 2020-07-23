package daos;

import beans.Policy;
import beans.PolicyHolder;
import beans.PolicyHolderAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import jdbc.ConnectionPool;
import java.util.concurrent.ThreadLocalRandom;
import java.security.SecureRandom;

public class PolicyHolderDao {

    public boolean addUserPolicyHolder(int userid,Policy policy) {
        boolean status = false;
         try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "insert into user_policy_policyholder(user_id,policy_id,start_date,time_duration,sum_assured)values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, userid);
                ps.setInt(2, policy.getId());
                  LocalDate date = LocalDate.now();
            String start_date = date.toString();
            ps.setString(3, start_date);
            int time = Integer.parseInt(policy.getMin_time_duration());
            ps.setInt(4, time);
            int amount = Integer.parseInt(policy.getMin_sum_assured());
          ps.setInt(5, amount*time);
          
          int n = ps.executeUpdate();
          if(n>0){
              status = true;
              System.out.println("record inserted in user_policy_policyholder");
          }
            }
         }catch(Exception e){
             System.out.println("DBerror:"+e.getMessage());
         }
         return status;
    }
    
    
public int getPolicyHolderId() {
       int phId = 0;
         try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                PreparedStatement ps = con.prepareStatement("select id from user_policy_policyholder order by id desc limit 1");
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    phId = rs.getInt("id");
                }
            }
         }catch(Exception e){
             
         }
         return phId;
}
    
    public boolean addPolicyHolder(PolicyHolder ph, PolicyHolderAddress phAddress,int userid,Policy policy,int phId,ArrayList<String> relation) {
        boolean status = false;
         try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                con.setAutoCommit(false);

                String sql = "insert into policy_holder (name,fname,email,gender,image,contact,dob,occupation,phId) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, ph.getName());
                ps.setString(2, ph.getFname());
                ps.setString(3, ph.getEmail());
                ps.setString(4, ph.getGender());
                ps.setString(5, ph.getImage());
                ps.setString(6, ph.getContact());
                ps.setString(7, ph.getDob());
                ps.setString(8, ph.getOccupation());
                ps.setInt(9, phId);
                
                int n = ps.executeUpdate();
                
                sql = "select id from policy_holder order by id desc limit 1 ";
                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                int ph_id = -1;
                if (rs.next()) {
                    ph_id = rs.getInt("id");
                    System.out.println("ph-id:"+ph_id);
                    sql = "insert into policy_holder_address (locality,city,state,pincode,policy_holder_id) values(?,?,?,?,?)";
                     ps = con.prepareStatement(sql);
                     ps.setString(1, phAddress.getLocality());
                     ps.setString(2, phAddress.getCity());
                     ps.setString(3, phAddress.getState());
                     ps.setInt(4, phAddress.getPincode());
                     ps.setInt(5, ph_id);
                     
                     n = ps.executeUpdate();
                     
                         ps = con.prepareStatement("insert into user_policyholder_relation (user_id,policyholder_id,relation) values(?,?,?)");
                        ps.setInt(1, userid);
                        ps.setInt(2, phId);
                       for(String rel:relation){
                           System.out.println("relation = "+rel);
                           ps.setString(3, rel);
                           break;
                       }
                      n = ps.executeUpdate();
                      if(n>0){
                        status = true;
                        con.commit();
                    System.out.println("Record Inserted...");}
                }
             
                con.close();
                

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public PolicyHolder  getPolicyHolderByUserId(String emailid){
      PolicyHolder pHolder=null;
       ConnectionPool cp = ConnectionPool.getInstance();
       cp.initialize();
       Connection con = cp.getConnection();
       if(con!=null){
        try{
            String sql = "select * from policy_holder where email=?";
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, emailid);
            ResultSet rs= smt.executeQuery();
            if(rs.next()){
                pHolder =new PolicyHolder();
                    pHolder.setId(rs.getInt("id"));
                    pHolder.setName(rs.getString("name"));
                    pHolder.setFname(rs.getString("fname"));
                    pHolder.setEmail(rs.getString("email"));
                    pHolder.setGender(rs.getString("gender"));
                    pHolder.setImage(rs.getString("image"));
                    pHolder.setContact(rs.getString("contact"));
                    pHolder.setDob(rs.getString("dob"));
                    pHolder.setOccupation(rs.getString("occupation"));
                    pHolder.setPhId(rs.getInt("phId"));
            }
            smt.close();
            cp.releaseConnection(con);
        }   catch(Exception e){
            System.out.println("DBError :"+e.getMessage());
        }
       }
       
    return pHolder;
   }
  
    
    public ArrayList<PolicyHolder> getPolicyHolderByUserId(int userid) {
        ArrayList<PolicyHolder> p_holderList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from policy_holder where phId in(select id from user_policy_policyholder where user_id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, userid);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    PolicyHolder p_holder = new PolicyHolder();
                    p_holder.setId(rs.getInt("id"));
                    p_holder.setName(rs.getString("name"));
                    p_holder.setFname(rs.getString("fname"));
                    p_holder.setEmail(rs.getString("email"));
                    p_holder.setGender(rs.getString("gender"));
                    p_holder.setImage(rs.getString("image"));
                    p_holder.setContact(rs.getString("contact"));
                    p_holder.setDob(rs.getString("dob"));
                    p_holder.setOccupation(rs.getString("occupation"));
                    p_holder.setPhId(rs.getInt("phId"));
                    p_holderList.add(p_holder);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return p_holderList;
    }

   
     public ArrayList<PolicyHolder> getAllPolicyHolder( ) {
        ArrayList<PolicyHolder> p_holderList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from policy_holder";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    PolicyHolder p_holder = new PolicyHolder();
                    p_holder.setId(rs.getInt("id"));
                    p_holder.setName(rs.getString("name"));
                    p_holder.setFname(rs.getString("fname"));
                    p_holder.setEmail(rs.getString("email"));
                    p_holder.setGender(rs.getString("gender"));
                    p_holder.setImage(rs.getString("image"));
                    p_holder.setContact(rs.getString("contact"));
                    p_holder.setDob(rs.getString("dob"));
                    p_holder.setOccupation(rs.getString("occupation"));
                    p_holder.setPhId(rs.getInt("phId"));
                    p_holderList.add(p_holder);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return p_holderList;
    }

    
    public ArrayList<PolicyHolder> getPolicyHolderByPhId(int pHolderId) {
        ArrayList<PolicyHolder> p_holderList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from policy_holder where phId = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, pHolderId);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    PolicyHolder p_holder = new PolicyHolder();
                    p_holder.setId(rs.getInt("id"));
                    p_holder.setName(rs.getString("name"));
                    p_holder.setFname(rs.getString("fname"));
                    p_holder.setEmail(rs.getString("email"));
                    p_holder.setGender(rs.getString("gender"));
                    p_holder.setImage(rs.getString("image"));
                    p_holder.setContact(rs.getString("contact"));
                    p_holder.setDob(rs.getString("dob"));
                    p_holder.setOccupation(rs.getString("occupation"));
                    p_holder.setPhId(rs.getInt("phId"));
                    p_holderList.add(p_holder);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return p_holderList;
    }

    
    public ArrayList<PolicyHolder> getPolicyHolderIdByUserId(int userid) {
        ArrayList<PolicyHolder> p_holderList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select id from user_policy_policyholder where user_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, userid);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    PolicyHolder p_holder = new PolicyHolder();
                     p_holder.setPhId(rs.getInt("id"));
                    p_holderList.add(p_holder);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return p_holderList;
    }

    public PolicyHolder getPolicyHolderByClaimId(int claim_id) {
         PolicyHolder p_holder = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from policy_holder where phId in(select policyHolderId from claim where id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, claim_id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                     p_holder = new PolicyHolder();
                    p_holder.setId(rs.getInt("id"));
                    p_holder.setName(rs.getString("name"));
                    p_holder.setFname(rs.getString("fname"));
                    p_holder.setEmail(rs.getString("email"));
                    p_holder.setGender(rs.getString("gender"));
                    p_holder.setImage(rs.getString("image"));
                    p_holder.setContact(rs.getString("contact"));
                    p_holder.setDob(rs.getString("dob"));
                     p_holder.setOccupation(rs.getString("occupation"));
                    p_holder.setPhId(rs.getInt("phId"));
                     
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return p_holder;
    }

    public ArrayList<PolicyHolder> getPolicyHolderByPolicyId(int policy_id) {
        ArrayList<PolicyHolder> p_holderList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from policy_holder where phId in(select id from user_policy_policyholder where policy_id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, policy_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    PolicyHolder p_holder = new PolicyHolder();
                    p_holder.setId(rs.getInt("id"));
                    p_holder.setName(rs.getString("name"));
                    p_holder.setFname(rs.getString("fname"));
                    p_holder.setEmail(rs.getString("email"));
                    p_holder.setGender(rs.getString("gender"));
                    p_holder.setImage(rs.getString("image"));
                    p_holder.setContact(rs.getString("contact"));
                    p_holder.setDob(rs.getString("dob"));
                     p_holder.setOccupation(rs.getString("occupation"));
                    p_holder.setPhId(rs.getInt("phId"));
                    p_holderList.add(p_holder);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return p_holderList;
    }

    public int getPolicyHolderCountByUserId(int userid) {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from policy_holder where phId in (select id from user_policy_policyholder where user_id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, userid);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return total;

    }

    public int getPolicyHolderCountByClaimId(int claim_id) {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from policy_holder where phId in (select policy_holder_id from claim where id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, claim_id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return total;

    }

    public int getPolicyHolderCountByPolicyId(int policy_id) {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from policy_holder where phId in (select id from user_policy_policyholder where policy_id=?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, policy_id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return total;

    }

    
 
 	// Function to generate random alpha-numeric password of specific length
	public String generateRandomPassword(int len)
	{
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

 
         public String getDateByPolicyHolderId(int policyHolderId) {
        String date = "";
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select start_date from user_policy_policyholder where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, policyHolderId);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    date = rs.getString("start_date");
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return date;

    }

          
      public ArrayList<String> getRelationByPolicyHolderId(int policyHolderId) {
          ArrayList<String>relationList = new ArrayList();
        String relation = "";
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select relation from user_policyholder_relation where policyholder_id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, policyHolderId);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    relation = rs.getString("relation");
                    relationList.add(relation);
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return relationList;

    }
    
      
}
