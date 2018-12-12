package ru.spbstu.tema.pp.lecture12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket s = new ServerSocket(10000);
		
		Socket connection;
		while(!Thread.currentThread().isInterrupted()) {
			connection = s.accept();
			connection.getOutputStream().write(("Hello world! " + new Date()).getBytes());
			connection.close();
		}
		
		s.close();
		
	}

}
