package com.utility.controller;

import com.utility.dto.InputDTO;
import com.utility.dto.UserDTO;
import com.utility.dto.common.RestResponse;
import com.utility.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Harshal Patil
 */
@RestController
@RequestMapping(value = "/ebi/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * API to add multiple users in db
     * @param person
     * @return
     */
    @PostMapping
    public ResponseEntity<RestResponse> addPerson(@RequestBody InputDTO person) {
        RestResponse restResponse = userService.addUsers(person.getData()).orElse(null);
        HttpStatus status = HttpStatus.CONFLICT;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.CREATED;
        return new ResponseEntity<>(restResponse, status);
    }

    /**
     * API to get list of user
     * @return
     */
    @GetMapping(value = "/list")
    public ResponseEntity<RestResponse> getUsers() {
        RestResponse restResponse = userService.getUsers().orElse(null);
        HttpStatus status = HttpStatus.CONFLICT;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.OK;
        return new ResponseEntity<>(restResponse, status);
    }

    /**
     * API to get user by id
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<RestResponse> getUser(@PathVariable Long id) {
        RestResponse restResponse = userService.getUser(id).orElse(null);
        HttpStatus status = HttpStatus.NOT_FOUND;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.CREATED;
        return new ResponseEntity<>(restResponse, status);
    }

    /**
     * API to add user
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseEntity<RestResponse> addUser(@RequestBody UserDTO userDTO) {
        RestResponse restResponse = userService.addUser(userDTO).orElse(null);
        HttpStatus status = HttpStatus.CONFLICT;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.CREATED;
        return new ResponseEntity<>(restResponse, status);
    }

    /**
     * API to update user by id
     * @param id
     * @param userDTO
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<RestResponse> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        RestResponse restResponse = userService.updateUser(id, userDTO).orElse(null);
        HttpStatus status = HttpStatus.NOT_FOUND;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.CREATED;
        return new ResponseEntity<>(restResponse, status);
    }

    /**
     * API to delete user by id
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse> deleteUser(@PathVariable Long id) {
        RestResponse restResponse = userService.deleteUser(id).orElse(null);
        HttpStatus status = HttpStatus.CONFLICT;
        if(null != restResponse && restResponse.isSuccess())
            status = HttpStatus.OK;
        return new ResponseEntity<>(restResponse, status);
    }

}
