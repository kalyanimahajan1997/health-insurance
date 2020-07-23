package daos;

import beans.Hospital;
import beans.Hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbc.ConnectionPool;

public class HospitalDao {

    public boolean add(Hospital hospital) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "Insert into hospital(name,address) values(?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, hospital.getName());
                smt.setString(2, hospital.getAddress());

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

    public ArrayList<Hospital> getAllHospital() {
        ArrayList<Hospital> AllHospital = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from hospital";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Hospital hospital = new Hospital();
                    hospital.setId(rs.getInt("id"));
                    hospital.setName(rs.getString("name"));
                    hospital.setAddress(rs.getString("address"));

                    AllHospital.add(hospital);
                }
                cp.releaseConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        return AllHospital;
    }

    public boolean remove(int hospital_id) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "Delete from hospital where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, hospital_id);

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

    public int getHospitalId() {
        int hId = 0;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select id from hospital order by id desc limit 1";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    hId = rs.getInt("id");
                }
                con.close();
            } catch (Exception e) {
                System.out.println(" DbError:" + e.getMessage());
            }
        }

        return hId;
    }

    public Hospital getHospitalById(int hospital_id) {
        Hospital hospital = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from hospital where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, hospital_id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    hospital = new Hospital();
                    hospital.setId(rs.getInt("id"));
                    hospital.setName(rs.getString("name"));
                    hospital.setAddress(rs.getString("address"));
                }
                smt.close();
                cp.releaseConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return hospital;
    }

    public boolean addBill(int amount, int hId, String aDate, String dDate, int phId) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "insert into bill(amount,hospital_id,admit_date,discharge_date,policy_holder_id)values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, amount);
                ps.setInt(2, hId);
                ps.setString(3, aDate);
                ps.setString(4, dDate);
                ps.setInt(5, phId);
                int n = ps.executeUpdate();
                if(n>0){
                    status = true;
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("DbError:" + e.getMessage());
            }

        }
        return status;
    }

    public boolean addPHolderHospitalRecord(int phId,int hId,String dName,String docName) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "insert into hospital_disease_policyholder(policy_holder_id,hospital_id,disease_name,doctor_name)values(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, phId);
                ps.setInt(2, hId);
                ps.setString(3, dName);
                ps.setString(4, docName);
                 int n = ps.executeUpdate();
                if(n>0){
                    status = true;
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("DbError:" + e.getMessage());
            }

        }

        return status;
    }
}
