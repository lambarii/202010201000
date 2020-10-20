package br.com.tst.web.rest.vm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ErrorVM implements Serializable {

	private static final long serialVersionUID = -4376929113940480418L;
	
	private List<String> errors;
    
	public ErrorVM(List<String> erros) {
		this.errors = erros;
	}
	
	public ErrorVM(String message) {
		this.errors = Arrays.asList(message);
	}    
    
}
