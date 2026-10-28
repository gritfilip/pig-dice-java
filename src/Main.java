import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Spelet Pig dice, två spelare möts i ett tärningsspel.
        // Först till 50 vinner, man turas om och poäng sparas per runda.
        // Per runda slår man en tärning hur många gånger man vill.
        // Slår man en 1:a förlorar man alla poäng ifrån den rundan och det går över till nästa spelares tur.

        // Scanner och Random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Variabel för spelarnas poäng (2st)
        int totalPoangSpelare1 = 0;
        int totalPoangSpelare2 = 0;

        // Variabel för spelarnas poäng per runda
        int rundaPoangSpelare = 0;

        // Tärning
        int tarningsKast = 0;

        // Variabel boolean spelSlut = false
        boolean spelSlut = false;

        // Konstant för se vinnare
        final int VINST_POANG = 50;

        IO.println("""
                🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🐷🐷🐷🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲
                                  PIG DICE

                Två spelare möts i ett tärningsspel.
                Först till %d poäng vinner.
                Man turas om att kasta tärningen, och kastar så många gånger man vill.
                Stannar man sparas rundans poäng.
                Slår man en 1:a försvinner rundans poäng, och turen går över.

                🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🐷🐷🐷🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲
                """.formatted(VINST_POANG));

        // While loop, spelet startar med spelSlut
        while (!spelSlut) {

            // While loop för spelare 1 pågår
            while (true) {
                // spelare 1 slår tärning, random från 1 - 6
                tarningsKast = random.nextInt(1, 7);
                rundaPoangSpelare += tarningsKast;

                IO.println("Spelare 1 kastade " + tarningsKast + " 🎲");
                IO.println("Dina poäng för denna runda är nu: " + rundaPoangSpelare);
                if (totalPoangSpelare1 > 0) {
                    IO.println("Dina totala poäng är: " + totalPoangSpelare1);
                }

                // poäng för rundan försvinner vid tärningslag 1 och turen tar slut
                if (tarningsKast == 1) {
                    rundaPoangSpelare = 0;
                    IO.println("Tyvärr du kastade en 1a, dina poäng för denna runda är borta och det är nästa spelares tur");
                    IO.println();
                    IO.println("🎲🎲🎲🎲🎲🎲");
                    break;
                }

                // Fråga om spelare 1 vill slå igen (Y/N)
                IO.print("Vill du kasta igen?: (Y/N) ");
                String slaIgen = scanner.nextLine();

                if (slaIgen.equalsIgnoreCase("Y")) {
                    continue;
                }
                // spara rundans poäng i totalen och nollställ rundaPoangSpelare
                else {
                    totalPoangSpelare1 += rundaPoangSpelare;
                    rundaPoangSpelare = 0;
                    IO.println("Totala poäng är nu: " + totalPoangSpelare1);

                    // har spelaren nått vinstgränsen?
                    if (totalPoangSpelare1 >= VINST_POANG) {
                        spelSlut = true;
                        IO.println("""
                                🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆
                                🏆 SPELARE 1 HAR VUNNIT 🏆
                                🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆
                                """);
                    }
                    break;
                }
            }

            // om spelare 1 vann ska spelare 2 inte få spela
            if (spelSlut) {
                break;
            }

            // While loop för spelare 2 pågår
            while (true) {
                // spelare 2 slår tärning, random från 1 - 6
                tarningsKast = random.nextInt(1, 7);
                rundaPoangSpelare += tarningsKast;

                IO.println("Spelare 2 kastade " + tarningsKast + " 🎲");
                IO.println("Dina poäng för denna runda är nu: " + rundaPoangSpelare);
                if (totalPoangSpelare2 > 0) {
                    IO.println("Dina totala poäng är: " + totalPoangSpelare2);
                }

                // poäng för rundan försvinner vid tärningslag 1 och turen tar slut
                if (tarningsKast == 1) {
                    rundaPoangSpelare = 0;
                    IO.println("Tyvärr du kastade en 1a, dina poäng för denna runda är borta och det är nästa spelares tur");
                    IO.println("🎲🎲🎲🎲🎲🎲");
                    break;
                }

                // Fråga om spelare 2 vill slå igen (Y/N)
                IO.print("Vill du kasta igen? (Y/N) ");
                String slaIgen = scanner.nextLine();

                if (slaIgen.equalsIgnoreCase("Y")) {
                    continue;
                }
                // spara rundans poäng i totalen och nollställ rundaPoangSpelare
                else {
                    totalPoangSpelare2 += rundaPoangSpelare;
                    rundaPoangSpelare = 0;
                    IO.println("Totala poäng är nu: " + totalPoangSpelare2);

                    // har spelaren nått vinstgränsen?
                    if (totalPoangSpelare2 >= VINST_POANG) {
                        IO.println("""
                                🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆
                                🏆 SPELARE 2 HAR VUNNIT 🏆
                                🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆
                                """);
                        spelSlut = true;
                    }
                    break;
                }
            }
        }   // while loop för hela spelet slut
    }
}