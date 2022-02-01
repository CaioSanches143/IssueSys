package uff.issuesys.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uff.issuesys.model.Tags;
import uff.issuesys.service.TagService;

@RestController
@RequestMapping("/Tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @Operation(summary = "This request create a new Tag.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Tag was created.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content)
    })
    @PostMapping("/")
    public Tags saveTag(@RequestBody Tags tags){

        return tagService.saveTag(tags);
    }

    @Operation(summary = "This request bring to us all Tags.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are all tags.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content)
    })
    @GetMapping("/getAllTags")
    public Iterable<Tags> getAllTag(){

        Iterable<Tags> iterable;
        for(Tags s : tagService.getAllTag()){
            System.out.println(s.getTagId()+" "+s.getTagName()+" "+s.getTagDescription());
        };

        return tagService.getAllTag();
    }

}
