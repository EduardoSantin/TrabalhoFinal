package principal.model;

import javax.swing.tree.VariableHeightLayoutCache;

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
public class Funcionario {
	
	private Integer codigo;
	private String nome;
	private Integer cpf;
	private Integer rg;
	private String ctps;
	private String dtNasc;
	private String endereco;
	private String bairro;
	private Integer cep;
	private String cargo;
	private Integer salario;
	private String dtaAdmissao;
	//Tem que arrumae aq a DATA Admissao


}