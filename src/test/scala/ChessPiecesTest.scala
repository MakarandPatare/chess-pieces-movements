import ChessMovementsApp.parseInput
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ChessPiecesTest extends AnyFunSpec with Matchers {

  describe("Normal Cases") {

    it("Should output correct moves for Pawn") {
      val input = parseInput("Pawn D5")
      val moves = Pawn.possibleMoves(input.position)
      val expectedPositions = "E5"
      moves shouldBe expectedPositions
    }

    it("Should output correct moves for King") {
      val input = parseInput("King D5")
      val moves = King.possibleMoves(input.position)
      val expectedPositions = "E5,E6,D6,C6,C5,C4,D4,E4"
      moves shouldBe expectedPositions
    }

    it("Should output correct moves for Queen") {
      val input = parseInput("Queen D5")
      val moves = Queen.possibleMoves(input.position)
      val expectedPositions = "E5,F5,G5,H5,E6,F7,G8,D6,D7,D8,C6,B7,A8,C5,B5,A5,C4,B3,A2,D4,D3,D2,D1,E4,F3,G2,H1"
      moves shouldBe expectedPositions
    }

    it("Should output correct moves for Rook") {
      val input = parseInput("Rook D5")
      val moves = Rook.possibleMoves(input.position)
      val expectedPositions = "E5,F5,G5,H5,D6,D7,D8,C5,B5,A5,D4,D3,D2,D1"
      moves shouldBe expectedPositions
    }

    it("Should output correct moves for Bishop") {
      val input = parseInput("Bishop D5")
      val moves = Bishop.possibleMoves(input.position)
      val expectedPositions = "E6,F7,G8,C6,B7,A8,C4,B3,A2,E4,F3,G2,H1"
      moves shouldBe expectedPositions
    }

    it("Should output correct moves for Horse") {
      val input = parseInput("Horse E3")
      val moves = Horse.possibleMoves(input.position)
      val expectedPositions = "G4,F5,C4,D5,C2,D1,G2,F1"
      moves shouldBe expectedPositions
    }
  }

  describe("Edge Cases") {
    it("Should return empty when Pawn is at the last file") {
      val input = parseInput("Pawn H5")
      val moves = Pawn.possibleMoves(input.position)
      val expectedPositions = ""
      moves shouldBe expectedPositions
    }

    it("Should return five moves when King is at the last file") {
      val input = parseInput("King H5")
      val moves = King.possibleMoves(input.position)
      val expectedPositions = "H6,G6,G5,G4,H4"
      val positionCount = expectedPositions.split(",").length
      positionCount shouldBe 5
      moves shouldBe expectedPositions
    }

    it("Should return correct moves when Queen is in the corner") {
      val input = parseInput("Queen H8")
      val moves = Queen.possibleMoves(input.position)
      val expectedPositions = "G8,F8,E8,D8,C8,B8,A8,G7,F6,E5,D4,C3,B2,A1,H7,H6,H5,H4,H3,H2,H1"
      moves shouldBe expectedPositions
    }

    it("Should return two moves when Horse is in the corner") {
      val input = parseInput("Horse A1")
      val moves = Horse.possibleMoves(input.position)
      val expectedPositions = "C2,B3"
      val positionCount = expectedPositions.split(",").length
      positionCount shouldBe 2
      moves shouldBe expectedPositions
    }

    it("Should return three moves when Horse is on the edge") {
      val input = parseInput("Horse D1")
      val moves = Horse.possibleMoves(input.position)
      val expectedPositions = "F2,E3,B2,C3"
      val positionCount = expectedPositions.split(",").length
      positionCount shouldBe 4
      moves shouldBe expectedPositions
    }
  }
}

