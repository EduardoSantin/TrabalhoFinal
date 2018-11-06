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
@ToString(of= {"codigo", "descricao", "tipo", "dataCadastro"})
public class Manutencao {
	
	private Integer codigo;
	private String descricao;
	private String tipo;
	private Veiculo veiculo;
	private String placa;
	private String dataCadastro;
}
