package edu.umb.cs443.chineseschess.piece;


import java.awt.List;
import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;

public class Elephant extends Piece
{
    public Elephant(boolean isRed,int X, int Y, int id){
        super(isRed, X , Y , id);
    }

    public static boolean checkPos(int X, int Y, boolean isRed){
        if (isRed)
            return (X == 0 && Y == 2) || (X == 2 && Y == 0) || (X == 5 && Y == 0) || (X == 5 && Y == 2 ) || (X == 8 && Y == 2) || (X == 2 || Y == 5) || (X == 5 || Y == 5);
        else
            return (X == 0 && Y == 2) || (X == 2 && Y == 9) || (X == 5 && Y == 9) || (X == 5 && Y == 7) || (X == 8 && Y == 7) || (X == 2 || Y == 6) || (X == 5 || Y == 6);
    }

    public boolean move(int X, int Y, Board board){
        LinkedList<Point2D> movelist = getMoveList(board);
        if(movelist.contains(new Point2D(X,Y))){
            int oldX = this.X;
            int oldY = this.Y;
            this.X = X;
            this.Y = Y;
            board.updatePos(this, oldX, oldY);
            return true;
        }else
            return false;
    }

    public LinkedList<Point2D> getMoveList(Board board){
        LinkedList<Point2D> list = new LinkedList<Point2D>();
        if (isRed){
            if (board.isIn(super.X + 2, super.Y + 2) && board.board[X + 1][Y + 1].isEmpty && Y + 2 < board.RIVER_RED_SIDE)
                list.add(new Point2D(super.X + 2, super.Y + 2));
            if (board.isIn(super.X - 2, super.Y + 2) && board.board[X - 1][Y + 1].isEmpty && Y + 2 < board.RIVER_RED_SIDE)
                list.add(new Point2D(super.X - 2, super.Y + 2));
            if (board.isIn(super.X - 2, super.Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_RED_SIDE)
                list.add(new Point2D(X - 2, Y - 2));
            if (board.isIn(super.X + 2, Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_RED_SIDE)
                list.add(new Point2D(X + 2, Y - 2));
        }
        else{
            if (board.isIn(super.X + 2, Y + 2) && board.board[X + 1][Y + 1].isEmpty && Y + 2 < board.RIVER_BLACK_SIDE)
                list.add(new Point2D(X + 2, Y + 2));
            if (board.isIn(super.X - 2, Y + 2) && board.board[X - 1][Y + 1].isEmpty && Y + 2 < board.RIVER_BLACK_SIDE)
                list.add(new Point2D(X - 2, Y + 2));
            if (board.isIn(super.X - 2, Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_BLACK_SIDE)
                list.add(new Point2D(X - 2, Y - 2));
            if (board.isIn(super.X + 2, Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_BLACK_SIDE)
                list.add(new Point2D(X + 2, Y - 2));
        }
        return list;
    }


}


