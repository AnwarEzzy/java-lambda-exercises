import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
public class Main {
    public static void main(String[] args) {

        //Exercice 5
        Operation addition = (a, b) -> a + b;
        Operation soustraction = (a, b) -> a - b;
        Operation produit = (a, b) -> a * b;
        Integer[] numbers = new Integer[]{1, 2, 3, 4};
        int somme = 0;
        int prod = 1;

        for (Integer n : numbers) {
            somme = addition.calculer(somme, n);
            prod = produit.calculer(prod, n);
        }

        System.out.println("la somme est:" + somme);
        System.out.println("le produit est:" + prod);

        System.out.println("-------------------------------------------------------");
        //Exercice 6
        Filter test = (s) -> s.startsWith("A");
        String[] names = {"Ananas", "Banane", "Abricot", "Cerise"};
        for (String name : names) {
            if (test.verifier(name)) {
                System.out.println(name);
            }
        }
        System.out.println("-------------------------------------------------------");

        //Exercice 7
        Calculateur division = (a, b) -> a / b;
        Calculateur puissance = (a, b) -> Math.pow(a, b);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        System.out.println("division: " + division.effectuer(number1, number2));
        System.out.println("puissance: " + puissance.effectuer(number1, number2));

        System.out.println("-------------------------------------------------------");

        //Exercice 8
        int[] numbs = {12, 5, 8, 20};

        Compareur max = (a, b) -> (a > b) ? a : b;

        int largest = numbs[0]; // start with the first element
        for (int i = 1; i < numbs.length; i++) {
            largest = max.comparer(largest, numbs[i]);
        }

        System.out.println("Le plus grand est: " + largest);

        System.out.println("-------------------------------------------------------");

        //Exercice 9

        Predicate<Integer> Sup = n -> n > 10;

        Integer[] nbs = {5, 12, 7, 18, 3};

        for (Integer n : nbs) {
            System.out.println("nombre " + n + " est : " + Sup.test(n));
        }
        System.out.println("-------------------------------------------------------");

        //Exercice 10

        List<String> animaux = new ArrayList<>(Arrays.asList("chat", "chien", "cheval"));

        for (String animal : animaux) {
            System.out.println(animal.toUpperCase());
        }
        animaux.sort(String::compareTo);
        animaux.forEach(System.out::println);

        System.out.println("-------------------------------------------------------");

        //Exercice 11

        VerifierPalindrome verifier = s -> {
            int n = s.length();
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - 1 - i)) {
                    return false;
                }
            }
            return true;
        };

        String[] mots = {"kayak", "java", "radar", "lambda"};

        for (String mot : mots) {
            if (verifier.estPalindrome(mot)) {
                System.out.println(mot + " est un palindrome.");
            } else {
                System.out.println(mot + " n'est pas un palindrome.");
            }

        }

        System.out.println("-------------------------------------------------------");

        //Exercice 12

        int[] tableau = {1, 2, 3, 4, 5, 6};

        OperationTableau som = t -> {
            int total = 0;
            for (int n : t) {
                total += n;
            }
            System.out.println("La somme des elements est : " + total);
        };

        OperationTableau afficherPairs = t -> {
            System.out.print("Elements pairs : ");
            for (int n : t) {
                if (n % 2 == 0) {
                    System.out.print(n + " ");
                }
            }
            System.out.println();
        };
        som.effectuer(tableau);
        afficherPairs.effectuer(tableau);

        System.out.println("-------------------------------------------------------");

        //Exercice 13

        BiFunction<Integer, Integer, Integer> aireRectangle = (longueur, largeur) -> longueur * largeur;

        // Test cases
        System.out.println("Aire de 5x3 : " + aireRectangle.apply(5, 3));
        System.out.println("Aire de 7x2 : " + aireRectangle.apply(7, 2));

        System.out.println("-------------------------------------------------------");

        //Exercice 14

        Comparateur comparerLongueur = (s1, s2) -> s1.length() > s2.length();

        String[] fruits = {"orange", "pomme", "cerise"};

        for (int i = 0; i < fruits.length - 1; i++) {
            String f1 = fruits[i];
            String f2 = fruits[i + 1];
            if (comparerLongueur.comparer(f1, f2)) {
                System.out.println(f1 + " est plus long que " + f2);
            } else {
                System.out.println(f1 + " n'est pas plus long que " + f2);
            }

        }
    }
}

