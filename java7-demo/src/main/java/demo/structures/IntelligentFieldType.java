package demo.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public enum IntelligentFieldType
{
    PASSWORD("password")
    {
        // A password must contain one or more digits, one or more lowercase
        // letters, one or
        // more uppercase letters, and be a minimum of 6 characters in length.
        //
        @Override
        public boolean validate(String fieldValue)
        {
            return Pattern.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})", fieldValue);
        }
    },
    EMAIL_ADDRESS("email")
    {
        // An email address begins with a combination of alphanumeric
        // characters, periods,
        // and hyphens, followed by a mandatory ampersand (‘@’) character,
        // followed by
        // a combination of alphanumeric characters (hyphens allowed), followed
        // by a
        // one or more periods (to separate domains and subdomains), and ending
        // in 2-4

        // alphabetic characters representing the domain.
        //
        @Override
        public boolean validate(String fieldValue)
        {
            return Pattern.matches("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z|a-z]{2,4}$", fieldValue);
        }
    },
    PHONE_NUMBER("phone")
    {
        // A phone number must contain a minium of 7 digits. Three optional
        // digits
        // representing the area code may appear in front of the main 7 digits.
        // The area
        // code may, optionally, be surrounded by parenthesis. If an area code
        // is included,
        // the number may optionally be prefixed by a ‘1’ for long distance
        // numbers.
        // Optional hypens my appear after the country code (‘1’), the area
        // code, and the
        // first 3 digits of the 7 digit number.
        //
        @Override
        public boolean validate(String fieldValue)
        {
            return Pattern.matches("^1?[- ]?\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", fieldValue);
        }
    },
    SOCIAL_SECURITY_NUMBER("ssn")
    {
        // A social security number must contain 9 digits with optional hyphens
        // after the
        // third and fifth digits.
        //
        @Override
        public boolean validate(String fieldValue)
        {
            return Pattern.matches("^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$", fieldValue);
        }
    }; // End of enum constants definition
       // Instance members
       //
    private String fieldName;

    private IntelligentFieldType(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getFieldName()
    {
        return this.fieldName;
    }

    // 抽象的校验方法
    abstract boolean validate(String fieldValue);

    // Static class members
    private static final Map<String, IntelligentFieldType> nameToFieldTypeMap = new HashMap<>();
    static
    {
        for (IntelligentFieldType field : IntelligentFieldType.values())
        {
            nameToFieldTypeMap.put(field.getFieldName(), field);
        }
    }

    public static IntelligentFieldType lookup(String fieldName)
    {
        return nameToFieldTypeMap.get(fieldName.toLowerCase());
    }

}
