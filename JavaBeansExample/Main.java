import CustomerBeans;

public class Main {
    public static void main(String[] args) {
        CustomerBeans cb = new CustomerBeans();
        cb.setFull_name("John Doe");
        cb.setId(1);
        cb.setEmail("Male");
        cb.setContact("1234567890");
        cb.setGender("");
        System.out.println("Full Name: " + cb.getFull_name());
        System.out.println("ID: " + cb.getId());
        System.out.println("Email: " + cb.getEmail());
        System.out.println("Contact: " + cb.getContact());
        System.out.println("Gender" + cb.getGender());
        System.out.println("Bean object" + cb);
    }
}
