package dev.enzmann.trainingtracker.controller

import dev.enzmann.trainingtracker.models.User
import dev.enzmann.trainingtracker.models.UserWeight
import dev.enzmann.trainingtracker.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
class UserController(private val userService: UserService) {
    @PostMapping("/user/add")
    @Validated
    fun addUser(@RequestBody user: User) = ResponseEntity.created(URI("/user/id")).body(userService.save(user))


    @GetMapping("/users")
    fun getUsers() = ResponseEntity.ok(userService.getUsers())

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: UUID) = ResponseEntity.ok(userService.getUserById(id))

    @PostMapping("/user/{id}/weight")
    @Validated
    fun addWeight(@PathVariable id: UUID, @RequestBody weight: UserWeight): ResponseEntity<User> {
        val user = userService.getUserById(id)
        return ResponseEntity.ok(userService.addBodyWeight(user, weight))
    }
}