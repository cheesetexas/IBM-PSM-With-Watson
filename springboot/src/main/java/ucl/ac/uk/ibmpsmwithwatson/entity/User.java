package ucl.ac.uk.ibmpsmwithwatson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String sub;
    private String iss;
    private String aud;
    private String family_name;
    private String given_name;
    private String email;
    private String phone_number;
    private String birthdate;
    private String address;
    private String nhs_number;
    private String role;
    private String password;
    private String app_token;

    public Map<String, String> toMap(User user) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sub", user.getSub());
        map.put("iss", user.getIss());
        map.put("aud", user.getAud());
        map.put("family_name", user.getFamily_name());
        map.put("given_name", user.getGiven_name());
        map.put("email", user.getEmail());
        map.put("phone_number", user.getPhone_number());
        map.put("birthdate", user.getBirthdate());
        map.put("address", user.getAddress());
        map.put("nhs_number", user.getNhs_number());
        map.put("role", user.getRole());
        return map;
    }
}
