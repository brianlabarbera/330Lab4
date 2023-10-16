import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.println("Enter URL:");
            String address = userInput.nextLine();

            URL pageLocation = new URL(address);

            System.out.println("Enter file to save data:");
            String fileName = userInput.nextLine();

            try (FileWriter fileWriter = new FileWriter(fileName)) {
                Scanner in = new Scanner(pageLocation.openStream());

                fileWriter.write(pageLocation.getHost() + "\n");
                fileWriter.write(pageLocation.getProtocol() + "\n");
                fileWriter.write(pageLocation.getFile() + "\n");
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while opening the URL: " + e.getMessage());
        }
    }
}