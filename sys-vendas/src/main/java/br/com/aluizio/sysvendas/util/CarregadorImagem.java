package br.com.aluizio.sysvendas.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.ProdutoDao;

@WebServlet("/carregadorImagem")
public class CarregadorImagem extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static FileInputStream fileInputStream;

    public CarregadorImagem() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException 
    {
   
    	int id = Integer.parseInt(request.getParameter("id"));// vem do jsp

    	ProdutoDao dao = new ProdutoDao();
    	
    	//camininho da imagem baseado no id do produto;
    	byte[] imageData = carregarImagem(dao.recuperaImagem(id));
    	
    	response.setContentType("image/jpeg");
    	response.getOutputStream().write(imageData);  	
    }

    private static byte[] carregarImagem(String path) throws  IOException {

        byte[] image;
        File file = new File(path);//monta imagem baseada no path
        image = new byte[(int)file.length()]; // define tamanho do array

        fileInputStream = new FileInputStream(file);
        fileInputStream.read(image);

        return image;
    }
}


