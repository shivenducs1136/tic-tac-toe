
class BoardPrinter{

    fun printBoard(currentBoard:Board){
        for(row in 0..currentBoard.board.size-1){
            for(char in currentBoard.board[row]){
                print("$char ")
            }
            println()
        }
    }
}