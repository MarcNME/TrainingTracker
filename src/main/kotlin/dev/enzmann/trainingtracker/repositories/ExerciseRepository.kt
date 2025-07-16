package dev.enzmann.trainingtracker.repositories

import dev.enzmann.trainingtracker.models.Exercise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExerciseRepository : JpaRepository<Exercise, UUID> {
    fun getUserById(id: UUID): Exercise?
}