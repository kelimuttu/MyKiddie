package femaledev.mykiddie;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetailJadwal2 extends Activity {

	/** Called when the activity is first created. */
	public final static String STOREJADWAL2="storejadwal2.txt";
	public final static String STOREWAKTU2="storewaktu2.txt";
	public final static String STORETEMPAT2="storetempat2.txt";
	public final static String STORENOTES2="storenotes2.txt";
	private TextView teks5, teks6, teks7, teks8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_jadwal2);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		teks5=(TextView)findViewById(R.id.jadwal2);
		teks6=(TextView)findViewById(R.id.waktu2);
		teks7=(TextView)findViewById(R.id.tempat2);
		teks8=(TextView)findViewById(R.id.notes2);
		readFileInEditor();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.items, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	        
	    case R.id.action_tambah_jadwal:
    		TambahJadwal2.Launch(this);
        	return true;
        
	    case R.id.tentang:
        	Tentang.Launch(this);
            return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	public static void Launch(Context c) {
	    Intent detailjadwal = new Intent(c, DetailJadwal2.class);
	    c.startActivity(detailjadwal);  
	}
	
	public void readFileInEditor() {
		try {
		InputStream in5 = openFileInput(STOREJADWAL2);
		InputStream in6 = openFileInput(STOREWAKTU2);
		InputStream in7 = openFileInput(STORETEMPAT2);
		InputStream in8 = openFileInput(STORENOTES2);
		if (in5 != null) {
		InputStreamReader tmp5=new InputStreamReader(in5);
		InputStreamReader tmp6=new InputStreamReader(in6);
		InputStreamReader tmp7=new InputStreamReader(in7);
		InputStreamReader tmp8=new InputStreamReader(in8);
		BufferedReader reader5=new BufferedReader(tmp5);
		BufferedReader reader6=new BufferedReader(tmp6);
		BufferedReader reader7=new BufferedReader(tmp7);
		BufferedReader reader8=new BufferedReader(tmp8);
		String str5, str6, str7, str8;
		StringBuilder buf5=new StringBuilder();
		StringBuilder buf6=new StringBuilder();
		StringBuilder buf7=new StringBuilder();
		StringBuilder buf8=new StringBuilder();
		while (((str5 = reader5.readLine()) != null)&&((str6 = reader6.readLine()) != null)&&((str7 = reader7.readLine()) != null)&&((str8 = reader8.readLine()) != null)) {
		buf5.append(str5);
		buf6.append(str6);
		buf7.append(str7);
		buf8.append(str8);
		}
		in5.close();
		in6.close();
		in7.close();
		in8.close();
		teks5.setText(buf5.toString());
		teks6.setText(buf6.toString());
		teks7.setText(buf7.toString());
		teks8.setText(buf8.toString());
		}
		}
		catch (java.io.FileNotFoundException e) {
		// that's OK, we probably haven't created it yet
		}
			catch (Throwable t) {
			Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
			}
		}
	
}
