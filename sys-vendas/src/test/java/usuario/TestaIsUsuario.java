package usuario;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * TestaBuscaPorId.java
 * @author Aluizio Monteiro
 * 29 de ago de 2018
 */

public class TestaIsUsuario {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setLogin("Pereira");
		usuario.setSenha("Pereira");
		
		UsuarioDao dao = new UsuarioDao();
		Usuario buscaUsuario = dao.buscaUsuario(usuario);
		
		if(buscaUsuario.getId()==null) {
			System.out.println("É null");
		}else {
			System.out.println("não é null");
		}
		System.out.println(buscaUsuario);
		
		if(new UsuarioDao().isUsuario(usuario)) {
			System.out.println("Existe");
		}else{
			System.out.println("Não existe");
		}
		
	}
}
