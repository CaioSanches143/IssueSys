package uff.issuesys.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uff.issuesys.model.Tags;
import uff.issuesys.model.Users;
import uff.issuesys.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;


    /* **********************************
        Create
    ********************************** */
    @Operation(summary = "This request create a new User.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The User was created.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This User already exists.",content = @Content)
    })
    @PostMapping("/")
    public Users saveUser(@RequestBody Users users){

        return userService.saveUser(users);
    }
    /* **********************************
        Edit
    ********************************** */

    @Operation(summary = "This request edit an User.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The User was edited.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This User does not exist.",content = @Content)
    })
    @PutMapping("/editUser")
    public Users editUser(@RequestBody Users users){
        return userService.editUser(users);
    }
    /* **********************************
        Find - All or ById
    ********************************** */
    @Operation(summary = "This request bring to us all Users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are all Users.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content)
    })
    @GetMapping("/getAllUsers")
    public Iterable<Users> getAllUser(){
        return userService.getAllUser();
    }

    @Operation(summary = "This request bring to us an specific User.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are your User.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This User does not exists.",content = @Content)
    })
    @GetMapping("/getUserById/{id}")
    public Users getUserById(@PathVariable("id") String userIdTofind){
        return userService.getUserById(userIdTofind);
    }

    /* **********************************
        Delete
    ********************************** */

    @Operation(summary = "Delete an especific User by your ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The User was excluded.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",description = "Service not available.",content = @Content),
            @ApiResponse(responseCode = "500",description = "This User does not exists.",content = @Content)
    })
    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable("id") String userIdToDelete){
        return userService.deleteUserById(userIdToDelete);
    }

}
