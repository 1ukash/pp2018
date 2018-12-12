package ru.spbstu.tema.pp.lecture12;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3780731923190957755L;

	public static enum Command {
		POISONPILL, MSG, DATE
	}

	private String msg;
	private Command command;
	
	public Message(String msg, Command command) {
		super();
		this.msg = msg;
		this.command = command;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

}
