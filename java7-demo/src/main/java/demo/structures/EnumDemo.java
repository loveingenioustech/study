package demo.structures;

import java.util.Arrays;

public class EnumDemo
{

    public static void main(String[] args)
    {
        demo1();

        demo2();
    }

    private static void printValid(IntelligentFieldType field, String fieldValue, boolean valid)
    {
        System.out.println(field.getFieldName() + "(\"" + fieldValue + "\") valid: " + valid);
    }

    /**
     * 
     */
    private static void demo1()
    {
        FieldType field = FieldType.EMAIL_ADDRESS;
        System.out.println("field.name(): " + field.name());
        System.out.println("field.ordinal(): " + field.ordinal());
        System.out.println("field.toString(): " + field.toString());
        System.out.println("field.isEqual(EMAIL_ADDRESS): " + field.equals(FieldType.EMAIL_ADDRESS));
        System.out.println("field.isEqual(\"EMAIL_ADDRESS\"'): " + field.equals("EMAIL_ADDRESS"));
        System.out.println("field == EMAIL_ADDRESS: " + (field == FieldType.EMAIL_ADDRESS));
        // Won’t compile – illustrates type safety of enum
        // System.out.println("field == \”EMAIL_ADDRESS\": " + (field ==
        // "EMAIL_ADDRESS"));
        System.out.println("field.compareTo(EMAIL_ADDRESS): " + field.compareTo(FieldType.EMAIL_ADDRESS));
        System.out.println("field.compareTo(PASSWORD): " + field.compareTo(FieldType.PASSWORD));
        System.out.println("field.valueOf(\"EMAIL_ADDRESS\"): " + field.valueOf("EMAIL_ADDRESS"));
        try
        {
            System.out.print("field.valueOf(\"email_address\"): ");
            System.out.println(FieldType.valueOf("email_address"));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.toString());
        }

        System.out.println("FieldType.values(): " + Arrays.toString(FieldType.values()));
    }

    private static void demo2()
    {
        String fieldName = "password";
        String fieldValue = "1Cxy9"; // invalid - must be at least 6 characters
        IntelligentFieldType field = IntelligentFieldType.lookup(fieldName);
        printValid(field, fieldValue, field.validate(fieldValue));
        fieldName = "phone";
        fieldValue = "1-800-555-1234"; // valid
        field = IntelligentFieldType.lookup(fieldName);
        printValid(field, fieldValue, field.validate(fieldValue));
        fieldName = "email";
        fieldValue = "john@doe"; // invalid - missing .<tld>
        field = IntelligentFieldType.lookup(fieldName);
        printValid(field, fieldValue, field.validate(fieldValue));
        fieldName = "ssn";
        fieldValue = "111-11-1111"; // valid
        field = IntelligentFieldType.lookup(fieldName);
        printValid(field, fieldValue, field.validate(fieldValue));
    }

}
