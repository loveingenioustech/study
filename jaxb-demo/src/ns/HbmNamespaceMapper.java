package ns;

//import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
//import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
//import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class HbmNamespaceMapper extends NamespacePrefixMapper {

	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion,
			boolean requirePrefix) {
//		if ("http://www.hibernate.org/xsd/hibernate-mapping"
//				.equals(namespaceUri)) {
//			return "";
//		}
//		return suggestion;
		
//		System.out.println("namespaceUri :" + namespaceUri );
//		System.out.println("suggestion : "+suggestion);
//		System.out.println("requirePrefix :" + requirePrefix);
		
		return "TODO";
	}

//	@Override
//	public String[] getPreDeclaredNamespaceUris() {
//		return new String[]{"", ""};
//	}

}
