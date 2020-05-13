package hoanglinh.codegym.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String content;
    private String category;
    private String title;
//    private Date time;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }





    public Blog(Long id, String author, String content, String title, String category) {
        this.id=id;
        this.author =author;
        this.content = content;
        this.title = title;
//        this.time = time;
        this.category=category;

    }

    public Blog() {

    }

    public  Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Date getTime() {
//        return time;
//    }
//
//    public void setTime(Date time) {
//        this.time = time;
//    }
}
