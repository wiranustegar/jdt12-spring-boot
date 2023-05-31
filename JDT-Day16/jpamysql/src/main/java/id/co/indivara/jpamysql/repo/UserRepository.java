package id.co.indivara.jpamysql.repo;

import id.co.indivara.jpamysql.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

//JIKA ADA METHOD TAMBAHAN YG MENYEBABKAN CHANGES, WAJIB DITAMBAHKAN ANNOTATION @Transactional
@Transactional
public interface UserRepository extends CrudRepository <User, Integer> {

    List<User> findByName(String name);
    void deleteByEmail(String email);

}
