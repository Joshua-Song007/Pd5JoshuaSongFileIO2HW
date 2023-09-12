import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Pd5JoshuaSongFileIO2HW {
    public static void main (String []args) throws FileNotFoundException{
        FileChanger test = new FileChanger();
        test.bracketMover();
    }
}

class FileChanger{
    private Scanner reader;
        public FileChanger() throws FileNotFoundException{
            reader = new Scanner(new File("Test.java"));
        }
    

    public void bracketMover() throws FileNotFoundException{
        PrintStream result = new PrintStream("NextLineBraceStyle.txt");
        String currentLine = reader.nextLine();
        String nextLine = "";
        while(reader.hasNextLine()){
                nextLine = reader.nextLine();
                if(nextLine.equals("{")){
                    result.println(currentLine + nextLine);
                    if(reader.hasNextLine())
                    currentLine = reader.nextLine();
                    else
                    break;
                }
                else{
                    result.println(currentLine);
                    currentLine = nextLine;
                }
            }
        result.print(currentLine);
        result.close();
        result.flush();
        }
        
    }
