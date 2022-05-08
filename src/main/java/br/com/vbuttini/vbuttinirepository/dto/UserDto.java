package br.com.vbuttini.vbuttinirepository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Vinícius Buttini
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

        private Long id;

        private String email;

        private CompanyDto company;

}