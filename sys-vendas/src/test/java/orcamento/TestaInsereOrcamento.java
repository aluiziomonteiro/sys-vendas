package orcamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * TestaInsereOrcamento.java
 * 
 * @author Aluizio Monteiro 22 de ago de 2018
 */

public class TestaInsereOrcamento {

	public static void main(String[] args) {
		
		Integer fk_cliente = 2;//
		Integer fk_usuario = 6;//
		BigDecimal subTotalOrcamento = new BigDecimal("10.00");//
		BigDecimal descontos = new BigDecimal("10.00");//
		BigDecimal totalOrcamento = new BigDecimal("10.00");//
		LocalDate dataLancamento = LocalDate.now();//
		Integer totalParcelas = 2;
		Integer parcelasPagas = 2;
		
		Cliente cliente = new Cliente();
		cliente.setId(fk_cliente);
		
		Usuario usuario = new Usuario();
		usuario.setId(fk_usuario);
		
		Orcamento orcamento = new Orcamento();

		orcamento.setSubTotalOrcamento(subTotalOrcamento);
		orcamento.setDescontos(descontos);
		
		orcamento.setDataLancamento(dataLancamento);
		
		orcamento.setTotalOrcamento(totalOrcamento);
		
		orcamento.setCliente(cliente);
		orcamento.setUsuario(usuario);
	
		orcamento.setTotalParcelas(totalParcelas);
		orcamento.setParcelasPagas(parcelasPagas);
		
		/*Carrinho car1 = new Carrinho();
		car1.setProdutoNome("produto teste 1");
		car1.setQtd(2);
		car1.setValorUnid(new BigDecimal("00.00"));
		car1.setSubTotal(new BigDecimal("00.00"));
		
		Carrinho car2 = new Carrinho();
		car2.setProdutoNome("produto teste 2");
		car2.setQtd(2);
		car2.setValorUnid(new BigDecimal("00.00"));
		car2.setSubTotal(new BigDecimal("00.00"));
		
		Carrinho car3 = new Carrinho();
		car3.setProdutoNome("produto teste 3");
		car3.setQtd(2);
		car3.setValorUnid(new BigDecimal("00.00"));
		car3.setSubTotal(new BigDecimal("00.00"));
		
		List<Carrinho> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		*/
		OrcamentoDao dao = new OrcamentoDao();
		dao.salvaOrcamento(orcamento);
		
		System.out.println("Orcamento salvo com sucesso");
		//System.out.println("Produtos do orçamento salvos com sucesso.");		
	
	
		
	}
}
