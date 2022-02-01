package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long issueId;
    private String issueName;
    private String issueDescription;
    @ManyToMany
    @JoinTable(
            name = "IssueTagList",
            joinColumns = @JoinColumn(name = "issueId"),
            inverseJoinColumns = @JoinColumn(name = "issueTagId"))
    private List<IssueTagList> tagTagList;

    @ManyToMany
    @JoinTable(
            name = "IssuePostList",
            joinColumns = @JoinColumn(name = "issueId"),
            inverseJoinColumns = @JoinColumn(name = "issuePostId"))
    private List<IssuePostList> tagPostList;

    @ManyToMany
    @JoinTable(
            name = "IssuePostList",
            joinColumns = @JoinColumn(name = "issueId"),
            inverseJoinColumns = @JoinColumn(name = "issueUserId"))
    private List<IssueUserList> tagUserList;

    public Issues(String issueName, String issueDescription, IssueTagList issueTag, IssueUserList issueUser){
        Validate.notNull(issueName,"Issue NAME is required.");
        Validate.notNull(issueDescription,"Issue DESCRIPTION is required.");
        Validate.notNull(issueUser,"At least one USER for Issue  is required.");

        this.issueName = issueName;
        this.issueDescription = issueDescription;
        this.tagTagList.add(issueTag);
        this.tagUserList.add(issueUser);
        this.tagPostList = new ArrayList<>();

    }

}
