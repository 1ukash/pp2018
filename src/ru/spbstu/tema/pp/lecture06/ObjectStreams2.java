package ru.spbstu.tema.pp.lecture06;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ObjectStreams2 {
	
	public static void main(String[] args) throws IOException {
		File f = new File("file.dat");
		writeToFile(f);
		readFromFile(f);
	}

	private static void readFromFile(File f) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		GZIPInputStream gz = new GZIPInputStream(fis);
		DataInputStream dis = new DataInputStream(gz);
		
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		System.out.println(dis.readUTF());
		
		dis.close();
	}

	private static void writeToFile(File file) throws IOException {
		FileOutputStream fis = new FileOutputStream(file);
		BufferedOutputStream buf = new BufferedOutputStream(fis);
		GZIPOutputStream gz = new GZIPOutputStream(buf);
		DataOutputStream dos = new DataOutputStream(gz);
		
		dos.writeInt(1);
		dos.writeDouble(.191923);
		dos.writeUTF("string 1");
		dos.writeUTF("string 2");

		dos.flush();
		dos.close();
		fis.close();
	}

}
