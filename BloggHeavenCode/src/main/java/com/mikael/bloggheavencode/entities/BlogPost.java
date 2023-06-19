package com.mikael.bloggheavencode.entities;

import javax.persistence.*;

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
    @Column(name = "id", nullable = false)
    private Long id;

    private String user;
    private String content;

    // -----------------------------------------------------------------------------------------------------------------
    //   Constructor
    // -----------------------------------------------------------------------------------------------------------------

    public BlogPost() {
    }

    public BlogPost(Long id, String user, String content) {
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public BlogPost(String user, String content) {
        this.user = user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
