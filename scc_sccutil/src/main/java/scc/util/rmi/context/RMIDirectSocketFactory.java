package scc.util.rmi.context;

/*
 * @(#)RMIDirectSocketFactory.java	1.10 03/12/19
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.rmi.server.RMISocketFactory;

/**
 * RMIDirectSocketFactory creates a direct socket connection to the specified
 * port on the specified host.
 */
public class RMIDirectSocketFactory extends RMISocketFactory {

	private final static int RESPONSETIMEOUT=30 * 60 * 1000;
	private final static int CONNECTTIMEOUT=60000;

	public Socket createSocket(String host, int port) throws IOException {
		Socket socket = new Socket();
		SocketAddress endpoint = host != null ? new InetSocketAddress(host,
				port)
				: new InetSocketAddress(InetAddress.getByName(null), port);
		socket.setSoTimeout(RESPONSETIMEOUT);
		socket.connect(endpoint, CONNECTTIMEOUT);

		return socket;
	}

	public ServerSocket createServerSocket(int port) throws IOException {
		return new ServerSocket(port);
	}
}
