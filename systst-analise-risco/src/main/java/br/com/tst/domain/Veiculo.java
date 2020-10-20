package br.com.tst.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -2920553748915788126L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 25)
	@NotEmpty(message = "{campo.marca.required}")
	private String marca;

	@Column(nullable = false, length = 50)
	@NotEmpty(message = "{campo.modelo.required}")
	private String modelo;
	
	@Column(nullable = false, length = 4)
	@NotNull(message = "{campo.ano.required}")
	private Integer ano;
	
	@NotNull(message = "{campo.valor.required}")	
	@DecimalMin(value = "300.00", message = "{campo.valor.lowvalue}")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,###,##0.00")			
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00" )
	private BigDecimal valor;
	
	@Column(nullable = false, length = 35)
	private String classificacao;
}
