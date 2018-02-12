package com.javabank;

public class Test {
	static final String ACCOUNTS_HEADING = "계좌번호|소유자명|잔고";
    static final String TRANSACTIONS_HEADING = "거래일|거래시간|구분|금액|잔고";

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Bank bank = new Bank();
        bank.addAccount("101", "홍길동");
        bank.addAccount("202", "임꺽정");
        bank.addAccount("303", "장길산");
        bank.addAccount("404", "홍길동");
        
        //1. 총 계좌 목록을 출력한다.
        System.out.println("1. 총 계좌 목록을 출력한다.");
        Account[] accounts = bank.getAccounts();
        int totalAccount = bank.getTotalAccount();
        System.out.println(Test.ACCOUNTS_HEADING);
        for (int i = 0; i < totalAccount; i++) {
            System.out.println(accounts[i]);
        }

        System.out.println();
                
        //2. 101계좌에 10,000원을 입금한다.
        System.out.println("2. 101계좌에 10,000원을 입금한다.");        
        Account hong = bank.getAccount("101");
        hong.deposit(10000);
        System.out.println(Test.ACCOUNTS_HEADING);
        System.out.println(hong);

        System.out.println();
                
        //3. 101계좌에 5,000원을 출금한다.
        System.out.println("3. 101계좌에 5,000원을 출금한다.");        
        hong.withdraw(5000);
        System.out.println(Test.ACCOUNTS_HEADING);
        System.out.println(hong);

        System.out.println();
                
        //4. 101계좌의 입출금 명세를 출력한다.
        System.out.println("4. 101계좌의 입출금 명세를 출력한다.");        
        Transaction[] transactions = hong.getTransactions();
        int totalTransaction = hong.getTotalTransaction();
        System.out.println(Test.TRANSACTIONS_HEADING);
        for (int i = 0; i < totalTransaction; i++) {
            System.out.println(transactions[i]);
        }

        System.out.println();
        
        //5. 고객명으로 계좌를 찾는다.
        System.out.println("5. 홍길동 계좌찾기");
        Account[] matched = bank.findAccountByName("홍길동");
        System.out.println(Test.ACCOUNTS_HEADING);
        //확장된 for문
        for (Account account : matched) {
            System.out.println(account);
        }
	}

}
