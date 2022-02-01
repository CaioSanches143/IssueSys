package uff.issuesys.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uff.issuesys.model.Tags;
import uff.issuesys.service.TagService;

@RestController
@RequestMapping("/Tag")
public class TagController {

    @Autowired
    private TagService tagService;



    @Operation(summary = "This post create a new Tag.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Tag was created.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Microservice not available.",content = @Content)
    })
    @PostMapping("/")
    public Tags saveTag(@RequestBody Tags tags){
        return tagService.saveTag(tags);
    }

}
