package ucl.ac.uk.ibmpsmwithwatson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.HashMap;
import java.util.Map;

@Node("User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String given_name;
    private String family_name;
    private String email;
    private String phone_number;
    private String password;
    private String role;
    private String gender;
    private String birthdate;
    private String address;
    private String nhs_number;
    private String doctor;
    private String app_token;

    public Map<String, String> toMap(User user) {
        HashMap<String, String> map = new HashMap<>();
        map.put("given_name", user.getGiven_name());
        map.put("family_name", user.getFamily_name());
        map.put("email", user.getEmail());
        map.put("phone_number", user.getPhone_number());
        map.put("role", user.getRole());
        map.put("gender", user.getGender());
        map.put("birthdate", user.getBirthdate());
        map.put("address", user.getAddress());
        map.put("nhs_number", user.getNhs_number());
        map.put("doctor", user.getDoctor());
        return map;
    }
}
