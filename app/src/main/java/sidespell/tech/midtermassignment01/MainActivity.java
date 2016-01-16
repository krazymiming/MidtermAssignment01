package sidespell.tech.midtermassignment01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] countries = new String[] {
            "India",
            "Pakistan",
            "Sri Lanka",
            "China",
            "Bangladish",
            "Nepal",
            "Afghanistan",
            "North Korea",
            "Philippines"
    };

    int[] flags = new int[]{
            R.drawable.india,
            R.drawable.pakistan,
            R.drawable.srilanka,
            R.drawable.china,
            R.drawable.bangladish,
            R.drawable.nepal,
            R.drawable.afghanistan,
            R.drawable.philippines,
            R.drawable.northkorea
    };

    String[] currency = new String[]{
            "Indian Rupee",
            "Pakistani Rupee",
            "Sri Lankan Rupee",
            "Bangladeshi Taka",
            "Nepalese Rupee",
            "Afghani Rupee",
            "North Korean Won",
            "Philippines Won",
            "China Won  "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }



    });

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<9;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", countries[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            hm.put("cur", currency[i]);
            aList.add(hm);
        }

        String[] from = { "flag","txt"};

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.auto_complete, from, to);

        // Getting a reference to CustomAutoCompleteTextView of activity_main.xml layout file
        AutoComplete autoComplete = ( AutoComplete) findViewById(R.id.autocomplete);

        /** Defining an itemclick event listener for the autocompletetextview */
        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

                /** Each item in the adapter is a HashMap object.
                 *  So this statement creates the currently clicked hashmap object
                 * */
                HashMap<String, String> hm = (HashMap<String, String>) arg0.getAdapter().getItem(position);

                /** Getting a reference to the TextView of the layout file activity_main to set Currency */
                TextView tvCurrency = (TextView) findViewById(R.id.tv_currency) ;

                /** Getting currency from the HashMap and setting it to the textview */
                tvCurrency.setText("Currency : " + hm.get("cur"));
            }
        };

        /** Setting the itemclick event listener */
        autoComplete.setOnItemClickListener(itemClickListener);

        /** Setting the adapter to the listView */
        autoComplete.setAdapter(adapter);

    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        TextView tvCurrency = (TextView) findViewById(R.id.tv_currency) ;
//        outState.putString("currency", tvCurrency.getText().toString());
//        super.onSaveInstanceState(outState);
//    }
//
//    /** A callback method, which is executed when the activity is recreated
//     * ( eg :  Configuration changes : portrait -> landscape )
//     */
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        TextView tvCurrency = (TextView) findViewById(R.id.tv_currency) ;
//        tvCurrency.setText(savedInstanceState.getString("currency"));
//        super.onRestoreInstanceState(savedInstanceState);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
