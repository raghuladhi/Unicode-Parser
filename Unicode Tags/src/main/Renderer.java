package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class renderer
 */
@WebServlet("/renderer")
public class Renderer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Renderer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();
		String line="";
		BufferedReader reader = request.getReader();
		while((line=reader.readLine())!=null){
			sb.append(line);
		}
		
		String inputText = sb.toString();
		
		HashMap<String,String> unicode = new HashMap<String,String>();
		unicode.put("\\\\n", "<p>");
		unicode.put("\\\\u0010", "<table>");
		unicode.put("\\\\u0012", "<tr>");
		unicode.put("\\\\u001c", "<td>");
		unicode.put("\\\\u0011", "</table>");
		unicode.put("\\\\u000b", "<br>");
		for(String key:unicode.keySet()){
	
			inputText = inputText.replaceAll(key, unicode.get(key));
		}
		response.setContentType("text/plain");
		response.getWriter().write(inputText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
