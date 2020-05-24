package polyvolve.prototype.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

/**
 * Manages an instance of Polyvolve.
 *
 * ssh -L 5432:194.55.12.109:5432 194.55.12.109 -p 56783 -l flaw
 */
@SpringBootApplication
@EnableScheduling
class PrototypeApplication

fun main(args: Array<String>) {
    runApplication<PrototypeApplication>(*args)
}
