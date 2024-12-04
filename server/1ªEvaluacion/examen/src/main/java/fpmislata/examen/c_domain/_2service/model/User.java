package fpmislata.examen.c_domain._2service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer id;
    String username;
    String password;
    String email;
    String first_name;
    String surname;
    String address;
    Boolean isAdmin;
}
