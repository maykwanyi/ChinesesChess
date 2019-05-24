package edu.umb.cs443.chineseschess;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class listAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the pieces images
    private final Integer[] imageIDarray;

    //to store the list of countries
    private final String[] nameArray;

    public listAdapter(Activity context, String[] nameArrayParam, Integer[] imageIDArrayParam){
        super(context,R.layout.listview, nameArrayParam);

        this.context=context;
        this.imageIDarray=imageIDArrayParam;
        this.nameArray=nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview, null,true);

        //this code gets references to objects in the listview.xml file
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image_rook_black);
        /*
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.image_horse_black);
        ImageView imageView3 = (ImageView) rowView.findViewById(R.id.image_elephant_black);
        ImageView imageView4 = (ImageView) rowView.findViewById(R.id.image_advisor_black);
        ImageView imageView5 = (ImageView) rowView.findViewById(R.id.image_general_black);
        ImageView imageView6 = (ImageView) rowView.findViewById(R.id.image_cannon_black);
        ImageView imageView7 = (ImageView) rowView.findViewById(R.id.image_solider_black);
        */

        //this code sets the values of the objects to values from the arrays
        /*
        imageView1.setImageResource(imageIDarray[position]);
        imageView2.setImageResource(imageIDarray[position]);
        imageView3.setImageResource(imageIDarray[position]);
        imageView4.setImageResource(imageIDarray[position]);
        imageView5.setImageResource(imageIDarray[position]);
        imageView4.setImageResource(imageIDarray[position]);
        imageView3.setImageResource(imageIDarray[position]);
        imageView2.setImageResource(imageIDarray[position]);
        imageView1.setImageResource(imageIDarray[position]);
        */
        imageView.setImageResource(position);

        return rowView;
    };
}
