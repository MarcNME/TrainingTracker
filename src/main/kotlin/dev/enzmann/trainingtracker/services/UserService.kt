package dev.enzmann.trainingtracker.services

import dev.enzmann.trainingtracker.exceptions.UserException
import dev.enzmann.trainingtracker.models.ExerciseWeight
import dev.enzmann.trainingtracker.repositories.UserRepository
import dev.enzmann.trainingtracker.models.User
import dev.enzmann.trainingtracker.models.UserWeight
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(id: UUID): User {
        val user = userRepository.getUserById(id) ?: throw UserException(
            id.toString(),
            "User with id $id not found"
        )

        return user
    }

    fun save(user: User): User = userRepository.save(user)

    fun getUsers(): List<User> = userRepository.findAll()

    fun addBodyWeight(user: User, weight: UserWeight): User {
        user.bodyWeightHistory.add(weight)
        return userRepository.save(user)
    }

    fun addExerciseWeight(user: User, exerciseWeight: ExerciseWeight): User {
        user.exerciseWeightHistory.add(exerciseWeight)
        return userRepository.save(user)
    }

}