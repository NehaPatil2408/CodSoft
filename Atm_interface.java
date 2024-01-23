import java.util.Scanner;

class BankAccount
{
	private double balance;
	private static final double withdraw_amt = 10000;

	public BankAccount(double initialBalance)
	{
		this.balance = initialBalance;
	}

	public double getBalance()
	{
		return balance;
	}

	public void deposit(double amount)
	{
		if(amount > 0)
		{
			balance += amount;
			System.out.println("Transaction get Successfully for deposit the amount. \n Account Balance : "+balance);
		}
		else 
		{
			System.out.println("Transaction failure!!! \n Invalid deposit amount");
		}
	}


	public void withdraw(double amount)
	{
		if(amount > 0 && amount <= withdraw_amt && amount<=balance)
		{
			balance -=amount;
			System.out.println("Transaction Successfully for withdraw the amount. \n Account Balance : "+balance);
		}
		else 
		{
			System.out.println("Transaction failure!!! \n Invalid withdraw amount or insufficient balance");
		}
	}
}

class ATM
{

	private BankAccount ba;

	public ATM(BankAccount ba)
	{
		this.ba = ba;
	}

	public void display()
	{
		System.out.println(" * * * * * ATM InterFace * * * * * ");
		System.out.println("1 : Deposit");
		System.out.println("2 : withdraw");
		System.out.println("3 : Check balance");
		System.out.println("4 : Exit");
	}
		public void performTransaction(int option, double amount)
		{
			switch(option)
			{
				case 1 :
					ba.deposit(amount);
				    break;
				case 2 :
					ba.withdraw(amount);
					break;
				case 3 : 
					System.out.println("Current Balance : "+ba.getBalance());
					break;
				case 4:
					System.out.println("Existing..... Thank You!!!!");
					System.exit(0);
					break;
				default:
					System.out.println("Inavalis option to be selected");
			}
		}
	
}

class Atm_interface
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the initial amount in the account : ");
		double initialBalance  = sc.nextDouble();

		BankAccount ba = new BankAccount(initialBalance);
		ATM atm = new ATM(ba);

		while(true)
		{
			atm.display();

			System.out.println("Enter your option : ");
			int option = sc.nextInt();

			System.out.println("Enter amount : ");
			double amount = sc.nextDouble();

			atm.performTransaction(option, amount);


		}
	}
}