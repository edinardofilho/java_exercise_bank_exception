package model.entities;

import model.exception.BalanceException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance, withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount > withdrawLimit) {
			throw new BalanceException("Withdraw error: The amount exceeds withdraw limit");
		}
		double tempBalance = balance - amount;
		if (tempBalance < 0.0) {
			throw new BalanceException("Withdraw error: Not enough balance");
		}
		
		balance = tempBalance;
	}

	@Override
	public String toString() {
		return "New balance: " + String.format("%.2f", balance);
	}
}
