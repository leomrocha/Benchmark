package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09178")
public class BenchmarkTest09178 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		// Create the file first so the test won't throw an exception if it doesn't exist.
		// Note: Don't actually do this because this method signature could cause a tool to find THIS file constructor 
		// as a vuln, rather than the File signature we are trying to actually test.
		// If necessary, just run the benchmark twice. The 1st run should create all the necessary files.
		//new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar).createNewFile();
		


        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
        		org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
        java.io.FileDescriptor fd = fileInputStream.getFD();
        java.io.FileOutputStream anotOutputStream = new java.io.FileOutputStream(fd);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map96326 = new java.util.HashMap<String,Object>();
		map96326.put("keyA-96326", "a Value"); // put some stuff in the collection
		map96326.put("keyB-96326", param.toString()); // put it in a collection
		map96326.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map96326.get("keyB-96326"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass