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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Streams {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FooBar o = new FooBar(1, "abcd", .344444);
		File f = new File("file.dat");
		writeObjectToFile(f, o);
		FooBar res = readObjectFromFile(f);
		System.out.println(res);
		System.out.println(res.getMyself());
		
		System.out.println(res == res.getMyself());
	}

	private static FooBar readObjectFromFile(File f) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream dis = new ObjectInputStream(fis);
		
		Object o = dis.readObject();
		dis.close();
		return (FooBar) o;
	}

	private static void writeObjectToFile(File file, FooBar o) throws IOException {
		FileOutputStream fis = new FileOutputStream(file);
		BufferedOutputStream buf = new BufferedOutputStream(fis);
		ObjectOutputStream dos = new ObjectOutputStream(buf);

		dos.writeObject(o);

		dos.flush();
		dos.close();
		fis.close();
	}

}
