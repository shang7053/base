package scc.rmi.test;

import scc.util.rmi.context.RemoteServiceFactory;


public class TestClient {
	public static void main(String[] args) {
		IRMITest r = RemoteServiceFactory.instance(IRMITest.class);
//		System.out.println(r);
//		System.out.println(r.login("sss", "ssss"));
	}
}
