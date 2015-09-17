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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetailJadwal extends Activity {

	/** Called when the activity is first created. */
	public final static String STOREJADWAL="storejadwal.txt";
	public final static String STOREWAKTU="storewaktu.txt";
	public final static String STORETEMPAT="storetempat.txt";
	public final static String STORENOTES="storenotes.txt";
	private TextView teks1, teks2, teks3, teks4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_jadwal);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		teks1=(TextView)findViewById(R.id.jadwal);
		teks2=(TextView)findViewById(R.id.waktu);
		teks3=(TextView)findViewById(R.id.tempat);
		teks4=(TextView)findViewById(R.id.notes);
		readFileInEditor();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	        
	    case R.id.action_tambah_jadwal:
    		TambahJadwal.Launch(this);
        	return true;
        
	    case R.id.tentang:
        	Tentang.Launch(this);
            return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

	public static void Launch(Context c) {
	    Intent detailjadwal = new Intent(c, DetailJadwal.class);
	    c.startActivity(detailjadwal);  
	}
	
	public void readFileInEditor() {
		try {
		InputStream in1 = openFileInput(STOREJADWAL);
		InputStream in2 = openFileInput(STOREWAKTU);
		InputStream in3 = openFileInput(STORETEMPAT);
		InputStream in4 = openFileInput(STORENOTES);
		if (in1 != null) {
		InputStreamReader tmp1=new InputStreamReader(in1);
		InputStreamReader tmp2=new InputStreamReader(in2);
		InputStreamReader tmp3=new InputStreamReader(in3);
		InputStreamReader tmp4=new InputStreamReader(in4);
		BufferedReader reader1=new BufferedReader(tmp1);
		BufferedReader reader2=new BufferedReader(tmp2);
		BufferedReader reader3=new BufferedReader(tmp3);
		BufferedReader reader4=new BufferedReader(tmp4);
		String str1, str2, str3, str4;
		StringBuilder buf1=new StringBuilder();
		StringBuilder buf2=new StringBuilder();
		StringBuilder buf3=new StringBuilder();
		StringBuilder buf4=new StringBuilder();
		while (((str1 = reader1.readLine()) != null)&&((str2 = reader2.readLine()) != null)&&((str3 = reader3.readLine()) != null)&&((str4 = reader4.readLine()) != null)) {
		buf1.append(str1);
		buf2.append(str2);
		buf3.append(str3);
		buf4.append(str4);
		}
		in1.close();
		in2.close();
		in3.close();
		in4.close();
		teks1.setText(buf1.toString());
		teks2.setText(buf2.toString());
		teks3.setText(buf3.toString());
		teks4.setText(buf4.toString());
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
