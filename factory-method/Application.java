import java.util.Scanner;

interface Ethnicity {
    public String greet();
}

class Taiwanese implements Ethnicity {
    public String greet() {
        return "你好";
    }
}

class Japanese implements Ethnicity {
    public String greet() {
        return "\u3053\u3093\u306B\u3061\u306F";
    }
}

class American implements Ethnicity {
    public String greet() {
        return "Hi";
    }
}


abstract class GreetingBot {
    public abstract Ethnicity createBot();

    public void greet() {
        Ethnicity ethnicity = this.createBot();
        System.out.println("Bot: " + ethnicity.greet());
    }
}

class TaiwaneseGreetingBot extends GreetingBot {
    public Ethnicity createBot() {
        return new Taiwanese();
    }
}

class JapaneseGreetingBot extends GreetingBot {
    public Ethnicity createBot() {
        return new Japanese();
    }
}

class AmericanGreetingBot extends GreetingBot {
    public Ethnicity createBot() {
        return new American();
    }
}

class Application {
    public static void main(String args[]){
        System.out.println("Choose a language option:");
        System.out.println("1. Taiwanese");
        System.out.println("2. Japanese");
        System.out.println("3. American");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        int selectedOption = 0;
        GreetingBot bot = null;

        while (true) {
            while (selectedOption < 1 || selectedOption > 4) {
                System.out.println("");
                System.out.print("Enter the number of your choice (1-4): ");
                if (scanner.hasNextInt()) {
                    selectedOption = scanner.nextInt();
                } else {
                    scanner.next();
                }
            }

            switch (selectedOption) {
                case 1:
                    bot = new TaiwaneseGreetingBot();
                    break;
                case 2:
                    bot = new JapaneseGreetingBot();
                    break;
                case 3:
                    bot = new AmericanGreetingBot();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
                    break;
            }
            if (bot != null) {
                bot.greet();
            }
            bot = null;
            selectedOption = 0;
        }
    }
}
