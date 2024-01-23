import java.util.Scanner;
import java.util.Random;

class NumberGuessing
{
	public static void main(String[] args)
	{
			Scanner sc = new Scanner(System.in);
			Random r = new Random();

			int min  = 1;
			int max = 100;
			int attempts = 10;
			int score = 0;
			int rounds =0;

			boolean playagain = true;

			System.out.println("* * * * * Welcome to Number Guessing Game * * * * *");
			while(playagain)
			{
				int target = r.nextInt(max - min + 1);
				int attempt = 0;
				boolean correctGuess = false;

				System.out.println("Round : "+(rounds+1));
				System.out.println("Guess the number in between "+min+" to "+max );


				while(attempt < attempts && !correctGuess)
				{
					System.out.print((attempt+1) + " Attempt :- Enter your guess: ");
                    int UserGuess = sc.nextInt();
                    attempt++;

                    if(UserGuess == target)
                    {
                    	System.out.println("Congratulation! You guessed the correct number in "+attempt+ " attempts");
                    	correctGuess = true;
                    }
                    else if(UserGuess < target)
                    {
                    	System.out.println("Too Low! Try Again...");
                    }
                    else
                    {
                    	System.out.println("Too High! Try Again...");
                    }

				}

				if(!correctGuess)
				{
					System.out.println("Sorry, you've run out of attempts. The correct number was: " + target);
	
				}
				System.out.println("Do you want to play again? (Yes/No) : ");
				playagain = sc.next().toLowerCase().equals("yes");
				rounds++;
			}

			System.out.println("Thanks for playing the game! Your final score is : "+rounds);
	}
}