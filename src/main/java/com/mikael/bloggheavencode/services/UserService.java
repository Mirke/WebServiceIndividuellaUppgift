package com.mikael.bloggheavencode.services;
import com.mikael.bloggheavencode.entities.BlogPost;
import com.mikael.bloggheavencode.repositories.BlogPostRepository;
import com.mikael.bloggheavencode.repositories.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * <code>UserService</code> - Service that is a middle person between Users and Repositories, business logic
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Service
public class UserService implements IUserService{

    // -----------------------------------------------------------------------------------------------------------------
    //   Repository Property
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private BlogUserRepository userRepository;

    @Autowired
    private BlogPostRepository postRepository;

    // -----------------------------------------------------------------------------------------------------------------
    //   Service Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<BlogPost> findBlogPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Optional<BlogPost> deleteBlogPostById(Long id) {
        return postRepository.deleteBlog_PostById(id);
    }

    @Override
    public ResponseEntity<String> createBlogPost(BlogPost blogPost){
        try {
            postRepository.save(blogPost);
            return new ResponseEntity<>("Created blog post", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateBlogPost(Long id, String content) {
        if(postRepository.existsById(id)){
            try{
                BlogPost blogPost = postRepository.getById(id);
                blogPost.setContent(content);
                postRepository.save(blogPost);
                return new ResponseEntity<>("Update new blog post!", HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
        return new ResponseEntity<>("Post by that id not found!", HttpStatus.NOT_FOUND);
        }
    }
}
