package ru.spbstu.tema.pp.lecture12;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import ru.spbstu.tema.pp.lecture12.Message.Command;

public class ServerWithThreads {
	
	public static class ClientProcessor implements Runnable {
		
		private Socket s;
		

		public ClientProcessor(Socket s) {
			super();
			this.s = s;
		}


		@Override
		public void run() {
			
			ObjectOutputStream out;
			ObjectInputStream in;
			InputStream inputStream;
			try {
				inputStream = s.getInputStream();
				out = new ObjectOutputStream(s.getOutputStream());
				in = new ObjectInputStream(inputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
				return;
			}
			
			while (!Thread.currentThread().isInterrupted() && !s.isClosed()) {
				
				Message msg = new Message(new Date().toString(), Command.DATE);
				try {
					out.writeObject(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				try {
					while(inputStream.available() == 0) {
						Thread.sleep(100);
					}
					Message reply = (Message) in.readObject();
					
					if (reply.getCommand() == Command.POISONPILL) {
						out.close();
						in.close();
						s.close();
						return;
					}
					
					System.out.println(reply.getMsg());
				} catch (ClassNotFoundException | IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket s = new ServerSocket(10000);
		
		while(!Thread.currentThread().isInterrupted()) {
			final Socket connection = s.accept();
			new Thread(new ClientProcessor(connection)).start();
		}
		
		s.close();
		
	}

}
