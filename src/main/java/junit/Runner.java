package junit;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        Deck deck = new Deck(true);

        Card[] shuffledCards = deck.shuffle();
        System.out.println("---------- Shuffled cards ----------");
        Arrays.stream(shuffledCards).forEach(System.out::println);

        Card[] sortedCards = deck.sort();
        System.out.println("---------- Sorted cards ----------");
        Arrays.stream(sortedCards).forEach(System.out::println);

        Card first = deck.getFirst();
        System.out.println("---------- First card ----------");
        System.out.println(first);

        boolean hasJoker = deck.isHasJoker();
        System.out.println("---------- Has joker ----------");
        System.out.println(hasJoker);
    }

}
