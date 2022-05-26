package br.com.vbuttini.vbuttinirepository.service;

import br.com.vbuttini.vbuttinirepository.model.CompanyModel;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import br.com.vbuttini.vbuttinirepository.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Vinícius Buttini
 */
@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyModel insertByUser(UserModel userModel) {
        CompanyModel companyModel = userModel.getCompany();
        companyModel.setUser(null);
        companyModel.setUser(userModel);
        userModel.getCompany().setCreatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        userModel.getCompany().setUpdatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return companyRepository.save(companyModel);
    }

}