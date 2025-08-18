package data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
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
}
