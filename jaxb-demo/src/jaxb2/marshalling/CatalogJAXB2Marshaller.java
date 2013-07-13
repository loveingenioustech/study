package jaxb2.marshalling;

import javax.xml.bind.*;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import jaxb2.catalog.ArticleType;
import jaxb2.catalog.CatalogType;
import jaxb2.catalog.JournalType;
import jaxb2.catalog.ObjectFactory;

public class CatalogJAXB2Marshaller {

	public void generateXMLDocument(File xmlDocument) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance("jaxb2.catalog");

			Marshaller marshaller = jaxbContext.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", new Boolean(true));

			ObjectFactory factory = new ObjectFactory();

			CatalogType catalog = factory.createCatalogType();
			catalog.setCatalogid(1);
			catalog.setTitle("Oracle Magazine");
			catalog.setPublisher("Oracle Publishing");
			JournalType journal = factory.createJournalType();
			journal.setDate("September-October 2008");
			List<JournalType> journalList = catalog.getJournal();
			journalList.add(journal);
			ArticleType article = factory.createArticleType();
			article.setSection("FEATURES");
			article.setTitle("Share 2.0");
			article.setAuthor("Alan Joch");
			List<ArticleType> articleList = journal.getArticle();
			articleList.add(article);
			journal = factory.createJournalType();
			journal.setDate("March-April 2008");

			journalList.add(journal);
			article = factory.createArticleType();
			article.setSection("ORACLE DEVELOPER");
			article.setTitle("Declarative Data Filtering");
			article.setAuthor("Steve Muench");
			articleList = journal.getArticle();
			articleList.add(article);

			JAXBElement<CatalogType> catalogElement = factory
					.createCatalog(catalog);

			marshaller.marshal(catalogElement,
					new FileOutputStream(xmlDocument));

		} catch (IOException e) {
			System.err.println(e.toString());

		} catch (JAXBException e) {

			System.err.println(e.toString());

		}

	}

	public static void main(String[] argv) {
		String xmlDocument = "src/catalog.xml";
		CatalogJAXB2Marshaller jaxbMarshaller = new CatalogJAXB2Marshaller();
		jaxbMarshaller.generateXMLDocument(new File(xmlDocument));
	}
}
