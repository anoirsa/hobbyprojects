import player.data.Player;
import player.data.Status;
import testing.Person;

import java.util.*;
import java.util.function.Predicate;

import static player.data.Status.OFF;
import static player.data.Status.valueOf;

public class testClass {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> lisit = List.of("go","mo","od");
        Random rn = new Random();
        int newsd = rn.nextInt(lisit.size());
        System.out.println(newsd);
    }



}
