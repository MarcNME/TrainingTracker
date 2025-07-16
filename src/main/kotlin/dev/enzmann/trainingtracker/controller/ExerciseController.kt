package dev.enzmann.trainingtracker.controller

import dev.enzmann.trainingtracker.models.Exercise
import dev.enzmann.trainingtracker.services.ExerciseService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

const val EXERCISE_PATH = "/exercise"

@RestController
class ExerciseController(private val exerciseService: ExerciseService) {


    @GetMapping("/exercises")
    fun getExercises(): ResponseEntity<List<Exercise>> = ResponseEntity.ok(exerciseService.getAllExercises())

    @GetMapping("$EXERCISE_PATH/{id}")
    fun getExercisesById(@PathVariable id: UUID): ResponseEntity<Exercise> = ResponseEntity.ok(exerciseService.getExercise(id))

    @PostMapping(EXERCISE_PATH)
    @Validated
    fun addExercise(@RequestBody exercise: Exercise): ResponseEntity<Exercise> {
        val createdExercise = exerciseService.safe(exercise)
        return ResponseEntity.created("$EXERCISE_PATH/${createdExercise.id}")
    }
}