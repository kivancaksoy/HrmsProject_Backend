package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.appUsers.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
