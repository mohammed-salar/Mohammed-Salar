import java.util.Scanner;
public class GuessingNumberGame
{
	public static void main(String[] args) 
	{
		int attempt = 1;
		int userGuessNumber = 0;
		int secretNumber = (int) (Math.random() * 99 + 1);

		Scanner userInput = new Scanner(System.in); 
		System.out.println("Welcome to Guess the number game \nYou will be Asked to Guess A Number to win the game \nYou have Maximun 5 attempts");
		do 
		{
			System.out.println("Guess the number between 1-100\n");
			if(userInput.hasNextInt())
			{
				userGuessNumber = userInput.nextInt();
				

				if(userGuessNumber == secretNumber)
				{
					System.out.println("yay!, your number is correct. you win the game!");
					break;
				}
				

				else if(userGuessNumber > secretNumber)
					System.out.println("your number is greater.");
				

				else if(userGuessNumber < secretNumber)
					System.out.println("your number is smaller.");
			
				
				if(attempt == 5)
				{
					System.out.println("you've exceeded the max limit, try again");
					break;
				}
				attempt++;
			}
			else
			{
				System.out.println("Enter a valid Number");
				break;
			}
		}
		while(userGuessNumber != secretNumber);
	}
}