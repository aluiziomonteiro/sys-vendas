package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 * 
 */
public class Categoria {
	private Integer id;
	private String nome;

	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
