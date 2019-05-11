package edu.umb.cs443.chineseschess.piece;

import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;

public class Piece
{
    public boolean isEmpty;
    public boolean isRed;
    public int X;
    public int Y;

    public int id;
    public Piece(boolean isRed, int X, int Y, int id)
    {
        this.X = X;
        this.Y = Y;
        this.isRed = isRed;
        isEmpty = false;
        this.id = id;
    }
    public Piece(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
        isEmpty = true;
    }/*
    public void eat (Board board)
    {
        if (!board.board[X][Y].isEmpty && board.board[X][Y].isRed != isRed)
        {
            board.board[X][Y] = this;
            if (new Point2D(X, Y).equals(board.RGP))
                Game.checkmate("RED");
            else if (new Point2D(X, Y).equals(board.BGP))
                Game.checkmate("BLACK");
        }
    } */
    public String toString(){
        return " ";
    }

    public boolean move(int X, int Y, Board board){
        return false;
    }
}

