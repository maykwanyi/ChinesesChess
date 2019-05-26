package edu.umb.cs443.chineseschess;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class listAdapter extends ArrayAdapter<Integer> {
    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final Integer[] imageIDarray;

    public listAdapter(Activity context, Integer[] imageIDArrayParam){
        super(context,R.layout.listview, imageIDArrayParam);

        this.context=context;
        this.imageIDarray=imageIDArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview, null,true);

        //this code gets references to objects in the listview.xml file
        ImageView imageView = (ImageView) rowView.findViewById(R.id.rook_black);

        //this code sets the values of the objects to values from the arrays
        imageView.setImageResource(imageIDarray[position]);

        return rowView;
    };
}
