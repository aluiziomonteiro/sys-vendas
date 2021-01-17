package usuario;

import java.util.List;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * TestaBuscaPorNome.java
 * @author Aluizio Monteiro
 * 26 de set de 2018
 */

public class TestaBuscaPorNome {
	public static void main(String[] args) {
		Usuario usuarioBuscado = new Usuario();
		usuarioBuscado.setNome("as");
		
		UsuarioDao dao = new UsuarioDao();
		List<Object> buscaPorNome = dao.buscaPorNome(usuarioBuscado);
		buscaPorNome.forEach(b -> System.out.println(b));
		
	}
}
