package edu.umb.cs443.chineseschess;

public class Point2D
{
    public int X;
    public int Y;

    public Point2D (int X, int Y)
    {
        this.X = X;
        this.Y = Y;
    }
    public boolean equals(Point2D that)
    {
        return this.X == that.X && this.Y == that.Y;
    }

    public int GetHashCode()
    {
        return (new Integer(X).hashCode()) + (new Integer(Y).hashCode());
    }
}