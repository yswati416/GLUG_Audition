import java.util.*;
import java.util.Random;
public class mergegames {
    public static Scanner sc = new Scanner(System.in);
    public static Random in = new Random(); 
    public static char board[][];
    public static char player = 'X';

    public static void main(String args[]) {
        System.out.println("Enter the size");
        int n = sc.nextInt();
        board = new char[n][n]; 
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ' ';
            }
        }
        
        System.out.println("Enter 1 for 2 user mode");
        System.out.println("Enter 2 for computer mode");
        System.out.println("Enter 3 for exit");
        int ch = sc.nextInt();
        boolean f = false;

        switch(ch) {
            case 1:
                {
                print(board);
                while (!f) {
                    print(board);
                    System.out.println("Enter your move player " + player + ":");
                    int i = sc.nextInt();
                    int j = sc.nextInt();

                    if (i >= 0 && i < n && j >= 0 && j < n && board[i][j] == ' ') {
                        board[i][j] = player;
                        f = wins(board, player);
                        if (f) {
                            System.out.println("Player " + player + " has won!");
                            print(board);
                            break;
                        } 
                        else if(draw(board)) 
                        {
                            System.out.println("It is a draw");
                            break;
                        }
                        else{
                            player = (player == 'O') ? 'X' : 'O'; 
                        }
                    } 
                    else {
                        System.out.println("Invalid move :(");
                    }
                }
                break;
            }

            case 2:
                {
                
                print(board);
                
                while (!f) {
                    print(board);
                    if (player == 'X') {
                        user();  }
                    else 
                    {
                         computer();  }

                    if (wins(board, player)) {
                             print(board);
                        if (player == 'X') {
                            System.out.println("User won");
                        }
                        else {
                            System.out.println("Computer won");
                        }
                        f = true;
                    
                    }
                    else if(draw(board))
                    { print(board);
                        System.out.println("It is a draw");
                        break;
                    }
                    
                    else {
                        player = (player == 'X') ? 'O' : 'X'; 
                    }
                }
                break;
            }
                case 3:
                    {
                    System.out.println("Ending game");
                    break;
                }

            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }

    
    public static void computer() { 
        int i, j;
        while (true) {
            i = in.nextInt(board.length);
            j = in.nextInt(board.length);

            if (i >= 0 && i < board.length && j >= 0 && j < board.length && board[i][j] == ' ') {
                board[i][j] = 'X';
                System.out.println("Computer's move:" +i+ ","+ j);
                break;
            }
            else if(draw(board) && !wins(board, player)){
            System.out.println("it is a draw");
            break;
        }
            else
            {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    
    public static void user() {
        int n = board.length;
        boolean f = false;
        while (!f) {
            System.out.println("Enter your move");
            int i = sc.nextInt();
            int j = sc.nextInt();
            if (i >= 0 && i < n && j >= 0 && j < n && board[i][j] == ' ') {
                board[i][j] = 'O';
                break;
            } else if(draw(board))
            { System.out.println("IT IS A DRAW");
                break;}
                else{
                System.out.println("Invalid choice");
            }
        }
    }

   
    public static boolean wins(char[][] board, char player) {
        int i,j;
            for (i = 0; i < board.length; i++) 
            {
                boolean fr= true;
                boolean fc= true;
                for (j = 0; j < board.length; j++)
                {
                    if(board[i][j]!= player)
                    fr=false;
                    if(board[j][i]!= player)
                    fc=false;
                } 
                if(fc|| fr)
                return true;
            }
           
             boolean fl= true;
             boolean fr= true;
        for (i = 0; i < board.length; i++) {
            
            if (board[i][i] != player) {
                fl = false;
            }
            if (board[i][board.length - 1 - i] != player) {
                fr = false;
            }
        }
        return  (fl || fr);
    }
    
    public static boolean draw(char board[][])
    { int i,j; boolean f=true;;
        for(i=0; i<board.length; i++)
        {
            for(j=0; j<board.length; j++)
            {
        if(board[i][j] ==' ')
        {
            f=false;
    }
}
}
    return f;
    }
 
    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|"+ "___"+ board[i][j] );
            }
            System.out.println();
        }
    }
}

