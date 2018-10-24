package ru.spbstu.tema.pp.lecture07;

public abstract class AbstractPerson {
	private int goodsNum;
	private int account;

	public AbstractPerson(int goodsNum, int account) {
		super();
		this.goodsNum = goodsNum;
		this.account = account;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
}
