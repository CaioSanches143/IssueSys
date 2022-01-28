package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tag {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long tagId;
    private String tagName;
    private String tagDescription;


    public Tag (String tagName, String tagDescription){
        Validate.notNull(tagName,"Tag NAME is required.");
        Validate.notNull(tagDescription,"Tag DESCRIPTION is required.");
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }

}
