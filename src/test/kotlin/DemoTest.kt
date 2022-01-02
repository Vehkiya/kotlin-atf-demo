import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import util.SomeService

class DemoTest : AnnotationSpec() {


    @org.junit.jupiter.api.BeforeEach
    internal fun setUp() {
        println("settting up some stuff")
    }

    @org.junit.jupiter.api.Test
    internal fun `Number is even or odd`() {
        SomeService.isEven(3).shouldBeFalse()
        SomeService.isEven(4).shouldBeTrue()
    }

    @org.junit.jupiter.api.Test
    internal fun isEvenTestSoftAssertions() {
        assertSoftly {
            SomeService.isEven(10).shouldBeTrue()
            SomeService.isEven(11).shouldBeFalse()
        }
    }
}