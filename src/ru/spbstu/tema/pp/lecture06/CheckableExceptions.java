package ru.spbstu.tema.pp.lecture06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class CheckableExceptions {
	
	public static void main(String[] args) {
		File f = new File("/tmp/test.out");
		
		SomeLibrary l = new SomeLibrary();
		
		Random r = new Random();
		try {
			l.makeImportantOps(r.nextBoolean());
		} catch (MyException e1) {
			e1.printStackTrace();
		}
		
		try {
			l.makeAnotherImportantOps(r.nextBoolean());
		} catch (Throwable e) { //never do this
			// will never happen
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			l.readFile(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//show error dialogue and propose to select another file
		}
	}

}
