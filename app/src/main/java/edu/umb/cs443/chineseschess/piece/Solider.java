package edu.umb.cs443.chineseschess.piece;

import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;

public class Solider extends Piece
{
    boolean isCrossed;
    public Solider (boolean isRed, int X, int Y, int id)
    {
        super (isRed, X, Y, id);
    }

    public static boolean checkPos(Board board, int X, int Y, boolean isRed)
    {
        Solider s = new Solider(isRed, X, Y, 0);
        if (s.checkCrossed(board))
            return true;
        else
        {
            if (isRed && Y > 3 && (X == 0 || X == 2 || X == 4 || X == 6 || X == 8))
                return true;
            else if (!isRed && Y < 7 && (X == 0 || X == 2 || X == 4 || X == 6 || X == 8))
                return true;
        }
        return false;
    }

    private boolean checkCrossed (Board board)
    {
        if (isRed && Y > board.RIVER_RED_SIDE)
            return true;
        else if (isRed && Y < board.RIVER_BLACK_SIDE)
            return true;
        return false;
    }

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
        if (!checkCrossed(board))
        {
            if (isRed)
                list.add(new Point2D(X, Y + 1));
            else
                list.add(new Point2D(X, Y + 1));
        }
        else
        {
            if (isRed)
            {
                if (board.isIn(X + 1, Y))
                    list.add(new Point2D(X + 1, Y));
                if (board.isIn(X - 1, Y))
                    list.add(new Point2D(X - 1, Y));
                if (board.isIn(X, Y + 1))
                    list.add(new Point2D(X + 1, Y));
            }
            else
            {
                if (board.isIn(X + 1, Y))
                    list.add(new Point2D(X + 1, Y));
                if (board.isIn(X - 1, Y))
                    list.add(new Point2D(X - 1, Y));
                if (board.isIn(X, Y - 1))
                    list.add(new Point2D(X, Y - 1));
            }
        }
        return list;
    }
}