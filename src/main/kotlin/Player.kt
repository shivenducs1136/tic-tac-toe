class Player {
    lateinit var name:String
    lateinit var playerType:PlayerType

     fun validateMove(currentBoard:Board,move:Move):Boolean{
        if(move.x_position-1>=size || move.y_position-1>=size){
            return false
        }
        if(currentBoard.board[move.x_position-1][move.y_position-1] !='-'){
            return false
        }
        return true
    }

    fun placeMove(currentMove: Move,currentBoard: Board){
        if(validateMove(currentBoard,currentMove)){
            if(playerType == PlayerType.X) {
                currentBoard.board[currentMove.x_position-1][currentMove.y_position-1] = 'X'
            }
            else{
                currentBoard.board[currentMove.x_position-1][currentMove.y_position-1] = 'O'
            }
        }
    }
}