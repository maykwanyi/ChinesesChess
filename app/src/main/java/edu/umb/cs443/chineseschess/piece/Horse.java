package edu.umb.cs443.chineseschess.piece;

import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;

public class Horse extends Piece {
    public Horse(boolean isRed, int X, int Y, int id)
    {
        super(isRed, X, Y, id);
    }
    @Override
    public boolean move(int X, int Y, Board board)
    {
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

    public LinkedList<Point2D> getMoveList(Board board)
    {
        LinkedList<Point2D> list = new LinkedList<Point2D>();

        if(board.isIn(X + 1, Y))
        {
            if (board.board[X + 1][Y].isEmpty && board.isIn(X + 2, Y + 1))
            { list.add(new Point2D(X + 2, Y + 1)); }
            if (board.board[X + 1][Y].isEmpty && board.isIn(X + 2, Y - 1))
                list.add(new Point2D(X + 2, Y - 1));
        }
        if (board.isIn(X - 1, Y)){
            if (board.board[X - 1][Y].isEmpty && board.isIn(X - 2, Y + 1))
            { list.add(new Point2D(X - 2, Y + 1)); }
            if (board.board[X - 1][Y].isEmpty && board.isIn(X - 2, Y - 1))
                list.add(new Point2D(X - 2, Y - 1));
        }
        if (board.isIn(X, Y + 1))
        {
            if (board.board[X][Y + 1].isEmpty && board.isIn(X + 1, Y + 2))
            { list.add(new Point2D(X + 1, Y + 2)); }
            if (board.board[X - 1][Y].isEmpty && board.isIn(X - 1, Y + 2))
                list.add(new Point2D(X - 1, Y + 2));
        }
        if (board.isIn(X, Y - 1))
        {
            if (board.board[X][Y - 1].isEmpty && board.isIn(X + 1, Y - 2))
            { list.add(new Point2D(X + 1, Y - 2)); }
            if (board.board[X][Y - 1].isEmpty && board.isIn(X - 1, Y - 2))
                list.add(new Point2D(X - 1, Y - 2));
        }
        return list;
    }
    @Override
    public String toString(){
        if(isRed)
            return "RH";
        else
            return "BH";
    }
}




