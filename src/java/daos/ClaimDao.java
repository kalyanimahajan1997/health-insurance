package daos;

import beans.Claim;
import beans.Claim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbc.ConnectionPool;

public class ClaimDao {

    public boolean add(String claimDate, int amount, int phId,String docs) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                //con.setAutoCommit(false);
                String sql = "Insert into claim(claim_date,amount,status,policyHolderId,docs) values(?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, claimDate);
                smt.setInt(2, amount);
                smt.setString(3, "pending");
                smt.setInt(4, phId);
                smt.setString(5, docs);
                int n = smt.executeUpdate();

                /* sql = "select id from claim order by id desc limit 1 ";
                smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                int cid = -1;
                if (rs.next()) {
                    cid = rs.getInt("id");

                    sql = "Insert into user_claim(claim_id,policy_holder_id) values(?,?)";
                    smt = con.prepareStatement(sql);
                    smt.setInt(1, cid);
                    smt.setInt(2, phId);
                    n = smt.executeUpdate();
                 */
                if (n > 0) {
                    status = true;
                    System.out.println("Record Inserted in claim table...");
                }

                cp.releaseConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return status;
    }

    public ArrayList<Claim> getAllClaims() {
        ArrayList<Claim> AllClaims = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from claim";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Claim claim = new Claim();
                    claim.setId(rs.getInt("id"));
                    claim.setClaim_date(rs.getString("claim_date"));
                    claim.setStatus(rs.getString("status"));
                    claim.setAmount(rs.getInt("amount"));

                    AllClaims.add(claim);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return AllClaims;
    }

    
    public ArrayList<Claim> getClaimsByStatus(String status) {
        ArrayList<Claim> AllClaims = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from claim where status=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, status);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Claim claim = new Claim();
                    claim.setId(rs.getInt("id"));
                    claim.setClaim_date(rs.getString("claim_date"));
                    claim.setStatus(rs.getString("status"));
                    claim.setAmount(rs.getInt("amount"));

                    AllClaims.add(claim);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return AllClaims;
    }
    
    public ArrayList<Claim> getAllClaimByUserId(int userid) {
        ArrayList<Claim> AllClaim = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from claim where policyHolderId in(select id from user_policy_policyholder where user_id=?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, userid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Claim claim = new Claim();
                    claim.setId(rs.getInt("id"));
                    claim.setClaim_date(rs.getString("claim_date"));
                    claim.setStatus(rs.getString("status"));
                    claim.setAmount(rs.getInt("amount"));
                    claim.setpHolderId(rs.getInt("policyHolderId"));
                    AllClaim.add(claim);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return AllClaim;
    }

    
    public Claim getClaimById(int cId) {
       Claim claim = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from claim where id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, cId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    claim = new Claim();
                    claim.setId(rs.getInt("id"));
                    claim.setClaim_date(rs.getString("claim_date"));
                    claim.setStatus(rs.getString("status"));
                    claim.setAmount(rs.getInt("amount"));
                    claim.setpHolderId(rs.getInt("policyHolderId"));
                    claim.setDocs(rs.getString("docs"));
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return claim;
    }

    public String getClaimReasonById(int cId) {
       String reason = "";
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select reason from claim_details where claim_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, cId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                     reason = rs.getString("reason");
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return reason;
    }
    
    public boolean changeClaimStatus(int cId,String sts) {
       boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "update claim set status = ? where id = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, sts);
                ps.setInt(2, cId);
                int n = ps.executeUpdate();
                if(n>0){
                    status = true;
                    con.close();
                }
            }
             
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
        }
        return status;
    }
    
    
}
