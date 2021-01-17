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
public class TestaAlteraUsuario {
	
	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setId(7);
		usuario.setNome("Junior");
		usuario.setLogin("junior");
		usuario.setSenha("junior");
		UsuarioDao dao = new UsuarioDao();
		dao.adicionaAltera(usuario);
		
		System.out.println("Usuário alterado com sucesso.");
	}
}
