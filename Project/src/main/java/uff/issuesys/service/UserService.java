package uff.issuesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uff.issuesys.model.Tags;
import uff.issuesys.model.Users;
import uff.issuesys.repository.IssueRepository;
import uff.issuesys.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager em;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public Users editUser(Users users) {
        Users oldUser = getUserById(users.getUserId().toString());
        if (oldUser != null){
            oldUser = users;
            return userRepository.save(oldUser);
        }
        return null;
    }

    public Users getUserById(String userIdToGet) {
        Users user = new Users();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> root = cq.from(Users.class);
        cq.select(root)
                .where(cb.equal(root.get("userId"), userIdToGet));
        TypedQuery<Users> q = em.createQuery(cq);
        return q.getSingleResult();
    }


    public Iterable<Users> getAllUser() {
        return userRepository.findAll();
    }

    public boolean deleteUserById(String userIdToDelete) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> root = cq.from(Users.class);
        cq.select(root)
                .where(cb.equal(root.get("userId"), userIdToDelete));
        TypedQuery<Users> q = em.createQuery(cq);

        Long id = q.getSingleResult().getUserId();

        userRepository.delete(q.getSingleResult());
        return !userRepository.existsById(id);
    }
}
