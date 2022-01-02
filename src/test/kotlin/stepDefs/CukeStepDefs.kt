package stepDefs

import io.cucumber.java8.En
import io.kotest.matchers.shouldBe
import util.SomeService

class CukeStepDefs : En {

    var number: Int = 0

    init {
        Given("a sequence of numbers") { println("Some random numbers") }
        When("user picks number {int}") { number: Int ->
            println("User picked $number")
            this.number = number
        }
        Then("that number is {word}") { condition: String ->
            val isEven: Boolean = when (condition) {
                "even" -> true
                "odd" -> false
                else -> throw IllegalArgumentException("Invalid setting $condition. Should be \"even\" or \"odd\"")
            }
            SomeService.isEven(number).shouldBe(isEven)
        }
    }

}