package br.com.vbuttini.vbuttinirepository.repository;

import br.com.vbuttini.vbuttinirepository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Vinícius Buttini
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

    /**
     * This method checks for the existence of a user by his id.
     */
    boolean existsById(Long id);

    /**
     * This method checks for the existence of a user by his email.
     */
    Boolean existsByEmail(String email);

}