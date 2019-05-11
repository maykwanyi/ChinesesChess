package edu.umb.cs443.chineseschess.piece;

import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;

public class Advisor extends Piece {
    public Advisor(boolean isRed, int X, int Y, int id){
        super(isRed, X, Y, id);
    }
    @Override
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
            if (board.isInRedPalace(X + 1, Y + 1))
                list.add(new Point2D(X + 1, Y + 1));
            if (board.isInRedPalace(X - 1, Y - 1))
                list.add(new Point2D(X - 1, Y - 1));
            if (board.isInRedPalace(X + 1, Y - 1))
                list.add(new Point2D(X + 1, Y - 1));
            if (board.isInRedPalace(X - 1, Y + 1))
                list.add(new Point2D(X - 1, Y + 1));
        }
        else{
            if (board.isInBlackPalace(X + 1, Y + 1))
                list.add(new Point2D(X + 1, Y + 1));
            if (board.isInBlackPalace(X - 1, Y - 1))
                list.add(new Point2D(X - 1, Y - 1));
            if (board.isInBlackPalace(X + 1, Y - 1))
                list.add(new Point2D(X + 1, Y - 1));
            if (board.isInBlackPalace(X - 1, Y + 1))
                list.add(new Point2D(X - 1, Y + 1));
        }
        return list;
    }
    public static boolean checkPos(int X, int Y,boolean isRed){
        if (isRed && (X == 4 && Y == 0) || (X == 5 && Y == 1) || (X == 6 && Y == 0) || (X == 4 && Y == 2) || (X == 6 && Y == 2))
            return true;
        else if (!isRed && (X == 4 && Y == 9) || (X == 5 && Y == 8) || (X == 6 && Y == 9) || (X == 4 && Y == 7) || (X == 6 && Y == 7))
            return true;
        return false;
    }
    @Override
    public String toString(){
        if(isRed)
            return "RA";
        else
            return "BA";
    }
}


