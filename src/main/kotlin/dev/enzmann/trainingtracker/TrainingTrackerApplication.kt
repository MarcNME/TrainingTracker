package dev.enzmann.trainingtracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class TrainingTrackerApplication

fun main(args: Array<String>) {
    runApplication<TrainingTrackerApplication>(*args)
}
