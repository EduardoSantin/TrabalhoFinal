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
public class Funcionario {
	
	private Integer codigo;
	private String nome;
	private Integer cpf;
	private Integer rg;
	private String dtNasc;
	private String endereco;
	private Integer cep;
	private String bairro;
	private String cargo;
	private Double salario;
	private Integer cargarHoraria;
	private String dtaAdmissao;
	//Tem que arrumae aq a DATA Admissao


}