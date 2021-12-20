import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe
 {
    static ArrayList<Integer> p1 = new
            ArrayList<Integer>();
      static ArrayList<Integer> p2 = new
            ArrayList<Integer>();

       public static void main(String[] args)
      {
        System.out.println("Welcome to TIC TAC TOE");
        System.out.println("By PIYUSH KARAN");
        char[][] gameboard =
                {
                        {' ', '+', '-', '+', '-', '+', '-', '+'},
                        {' ', '|', ',', '|', ',', '|', ',', '|'},
                        {' ', '+', '-', '+', '-', '+', '-', '+'},
                        {' ', '|', ',', '|', ',', '|', ',', '|'},
                        {' ', '+', '-', '+', '-', '+', '-', '+'},
                        {' ', '|', ',', '|', ',', '|', ',', '|'},
                        {' ', '+', '-', '+', '-', '+', '-', '+'},
                };
        printboard(gameboard);
        Scanner ip = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter the position for player 1(x)");
            int pos = ip.nextInt();
            while (p1.contains(pos) || p2.contains(p1)) {
                System.out.println("Position taken please enter correct position");
                pos = ip.nextInt();
            }
            placepiece(gameboard, pos, "Player 1");
            String whoWin = checkWinner();
            if  (whoWin.length() >0)
            {
                System.out.println(whoWin);
                break;
            }
            System.out.println("Enter the position for player 2(0)");
            int pos2 = ip.nextInt();
            while (p2.contains(pos2) || p1.contains(p2)) {
                System.out.println("Position taken please enter correct position");
                pos2 = ip.nextInt();
            }
            placepiece(gameboard, pos2, "player 2");

            whoWin = checkWinner();
            if (whoWin.length() > 0) {
                System.out.println(whoWin);
                break;
            }
        }
     }



    public static void printboard(char[][] gameboard)
    {
        for (int i = 0; i < gameboard.length; i++)
        {
            for (int j = 0; j < gameboard[i].length; j++)
            {
                System.out.print(" "+gameboard[i][j]);
            }
            System.out.println("");
        }
    }

    public static void placepiece(char[][] gameboard, int pos, String user)
    {
        char symbol = ' ';
        if (user.equals("Player 1"))
        {
            symbol = 'X';
            p1.add(pos);
        }
        else
        {
            symbol = 'O';
            p2.add(pos);
        }
        switch (pos)
        {
            case 1:
                gameboard[1][2] = symbol;
                break;
            case 2:
                gameboard[1][4] = symbol;
                break;
            case 3:
                gameboard[1][6] = symbol;
                break;
            case 4:
                gameboard[3][2] = symbol;
                break;
            case 5:
                gameboard[3][4] = symbol;
                break;
            case 6:
                gameboard[3][6] = symbol;
                break;
            case 7:
                gameboard[5][2] = symbol;
                break;
            case 8:
                gameboard[5][4] = symbol;
                break;
            case 9:
                gameboard[5][6] = symbol;
                break;

            default:
                System.out.println("Enter proper choice ");
        }
        printboard(gameboard);
    }

    public static String checkWinner() {
        List top = Arrays.asList(1 , 2 , 3);
        List mid = Arrays.asList(4, 5, 6);
        List bott = Arrays.asList(7, 8, 9);
        List left = Arrays.asList(1, 4, 7);
        List midc = Arrays.asList(2, 5, 8);
        List right = Arrays.asList(3, 6, 9);
        List c1 = Arrays.asList(1, 5, 9);
        List c2 = Arrays.asList(3, 5, 9);
        List<List> winner = new ArrayList<List>();
        winner.add(top);
        winner.add(mid);
        winner.add(bott);
        winner.add(left);
        winner.add(midc);
        winner.add(right);
        winner.add(c1);
        winner.add(c2);

        for (List l : winner) {
            if (p1.containsAll(l)) {
                return "Player 1 WIN";
            } else if (p2.containsAll(l)) {
                return "Player 2 WIN";
            } else if (p1.size() + p2.size() == 9) {
                return "TIE";
            }
        }
        return "";
    }
}










