import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Arthur on 24-3-2017.
 */
public class FileIO implements Serializable {

    String filePath;
    File file;

    public static void main(String[] args)
    {
        FileIO fileIO = new FileIO();
    }

    public FileIO()
    {
        filePath = "OGP3_FileIO_Practice/src/test.txt";
        file = new File(filePath);

        System.out.println("---Running File information-------------------------------------------");
        fileInformation();
        //System.out.println("---Running File structure-------------------------------------------");
        //fileStructure();
        System.out.println("---Running PrintFile-------------------------------------------");
        printFile();
        System.out.println("---Running CreateFile-------------------------------------------");
        createNewFile();
        System.out.println("---Running Print Web Data-------------------------------------------");
        readWebData();
    }

    public boolean fileExists()
    {
        if(!file.exists())
        {
            System.out.println("The file was not found.");
            return false;
        }
        else
        {
            System.out.println("The file exists.");
            return true;
        }
    }

    public void fileInformation()
    {
        if(fileExists())
        {
            if(file.canRead())
                System.out.println("The file can be read.");
            else
                System.out.println("The file cannot be read.");

            if(file.canExecute())
                System.out.println("The file can be executed.");
            else
                System.out.println("The file cannot be executed.");

            if(file.canWrite())
                System.out.println("The file can be written.");
            else
                System.out.println("The file cannot be written.");

            System.out.println("The file path is: " + file.getAbsolutePath());
        }
    }

    public void printFile()
    {
        if(file.exists())
        {
            Scanner readFile = null;
            try
            {
                readFile = new Scanner(file);

                while (readFile.hasNextLine())
                {
                    System.out.println(readFile.nextLine());
                }
                readFile.close();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void createNewFile()
    {
        String filePath = "OGP3_FileIO_Practice/src/fileWriteTest.txt";

        try
        {
            PrintWriter newFile = new PrintWriter(filePath);

            for(int i = 1; i < 1001; i++)
                newFile.println(i);
            newFile.close();

            File createdFile = new File(filePath);
            if(createdFile.exists())
                System.out.println("The file was successfully created.");
            else
                System.out.println("The file was not created.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void readWebData()
    {
        String filePath = "OGP3_FileIO_Practice/src/urlTest.txt";
        ArrayList<String> lines = new ArrayList<>();

        try
        {
            PrintWriter newFile = new PrintWriter(filePath);

            try
            {
                URL url = new URL("http://www.nu.nl/");
                try
                {
                    Scanner scanner = new Scanner(url.openStream());
                    System.out.println(scanner.hasNext());
                    while(scanner.hasNextLine())
                    {
                        newFile.println(scanner.nextLine());
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

            newFile.close();

            File createdFile = new File(filePath);
            if(createdFile.exists())
            {
                System.out.println("The file was successfully created.");
            }
            else
            {
                System.out.println("The file was not created.");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /*
    public void fileStructure()
    {
        if(fileExists())
        {
            String filePath = file.getAbsolutePath();
            String[] path = filePath.split("\\'\'");
            System.out.println(path[0]);

            for(int i = 0; i < path.length; i++)
            {
                System.out.println(path[i]);
            }
        }
    }
    */

}
