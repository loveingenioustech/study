package demo.basic;

import java.util.Map;

public class EnvVars
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Map<String, String> vars = System.getenv();

        for (String var : vars.keySet())
        {
            System.out.println(var + " = " + vars.get(var));
        }
    }

}
