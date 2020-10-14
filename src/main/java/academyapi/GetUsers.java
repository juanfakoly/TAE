package academyapi;

import academyapi.pojos.User;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetUsers {

    private GetUsers() {
    }

    public static Set<User> getUsers()  {
        Set<User> listUsers = new HashSet<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/test/resources/user.csv"));
            for (String line : lines) {
                String [] attributes = line.split(";");
                User user = getUser(attributes);
                listUsers.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listUsers;
    }

    private static User getUser(String [] attributes) {
        String name = attributes[0];
        String lastName = attributes[1];
        int accountNumber = Integer.parseInt(attributes[2]);
        Double amount = Double.parseDouble(attributes[3]);
        String transactionType = attributes[4];
        String email = attributes[5];
        Boolean active = Boolean.parseBoolean(attributes[6]);
        String country = attributes[7];
        String telephone = attributes[8];
        return new User(name, lastName, accountNumber, amount, transactionType, email, active, country, telephone);
    }
}
