package scc.rmi.test;

import java.rmi.RemoteException;

public class RMITestImpl implements IRMITest {

	public RMITestImpl() throws RemoteException {
		super();
	}

	@Override
	public String login(String userName, String password){
		return userName+"==============="+password;
	}
	
}
