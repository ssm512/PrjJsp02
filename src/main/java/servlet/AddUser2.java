package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import db.DBHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adduser2") // 이 주소가 들어가있으면 바로 현재 java 문서로 오겠다는 거임
public class AddUser2 extends HttpServlet { // request 객체를 상속받는 의미임, request말고도 다른 객체들도 있음
	private static final long serialVersionUID = 1L;
    /*
	// 숫자는 실행순서임
	// 1.생성자 constructor : 보통 생략
    public AddUser2() {
    	System.out.println("생성자");
    } // 기본 생성자

    // 2.init - 초기화 : 보통 생략
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행");
	}

	// 6.destory - 클래스의 인스턴스 소명될때 실행됨 : 보통 생략
	public void destroy() {
		System.out.println("destory() 실행");
	}
	
	// 3.service - doget인지, dopost인지 판단
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
	}
	*/
	// 4.doget
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 실행");
		String		userid			=		request.getParameter("userid"); // request.~~ 객체임
	    String		username		=		request.getParameter("username");
	    String		email			=		request.getParameter("email");
		
	    // dbhandler
	    DBHandler		db		=	new	DBHandler();
	    try {
			db.addUser(userid, username, email);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	    
	    response.sendRedirect("/Prjjsp02/");
		
	    /*
		// console 출력
		System.out.println(userid); 
		// html 페이지에 출력
		// application/xml : .xml , application/json : .json , plain/text : .txt - content type 
		response.setContentType("text/html; charset=utf-8"); // 브라우저야 내가 html type으로 response 줄께
		PrintWriter  out	=	response.getWriter();
		out.write(userid);
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		*/
	}

	// 5.doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 실행");
		doGet(request, response);
	}

}
