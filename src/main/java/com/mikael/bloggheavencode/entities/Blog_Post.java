package com.mikael.bloggheavencode.entities;

import javax.persistence.*;

/**
 * <code>BlogPost</code> - Contains information posted on the site
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Entity
public class Blog_Post {

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
    Blog_User blog_user;

    // -----------------------------------------------------------------------------------------------------------------
    //   Constructor
    // -----------------------------------------------------------------------------------------------------------------

    public Blog_Post() {
    }

    public Blog_Post(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Blog_Post(Long id, String content, Blog_User blog_user) {
        this.id = id;
        this.content = content;
        this.blog_user = blog_user;
    }

    public Blog_Post(String content, Blog_User blog_user) {
        this.content = content;
        this.blog_user = blog_user;
    }

    public Blog_Post(String content) {
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

    public Blog_User getBlog_user() {
        return blog_user;
    }

    public void setBlog_user(Blog_User blog_user) {
        this.blog_user = blog_user;
    }
}
