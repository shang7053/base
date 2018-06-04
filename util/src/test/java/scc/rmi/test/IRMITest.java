package scc.rmi.test;

import scc.util.rmi.annotation.Scc;


@Scc(impl="scc.rmi.inter.RMITestImpl")
public interface IRMITest{
	public String login(String userName, String password);
}
