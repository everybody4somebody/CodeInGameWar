import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        Queue<String> hand1 = new LinkedList<>();
        Queue<String> hand2 = new LinkedList<>();
        
        Queue<String> war1 = new LinkedList<>();
        Queue<String> war2 = new LinkedList<>();
        
        Map values = new HashMap();
        values.put("J", "11");
        values.put("Q", "12");        
        values.put("K", "13");        
        values.put("A", "14");        
        
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            hand1.add(in.next());
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            hand2.add(in.next());
        }
        int numTurns = 0;
        while(!hand1.isEmpty() && !hand2.isEmpty()){
            String card1 = hand1.remove();
            String card2 = hand2.remove();
            
            String cardVal1 = card1.substring(0, card1.length() - 1);
            String cardVal2 = card2.substring(0, card2.length() - 1);
            
            if(values.containsKey(cardVal1))
                cardVal1 = (String)values.get(cardVal1);
            if(values.containsKey(cardVal2))
                cardVal2 = (String)values.get(cardVal2);
            
            int numVal1 = Integer.parseInt(cardVal1);
            int numVal2 = Integer.parseInt(cardVal2);
            
            System.err.println("----------------ROUND: " + (numTurns + 1) + "---------------");
            System.err.println("Player 1: " + numVal1);
            System.err.println("Player 2: " + numVal2);
            if(numVal1 > numVal2){
                System.err.println("Player 1 wins");
                
                while(!war1.isEmpty()){
                    hand1.add(war1.remove());
                }
                hand1.add(card1);
                
                while(!war2.isEmpty()){
                    hand1.add(war2.remove());
                }
                hand1.add(card2);
                
                numTurns++;
            
            } else if (numVal2 > numVal1){
                System.err.println("Player 2 wins");
                
                while(!war1.isEmpty()){
                    hand2.add(war1.remove());
                }
                hand2.add(card1);
                
                
                while(!war2.isEmpty()){
                    hand2.add(war2.remove());
                }
                hand2.add(card2);
                
                numTurns++;
                

            } else {
                System.err.println("-------------WAR------------");
                war1.add(card1);
                war2.add(card2);
                for(int i = 0; i < 3; i++){
                    if(!hand1.isEmpty()){
                        System.err.println("Player 1 war cards: " + (String)hand1.peek());
                        war1.add(hand1.remove());
                    }
                    if(!hand2.isEmpty()){
                        System.err.println("Player 2 war cards: " + (String)hand2.peek());
                        war2.add(hand2.remove());
                    }
                }
            }
            
        }
        
        if(war1.isEmpty() && war2.isEmpty()){
            if(hand2.isEmpty()){
                System.out.println("1 " + numTurns);
            } else {
                System.out.println("2 " + numTurns);
            }
        } else {
            System.out.println("PAT");
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
}
