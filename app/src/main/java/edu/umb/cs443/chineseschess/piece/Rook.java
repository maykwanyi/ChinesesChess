package edu.umb.cs443.chineseschess.piece;
import java.util.LinkedList;

import edu.umb.cs443.chineseschess.Board;
import edu.umb.cs443.chineseschess.Point2D;
public class Rook extends Piece {
    public Rook(boolean isRed, int X, int Y, int id)
    {
        super(isRed, X, Y, id);
    }

    @Override
    public boolean move (int X, int Y,Board board)
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
        boolean isEnd = false;
        LinkedList<Point2D> list = new LinkedList<Point2D>();
        int targetX,targetY;
        if(board.isIn(X + 1, Y)) {
            targetX = X + 1;
            targetY = Y;

            while (!isEnd && board.isIn(targetX, targetY)) {
                isEnd = !board.board[targetX][targetY].isEmpty;
                list.add(new Point2D(targetX, targetY));
                targetX++;
            }
            isEnd = false;
        }

        if(board.isIn(X - 1, Y)) {
            targetX = X - 1;
            targetY = Y;

            while (!isEnd && board.isIn(targetX, targetY)) {
                isEnd = !board.board[targetX][targetY].isEmpty;
                list.add(new Point2D(targetX, targetY));
                targetX--;
            }
            isEnd = false;
        }

        if(board.isIn(X, Y+1)) {
            targetX = X;
            targetY = Y + 1;

            while (!isEnd && board.isIn(targetX, targetY)) {
                isEnd = !board.board[targetX][targetY].isEmpty;
                list.add(new Point2D(targetX, targetY));
                targetY++;
            }
            isEnd = false;
        }

        if(board.isIn(X, Y - 1)) {
            targetX = X;
            targetY = Y - 1;
            while (!isEnd && board.isIn(targetX, targetY)) {
                isEnd = !board.board[targetX][targetY].isEmpty;
                list.add(new Point2D(targetX, targetY));
                targetY--;
            }
            isEnd = false;
        }
        return list;
    }
    @Override
    public String toString(){
        if(isRed)
            return "RR";
        else
            return "BR";
    }
}

