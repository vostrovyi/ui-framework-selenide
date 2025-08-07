package data;

import lombok.Data;
import net.bytebuddy.utility.RandomString;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class User {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String company;
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;

    /**
     * Constructor to generate RANDOM user
     */
    public User() {
        this.name = RandomString.make(5);
        this.lastName = RandomString.make(8);
        this.email = RandomString.make(8).toLowerCase() + "@test.com";
        this.password = RandomString.make(10);
        this.company = RandomString.make(7);
        this.address1 = "123 " + RandomString.make(10) + " Street";
        this.address2 = "Apt " + ThreadLocalRandom.current().nextInt(1, 500);
        this.state = RandomString.make(6);
        this.city = RandomString.make(8);
        this.zipcode = String.valueOf(ThreadLocalRandom.current().nextInt(10000, 100000));
        this.mobileNumber = String.valueOf(ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L));
    }

    /**
     * A static method for getting a Predefined User
     */
    public static User getPredefinedUser() {
        User user = new User();
        user.setName("testdsfd2");
        user.setEmail("test@tes342424wefft.com");
        user.setPassword("cxLszNRJ4avN@Qy");
        return user;
    }
}
