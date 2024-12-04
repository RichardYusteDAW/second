package fpmislata.examen.c_domain._2service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String surname;
    private String address;
    private Boolean isAdmin;

    public String getName() {
        return this.first_name + " " + this.surname;
    }
}
