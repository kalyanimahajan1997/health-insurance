 package beans;
 
public class Claim {
 private int id,amount,pHolderId;
 private String status,claim_date,docs;

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    public int getpHolderId() {
        return pHolderId;
    }

    public void setpHolderId(int pHolderId) {
        this.pHolderId = pHolderId;
    }

    public Claim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClaim_date() {
        return claim_date;
    }

    public void setClaim_date(String claim_date) {
        this.claim_date = claim_date;
    }
 
}
