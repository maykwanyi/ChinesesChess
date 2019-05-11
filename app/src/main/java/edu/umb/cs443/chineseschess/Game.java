package edu.umb.cs443.chineseschess;


import edu.umb.cs443.chineseschess.piece.*;

public class Game {

    public static void init(Board board) {

    }

    public static void standardInit(Board board) {
        //initial pos of generals/kings (帅)
        generatePiece(board, true, 0, 4, 0);
        generatePiece(board, false,0, 4, 9);

        //initial pos of rooks (車)
        generatePiece(board, true, 1, 0, 0);
        generatePiece(board, true, 1, 8, 0);
        generatePiece(board, false, 1, 0, 9);
        generatePiece(board, false, 1, 8, 9);

        //initial pos of horses (马)
        generatePiece(board, true, 2, 1, 0);
        generatePiece(board, true, 2, 7, 0);
        generatePiece(board, false, 2, 1, 9);
        generatePiece(board, false, 2, 7, 9);

        //initial pos of elephants(相)
        generatePiece(board, true, 4, 2, 0);
        generatePiece(board, true, 4, 6, 0);
        generatePiece(board, false, 4, 2, 9);
        generatePiece(board, false, 4, 6, 9);

        //initial pos of advisors(士）
        generatePiece(board, true, 5, 3, 0);
        generatePiece(board, true, 5, 5, 0);
        generatePiece(board, false, 5, 3, 9);
        generatePiece(board, false, 5, 5, 9);

        //initial pos of cannons(炮)
        generatePiece(board, true, 3, 1, 2);
        generatePiece(board, true, 3, 7, 2);
        generatePiece(board, false, 3, 1, 7);
        generatePiece(board, false, 3, 7, 7);

        //initial pos of soliders(兵)
        for (int i = 0, X = 0 ,Y = 3; i < 10 && X < 9; i++, X += 2 ) {
            generatePiece(board, true, 6, X, Y);
            generatePiece(board, false, 6, X, Y + 3);
        }
    }

    public static void generatePiece(Board board, boolean isRed, int type, int X, int Y) {
        switch (type){
            case 0: //帅
                board.board[X][Y] = new General(isRed, X, Y, type);
                if(isRed)
                    board.RGP = new Point2D(X, Y);
                else
                    board.BGP = new Point2D(X, Y);
                break;
            case 1: //車
                board.board[X][Y] = new Rook(isRed, X, Y, type);
                break;
            case 2: //马
                board.board[X][Y] = new Horse(isRed, X, Y, type);
                break;
            case 3: //炮
                board.board[X][Y] = new Cannon(isRed, X, Y, type);
                break;
            case 4: //相
                board.board[X][Y] = new Elephant(isRed, X, Y, type);
                break;
            case 5: //士
                board.board[X][Y] = new Advisor(isRed, X, Y, type);
                break;
            case 6: //兵
                board.board[X][Y] = new Solider(isRed,X,Y,type);
        }

    }
}
