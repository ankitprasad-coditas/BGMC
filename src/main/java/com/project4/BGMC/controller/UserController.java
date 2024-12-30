package com.project4.BGMC.controller;


import com.project4.BGMC.dto.ApiResponseDto;
import com.project4.BGMC.dto.AuthRequestDto;
import com.project4.BGMC.dto.TokenResponseDto;
import com.project4.BGMC.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;
//    private final UserService userService;



    // User Login
    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<TokenResponseDto>> login(@RequestBody AuthRequestDto authRequestDto) {
        ApiResponseDto<TokenResponseDto> response = new ApiResponseDto<>(authService.login(authRequestDto), HttpStatus.OK.value(), "User Successfully Logged In");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*//Create User
    @PostMapping("/createUser")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public ResponseEntity<ApiResponseDto<User>> createUser(@RequestBody UserRequestDto userRequestDto) {
        ApiResponseDto<User> response = new ApiResponseDto<>(userService.createUser(userRequestDto), HttpStatus.CREATED.value(), "User Created Successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }*/

    /*// Get All User
//    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    // Get User With Pagination and Sorting
    @GetMapping("/allUsers")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN','STAKEHOLDER','TRAINER')")
    public ResponseEntity<ApiResponseDto<List<UserResponseDto>>> getUserWithPaging(@RequestParam(defaultValue = "1") Integer pageNo,
                                                                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        ApiResponseDto<List<UserResponseDto>> response = new ApiResponseDto<>(userService.getUsersByPagination(pageNo, pageSize), HttpStatus.OK.value(), "User's List Fetched");
        return ResponseEntity.ok(response);
    }

    // Search User By Name
    @GetMapping("/searchUserByName")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN','STAKEHOLDER','TRAINER')")
    public ResponseEntity<ApiResponseDto<List<UserResponseDto>>> searchUserByName(@RequestParam("name")String name){
        ApiResponseDto<List<UserResponseDto>> response = new ApiResponseDto<>(userService.getUserByName(name),HttpStatus.OK.value(),"User's Fetched Successfully");
        return ResponseEntity.ok(response);
    }

    // Delete User
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public ResponseEntity<ApiResponseDto<UserResponseDto>> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto updatedUser = userService.updateUser(id, userRequestDto);
        ApiResponseDto<UserResponseDto> response = new ApiResponseDto<>(updatedUser,HttpStatus.OK.value(), "User Details Updated Successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/removeRole")
    public ResponseEntity<String> removeUserRole(@RequestParam("userId")Long userId,@RequestParam("roleId")Long roleId){
        userService.removeRoleFromUser(userId,roleId);
        return ResponseEntity.ok("Role Deleted Successfully");
    }*/
}
