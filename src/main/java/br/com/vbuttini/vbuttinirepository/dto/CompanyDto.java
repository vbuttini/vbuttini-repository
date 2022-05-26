package br.com.vbuttini.vbuttinirepository.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-3")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-3")
    private LocalDateTime updatedAt;

}