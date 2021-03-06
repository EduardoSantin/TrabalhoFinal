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
@EqualsAndHashCode(of = "codigo")
@ToString(of = { "codigo", "renavan", "marca", "modelo", "motor", "chassi", "categoria", "combustivel",
		"dataCadastro" })

public class Veiculo{
	
	private Integer codigo;
	private Integer renavan;
	private String marca;
	private String modelo;
	private String placa;
	private String motor;
	private Integer chassi;
	private String categoria;
	private String combustivel;
	private String dataCadastro;
	
	@Override
	public String toString() {
		return  placa;
	}	
}
