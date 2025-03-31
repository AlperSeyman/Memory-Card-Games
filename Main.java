import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Card[][] cards = new Card[4][4];
				
		cards[0][0] = new Card('E');
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('B');
        cards[0][3] = new Card('F');
        cards[1][0] = new Card('G');
        cards[1][1] = new Card('A');
        cards[1][2] = new Card('D');
        cards[1][3] = new Card('H');
        cards[2][0] = new Card('F');
        cards[2][1] = new Card('C');
        cards[2][2] = new Card('D');
        cards[2][3] = new Card('H');
        cards[3][0] = new Card('E');
        cards[3][1] = new Card('G');
        cards[3][2] = new Card('B');
        cards[3][3] = new Card('C');
		
        
        while(isGameOver(cards) == false) {
        	showBoard(cards);
        	toGuess(cards);
        }
        
		
	}
	public static void showBoard(Card[][] cards) {
		for(int i = 0; i < 4; i++) {
			System.out.println("___________________");
			for(int j = 0; j < 4; j++) {
				if (cards[i][j].getGuess()) {
					System.out.print(" |"  + cards[i][j].getValue() + "| ");
				}
				else {
					System.out.print(" | | ");
				}
			}
			System.out.println("");
		}
		System.out.println("___________________");
	}
	
	public static void toGuess(Card[][] cards) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the first guesses (i and j) leaveing a blank space between them. The guess must be 0 to 3. 0 and 3 is inclusive: ");
		
		int i1 = scanner.nextInt();
		int j1 = scanner.nextInt();
		
		cards[i1][j1].setGuess(true);
		showBoard(cards);
		
		System.out.println("Enter the second guesses (i and j) leaveing a blank space between them. The guess must be 0 to 3. 0 and 3 is inclusive: ");
		
		int i2 = scanner.nextInt();
		int j2 = scanner.nextInt();
		
		if(cards[i1][j1].getValue() == cards[i2][j2].getValue()){
			System.out.println("Correct Guess");
			cards[i2][j2].setGuess(true);
		}
		else {
			System.out.println("Wrong Guess");
			cards[i1][j1].setGuess(false);
			
		}
		
	}
	
	public static boolean isGameOver(Card[][] cards) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(cards[i][j].getGuess() == false) {
					return false;
				}
			}
		}
		return true;
	}
}
