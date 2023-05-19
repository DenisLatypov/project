import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bot {
    private String botToken;

    public Bot() {
        loadConfig();
    }

    private void loadConfig() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
            botToken = properties.getProperty("6001712224:AAH3NkWv-7k3QlHfk-OUYcHQCdrIRwoWQYg");
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<String> trackedLinks;


    public void start() {
        System.out.println("Bot started and restarted.");
    }

    public void help() {
        System.out.println("Available commands:");
        System.out.println("/start - start and restart the bot");
        System.out.println("/help - display available commands");
        System.out.println("/track \"github_link\" - start tracking a GitHub link");
        System.out.println("/untrack \"github_link\" - stop tracking a GitHub link");
        System.out.println("/list - display the list of tracked links");
    }

    public void track(String link) {
        trackedLinks.add(link);
        System.out.println("Tracking link: " + link);
    }

    public void untrack(String link) {
        if (trackedLinks.remove(link)) {
            System.out.println("Stopped tracking link: " + link);
        } else {
            System.out.println("Link was not being tracked: " + link);
        }
    }

    public void list() {
        if (trackedLinks.isEmpty()) {
            System.out.println("No tracked links.");
        } else {
            System.out.println("Tracked links:");
            for (String link : trackedLinks) {
                System.out.println(link);
            }
        }
    }

    public static void main(String[] args) {
        Bot bot = new Bot();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the bot!");

        do {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            if (command.startsWith("/")) {
                String[] parts = command.split(" ", 2);
                String cmd = parts[0].toLowerCase();

                if (cmd.equals("/start")) {
                    bot.start();
                } else if (cmd.equals("/help")) {
                    bot.help();
                } else if (cmd.equals("/track")) {
                    if (parts.length > 1) {
                        String link = parts[1];
                        bot.track(link);
                    } else {
                        System.out.println("Invalid command. Usage: /track \"github_link\"");
                    }
                } else if (cmd.equals("/untrack")) {
                    if (parts.length > 1) {
                        String link = parts[1];
                        bot.untrack(link);
                    } else {
                        System.out.println("Invalid command. Usage: /untrack \"github_link\"");
                    }
                } else if (cmd.equals("/list")) {
                    bot.list();
                } else {
                    System.out.println("Unknown command. Type /help to see available commands.");
                }
            } else {
                System.out.println("Invalid command. Commands should start with '/'. Type /help to see available commands.");
            }
        } while (!command.equalsIgnoreCase("/exit"));

        System.out.println("Bot exited.");
        scanner.close();
    }
}
