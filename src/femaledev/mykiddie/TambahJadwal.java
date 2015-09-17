package femaledev.mykiddie;

import java.io.OutputStreamWriter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class TambahJadwal extends Activity {

	/** Called when the activity is first created. */
	public final static String STOREJADWAL="storejadwal.txt";
	public final static String STOREWAKTU="storewaktu.txt";
	public final static String STORETEMPAT="storetempat.txt";
	public final static String STORENOTES="storenotes.txt";
	private EditText txtfield1, txtfield2, txtfield3, txtfield4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tambah_jadwal);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		txtfield1=(EditText)findViewById(R.id.InputJadwal);
		txtfield2=(EditText)findViewById(R.id.InputWaktu);
		txtfield3=(EditText)findViewById(R.id.InputTempat);
		txtfield4=(EditText)findViewById(R.id.InputNotes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tambah_jadwal, menu);
        return super.onCreateOptionsMenu(menu);
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
	    Intent inputjadwal = new Intent(c, TambahJadwal.class);
	    c.startActivity(inputjadwal);  
	}
	
	public void saveClicked(MenuItem item) {
		try { 
		OutputStreamWriter out1= new OutputStreamWriter(openFileOutput(STOREJADWAL, 0));
		OutputStreamWriter out2= new OutputStreamWriter(openFileOutput(STOREWAKTU, 0));
		OutputStreamWriter out3= new OutputStreamWriter(openFileOutput(STORETEMPAT, 0));
		OutputStreamWriter out4= new OutputStreamWriter(openFileOutput(STORENOTES, 0));
		out1.write(txtfield1.getText().toString());
		out2.write(txtfield2.getText().toString());
		out3.write(txtfield3.getText().toString());
		out4.write(txtfield4.getText().toString());
		out1.close();
		out2.close();
		out3.close();
		out4.close();
		if (STOREJADWAL != null){
			Toast.makeText(this, "Jadwal tersimpan!", Toast.LENGTH_LONG).show();
				}
		}
		catch (Throwable t) {
			Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
		}	
		DetailJadwal.Launch(this);
	}
		
}