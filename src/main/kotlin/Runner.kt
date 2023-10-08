
fun main(){
    val board = Board()
    val boardPrinter = BoardPrinter()
    val player1 = Player()
    player1.playerType = PlayerType.X
    val player2 = Player()
    player2.playerType = PlayerType.O
    val player1Input = readln()
    val p1Input = player1Input.split(" ")
    if(p1Input[0] == "X"){
        player1.name = p1Input[1]
    }
    val player2Input = readln()
    val p2Input = player2Input.split(" ")
    if(p2Input[0] == "O"){
        player2.name = p2Input[1]
    }
    board.initializeBoard(player1)
    boardPrinter.printBoard(board)

    while (true){
        println("${board.turn.name} enter move : ")
        var currentMove:Move =getCurrentMove()
        while (!board.turn.validateMove(board,currentMove)){
            println("Invalid move")
            println("${board.turn.name} enter move : ")
            currentMove = getCurrentMove()
        }
        board.turn.placeMove(currentMove,board)
        if(board.isWin()){
            println("${board.turn.name} Wins!!")
            break
        }
        else if(board.isDraw()){
            println("Match is Draw :O")
            break
        }
        if(board.turn.playerType== PlayerType.X){
            board.turn = player2
        }
        else{
            board.turn = player1
        }
        boardPrinter.printBoard(board)
    }
}
fun getCurrentMove():Move{
    val currentLine = readln()
    val intlist = currentLine.split(" ")
    val currentMove:Move = Move(intlist[0].toInt(),intlist[1].toInt())
    return currentMove
}