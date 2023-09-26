import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("\"manual\" - you add your own characteristic");
        System.out.println("\"auto\" - you use predefined characteristics (fighters characteristics will be equal)");
        System.out.println(""" 
                Predefined characteristics:  
                Attack - 20
                Defense - 10
                Max HP - 150
                HP - 150
                Min DMG - 5
                Max DMG 20
                """);
        System.out.println("Type \"manual\" or \"auto\" to choose application mode");

        Scanner sc = new Scanner(System.in);
        String mode = sc.nextLine();
        if (mode.equals("manual")) {
            BattleField battleField = new BattleField();

            battleField.initFighters(sc);
            sc.close();

            battleField.fight();

        } else if (mode.equals("auto")) {
            sc.close();

            BattleField battleField = new BattleField();
            battleField.putPredefinedCharacteristic();
            battleField.fight();
        }
    }

}
