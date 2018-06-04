package scc.rmi.test;

import java.rmi.RemoteException;

import scc.util.rmi.context.RmiService;


public class TestService {
	public static void main(String[] args) throws RemoteException {
		RmiService.openRmi();
	}
}
