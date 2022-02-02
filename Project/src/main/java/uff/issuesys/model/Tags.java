package uff.issuesys.model;

import lombok.*;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;

@Entity
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@NoArgsConstructor
public class Tags {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long tagId;
    @Column(unique=true)
    private String tagName;
    private String tagDescription;

    public Tags(String tagName, String tagDescription){
        Validate.notNull(tagName,"Tag NAME is required.");
        Validate.notNull(tagDescription,"Tag DESCRIPTION is required.");
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }

}
