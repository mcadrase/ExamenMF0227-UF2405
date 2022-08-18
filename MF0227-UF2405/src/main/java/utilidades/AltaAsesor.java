package utilidades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Asesor;

import java.io.IOException;
import java.io.PrintWriter;

import dao.AsesorDAO;
import dao.AsesorDAOMySQL;

/**
 * Servlet implementation class AltaAsesor
 */
public class AltaAsesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaAsesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		String contrato = request.getParameter("contrato");
		String seguro = request.getParameter("seguro");
		String promedio = request.getParameter("promedio");
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Datos del asesor</h1>");
		out.println("<ul>");
		out.println("<li>Nombre: "+nombre+"</li>");
		out.println("<li>Apellidos: "+apellidos+"</li>");
		out.println("<li>DNI: "+dni+"</li>");
		out.println("<li>Relación contractual: "+contrato+"</li>");
		out.println("<li>Tipo de seguros: "+seguro+"</li>");
		out.println("<li>Num Ventas promedio: "+promedio+"</li>");
		
		out.println("</body>\r\n"
				+ "</html>");
		
		int numVentas = Integer.parseInt(promedio);
		
		boolean coche=false;
		boolean hogar=false;
		boolean decesos=false;
		
		if(seguro.equals("Automóvil")) {
			coche=true;
		}
		else if(seguro.equals("Hogar")) {
			hogar=true;
		}
		else if(seguro.equals("Decesos")) {
			decesos=true;
		}
		
		Asesor a = new Asesor(dni, nombre, apellidos, contrato, coche, hogar, decesos, numVentas);
		
		AsesorDAO insertarDAO = new AsesorDAOMySQL();
		insertarDAO.insertarAsesor(a);
		
		System.out.println(a);
	}

}
