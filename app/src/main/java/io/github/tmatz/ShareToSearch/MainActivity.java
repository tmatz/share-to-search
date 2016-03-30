package io.github.tmatz.ShareToSearch;

import android.app.*;
import android.os.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String action = intent.getAction();
		if (Intent.ACTION_SEND.equals(action)) {
			Bundle extras = intent.getExtras();
			if (extras != null) {
				CharSequence ext = extras.getCharSequence(Intent.EXTRA_TEXT);
				if (ext != null) {
					Intent intentSearch = new Intent(Intent.ACTION_WEB_SEARCH);
					intentSearch.putExtra(SearchManager.QUERY, ext);
					startActivity(intentSearch);
					finish();
					return;
				}
			}
		}
        setContentView(R.layout.main);
    }
}
