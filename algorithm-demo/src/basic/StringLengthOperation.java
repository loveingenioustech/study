package basic;

public class StringLengthOperation implements GenericOperation<String, Integer> {

	@Override
	public Integer performOperation(String value) {
		return value.length();
	}

}
