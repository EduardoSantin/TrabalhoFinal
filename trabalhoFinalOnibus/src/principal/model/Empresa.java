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
@ToString(of={"codigo","razaoSocial","nomeFantasia", "cnpj", "endereco", "numero", "bairro", "cep","uf"})
public class Empresa{

	private Integer codigo;
	private String razaoSocial;
	private String nomeFantasia;
	private Integer cnpj;
	private String endereco;
	private Integer numero;
	private String bairro;
	private Integer cep;
	private String uf;

}
