package br.com.tst.web.rest.errors;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.tst.web.rest.vm.ErrorVM;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorVM handleValidationErros(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<String> messages = bindingResult.getAllErrors()
			.stream()
			.map(objectError -> objectError.getDefaultMessage())
			.collect(Collectors.toList());
		
		return new ErrorVM(messages);
	}
    
	@ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorVM> handleResponseStatusException(ResponseStatusException ex) {
    	String messageError = ex.getMessage();
    	HttpStatus statusCode = ex.getStatus();
    	ErrorVM errorVM = new ErrorVM(messageError);
    	
    	return new ResponseEntity<ErrorVM>(errorVM, statusCode);
    }
    
}
