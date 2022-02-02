package uff.issuesys.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uff.issuesys.model.Tags;
import uff.issuesys.service.*;

@RestController
@RequestMapping("/Tag")
public class TagController {

    @Autowired
    private TagService tagService;


    /* **********************************
        Create
    ********************************** */

    @Operation(summary = "This request create a new Tag.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Tag was created.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Tag already exists.",content = @Content)
    })
    @PostMapping("/")
    public Tags saveTag(@RequestBody Tags tags){

        return tagService.saveTag(tags);
    }
    /* **********************************
        Edit
    ********************************** */

    @Operation(summary = "This request edit an Tag.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Tag was edited.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Tag does not exist.",content = @Content)
    })
    @PutMapping("/editTag")
    public Tags editTag(@RequestBody Tags tags){
        return tagService.editTag(tags);
    }

    /* **********************************
        Find - All or ById
    ********************************** */

    @Operation(summary = "This request bring to us all Tags.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are all tags.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content)
    })
    @GetMapping("/getAllTags")
    public Iterable<Tags> getAllTag(){
        return tagService.getAllTag();
    }

    @Operation(summary = "This request bring to us an specific Tag.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are your tag.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Tag does not exists.",content = @Content)
    })
    @GetMapping("/getTagById/{id}")
    public Tags getTagById(@PathVariable("id") String tagIdTofind){
        return tagService.getTagById(tagIdTofind);
    }

    /* **********************************
        Delete
    ********************************** */

    @Operation(summary = "Delete an especific Tag by your ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The tag was excluded.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Tag does not exists.",content = @Content)
    })
    @DeleteMapping("/{id}")
    public boolean deleteTagById(@PathVariable("id") String tagIdToDelete){
        return tagService.deleteTagById(tagIdToDelete);
    }

}
