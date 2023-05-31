package id.co.indivara.jdt12.jpamysqllombok.repo;

import id.co.indivara.jdt12.jpamysqllombok.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository <User, Integer> {
    List<User> findByName(String name);

    void deleteByEmail(String email);
}
