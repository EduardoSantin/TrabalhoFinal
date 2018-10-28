package principal.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString
public class Movimentos {
	
	private Integer codigo;
	private Integer numeroNota;
	private String dtaEmissao;
	private Double kmInicial;
	private Double kmFinal;
	private Integer qtdPassageiros;
	private String origen;
	private String destino;
	private String motorista;
	private Veiculo veiculo;
	



}
