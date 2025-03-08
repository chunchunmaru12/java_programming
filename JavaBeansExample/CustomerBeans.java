import java.io.Serializable;

public class CustomerBeans implements Serializable {
    private static final long serialVersionUID = 1L;
    private String full_name;
    private int id;
    private String email;
    private String contact;
    private String gender;

    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    public CustomerBeans() {}
    @Override
    public String toString() {
        return "CustomerBeans [full_name=" + full_name + ", id=" + id + ", email=" + email + ", contact=" + contact
                + ",";
    }

}
