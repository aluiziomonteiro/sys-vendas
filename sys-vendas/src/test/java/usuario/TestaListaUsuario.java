package usuario;

import java.util.List;

import br.com.aluizio.sysvendas.dao.UsuarioDao;

/**
 * TestaListaUsuario.java
 * @author Aluizio Monteiro
 */

public class TestaListaUsuario {

	public static void main(String[] args) {
		UsuarioDao dao = new UsuarioDao();
		List<Object> usuarios = dao.getList();
		usuarios.forEach(u -> System.out.println(u));
	}
}
