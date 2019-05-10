package edu.umb.cs443.chinesechess;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {
    GridView gridView;
    private String[] numbers = new String[8*9];

    Thread t1;
    MoveTask t2;

    private static int a, target;
    private Object object = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView1);

        for (int i = 0; i < numbers.length; i++) numbers[i] = " ";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.selected_piece, numbers);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                t2=new MoveTask();
                t2.execute(new Integer(position));
            }
        });

        t1=new Thread(new Runnable(){
            public void run(){
                while(true) {
                    gridView.post(new Runnable() {
                        public void run() {
                            ((ArrayAdapter) gridView.getAdapter()).notifyDataSetChanged();
                        }
                    });
                }
            }
        }

        );
        t1.start();
    }


    private class MoveTask extends AsyncTask<Integer, Void, Void>{
        @Override
        protected Void doInBackground(Integer... params) {
            target=params[0].intValue();
            Log.i("myTag", params[0].toString());

            publishProgress();

            return null;
        }

        protected void onProgressUpdate(Void... values) {
            ((ArrayAdapter)gridView.getAdapter()).notifyDataSetChanged();
        }

    }

    public void elephant(View action){
        //...
    }

    public void advisor(View action){
        //...
    }

    public void horse(View action){
        //...
    }

    public void rook(View action){
        //...
    }

    public void general(View action){
        //...
    }

    public void solider(View action){
        //...
    }
}
