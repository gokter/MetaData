package com.flyingh.metadata;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			ActivityInfo activityInfo = getPackageManager().getActivityInfo(
					new ComponentName(this, MainActivity.class), PackageManager.GET_META_DATA);
			String name = activityInfo.metaData.getString("com.flyingh.name");
			int age = activityInfo.metaData.getInt("com.flyingh.age");
			String app = activityInfo.metaData.getString("com.flyingh.app");
			int id = activityInfo.metaData.getInt("com.flyingh.id");
			Toast.makeText(
					this,
					"name:" + name + ",age:" + age + ",app:" + app + ",id:" + id + ",id=0x7f0a000e:"
							+ (id == 0x7f0a000e), Toast.LENGTH_LONG).show();
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
