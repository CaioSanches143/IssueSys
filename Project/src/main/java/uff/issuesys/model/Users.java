package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;


import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private String userName;

    @OneToMany
    @JoinTable(
            name = "Users_Posts",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "postId"))
    private List<Posts> userPostList;

    @OneToMany
    @JoinTable(
            name = "Issues_Tags",
            joinColumns = @JoinColumn(name = "issueId"),
            inverseJoinColumns = @JoinColumn(name = "issueTagId"))
    private List<Tags> issueTagList;



    public Users(String userLogin, String userEmail, String userPassword, String userName){

        Validate.notNull(userEmail, "Post EMAIL is required.");
        Validate.notNull(userName, "Post NAME is required.");

        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;



    }

}
