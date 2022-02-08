package uff.issuesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uff.issuesys.model.Issues;
import uff.issuesys.model.Tags;
import uff.issuesys.repository.IssueRepository;
import uff.issuesys.repository.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;
    @PersistenceContext
    private EntityManager em;

    public Issues saveIssue(Issues issues) {
        return issueRepository.save(issues);
    }

    public Issues getIssueById(String issueIdToGet){
        Issues issue = new Issues();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Issues> cq = cb.createQuery(Issues.class);
        Root<Issues> root = cq.from(Issues.class);
        cq.select(root)
                .where(cb.equal(root.get("issueId"), issueIdToGet));
        TypedQuery<Issues> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    public Issues editIssue(Issues issue) {
        Issues oldIssue = getIssueById(issue.getIssueId().toString());
        if (oldIssue != null){
            oldIssue = issue;
            return issueRepository.save(oldIssue);
        }
        return null;
    }

    public Iterable<Issues> getAllTag() {
        return issueRepository.findAll();
    }

    public Issues getissueById(String issueIdTofind) {
        Issues issues = new Issues();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Issues> cq = cb.createQuery(Issues.class);
        Root<Issues> root = cq.from(Issues.class);
        cq.select(root)
                .where(cb.equal(root.get("issueId"), issueIdTofind));
        TypedQuery<Issues> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    @Transactional
    public boolean deleteIssueById(String issueIdToDelete) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Issues> cq = cb.createQuery(Issues.class);
        Root<Issues> root = cq.from(Issues.class);
        cq.select(root)
                .where(cb.equal(root.get("issueId"), issueIdToDelete));
        TypedQuery<Issues> q = em.createQuery(cq);

        Long id = q.getSingleResult().getIssueId();

        issueRepository.delete(q.getSingleResult());
        return !issueRepository.existsById(id);
    }
}

