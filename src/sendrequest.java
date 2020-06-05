

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendrequest
 */
@WebServlet("/sendrequest")
public class sendrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendrequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param fde 
	 * @param da 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, java.sql.Date fde, java.sql.Date da) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		System.out.println("1");
		try {
			java.sql.Date fda,dat;
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String date=request.getParameter("date");
		java.text.DateFormat in = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date fd=in.parse(date);
			//fde=fd;
		}catch(ParseException e)
		{
			System.out.println(e);
		}
		String withindate=request.getParameter("withindate");
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date d=format.parse(withindate);
		}catch(ParseException e) {
			System.out.println(e);
		}
		String age=request.getParameter("age");
		String blood=request.getParameter("blood");
		//System.out.print("1"+name+phone+date+withindate+age+blood);
		System.out.print("2"+date+withindate);
		System.out.print("3"+fde+da);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","srini397");
			PreparedStatement ps=con.prepareStatement("insert into request(name,date,withindate,age,blood,phone) values(?,?,?,?,?,?)");
			System.out.println("3");
			ps.setString(1,name);
			ps.setDate(2,fde);
			ps.setDate(3,da);
			ps.setString(4,age);
			ps.setString(5,blood);
			ps.setString(6,phone);
			int i=ps.executeUpdate();
			System.out.println("4");
			if(i>0)
			{
				System.out.println("inserted into database");
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
