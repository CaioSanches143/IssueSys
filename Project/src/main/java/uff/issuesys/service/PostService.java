package uff.issuesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uff.issuesys.model.Posts;
import uff.issuesys.model.Tags;
import uff.issuesys.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @PersistenceContext
    private EntityManager em;

    public Posts saveTag(Posts post) {
        return postRepository.save(post);
    }

    public Posts editPost(Posts posts) {
        Posts oldPost = getPostById(posts.getPostId().toString());
        if (oldPost != null){
            oldPost = posts;
            return postRepository.save(oldPost);
        }
        return null;
    }

    public Posts getPostById(String postIdToGet){
        Posts posts = new Posts();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Posts> cq = cb.createQuery(Posts.class);
        Root<Posts> root = cq.from(Posts.class);
        cq.select(root)
                .where(cb.equal(root.get("postId"), postIdToGet));
        TypedQuery<Posts> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    public Iterable<Posts> getAllPost() {
        return postRepository.findAll();
    }

    public boolean deleteIssueById(String postIdToDelete) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Posts> cq = cb.createQuery(Posts.class);
        Root<Posts> root = cq.from(Posts.class);
        cq.select(root)
                .where(cb.equal(root.get("postId"), postIdToDelete));
        TypedQuery<Posts> q = em.createQuery(cq);

        Long id = q.getSingleResult().getPostId();

        postRepository.delete(q.getSingleResult());
        return !postRepository.existsById(id);
    }
}
