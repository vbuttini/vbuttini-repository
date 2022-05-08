package br.com.vbuttini.vbuttinirepository.mapper;

import br.com.vbuttini.vbuttinirepository.dto.CompanyDto;
import br.com.vbuttini.vbuttinirepository.model.CompanyModel;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyDto convertToDto(CompanyModel companyModel) {
        return new CompanyDto(
                companyModel.getId(),
                companyModel.getName(),
                companyModel.getCnpj(),
                companyModel.getAgent(),
                companyModel.getPhone(),
                companyModel.getCreatedAt(),
                companyModel.getUpdatedAt()
        );
    }

}
