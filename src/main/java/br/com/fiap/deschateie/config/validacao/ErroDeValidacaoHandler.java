package br.com.fiap.deschateie.config.validacao;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroDeFormularioDTO> dto = new ArrayList<>();
		List<FieldError> fieldsErros = exception.getBindingResult().getFieldErrors();
		
		fieldsErros.stream().forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDTO erro = new ErroDeFormularioDTO(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidFormatException.class)
	public String handleDateTimeParseException(InvalidFormatException exception) {
		return "Erro formato de dado invalido!";
	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		exception.printStackTrace();
		ErrorDetails erros = new ErrorDetails(LocalDateTime.now());
		
		if(exception.getCause() instanceof InvalidFormatException) {
			erros.setMessage(ErrorEnum.FORMATO_INVALIDO.toString());

			if(exception.getCause().getCause() instanceof DateTimeException) {
				erros.setDetails("Erro ao converter a Data");
			}
			
		}
		
		if(exception.getCause() instanceof JsonParseException) {
			erros.setMessage(ErrorEnum.JSON_PARSER_ERROR.toString());
			erros.setDetails("Erro ao tentar converter o JSON da requisicao");
		}
		
		if(erros.getDetails().isEmpty() && erros.getDetails() == null) {
			erros.setDetails(ErrorEnum.ERRO_GENERICO.toString());
		}
		
		return ResponseEntity.badRequest().body(erros);
	}
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception){
		ErrorDetails erro = new ErrorDetails(LocalDateTime.now(), ErrorEnum.REQUISICAO_NAO_SUPORTADA.toString(), "Erro de Metodo nao suportado");
		return ResponseEntity.badRequest().body(erro);
	}
}
