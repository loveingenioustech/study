package demo.strings;

public class StringsDemo
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String filename = "test.xls";
        if (filename.endsWith(".txt"))
        {
            System.out.println("Text file");
        }
        else if (filename.endsWith(".doc"))
        {
            System.out.println("Document file");
        }
        else if (filename.endsWith(".xls"))
        {
            System.out.println("Excel file");
        }
        else if (filename.endsWith(".java"))
        {
            System.out.println("Java source file");
        }
        else
        {
            System.out.println("Other type of file");
        }

    }

}
