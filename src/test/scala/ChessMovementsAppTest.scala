import ChessMovementsApp.{Piece, Position, output, parseInput}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ChessMovementsAppTest extends AnyFunSpec with Matchers {

  describe("valid Input") {

    it("should parse the input correctly") {
      val parsedInput = parseInput("Queen C4")
      val expectedOutput = Piece("Queen", Position('C', 4))
      parsedInput shouldBe expectedOutput
    }

    it("Should give correct output for valid input") {
      val outputMoves = output("King D5")
      val expectedOutput = "E5,E6,D6,C6,C5,C4,D4,E4"
      outputMoves shouldBe expectedOutput
    }
  }

  describe("invalid input") {


    it("should output empty piece instance for invalid input format") {
      val parsedInput = parseInput("KnightC4")
      val expectedOutput = Piece("", Position(' ', 0))
      parsedInput shouldBe expectedOutput
    }

    it("should output valid piece instance for invalid piece name - shouldn't validate the name") {
      val parsedInput = parseInput("Knight C4")
      val expectedOutput = Piece("Knight", Position('C', 4))
      parsedInput shouldBe expectedOutput
    }

    it("should ignore trailing inputs - without space") {
      val parsedInput = parseInput("Horse C4D4")
      val expectedOutput = Piece("Horse", Position('C', 4))
      parsedInput shouldBe expectedOutput
    }

    it("should not register multiple inputs - Not supported") {
      val parsedInput = parseInput("Horse C4 Queen D5")
      val expectedOutput = Piece("", Position(' ', 0))
      parsedInput shouldBe expectedOutput
    }

    it("Should output error message for incorrect piece name") {
      val outputMoves = output("Knight D5")
      val expectedOutput = "Invalid input: Please check the piece name"
      outputMoves shouldBe expectedOutput
    }

    it("Should output error message for invalid position") {
      val outputMoves = output("Rook Z5")
      val expectedOutput = "Invalid input: Please check the row and column"
      outputMoves shouldBe expectedOutput
    }

    it("Should output error message for invalid position and piece name") {
      val outputMoves = output("Rook Z5")
      val expectedOutput = "Invalid input: Please check the row and column"
      outputMoves shouldBe expectedOutput
    }
  }
}
