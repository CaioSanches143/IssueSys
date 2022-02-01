package uff.issuesys.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Entity
public class IssueTagList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long issueTagId;

}
