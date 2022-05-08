package br.com.vbuttini.vbuttinirepository.repository;

import br.com.vbuttini.vbuttinirepository.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
}

