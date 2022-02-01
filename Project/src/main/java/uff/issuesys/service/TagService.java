package uff.issuesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uff.issuesys.model.Tags;
import uff.issuesys.repository.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tags saveTag(Tags tags) {
        return tagRepository.save(tags);
    }

    public Iterable<Tags> getAllTag(){
        return tagRepository.findAll();
    }
}
