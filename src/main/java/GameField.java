import player.data.Player;
import player.data.Referee;
import player.data.Status;
import player.data.Who;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static player.data.Status.*;

public class GameField {

    public static void main(String[] args) throws InterruptedException {
         Scanner scanner = new Scanner(System.in);
         List<String> listi = cardMatch.matchStart();

         Map<String, Long> collect = listi.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
         List<String>[] lists = cardMatch.distibuteCards(listi);
         List<String> remainigCards = lists[0];
         System.out.println("Enter your name");

         Player me = new Player(scanner.next(), OFF, lists[1], Who.USER);

         Player computer = new Player("Computer" , OFF , lists[2], Who.COMPUTER);
         TimeUnit.SECONDS.sleep(2);
         // DELAY
         System.out.println("Here is your initial list of cards");
         System.out.println(lists[1]);
         TimeUnit.SECONDS.sleep(4);
         // DELAY
         if(cardMatch.whoStart(me,computer).getPlayerName().equals(me.getPlayerName())) {
              me.setStatus(TURN);
              System.out.println("Your turn is the first");
         }
         else {
              computer.setStatus(TURN);
              System.out.println("The computer turn is the first");
         }


         String nextOrder = "";
         Referee referee = new Referee(me,computer,remainigCards,nextOrder);
         boolean gameEnded = false;
         nextOrder = referee.getFirstCard.get();

         while (gameEnded == false){
              nextOrder = me.handlePlayerChoices.apply(nextOrder);
              nextOrder = computer.handlePlayerChoices.apply(nextOrder);

              referee.setPlayer1(me);
              referee.setPlayer2(computer);
              nextOrder = referee.handleOutcome.apply(nextOrder);
              gameEnded = referee.handEndOfTheGame.test(listi);
              me = referee.getPlayer1();
              computer = referee.getPlayer2();
         }
         // Announcing the winner
         String winner = me.getStatus().equals(WIN) ? "Me" : "Computer";
         System.out.println("The winner of this game is " + winner);

      }

}

