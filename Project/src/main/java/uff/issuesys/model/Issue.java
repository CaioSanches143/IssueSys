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
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long issueId;
    private String issueName;
    private String issueDescription;
    private List<IssueTagList> tagTagList;
    private List<IssuePostList> tagPostList;
    private List<IssueUserList> tagUserList;

    public Issue (String issueName, String issueDescription, IssueTagList issueTag, IssueUserList issueUser){
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
