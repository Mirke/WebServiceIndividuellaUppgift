package com.mikael.bloggheavencode.entities;
import jakarta.persistence.*;


/**
 * <code>BlogPost</code> - Contains information posted on the site
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Entity
public class BlogPost {

    // -----------------------------------------------------------------------------------------------------------------
    //   Properties
    // -----------------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "fk_blog_user")
    BlogUser blog_user;

    // -----------------------------------------------------------------------------------------------------------------
    //   Constructor
    // -----------------------------------------------------------------------------------------------------------------

    public BlogPost() {
    }

    public BlogPost(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public BlogPost(Long id, String content, BlogUser blog_user) {
        this.id = id;
        this.content = content;
        this.blog_user = blog_user;
    }

    public BlogPost(String content, BlogUser blog_user) {
        this.content = content;
        this.blog_user = blog_user;
    }

    public BlogPost(String content) {
        this.content = content;
    }

    // -----------------------------------------------------------------------------------------------------------------
    //   Getter & Setter
    // -----------------------------------------------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogUser getBlog_user() {
        return blog_user;
    }

    public void setBlog_user(BlogUser blog_user) {
        this.blog_user = blog_user;
    }

    @Override
    public String toString() {
        return "Blog_Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", blog_user=" + blog_user +
                '}';
    }
}
