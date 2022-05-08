package br.com.vbuttini.vbuttinirepository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Vinícius Buttini
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private String cnpj;

    private String agent;

    private String phone;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
