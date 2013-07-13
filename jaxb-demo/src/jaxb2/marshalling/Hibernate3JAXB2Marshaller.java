package jaxb2.marshalling;


import javax.xml.bind.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import juno.hibernate3.HibernateMapping;
import juno.hibernate3.ObjectFactory;

public class Hibernate3JAXB2Marshaller {

	public void generateXMLDocument(File xmlDocument) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance("juno.hibernate3");

			Marshaller marshaller = jaxbContext.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", new Boolean(true));

			ObjectFactory factory = new ObjectFactory();

			HibernateMapping hibernateMapping = factory
					.createHibernateMapping();

			hibernateMapping.setCatalog("");
			
			juno.hibernate3.Class mappingClass = factory.createClass();
			
			JAXBElement<String> hibernateMappingElement = factory.createCreate("dto.Test");
		
			marshaller.marshal(hibernateMappingElement,
					new FileOutputStream(xmlDocument));		

		} catch (IOException e) {
			System.err.println(e.toString());

		} catch (JAXBException e) {

			System.err.println(e.toString());

		}

	}

	public static void main(String[] argv) {
		String xmlDocument = "src/Test.hbm.xml";
		Hibernate3JAXB2Marshaller jaxbMarshaller = new Hibernate3JAXB2Marshaller();
		jaxbMarshaller.generateXMLDocument(new File(xmlDocument));
	}
}
