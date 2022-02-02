package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users postUserID;

    @ManyToOne
    @JoinColumn(name = "issueId", nullable = false)
    private Issues postIssueId;

    @OneToMany
    @JoinTable(
            name = "Posts_Tags",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "postTagId"))
    private List<Tags> issueTagList;

    public Posts(String postContent, Long postUserID, Long postIssueId){
        Validate.notNull(postContent, "Post CONTENT is required.");
        Validate.notNull(postUserID,"At least one USER for Post is required.");
        this.postContent = postContent;


        Users user = new Users();
        this.issueTagList = new ArrayList<>();

        Tags tag = new Tags();
        this.issueTagList.add(tag);


    }
}
