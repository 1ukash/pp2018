package ru.spbstu.tema.pp.lecture12;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import ru.spbstu.tema.pp.lecture12.Message.Command;

public class ClientWithObject {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException, ClassNotFoundException {
		Socket s = new Socket("localhost", 10000);
		
		ObjectOutputStream out;
		ObjectInputStream in;
		InputStream inputStream = s.getInputStream();
		try {
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		
		int counter = 0;
		while (!Thread.currentThread().isInterrupted() && !s.isClosed()) {
			while(inputStream.available() == 0) {
				Thread.sleep(100);
			}
			
			Message msg = (Message) in.readObject();
			System.out.println(msg.getMsg());
			Thread.sleep(500);	
			if (counter < 10) {
				out.writeObject(new Message("hey " + (counter++), Command.MSG));
			} else {
				out.writeObject(new Message("hey " + (counter++), Command.POISONPILL));
			}
			
		}
		
		Thread.sleep(1000);
		InputStream is = inputStream;
		int bufSize = is.available();
		byte buf[] = new byte[bufSize];
		is.read(buf);
		System.out.println(new String(buf));
		s.close();
	}
}
