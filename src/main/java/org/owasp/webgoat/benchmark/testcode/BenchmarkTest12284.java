package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12284")
public class BenchmarkTest12284 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map59712 = new java.util.HashMap<String,Object>();
		map59712.put("keyA-59712", "a_Value"); // put some stuff in the collection
		map59712.put("keyB-59712", param.toString()); // put it in a collection
		map59712.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map59712.get("keyB-59712"); // get it back out
		bar = (String)map59712.get("keyA-59712"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass