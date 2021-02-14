import ChessMovementsApp.parseInput
import ChessPieces.{Bishop, King, Pawn, Queen, Rook}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ChessPiecesTest extends AnyFunSuite with Matchers {

  test("Pawn Moves") {
    val input = parseInput("Pawn D5")
    val moves = Pawn.possibleMoves(input._2)
    val expectedPositions = "E5"
    moves shouldBe expectedPositions
  }

  test("King Moves") {
    val input = parseInput("King D5")
    val moves = King.possibleMoves(input._2)
    val expectedPositions = "E5,E6,D6,C6,C5,C4,D4,E4"
    moves shouldBe expectedPositions
  }

  test("Queen Moves") {
    val input = parseInput("Queen D5")
    val moves = Queen.possibleMoves(input._2)
    val expectedPositions = "E5,F5,G5,H5,E6,F7,G8,D6,D7,D8,C6,B7,A8,C5,B5,A5,C4,B3,A2,D4,D3,D2,D1,E4,F3,G2,H1"
    moves shouldBe expectedPositions
  }

  test("Rook Moves") {
    val input = parseInput("Rook D5")
    val moves = Rook.possibleMoves(input._2)
    val expectedPositions = "E5,F5,G5,H5,D6,D7,D8,C5,B5,A5,D4,D3,D2,D1"
    moves shouldBe expectedPositions
  }

  test("Bishop Moves") {
    val input = parseInput("Bishop D5")
    val moves = Bishop.possibleMoves(input._2)
    val expectedPositions = "E6,F7,G8,C6,B7,A8,C4,B3,A2,E4,F3,G2,H1"
    moves shouldBe expectedPositions
  }

}

