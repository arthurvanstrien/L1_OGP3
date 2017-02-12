/**
 * Created by Arthur on 10-2-2017.
 */
import java.util.*;

public class GroupingSymbolChecker
{
    public static void main(String[] args) throws Exception
    {
        List<String> stackOpening = new Stack<>();
        List<String> stackClosing = new Stack<>();
        String block;

        java.io.File file = new java.io.File("blub.txt");
        String nameAndExtension = file.getName();

        if(file.exists())
        {
            Scanner loadedFile = new Scanner(file);
            while (loadedFile.hasNext())
            {
                String characters[];
                block = loadedFile.next();

                characters = block.split("(?!^)");

                for(int i = 0; i < characters.length; i++)
                {
                    String character = characters[i];
                    if(character.equals("{") || character.equals("(") || character.equals("["))
                    {
                        stackOpening.add(block);
                    }
                    else if(character.equals("}") || character.equals(")") || character.equals("]"))
                    {
                        stackClosing.add(character);
                    }
                }
                //ELSE: Other character found that we do not need.
            }
            loadedFile.close();
        }
        else
        {
            System.out.println("Het bestand dat u heeft opgegeven bestaat niet.");
        }

        if(compareStacks(stackOpening, stackClosing) == true)
        {
            System.out.println("De haakjes in " + nameAndExtension + " zijn in orde.");
        }
        else
        {
            System.out.println("Er zitten fouten in het gecontroleerde bestand: " + nameAndExtension);
        }
    }

    public static boolean compareStacks(List stack1, List stack2)
    {
        String valueStack1;
        String valueStack2;

        if(stack1.size() != stack2.size())
        {
            return false;
        }

        for(int i = 0; i < stack1.size(); i++)
        {
            if(stack1.equals("{") && !stack2.equals("}"))
            {
                return false;
            }
            else if(stack1.equals("(") && !stack2.equals(")"))
            {
                return false;
            }
            else if(stack1.equals("[") && !stack2.equals("]"))
            {
                return false;
            }
        }

        return true;
    }
}
