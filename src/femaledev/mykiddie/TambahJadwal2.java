package femaledev.mykiddie;

import java.io.OutputStreamWriter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class TambahJadwal2 extends Activity {

	/** Called when the activity is first created. */
	public final static String STOREJADWAL2="storejadwal2.txt";
	public final static String STOREWAKTU2="storewaktu2.txt";
	public final static String STORETEMPAT2="storetempat2.txt";
	public final static String STORENOTES2="storenotes2.txt";
	private EditText txtfield5, txtfield6, txtfield7, txtfield8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tambah_jadwal2);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		txtfield5=(EditText)findViewById(R.id.InputJadwal2);
		txtfield6=(EditText)findViewById(R.id.InputWaktu2);
		txtfield7=(EditText)findViewById(R.id.InputTempat2);
		txtfield8=(EditText)findViewById(R.id.InputNotes2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tambah_jadwal, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	        
	    case R.id.action_accept:
	    	saveClicked(item);
            return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

	public static void Launch(Context c) {
	    Intent inputjadwal = new Intent(c, TambahJadwal2.class);
	    c.startActivity(inputjadwal);  
	}
	
	public void saveClicked(MenuItem item) {
		try { 
		OutputStreamWriter out5= new OutputStreamWriter(openFileOutput(STOREJADWAL2, 0));
		OutputStreamWriter out6= new OutputStreamWriter(openFileOutput(STOREWAKTU2, 0));
		OutputStreamWriter out7= new OutputStreamWriter(openFileOutput(STORETEMPAT2, 0));
		OutputStreamWriter out8= new OutputStreamWriter(openFileOutput(STORENOTES2, 0));
		out5.write(txtfield5.getText().toString());
		out6.write(txtfield6.getText().toString());
		out7.write(txtfield7.getText().toString());
		out8.write(txtfield8.getText().toString());
		out5.close();
		out6.close();
		out7.close();
		out8.close();
		if (STOREJADWAL2 != null){
			Toast.makeText(this, "Jadwal tersimpan!", Toast.LENGTH_LONG).show();
				}
		}
		catch (Throwable t) {
			Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
		}	
		DetailJadwal2.Launch(this);
	}
	
}
