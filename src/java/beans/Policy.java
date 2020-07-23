 
package beans;
 
public class Policy {
    private int id;
    private String name,type, min_sum_assured, min_time_duration,description;

    public Policy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMin_sum_assured() {
        return min_sum_assured;
    }

    public void setMin_sum_assured(String min_sum_assured) {
        this.min_sum_assured = min_sum_assured;
    }

    public String getMin_time_duration() {
        return min_time_duration;
    }

    public void setMin_time_duration(String min_time_duration) {
        this.min_time_duration = min_time_duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
