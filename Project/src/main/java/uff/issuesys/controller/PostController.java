package uff.issuesys.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uff.issuesys.model.Posts;
import uff.issuesys.model.Tags;
import uff.issuesys.service.PostService;

@RestController
@RequestMapping("/Post")
public class PostController {

    @Autowired
    private PostService postService;


    /* **********************************
        Create
    ********************************** */
    @Operation(summary = "This request create a new Post.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Post was created.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Post already exists.",content = @Content)
    })
    @PostMapping("/")
    public Posts savePost(@RequestBody Posts post){
        return postService.saveTag(post);
    }
    /* **********************************
        Edit
    ********************************** */
    @Operation(summary = "This request edit an Post.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Post was edited.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Post does not exist.",content = @Content)
    })
    @PutMapping("/editPost")
    public Posts editTag(@RequestBody Posts posts){
        return postService.editPost(posts);
    }

    /* **********************************
        Find - All or ById
    ********************************** */
    @Operation(summary = "This request bring to us all Post.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are all posts.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content)
    })
    @GetMapping("/getAllPosts")
    public Iterable<Posts> getAllPost(){
        return postService.getAllPost();
    }

    @Operation(summary = "This request bring to us an specific Post.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are your post.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Post does not exists.",content = @Content)
    })
    @GetMapping("/getPostById/{id}")
    public Posts getTagById(@PathVariable("id") String postIdTofind){
        return postService.getPostById(postIdTofind);
    }

    /* **********************************
        Delete
    ********************************** */
    @Operation(summary = "Delete an especific Post by your ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Post was excluded.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Post does not exists.",content = @Content)
    })
    @DeleteMapping("/{id}")
    public boolean deletePostById(@PathVariable("id") String postIdToDelete){
        return postService.deleteIssueById(postIdToDelete);
    }


}
