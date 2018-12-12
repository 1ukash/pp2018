package ru.spbstu.tema.pp.lecture12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket s = new ServerSocket(10000);
		
		while(!Thread.currentThread().isInterrupted()) {
			final Socket connection = s.accept();
			CompletableFuture.supplyAsync(() -> {
				try {
					connection.getOutputStream().write(("Hello world! " + new Date()).getBytes());
					connection.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "OK";
			});
		}
		
		s.close();
		
	}

}
