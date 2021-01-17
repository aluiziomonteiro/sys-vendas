package backup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Servlet implementation class FiltroDeAuditoria
 * @author Aluizio Monteiro
 * 29 de ago de 2018
 */

//Para quem rodar
@WebFilter(urlPatterns="/*")

public class FiltroDeAuditoria implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		String uri = req.getRequestURI();
		
		String usuario = getUsuario(req);
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		
		System.out.println(" - "+hora+" "+data+" - Usuário"+usuario+" acessando a url: ("+uri+")");
		
		//Continua fluxo
		chain.doFilter(request, response);
	}

	//Pega o resultado da classe Cookies, se null então está deslogado
	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario == null) return "<deslogado>";
		
		return usuario.getLogin();
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
