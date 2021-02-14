import ChessMovementsApp.output
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ChessMovementsAppTest extends AnyFunSpec with Matchers {

  describe("valid Input") {
    it("Should give correct output for valid input") {
      val outputMoves = output("King D5")
      val expectedOutput = "E5,E6,D6,C6,C5,C4,D4,E4"
      outputMoves shouldBe expectedOutput
    }
  }

  describe("invalid input") {

    it("Should output error message for incorrect piece name") {
      val outputMoves = output("Knight D5")
      val expectedOutput = "Invalid input: Please check the piece name"
      outputMoves shouldBe expectedOutput
    }

    it("Should output error message for invalid position") {
      val outputMoves = output("Rook Z5")
      val expectedOutput = "Invalid input: Please check the file and rank"
      outputMoves shouldBe expectedOutput
    }

    it("Should output error message for invalid position and piece name") {
      val outputMoves = output("Rook Z5")
      val expectedOutput = "Invalid input: Please check the file and rank"
      outputMoves shouldBe expectedOutput
    }
  }
}
