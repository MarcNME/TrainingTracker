package dev.enzmann.trainingtracker.repositories

import dev.enzmann.trainingtracker.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun getUserById(id: UUID): User?
}