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

public class Kategori3 extends Activity {

	ListView kategori3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kategori3);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		kategori3 = (ListView)findViewById(R.id.Kategori3);
		String[] values = new String[] { "Tips Memilih Nama Bayi" 
										,"Mempersiapkan Perlengkapan Bayi"
										,"10 Cara Perawatan Bayi Pertama"};
		
		ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
		kategori3.setAdapter(adapter);
		kategori3.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		            int position, long id) {
		            // When clicked, show a toast with the TextView text
		            if(position == 0) {
		                //code specific to first list item    
		            	Intent myIntent = new Intent(view.getContext(), Tips5.class);
		                startActivityForResult(myIntent, 0);
		            }

		            if(position == 1) {
		                //code specific to 2nd list item    
		                Intent myIntent = new Intent(view.getContext(), Tips6.class);
		                startActivityForResult(myIntent, 0);
		            }
		            
		            if(position == 2) {
		                //code specific to 2nd list item    
		                Intent myIntent = new Intent(view.getContext(), Tips9.class);
		                startActivityForResult(myIntent, 0);
		            }
		        }
		    });
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kategori3, menu);
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
