package profit.gupao.netty.io.bio.tomcat.servlet;

import profit.gupao.netty.io.bio.tomcat.http.GPRequest;
import profit.gupao.netty.io.bio.tomcat.http.GPResponse;
import profit.gupao.netty.io.bio.tomcat.http.GPServlet;

public class SecondServlet extends GPServlet {

	public void doGet(GPRequest request, GPResponse response) throws Exception {
		this.doPost(request, response);
	}

	public void doPost(GPRequest request, GPResponse response) throws Exception {
		response.write("This is Second Serlvet");
	}

}
