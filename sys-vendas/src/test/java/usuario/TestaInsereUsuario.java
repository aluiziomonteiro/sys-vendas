/**
 * 
 */
package usuario;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * @author Aluizio Monteiro
 *
 */
public class TestaInsereUsuario {
	public static void main(String[] args) {
		 Usuario usuario = new Usuario();
		 usuario.setNome("Eduardo Dias");
		 usuario.setLogin("eduardo");
		 usuario.setSenha("eduardo");
		 
		 UsuarioDao dao = new UsuarioDao();
		 dao.adicionaAltera(usuario);
	}

}
