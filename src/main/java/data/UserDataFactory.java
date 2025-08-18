package data;

import net.bytebuddy.utility.RandomString;

import java.util.concurrent.ThreadLocalRandom;

public class UserDataFactory {

    public static User createRandomUser() {
        return new User()
                .setName(RandomString.make(5))
                .setLastName(RandomString.make(8))
                .setEmail(RandomString.make(8).toLowerCase() + "@test.com")
                .setPassword(RandomString.make(10))
                .setCompany(RandomString.make(7))
                .setAddress1("123 " + RandomString.make(10) + " Street")
                .setAddress2("Apt " + ThreadLocalRandom.current().nextInt(1, 500))
                .setState(RandomString.make(6))
                .setCity(RandomString.make(8))
                .setZipcode(String.valueOf(ThreadLocalRandom.current().nextInt(10000, 100000)))
                .setMobileNumber(String.valueOf(ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L)));
    }

    public static User getPredefinedUser() {
        return new User()
                .setName("testdsfd2")
                .setEmail("test@tes342424wefft.com")
                .setPassword("cxLszNRJ4avN@Qy");
    }

    public static User getUserWithInvalidPassword() {
        return getPredefinedUser()
                .setPassword(RandomString.make(15));
    }
}
