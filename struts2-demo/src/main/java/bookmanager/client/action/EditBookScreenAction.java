package bookmanager.client.action;

import java.util.ArrayList;
import java.util.List;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EditBookScreenAction extends ActionSupport
{
    private Long book_id;
    private String catalog;
    private String title;
    private String author;
    private Integer copyright;
    private String binding;
    private List<String> bindings = null;

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

    public List<String> getBindings()
    {
        if (bindings == null)
        {
            bindings = new ArrayList<String>();
            bindings.add("Trade");
            bindings.add("Hardcover");
            bindings.add("Paperback");
            bindings.add("eBook");
            bindings.add("Other");
        }
        return bindings;
    }
    
    public String execute() throws Exception
    {
        String successFlag = SUCCESS;

        Book book = new Book();
        try
        {
            book = Persistence.getInstance().getBook(book_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            successFlag = ERROR;
        }
        this.setBook_id(book.getBook_id());
        this.setTitle(book.getTitle());
        this.setCatalog(book.getCatalog());
        this.setAuthor(book.getAuthor());
        this.setBinding(book.getBinding());
        this.setCopyright(book.getCopyright());

        return successFlag;
    }
}
