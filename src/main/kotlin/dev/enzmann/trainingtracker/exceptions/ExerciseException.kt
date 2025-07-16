package dev.enzmann.trainingtracker.exceptions

class ExerciseException(
    val exerciseId: String,
    override val message: String,
    override val cause: Throwable? = null,
) : RuntimeException(message, cause) {
}