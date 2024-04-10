package com.example.hangmangame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordData {

    private static final Map<String, String> hangmanDictionary = new HashMap<>();

    static {
        hangmanDictionary.put("APPLE", "A common red fruit");
        hangmanDictionary.put("BANANA", "A yellow fruit that monkeys love to eat");
        hangmanDictionary.put("WHITE", "A popular color for wedding days");
        hangmanDictionary.put("WINTER", "A season with cold weather and snow");
        hangmanDictionary.put("DOG", "A very loyal animal");
        hangmanDictionary.put("CAT", "An animal that says 'meow'");
        hangmanDictionary.put("RED", "A popular color at Christmas");
        hangmanDictionary.put("BEE", "a small, flying insect that produces honey");
        hangmanDictionary.put("ROSE", "A type of flower often associated with love and romance");
        hangmanDictionary.put("PARIS", "what city is knows as the 'City of love?'");
        hangmanDictionary.put("ZEBRA", "An animal know for is black and white stripes");
        hangmanDictionary.put("AIRPLANE", "A vehicle used for flying through the sky");
        hangmanDictionary.put("SUMMER", "A season known for warm weather and beaches");
        hangmanDictionary.put("CAR", "A vehicle with four wheels and a horn");
        hangmanDictionary.put("RABBIT", "An animal with long ears that hops");
        hangmanDictionary.put("LEMON", "A small, yellow fruit often used in pies");
        hangmanDictionary.put("JAPAN", "A country with the capital city of Tokyo");
        hangmanDictionary.put("ROME", "A city known as the 'Eternal City' and the capital of Italy");
        hangmanDictionary.put("HOCKEY", "A sport played on ice with a puck");
        hangmanDictionary.put("MONA LISA", "A famous painting with a woman smiling");
        hangmanDictionary.put("GUITAR", "A musical instrument often associated with country music");
        hangmanDictionary.put("MOON", "A celestial body that orbits the Earth");
        hangmanDictionary.put("TENNIS", "A sport where players hit a small ball over a net");
        hangmanDictionary.put("TEA", "A beverage made from dried leaves, often with various flavors");
        hangmanDictionary.put("JAVA", "A programming language");
        hangmanDictionary.put("COFFEE", "A beverage made from coffee beans");
        hangmanDictionary.put("CHOCOLATE", "Delicious food made from cocoa");
        hangmanDictionary.put("OCEAN", "A large area of salt water");
        hangmanDictionary.put("UMBRELLA", "An object used to cover the rain");
    }

    public static List<Map.Entry<String, String>> getHangmanList() {
        return List.copyOf(hangmanDictionary.entrySet());
    }

    public static int getHangmanDictionaryLength() {
        return hangmanDictionary.size();
    }
}
