

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class request
 */
@WebServlet("/request")
public class request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
PrintWriter out = response.getWriter();
		try {	
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String date=request.getParameter("date");
		String withindate=request.getParameter("withindate");
		String age=request.getParameter("age");
		String blood=request.getParameter("blood");
		System.out.print("1"+name+phone+date+withindate+age+blood);
	
		System.out.print("2"+name+phone+date+withindate+age+blood+withindate);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","srini397");
			PreparedStatement ps=con.prepareStatement("insert into request(name,phone,date,withindate,age,blood) values(?,?,?,?,?,?)");
			System.out.println("3");
			ps.setString(1,name);
			ps.setString(2,phone);
			ps.setString(3,date);
			ps.setString(4,withindate);
			ps.setString(5,age);
			ps.setString(6,blood);
		
			int i=ps.executeUpdate();
			System.out.println("4");
			if(i>0)
			{
				System.out.println("inserted into database");
				response.sendRedirect("thankyoufile.html");
			}
			else {
				System.out.println("invlid");
			}
		}catch(Exception t)
			{
				t.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
