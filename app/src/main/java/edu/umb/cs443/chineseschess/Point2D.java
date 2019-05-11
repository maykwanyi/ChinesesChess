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
    @Override
    public boolean equals( Object that)
    {
        if (that instanceof Point2D) {
            Point2D other = (Point2D) that;
            return this.X == other.X && this.Y == other.Y;
        }
        return false;
    }

    public int GetHashCode()
    {
        return (new Integer(X).hashCode()) + (new Integer(Y).hashCode());
    }
}