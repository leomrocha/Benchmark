package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04138")
public class BenchmarkTest04138 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a10070 = param; //assign
		StringBuilder b10070 = new StringBuilder(a10070);  // stick in stringbuilder
		b10070.append(" SafeStuff"); // append some safe content
		b10070.replace(b10070.length()-"Chars".length(),b10070.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10070 = new java.util.HashMap<String,Object>();
		map10070.put("key10070", b10070.toString()); // put in a collection
		String c10070 = (String)map10070.get("key10070"); // get it back out
		String d10070 = c10070.substring(0,c10070.length()-1); // extract most of it
		String e10070 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10070.getBytes() ) )); // B64 encode and decode it
		String f10070 = e10070.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g10070 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10070); // reflection
		
		
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			// throw new ServletException(e); - for now, it's ok if this provider not on the platform
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		}

		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) executed");
	}
}