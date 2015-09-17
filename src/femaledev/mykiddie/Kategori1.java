package femaledev.mykiddie;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Kategori1 extends Activity {

	ListView kategori1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kategori1);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		kategori1 = (ListView)findViewById(R.id.Kategori1);
		String[] values = new String[] { "Catatan Penting Calon Ibu" 
										,"Mengenal Fase Kehamilan"};
		
		ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
		kategori1.setAdapter(adapter);
		kategori1.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		            int position, long id) {
		            // When clicked, show a toast with the TextView text
		            if(position == 0) {
		                //code specific to first list item    
		            	Intent myIntent = new Intent(view.getContext(), Tips1.class);
		                startActivityForResult(myIntent, 0);
		            }

		            if(position == 1) {
		                //code specific to 2nd list item    
		                Intent myIntent = new Intent(view.getContext(), Tips4.class);
		                startActivityForResult(myIntent, 0);
		            }
		        }
		    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kategori1, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	        
	    case R.id.tentang:
        	Tentang.Launch(this);
            return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

}
