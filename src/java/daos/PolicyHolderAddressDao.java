 package daos;
 
import beans.PolicyHolderAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.ConnectionPool;

public class PolicyHolderAddressDao {
 public PolicyHolderAddress getAddressByPolicyHolderId(int phId) {
      PolicyHolderAddress phAddress = null;    
     try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
             
            if (con != null) {
                String sql = "select * from policy_holder_address where policy_holder_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, phId);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    phAddress = new PolicyHolderAddress();
                    phAddress.setId(rs.getInt("id"));
                    phAddress.setLocality(rs.getString("locality"));
                    phAddress.setCity(rs.getString("city"));
                    phAddress.setState(rs.getString("state"));
                    phAddress.setPincode(rs.getInt("pincode"));
                }
                cp.releaseConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return phAddress;
    }
   
}
