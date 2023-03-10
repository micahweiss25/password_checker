package password_checker
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should._
class Password_Test extends AnyFunSpec with Matchers {
    describe("A password checker") {
        describe("determines proper length") {
            it("rejects passwords that are less than 6 characters") {
                val tooShort = "abcde"
                val longEnough = "abcdef"
                val evenLonger = "abcdefghi"
                Password.isValid(tooShort) shouldBe false
                Password.isValid(longEnough) shouldBe true
                Password.isValid(evenLonger) shouldBe true
            }
            describe("determines special character") {
                it("rejects passwords without a special character") {
                    val noSpecial = "abcdef"
                    val oneSpecial = "abcdef!"
                    val twoSpecial = "abcdef!@"
                    Password.isValid(noSpecial) shouldBe false
                    Password.isValid(oneSpecial) shouldBe true
                    Password.isValid(twoSpecial) shouldBe true
                }
            }
        }
    }
}