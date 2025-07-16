package dev.enzmann.trainingtracker.services

import dev.enzmann.trainingtracker.exceptions.ExerciseException
import dev.enzmann.trainingtracker.models.Exercise
import dev.enzmann.trainingtracker.repositories.ExerciseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ExerciseService(private val exerciseRepository: ExerciseRepository) {
    fun getAllExercises(): List<Exercise> = exerciseRepository.findAll()

    fun getExercise(id: UUID): Exercise = exerciseRepository.getUserById(id) ?: throw ExerciseException(
        exerciseId = id.toString(),
        message = "Could not find exercise with id: $id",
    )

    fun safe(exercise: Exercise): Exercise = exerciseRepository.save(exercise)
}