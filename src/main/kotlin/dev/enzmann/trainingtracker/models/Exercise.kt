package dev.enzmann.trainingtracker.models

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "exercises")
data class Exercise(
    val name: String,
    var image: ByteArray? = null,
) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Exercise

        if (id != other.id) return false
        if (name != other.name) return false
        if (!image.contentEquals(other.image)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + image.contentHashCode()
        return result
    }
}