package dev.enzmann.trainingtracker.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    val lastName: String,

    @param:Email
    var email: String? = null,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    val bodyWeightHistory: MutableList<UserWeight> = mutableListOf(),

    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY, orphanRemoval = true)
    val exerciseWeightHistory: MutableList<ExerciseWeight> = mutableListOf(),
) : BaseEntity()

@Entity
@Table(name = "user_body_weights")
data class UserWeight(
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User? = null,
    val weight: Double,
) : BaseEntity()

@Entity
@Table(name = "user_exerciese_weights")
data class ExerciseWeight(
    val weight: Double,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    val exercise: Exercise
) : BaseEntity()
