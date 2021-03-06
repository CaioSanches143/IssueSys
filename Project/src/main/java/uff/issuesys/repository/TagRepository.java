package uff.issuesys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uff.issuesys.model.Tags;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long> {
}
