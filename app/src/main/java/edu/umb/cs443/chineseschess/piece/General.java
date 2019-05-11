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
    @Override
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
            //eat(board);
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
            //eat(board);
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

        if (checkMove(X + 1, Y, board))
            list.add(new Point2D(X + 1, Y));
        if (checkMove(X - 1, Y, board))
            list.add(new Point2D(X - 1, Y));
        if (checkMove(X, Y + 1, board))
            list.add(new Point2D(X, Y + 1));
        if (checkMove(X, Y - 1, board))
            list.add(new Point2D(X, Y - 1));
        if (checkMove(board.RGP.X, board.RGP.Y,board) && !isRed)
            list.add(new Point2D(board.RGP.X, board.RGP.Y));
        if (checkMove(board.BGP.X, board.BGP.Y, board) && isRed)
            list.add(new Point2D(board.BGP.X, board.BGP.Y));

        return list;
    }

    private boolean checkMove(int X, int Y,Board board)
    {
        if(isRed && board.isInRedPalace(X , Y))
            return true;
        else if (!isRed && board.isInBlackPalace(X, Y))
            return true;
        else if (board.BGP.X == board.RGP.X){
            for (int i = board.RGP.Y + 1; i < board.board[0].length - 1; i++){
                if (!board.board[board.RGP.X][i].isEmpty)
                    return false;
            }
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        if(isRed)
            return "帥";
        else
            return "將";
    }
}
