package br.com.vbuttini.vbuttinirepository.service.exception;

/**
 * @author Vinícius Buttini
 */
public class DataBaseException extends RuntimeException {
    public DataBaseException(String msg) {
        super(msg);
    }
}
