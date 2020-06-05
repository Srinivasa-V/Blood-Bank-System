

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class donorregistration
 */
@WebServlet("/donorregistration")
public class donorregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donorregistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			String blood=request.getParameter("blood");
			String gender=request.getParameter("gene");
			System.out.println("1"+name+age+phone+email+address+gender+blood);
			try {
			String value;
			if(gender.equalsIgnoreCase("Male"))
			{
				value="Male";
			}
			else {
				value="Female";
			}
			System.out.println(""+value);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","srini397");
			PreparedStatement ps=con.prepareStatement("insert into donorform(name,age,phone,email,address,gender,blood) values(?,?,?,?,?,?,?)");
			System.out.println("3");
			ps.setString(1,name);
			ps.setString(2,age);
			ps.setString(3,phone);
			ps.setString(4,email);
			ps.setString(5,address);
			ps.setString(6,value);
			ps.setString(7,blood);
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
