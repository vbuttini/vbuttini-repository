package br.com.vbuttini.vbuttinirepository.controller.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Vinícius Buttini
 */
@Getter
@AllArgsConstructor
public class StandardError implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-3")
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}