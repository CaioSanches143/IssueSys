package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private String userName;


    public Users(String userLogin, String userEmail, String userPassword, String userName){

        Validate.notNull(userEmail, "Post EMAIL is required.");
        Validate.notNull(userName, "Post NAME is required.");

        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;



    }

}
