package principal.model;

import java.io.Serializable;
import java.time.LocalDate;

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
public class Manutencao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descricao;
	private String tipo;
	private LocalDate dataCadastro;
	private Veiculo veiculo;
}
