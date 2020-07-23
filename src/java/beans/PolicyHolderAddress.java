 package beans;
 
public class PolicyHolderAddress {
 private int id,policy_holder_id,pincode;
 private String locality,city,state;

   public PolicyHolderAddress() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPolicy_holder_id() {
        return policy_holder_id;
    }

    public void setPolicy_holder_id(int policy_holder_id) {
        this.policy_holder_id = policy_holder_id;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

  
}
