// This question is asked in TCS smart hiring on 2 july 2024.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinGame {
    public static void main(String[] args){
        //Taking Input from user (m and n)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Friends : ");
        int m = scanner.nextInt();

        System.out.print("Enter the Number of Coins : ");
        int n = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter the list of coins(give space between two coins) : ");
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = scanner.nextInt();
        }

        int result = simulateGame(n, m , coins, scanner);
        System.out.println("Total sum of coins Jack has: " + result);
    }

    private static int simulateGame(int n, int m, int[] coins, Scanner scanner){
        List<Integer> jackcoins = new ArrayList<>();
        List<Integer> coinslist = new ArrayList<>();

        //covert input array in to list 
        for(int coin : coins){
            coinslist.add(coin);
        }

        int turn = 0;
        while (!coinslist.isEmpty()) {
            
            if (turn%(m+1)==0) { //jack turn
                System.out.println("Jack's tuns : ");
            }else{ //friends turn
                System.out.println("Friend"+ (turn%(m+1)) +"'s turn : ");
            }

            System.out.print("Enter the coin to pick : ");  
            int pick = scanner.nextInt();
            scanner.nextLine();
            
            if (turn%(m+1)==0) { //if jacks turn then add coin to jackcoin list
                for(int i=0; i < coinslist.size(); i++){
                    if (coinslist.get(i)== pick) {
                        jackcoins.add(pick);
                    }
                }
            }


            //remove selected pick coins
            while (coinslist.contains(pick)) {
                coinslist.remove((Integer) pick);
            }

            turn++;
        }

        //Calculate sum of jackcoins
        int sum = 0;
        for(int coin : jackcoins){
            sum+=coin;
        }

        return sum;
    }
}
