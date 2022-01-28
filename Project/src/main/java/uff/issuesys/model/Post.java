package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String postContent;
    private Long postUserID;
    private List<PostTagList> issueTagList;

    public Post (String postContent, Long postUserID){
        Validate.notNull(postContent, "Post CONTENT is required.");
        Validate.notNull(postUserID,"At least one USER for Post is required.");
        this.postContent = postContent;
        this.postUserID = postUserID;
        issueTagList = new ArrayList<>();
    }
}
