package com.mikael.bloggheavencode.services;
import com.mikael.bloggheavencode.entities.BlogPost;
import com.mikael.bloggheavencode.entities.BlogUser;
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
    //   Repository Property and Services
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private BlogPostRepository postRepository;

    @Autowired
    private AdminService adminService;

    // -----------------------------------------------------------------------------------------------------------------
    //   Service Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<BlogPost> findBlogPostById(Long id) { return postRepository.findById(id); }

    @Override
    public ResponseEntity<String> deleteBlogPostById(Long id) {
        if(postRepository.existsById(id)) {
            try {
                postRepository.deleteBlog_PostById(id);
                return new ResponseEntity<>("Deleted blog post with id: " + id, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Could not delete post with id: " + id + " error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>("Post by that id not found!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> createBlogPost(BlogPost blogPost){
        try {
            postRepository.save(blogPost);
            Optional<BlogUser> user = adminService.findBlogUserById(blogPost.getBlog_user().getId());
            String author = user.get().getFirstName() + " " +  user.get().getLastName();
            return new ResponseEntity<>(author + " writes: " + blogPost.getContent(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateBlogPost(Long id, String content) {
        if(postRepository.existsById(id)){
            try{
                BlogPost blogPost = postRepository.getReferenceById(id);
                String oldMessage = blogPost.getContent();
                blogPost.setContent(content);
                postRepository.save(blogPost);
                return new ResponseEntity<>("Updated blog post with id: " + id + "\nOld message '" + oldMessage + "'\nNew message '" + blogPost.getContent() + "'" , HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
        return new ResponseEntity<>("Post by that id not found!", HttpStatus.NOT_FOUND);
        }
    }
}
