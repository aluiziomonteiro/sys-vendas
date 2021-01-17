package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 */

public class Fornecedor {
	private Integer id;
	private EnumPessoa pessoa;
	private String nome;
	private String cnpjCpf;
	private String cep;
	private String endereco;
	private String bairro;
	private String cidade;
	private String complemento;
	private String uf;
	private String fone;
	private String email;
	private String observacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public EnumPessoa getPessoa() {
		return this.pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPessoa(EnumPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", pessoa=" + pessoa + ", nome=" + nome + ", cnpjCpf=" + cnpjCpf + ", cep="
				+ cep + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", complemento="
				+ complemento + ", uf=" + uf + ", fone=" + fone + ", email=" + email + ", observacao=" + observacao
				+ "]";
	}



	

}
