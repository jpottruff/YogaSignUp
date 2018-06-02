package com.yoga;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		
		try {
			//getting input from form
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phoneNumber");
			
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String appointment = request.getParameter("appointment");
			
			String [] values = request.getParameterValues("yogaType");
			String yogaType = "";
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					yogaType += values[i] + ", ";
				} 
				
				yogaType = (yogaType.substring(0, (yogaType.length()) - 2));
			} else {
				yogaType = "<i>No Preference</i>";
			}

			
			
			String transport = request.getParameter("transport");
			
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			
			PrintWriter out = response.getWriter();
			
			//customized content
			String html= "";
			
			html+= "<h1> Confirmed! </h1>";
			html+=	"<p>Thank you <b>" + name + "</b>, we will get back to you soon </p><br />";
			html += "<b>Your Info: </b><br /><br />";
			html += "<i>Email:</i> " + email + "<br />";
			html += "<i>Contact Number:</i> " + phoneNumber + "<br />";
			html += "<i>Gender:</i> " + gender + "<br />";
			html += "<i>Age:</i> " + age + "<br />";
			html += "<i>Appointment:</i> " + appointment + "<br />";
			html += "<i>Interested In:</i> " + yogaType + "<br />";
			html += "<i>Transport Required:</i> "+ transport + "<br />";
			html += "<i>City:</i> " + city + "<br />";
			html += "<i>State:</i> " + state + "<br />";
			html += "<i>Country:</i> " + country + "<br />";
			html += "</p>";
			
			//output
			out.println(htmlResponse("Confirmation Page", "styles.css", html));
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		

	}
	
	//method lays out standard HTML 5 document
	//accepts page title, external css document location, and unique content, inserts in where appropriate
	private String htmlResponse(String pageTitle, String cssLocation, String content) {
		String htmlResponse = "";
		
		htmlResponse += "<!DOCTYPE html>";
		htmlResponse += "<html>";
		htmlResponse += "<head>";
		htmlResponse += "<meta charset='ISO-8859-1'>";
		htmlResponse += "<title>" + pageTitle + "</title>";
		htmlResponse += "<link rel='stylesheet' type = 'text/css' href='" + cssLocation + "'>";
		htmlResponse += "</head>";
		htmlResponse += "<body>";
		htmlResponse += content;
		htmlResponse += "</body>";
		htmlResponse += "</html>";
		
		return htmlResponse;
		
	}

}
