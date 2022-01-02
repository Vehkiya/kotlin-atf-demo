import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class DemoTest : AnnotationSpec() {

    private fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    @org.junit.jupiter.api.BeforeEach
    internal fun setUp() {
        println("settting up some stuff")
    }

    @org.junit.jupiter.api.Test
    internal fun isEvenTest() {
        isEven(3).shouldBeFalse()
        isEven(4).shouldBeTrue()
    }

    @org.junit.jupiter.api.Test
    internal fun isEvenTestSoftAssertions() {
        assertSoftly {
            isEven(10).shouldBeTrue()
            isEven(11).shouldBeFalse()
        }
    }
}