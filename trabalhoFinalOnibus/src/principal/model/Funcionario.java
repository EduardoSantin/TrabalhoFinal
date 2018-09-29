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
	private Integer clps;
	private String dtNasc;
	private String endereco;
	private String bairro;
	private Integer cep;
	private String cargo;
	private float salario;
	private String dtaAdmissao;
	private Float cargaHoraria;
	private String banco;
	private Integer agencia;
	private Integer conta;

}