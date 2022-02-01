package uff.issuesys.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostTagList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postTagId;
}
