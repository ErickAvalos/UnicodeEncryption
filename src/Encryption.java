import java.io.*;
import java.util.Scanner;

/**
 * This program is designed to encrypt alphanumeric values from
 * a file submitted by the user into Unicode values.  The newly
 * generated values are then written into a new and separate file.
 *
 * @author Erick Avalos and Jose Reyes
 * @since 2018-03-30
 */

public class Encryption{// begin class

    /**
     * The main method which calls the operational methods
     */
    public static void main(String [] args) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file name:\n"+
                "(please include file type)");
        String s = input.nextLine();
        String info = readFile(s);
        String name = removeLast4Chars(s);
        String encryption = getUnicode(info);
        writeToFile(name, encryption);
    }

    /**
     * The purpose of this method is to read the
     * file submitted by the user and return the
     * information of the file as a String.
     *
     * @param s This is the name of the file to be read
     * @return info Returns the content of the file
     */
    public static String readFile(String s) throws IOException{
        Scanner scan = new Scanner(new File(s));
        String info = "";
        while(scan.hasNext()){
            info = scan.nextLine();
        }
        return info;
    }

    /**
     * The purpose of this method is to receive the
     * name of the file as a String and remove the last
     * 4 characters of the file name.  This is done in
     * order to prep and return the name for the new file
     * to be written.
     *
     * @param s This is the name of the file
     * @return name Returns the name of the file
     *              without the last 4 characters
     */
    public static String removeLast4Chars(String s){
        String name = s.split("\\.")[0];
        return name;
    }

    /**
     * The purpose of this method is to receive the
     * contents of the file and generate Unicode and
     * to return the Unicode values.
     *
     * @param info This is the contents of the file
     * @return encryption Returns the newly generated
     *                    Unicode values
     */
    public static String getUnicode(String info){
        int length = info.length();
        int unicode = 0;
        String encryption = "";
        for(int i = 0; i < length; i++){
            unicode = (int) info.charAt(i);
            encryption += Integer.toString(unicode);
            encryption += " ";
        }
        return encryption;
    }

    /**
     * The purpose of this method is to receive the file name
     * and Unicode values, then write the Unicode values
     * onto a new file with the same name, plus "output.txt"
     *
     * @param name The shortened name of the original file
     * @param encryption The Unicode values of the contents
     *                   of the file
     */
    public static void writeToFile(String name, String encryption) throws IOException{
        name += "Output.txt";
        PrintWriter print = new PrintWriter(name);
        print.println(encryption);
        print.close();
    }
}// end class