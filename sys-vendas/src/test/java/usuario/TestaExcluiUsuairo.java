package usuario;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

//Excluir
public class TestaExcluiUsuairo {
	
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		UsuarioDao dao = new UsuarioDao();
		dao.remover(usuario);
	}
}
