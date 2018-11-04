package principal.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString(of = {"codigo", "nome", "cpf", "rg", "dtNasc", "endereco", "cep", "bairro",
		"cargo", "salario", "cargaHoraria", "dtaAdmisao"})
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
	private Double cargaHoraria;
	private String dtaAdmisao;
	//Tem que arrumae aq a DATA Admissao
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Double getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getDtaAdmissao() {
		return dtaAdmisao;
	}
	public void setDtaAdmissao(String dtaAdmisao) {
		this.dtaAdmisao = dtaAdmisao;
	}

	

}