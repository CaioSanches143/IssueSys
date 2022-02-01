package uff.issuesys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IssuePostList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long issuePostId;
}
