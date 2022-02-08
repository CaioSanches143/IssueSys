package uff.issuesys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uff.issuesys.model.Issues;
import uff.issuesys.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
