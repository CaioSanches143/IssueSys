package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String postContent;
    private Long postUserID;
    @ManyToMany
    @JoinTable(
            name = "PostTagList",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "postTagId"))
    private List<PostTagList> issueTagList;

    public Posts(String postContent, Long postUserID){
        Validate.notNull(postContent, "Post CONTENT is required.");
        Validate.notNull(postUserID,"At least one USER for Post is required.");
        this.postContent = postContent;
        this.postUserID = postUserID;
        issueTagList = new ArrayList<>();
    }
}
