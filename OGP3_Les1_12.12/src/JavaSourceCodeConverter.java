/**
 * Created by Arthur on 3-2-2017.
 */
import java.lang.reflect.Array;
import java.util.Scanner;

public class JavaSourceCodeConverter
{
    public static void main(String[] args) throws Exception
    {
        String previousLine = "";
        String fileName = "";
        String fileExtension = "";
        String oneLine = "";
        boolean skipLine = false;

        java.io.File file = new java.io.File("blub.txt");
        String nameAndExtension = file.getName();
        String[] parts = nameAndExtension.split("\\.");
        fileName = parts[0];
        fileExtension = parts[1];
        java.io.PrintWriter outputFile = new java.io.PrintWriter(fileName + "_Edited." + fileExtension);

        if(file.exists())
        {
            Scanner loadedFile = new Scanner(file);
            while (loadedFile.hasNextLine())
            {
                oneLine = loadedFile.nextLine();
                oneLine = oneLine.trim();

                if (oneLine.equals("{"))
                {
                    previousLine = previousLine + " {";
                    outputFile.println(previousLine);
                    skipLine = true;
                }
                else if(skipLine == true)
                {
                    skipLine = false;
                    previousLine = oneLine;
                }
                else
                {
                    outputFile.println(previousLine);
                    previousLine = oneLine;
                }
            }
            outputFile.print(oneLine);


            outputFile.close();
            loadedFile.close();
        }
        else
        {
            System.out.println("Het bestand dat u heeft opgegeven bestaat niet.");
        }
    }
}
