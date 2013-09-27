package bookmanager.client.action;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EditBookAction extends ActionSupport
{
    Long book_id;
    String catalog;
    String title;
    String author;
    Integer copyright;
    String binding;

    public Long getBook_id()
    {
        return book_id;
    }

    public void setBook_id(Long bookId)
    {
        book_id = bookId;
    }

    public String getCatalog()
    {
        return catalog;
    }

    public void setCatalog(String catalog)
    {
        this.catalog = catalog;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Integer getCopyright()
    {
        return copyright;
    }

    public void setCopyright(Integer copyright)
    {
        this.copyright = copyright;
    }

    public String getBinding()
    {
        return binding;
    }

    public void setBinding(String binding)
    {
        this.binding = binding;
    }

    public String execute() throws Exception
    {
        String successFlag = SUCCESS;
        Book book = new Book();
        book.setBook_id(book_id);
        book.setTitle(title);
        book.setCatalog(catalog);
        book.setAuthor(author);
        book.setBinding(binding);
        book.setCopyright(copyright);

        try
        {
            Persistence.getInstance().updateBook(book);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            successFlag = ERROR;
        }
        return successFlag;
    }
}
