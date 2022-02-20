import java.util.Scanner;
public class ATM
{
	public static void main(String[] args) 
	{
		int balance = 100000, withdraw, deposit;
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("Automated teller machine");
			System.out.println("Choose 1 for withdraw");
			System.out.println("Choose 2 for deposit");
			System.out.println("Choose 3 for check balance");
			System.out.println("Choose 4 for exit");
			System.out.println("Choose the operation you want to perform: ");

			int choice = sc.nextInt();
			switch(choice)
			{
				case 1:
				System.out.println("Enter money to be withdrawn: ");
				withdraw = sc.nextInt();

				if(balance >= withdraw)
				{
					balance = balance - withdraw;
					System.out.println("PLease collect Your money");
				}
				else
				{
					System.out.println("insufficient balance");
				}
				System.out.println(" ");
				break;


				case 2: 
				System.out.println("enter money needed to br deposited: ");
				deposit = sc.nextInt();

				balance = balance + deposit;

				System.out.println("Your money has been succesfully deposited ");
				System.out.println(" ");
				break;


				case 3:
				System.out.println("Balance: "+balance);
				System.out.println(" ");
				break;


				case 4:
				System.exit(0);
			}

		}		
	}
}