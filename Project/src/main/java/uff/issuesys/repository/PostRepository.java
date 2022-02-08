package uff.issuesys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uff.issuesys.model.Posts;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
