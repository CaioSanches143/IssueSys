package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@NoArgsConstructor
public class Tags {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long tagId;
    private String tagName;
    private String tagDescription;

    public Tags(String tagName, String tagDescription){
        Validate.notNull(tagName,"Tag NAME is required.");
        Validate.notNull(tagDescription,"Tag DESCRIPTION is required.");
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }

}
