package academyapi.servicepagone;

import academyapi.utils.GetUsers;
import academyapi.baseservice.BaseService;
import academyapi.pojos.User;
import io.restassured.response.Response;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostUsers extends BaseService {

    private Map<String, Object> userMap = new HashMap<>();
    private static final String API_URL = "https://5f836d476b97440016f4e6d9.mockapi.io/users";
    private Response response;

    public void postUsers() {
        Set<User> userList = GetUsers.getUsers();
        for (User user : userList) {
            boolean emailAlreadyExist = emailAlreadyExist(user.getEmail());
            if (emailAlreadyExist) {
                Logger.getLogger("Email").log(Level.WARNING, "Email Already Exist");
            } else {
                response = requestPostMethod(API_URL, getUserMap(user));
            }
        }
    }

    private Boolean emailAlreadyExist(String email) {
        response = requestGetMethod(API_URL);
        boolean notEmpty = response.getBody().print().contains("id");
        if (notEmpty) {
            List<String> mails = response.jsonPath().getList("email");
            for (String mail : mails) {
                if (email.equals(mail)) return true;
            }
        }
        return false;
    }

    private Map<String, Object> getUserMap(User user) {
        userMap.put("name", user.getName());
        userMap.put("lastName", user.getLastName());
        userMap.put("accountNumber", user.getAccountNumber());
        userMap.put("amount", user.getAmount());
        userMap.put("transactionType", user.getTransactionType());
        userMap.put("email", user.getEmail());
        userMap.put("active", user.getActive());
        userMap.put("country" , user.getCountry());
        userMap.put("telephone", user.getTelephone());
        return userMap;
    }
}
