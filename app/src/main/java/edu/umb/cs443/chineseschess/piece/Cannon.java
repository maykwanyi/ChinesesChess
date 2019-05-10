package edu.umb.cs443.chineseschess.piece;

import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;


public class Cannon extends Piece {

    public Cannon(boolean isRed, int x, int y, int id) {
        super(isRed,x,y,id);
    }

    public boolean move (int X, int Y, Board board) {
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

    public LinkedList<Point2D> getMoveList(Board board) {
        boolean isEnd = false;
        LinkedList<Point2D> list = new LinkedList<Point2D>();

        int targetX = X + 1;
        int targetY = Y;

        //odd while loop - for moving
        while (!isEnd && board.isIn(targetX,targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(isEnd)
                list.add(new Point2D(targetX, targetY));
            targetX++;
        }
        //even while loop - for eating
        while (!isEnd && board.isIn(targetX,targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(!isEnd && (board.board[targetX][targetY].isRed != isRed))
                list.add(new Point2D(targetX, targetY));
            targetX++;
        }

        //other direction
        targetX = X - 1;
        targetY = Y;

        while (!isEnd && board.isIn(targetX, targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(isEnd)
                list.add(new Point2D(targetX, targetY));
            targetX--;
        }

        while (!isEnd && board.isIn(targetX,targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(!isEnd && (board.board[targetX][targetY].isRed != isRed))
                list.add(new Point2D(targetX, targetY));
            targetX--;
        }

        targetX = X;
        targetY = Y + 1;

        while (!isEnd && board.isIn(targetX, targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(isEnd)
                list.add(new Point2D(targetX, targetY));
            targetY++;
        }

        while (!isEnd && board.isIn(targetX,targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(!isEnd && (board.board[targetX][targetY].isRed != isRed))
                list.add(new Point2D(targetX, targetY));
            targetY++;
        }


        targetX = X;
        targetY = Y - 1;
        while (!isEnd && board.isIn(targetX, targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(isEnd)
                list.add(new Point2D(targetX, targetY));
            targetY--;
        }

        while (!isEnd && board.isIn(targetX,targetY))
        {
            isEnd = board.board[targetX][targetY].isEmpty;
            if(!isEnd && (board.board[targetX][targetY].isRed != isRed))
                list.add(new Point2D(targetX, targetY));
            targetY--;
        }
        return list;
    }
}

