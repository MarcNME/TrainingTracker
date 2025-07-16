package dev.enzmann.trainingtracker.exceptions

class UserException(
    val userId: String,
    override val message: String,
    override val cause: Throwable? = null,
) : RuntimeException(message, cause) {
}