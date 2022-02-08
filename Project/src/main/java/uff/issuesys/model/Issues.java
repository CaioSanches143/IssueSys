package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long issueId;
    private String issueName;
    private String issueDescription;
    @OneToMany
    @JoinTable(
            name = "Issues_Tags",
            joinColumns = @JoinColumn(name = "issueId"),
            inverseJoinColumns = @JoinColumn(name = "issueTagId"))
    private List<Tags> issueTagList;


    @OneToMany
    @JoinTable(
            name = "Issues_Posts",
            joinColumns = @JoinColumn(name = "issueId"),
            inverseJoinColumns = @JoinColumn(name = "postId"))
    private List<Posts> issuePostList;

    @OneToMany
    @JoinTable(
            name = "Issues_Users",
            joinColumns = @JoinColumn(name = "issueId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<Users> issueUserList;

    public Issues(String issueName, String issueDescription, Long issueUserId, List<Long> issueListTagId){
        Validate.notNull(issueName,"Issue NAME is required.");
        Validate.notNull(issueDescription,"Issue DESCRIPTION is required.");
        Validate.notNull(issueUserId,"At least one USER for Issue  is required.");

        this.issueName = issueName;
        this.issueDescription = issueDescription;

        //buscar tags com os IDs da lista issueListTagId
        Tags tags = new Tags();
        this.issueTagList.add(tags);


        //buscar usuário com ID issueUserId
        Users users = new Users();
        this.issueUserList.add(users);


    }

}
