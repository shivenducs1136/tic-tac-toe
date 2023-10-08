
const val size = 3
class Board {
    val board:MutableList<MutableList<Char>> = mutableListOf<MutableList<Char>>()
    var winStatus= false
    lateinit var turn:Player
    fun initializeBoard(player:Player){
        for( i in 0..size-1){
            val row = mutableListOf<Char>()
            for(j in 0..size-1){
                row.add('-')
            }
            board.add(row)
        }
        turn = player
    }

    fun isWin():Boolean{
        if(checkDiagonal() && board[1][1] !='-'){
            return true
        }
        for( row in board){
            if(checkRow(row) && row[0] != '-'){
                return true
            }
        }
        for(i in 0..size-1){
            if(checkColumn(i) && board[0][i]!='-'){
                return true
            }
        }
        return false
    }

    fun isDraw():Boolean{
        for( i in 0..size-1){
            for(j in 0..size-1){
                if(board[i][j] == '-'){
                    return false
                }
            }
        }
        return true
    }
    private fun checkRow(row:MutableList<Char>):Boolean{
        return row[1] == row[0] && row[1] == row[2]
    }
    private fun checkColumn(column:Int):Boolean{
        return board[0][column] == board[1][column] && board[1][column] == board[2][column]
    }

    private fun checkDiagonal():Boolean{
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0])
    }

}