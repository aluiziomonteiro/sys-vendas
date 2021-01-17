package br.com.aluizio.sysvendas.model;

import java.time.LocalDate;

/**
 * Cliente.java
 * 
 * @author Aluizio Monteiro 21 de set de 2018
 */

public class Cliente {

	private Integer id;
	private EnumPessoa pessoa;
	private EnumSituacao situacao;
	private EnumSexo sexo;
	private String nome;
	private String sobreNome;
	private LocalDate nascimento;
	private String observacao;
	private String email;
	private String celular;
	private String endereco;
	private String bairro;
	private String cidade;
	private String complemento;
	private String numero;
	private String uf;
	private String cep;
	private String fone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnumPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EnumPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public EnumSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(EnumSituacao situacao) {
		this.situacao = situacao;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", pessoa=" + pessoa + ", situacao=" + situacao + ", sexo=" + sexo + ", nome="
				+ nome + ", sobreNome=" + sobreNome + ", nascimento=" + nascimento + ", observacao=" + observacao
				+ ", email=" + email + ", celular=" + celular + ", endereco=" + endereco + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", complemento=" + complemento + ", numero=" + numero + ", uf=" + uf + ", cep="
				+ cep + ", fone=" + fone + "]";
	}

	
}
