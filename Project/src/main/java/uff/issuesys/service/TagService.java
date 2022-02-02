package uff.issuesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uff.issuesys.model.Tags;
import uff.issuesys.repository.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    @PersistenceContext
    private EntityManager em;

    public Tags saveTag(Tags tags) {
        return tagRepository.save(tags);
    }

    public Iterable<Tags> getAllTag(){
        return tagRepository.findAll();
    }

    public Tags getTagById(String tagIdToGet){
       Tags tags = new Tags();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tags> cq = cb.createQuery(Tags.class);
        Root<Tags> root = cq.from(Tags.class);
        cq.select(root)
                .where(cb.equal(root.get("tagId"), tagIdToGet));
        TypedQuery<Tags> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    @Transactional
    public boolean deleteTagById(String tagIdToDelete) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tags> cq = cb.createQuery(Tags.class);
        Root<Tags> root = cq.from(Tags.class);
        cq.select(root)
                .where(cb.equal(root.get("tagId"), tagIdToDelete));
        TypedQuery<Tags> q = em.createQuery(cq);

        Long id = q.getSingleResult().getTagId();

        tagRepository.delete(q.getSingleResult());
        return !tagRepository.existsById(id);
    }

    public Tags editTag(Tags tags) {
        Tags oldTag = getTagById(tags.getTagId().toString());
        if (oldTag != null){
            oldTag.setTagName(tags.getTagName());
            oldTag.setTagDescription(tags.getTagDescription());
            return tagRepository.save(oldTag);
        }
        return null;
        }
}
