package org.example.repositorys;

import org.example.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String username);

    boolean existsByEmail(String email);
}
