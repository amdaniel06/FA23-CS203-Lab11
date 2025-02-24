import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.*;
public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
         try{
            String message = readFile(inputFilePath);
            message = message.toLowerCase();
         for (int i = 0; i < message.length(); i++)
         {
            char P = message.charAt(i);
            if(Character.isLetter(P)){
                P = (char)((P - 'a' + shift + 26) % 26 + 'a');
            }
                String str = "" + P;
                String text = str;
                
        writeFile(text, encryptedFilePath);
        }}
        catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
        //TODO: Call the read method, encrypt the file contents, and then write to new file
    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        try{
            String message = readFile(messageFilePath);
        message = message.toLowerCase();
         for (int i = 0; i < message.length(); i++)
         {
            char P = message.charAt(i);
            if(Character.isLetter(P)){
                P = (char)((P - 'a' - shift + 26) % 26 + 'a');
            }
            String str = "" + P;
            String text = str;

        writeFile(text, decryptedFilePath);
        }}
        catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
         

    
}

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        String message = "";
        try (Scanner fileScanner = new Scanner(Paths.get(filePath))){
            while(fileScanner.hasNextLine()){
                String file = fileScanner.nextLine();
                message = message + file + "\n";
            } fileScanner.close();
        } catch (Exception e){
            System.out.println("ERROR: " + e.toString());
        }
        return message;
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) {
        try (PrintWriter output = new PrintWriter(filePath)){
            output.println(data);
            output.close();
        } catch (Exception e){
            System.out.println("ERROR: " + e.toString());
        }
        }
    

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
