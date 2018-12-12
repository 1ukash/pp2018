package ru.spbstu.tema.pp.lecture12;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket s = new Socket("localhost", 10000);
		Thread.sleep(1000);
		InputStream is = s.getInputStream();
		int bufSize = is.available();
		byte buf[] = new byte[bufSize];
		is.read(buf);
		System.out.println(new String(buf));
		s.close();
	}
}
