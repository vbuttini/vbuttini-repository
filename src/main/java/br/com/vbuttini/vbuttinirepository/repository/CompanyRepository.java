package br.com.vbuttini.vbuttinirepository.repository;

import br.com.vbuttini.vbuttinirepository.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vinícius Buttini
 */
@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

}