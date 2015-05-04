package demo.numbers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumbersDemo
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        NumbersDemo nd = new NumbersDemo();
        float myFloat = 1.1f;
        System.out.println(nd.roundFloatToInt(myFloat));

        double myDouble = 1.1d;
        System.out.println(nd.roundDoubleToLong(myDouble));

        System.out.println(nd.formatDouble(myDouble));

        BigDecimal currencyOne = new BigDecimal("25.65");
        BigDecimal currencyTwo = new BigDecimal("187.32");
        BigDecimal currencyThree = new BigDecimal("4.86");
        BigDecimal result = null;
        String printFormat = null;
        // Add all three values
        result = currencyOne.add(currencyTwo).add(currencyThree);
        // Convert to double and send to formatDollars(), returning a String
        printFormat = nd.formatDollars(result.doubleValue());
        System.out.println(printFormat);
        // Subtract the first currency value from the second
        result = currencyTwo.subtract(currencyOne);
        printFormat = nd.formatDollars(result.doubleValue());
        System.out.println(printFormat);

        // Readable Numeric Literals
        int million = 1_000_000;
        int billion = 1_000_000_000;
        float ten_pct = 1_0f;
        double exp = 1_234_56.78_9e2;
        System.out.println(million);
        System.out.println(billion);
        System.out.println(ten_pct);
        System.out.println(exp);
    }

    public int roundFloatToInt(float myFloat)
    {
        return Math.round(myFloat);
    }

    public long roundDoubleToLong(double myDouble)
    {
        return Math.round(myDouble);
    }

    public String formatDouble(double myDouble)
    {
        NumberFormat numberFormatter = new DecimalFormat("##.000");
        return numberFormatter.format(myDouble);
    }

    public String formatDollars(double value)
    {
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return dollarFormat.format(value);
    }
}
