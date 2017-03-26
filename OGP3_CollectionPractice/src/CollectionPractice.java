import java.util.*;

/**
 * Created by Arthur on 26-3-2017.
 */
public class CollectionPractice
{
    public static void main(String[] args)
    {
        CollectionPractice collectionPractice = new CollectionPractice();
    }

    public CollectionPractice()
    {
        System.out.println("---Running Array to List-------------------------------------------");
        arrayToList();
        System.out.println("---Running List to Array-------------------------------------------");
        arrayToList();
        System.out.println("---Stack-------------------------------------------");
        stack();
    }

    public void arrayToList()
    {
        Integer[] intArray = new Integer[1000];

        for(int i = 0; i < 1000; i++)
        {
            intArray[i] = i;
        }

        System.out.println(intArray.length);

        List<Integer> intList = Arrays.asList(intArray);

        System.out.println(intList.size());
    }

    public void listToArray()
    {
        List<Integer> integerList = new ArrayList<>();

        for(int i = 0; i < 1000; i++)
        {
            integerList.add(i);
        }

        System.out.println(integerList.size());

        Integer[] integerArray = new Integer[integerList.size()];
        integerArray = integerList.toArray(integerArray);

        System.out.println(integerArray.length);
    }

    public void stack()
    {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < 10; i++)
        {
            stack.add(i);
        }

        while (!stack.empty())
        {
            System.out.println(stack.pop());
        }
    }
}
