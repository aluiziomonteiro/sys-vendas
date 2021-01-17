package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Carrinho;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamentos;
import br.com.aluizio.sysvendas.model.Usuario;
import br.com.aluizio.sysvendas.service.CarregarDashboard;

/**
 * Salva um orcamento relacionado com um cliente.
 * 
 * @date 30/11/2018
 * @author Aluizio Monteiro 30 de nov de 2018
 */

@WebServlet("/salvaOrcamento")
public class SalvaOrcamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sessaoCliente, usuarioLogado, sessionProdutos;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Pega Usuário
		usuarioLogado = request.getSession(false);
		Usuario usuario = (Usuario) usuarioLogado.getAttribute("usuarioLogado");

		// Pega Cliente
		sessaoCliente = request.getSession(false);
		Cliente cliente = (Cliente) sessaoCliente.getAttribute("sessaoCliente");

		// Popula Orçamento e Cliente
		Orcamento orcamento = new Orcamento();
		orcamento.setUsuario(usuario);
		orcamento.setCliente(cliente);

		int totalParcelas = Integer.parseInt(request.getParameter("parcelas"));
		int parcelasPagas = 0;
		
		String sTotalOrcamento = request.getParameter("totalOrcamento");
		String sSubTotalOrcamento = request.getParameter("subTotalOrcamento");
		String sDescontos = request.getParameter("descontos");
		//String sCusto= request.getParameter("custo");
		
		
		
		
		
		
		BigDecimal totalOrcamento = new BigDecimal(sTotalOrcamento);
		orcamento.setTotalOrcamento(totalOrcamento);

		BigDecimal subTotalOrcamento = new BigDecimal(sSubTotalOrcamento);
		orcamento.setSubTotalOrcamento(subTotalOrcamento);

		BigDecimal descontos = new BigDecimal(sDescontos);
		orcamento.setDescontos(descontos);

		//BigDecimal custo = new BigDecimal(sCusto);
		//orcamento.setCusto(custo);
		
		
		
		// Seta a dataLancamento de agora
		LocalDate dataLancamento = LocalDate.now();
		orcamento.setDataLancamento(dataLancamento);

		OrcamentoDao dao = new OrcamentoDao();
		int fkOrcamento = (dao.buscaMaiorId() + 1);

		// Pega os produtos do carrinho
		sessionProdutos = request.getSession(false);
		ArrayList<Carrinho> list = (ArrayList<Carrinho>) sessionProdutos.getAttribute("carroCompras");

		
		
		
		
		
		//Calculainvestimento
		//setar custo unidade no banco e setar a data atual ao cadastrar um orçamento
			//select (carrinho.qtd * produtos.custoUnid), month(carrinho.data) from carrinho inner join produtos on carrinho.produtoId = produtos.id ;
		
		List<Pagamentos> pagamentoList = new ArrayList<>();

		for (int i = 1; i <= totalParcelas; i++) {

			BigDecimal parcelaValor = new BigDecimal(request.getParameter("parcelaValor[" + i + "]"));

			LocalDate parcelaData = LocalDate.parse(request.getParameter("parcelaData[" + i + "]"));

			String statusText = String.valueOf(request.getParameter("checkBoxPagar["+i+"]"));
			
			System.out.println("conteúdo do checkbox: "+statusText);
			
			EnumStatus status = null;
			
			if (statusText.equals("on")) {
				status = EnumStatus.valueOf("QUITADO");
				parcelasPagas++; // COnta as parcelas que já foram pagas
			} else {
				status = EnumStatus.valueOf("A_PAGAR");
			}
			
			Pagamentos pagamento = new Pagamentos();
			pagamento.setValorParcela(parcelaValor);
			pagamento.setNumParcela(i);
			pagamento.setFkOrcamento(fkOrcamento);
			pagamento.setParcelaData(parcelaData);
			pagamento.setStatus(status);
			
			pagamentoList.add(pagamento);

			System.out.println(pagamento);
			System.out.println(" - Número da parcela: " + i);
			System.out.println("A parcela foi paga? " + status);

		}
		
		//seta parcelas pagas
		orcamento.setParcelasPagas(parcelasPagas);
		orcamento.setTotalParcelas(totalParcelas);

		// Manda Orçamento para o banco
		dao.salvaOrcamento(orcamento);
		dao.salvaCarrinho(list);

				
		new PagamentoDao().inserir(pagamentoList);

		JOptionPane.showMessageDialog(null, "Registrado com Sucesso!");

		//Carrega a index.jsp
		CarregarDashboard.carregarDashboard(request, response);
		
	}
}
