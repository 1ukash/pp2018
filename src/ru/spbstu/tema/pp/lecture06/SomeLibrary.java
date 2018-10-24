package ru.spbstu.tema.pp.lecture06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SomeLibrary {

	void makeImportantOps(boolean flag) throws MyException {

		System.out.println("before");
		if (flag) {
			throw new MyException();
		}

		System.out.println("after");
	}

	void makeAnotherImportantOps(boolean flag)  {

		System.out.println("before");
		if (flag) {
			throw new RuntimeException();
		}

		System.out.println("after");
	}
	
	void readFile(File f) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(f);
	}

}
