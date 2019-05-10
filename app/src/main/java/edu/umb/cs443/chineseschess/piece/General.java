package edu.umb.cs443.chineseschess.piece;


import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;

public class General extends Piece
{

    public General(boolean isRed, int X, int Y, int id)
    {
        super(isRed, X, Y, id);
    }

    public boolean move (int X, int Y, Board board)
    {
        if (checkMove(X, Y,board) && isRed)
        {
            int oldX = this.X;
            int oldY = this.Y;
            this.X = X;
            this.Y = Y;
            board.RGP.X = X;
            board.RGP.Y = Y;
            eat(board);
            board.updatePos(this,oldX,oldY);
            return true;
        }

        else if (!isRed && checkMove(X, Y, board))
        {
            int oldX = this.X;
            int oldY = this.Y;
            this.X = X;
            this.Y = Y;
            board.BGP.X = X;
            board.BGP.Y = Y;
            eat(board);
            board.updatePos(this, oldX, oldY);
            return true;
        }/*
        else if (board.RGP.Y == board.BGP.Y)
        {
            bool hasCovers = false;
            for (int i = board.RGP.X; i < board.BGP.X; i++)
                if (board.board[board.RGP.X][i].isEmpty)
                {
                    hasCovers = true;
                    break;
                }
            if (!hasCovers)
            {
                if (isRed)
                {
                    this.X = board.BGX;
                    this.Y = board.BGY;
                    eat(board);
                }
                else
                {
                    this.X = board.RGP.X;
                    this.Y = board.RGP.Y;
                    eat(board);
                }
                return true;
            }     */


        return false;
    }
    public LinkedList<Point2D> getMoveList(Board board)
    {
        LinkedList <Point2D> list= new LinkedList<Point2D>();

        if (checkMove(X++, Y, board))
            list.add(new Point2D(X, Y));
        if (checkMove(X--, Y, board))
            list.add(new Point2D(X, Y));
        if (checkMove(X, Y++, board))
            list.add(new Point2D(X, Y));
        if (checkMove(X, Y--, board))
            list.add(new Point2D(X, Y));
        if (checkMove(board.RGP.X, board.RGP.Y,board))
            list.add(new Point2D(board.RGP.X, board.RGP.Y));
        if (checkMove(board.BGP.X, board.BGP.Y, board))
            list.add(new Point2D(board.BGP.X, board.BGP.Y));

        return list;
    }

    private boolean checkMove(int X, int Y,Board board)
    {
        if (isRed && X >= 3 && X <= 5 && Y <= 2 && Y >= 0 && (Math.abs(X - this.X) == 1 ^ Math.abs(Y - this.Y) == 1) && (board.board[X][Y].isEmpty) && X != this.X && Y != this.Y)
            return true;
        else if (!isRed && X >= 3 && X <= 5 && Y >= 7 && Y <= 9 && (Math.abs(X - this.X) == 1 ^ Math.abs(Y - this.Y) == 1) && (board.board[X][Y].isEmpty) && X != this.X && Y != this.Y)
            return true;
        else if (board.RGP.Y == board.BGP.Y)
        {
            boolean hasCovers = false;
            for (int i = board.RGP.X; i < board.BGP.X; i++)
                if (board.board[board.RGP.X][i].isEmpty)
                {
                    hasCovers = true;
                    break;
                }
            if (!hasCovers)
                return true;
        }
        return false;
    }
}
