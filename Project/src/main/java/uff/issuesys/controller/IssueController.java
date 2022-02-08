package uff.issuesys.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uff.issuesys.model.Issues;
import uff.issuesys.model.Tags;
import uff.issuesys.service.IssueService;
import uff.issuesys.service.TagService;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/Issue")
public class IssueController {

    @Autowired
    private IssueService issueService;


    /* **********************************
        Create
    ********************************** */

    @Operation(summary = "This request create a new Issue.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Issue was created.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Issue already exists.",content = @Content)
    })
    @PostMapping("/")
    public Issues saveIssue(@RequestBody Issues issues){

        return issueService.saveIssue(issues);
    }

    /* **********************************
        Edit
    ********************************** */

    @Operation(summary = "This request edit an Issue.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Issue was edited.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Issue does not exist.",content = @Content)
    })
    @PutMapping("/editIssue")
    public Issues editTag(@RequestBody Issues issue){
        return issueService.editIssue(issue);
    }
    /* **********************************
        Find - All or ById
    ********************************** */

    @Operation(summary = "This request bring to us all Issues.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are all issues.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content)
    })
    @GetMapping("/getAllIssues")
    public Iterable<Issues> getAllTag(){
        return issueService.getAllTag();
    }

    @Operation(summary = "This request bring to us an specific Issue.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are your issue.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This issue does not exists.",content = @Content)
    })
    @GetMapping("/getIssueById/{id}")
    public Issues getTagById(@PathVariable("id") String issueIdTofind){
        return issueService.getissueById(issueIdTofind);
    }


    /* **********************************
        Delete
    ********************************** */

    @Operation(summary = "Delete an especific Issue by your ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Issue was excluded.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This Issue does not exists.",content = @Content)
    })
    @DeleteMapping("/{id}")
    public boolean deleteTagById(@PathVariable("id") String issueIdToDelete){
        return issueService.deleteIssueById(issueIdToDelete);
    }


}
