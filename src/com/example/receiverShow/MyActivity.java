package com.example.receiverShow;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MyActivity extends Activity {
    private BroadcastReceiver lastGuy;
    private BroadcastReceiver myGuy = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle resultExtras = getResultExtras(false);
            ;
            Log.d("BLAH", "Blah from ui");
            Bundle extras = new Bundle();
            extras.putString("myExtra", "blah");
            extras.putBoolean("myBoolean", true);
            setResultExtras(extras);
            setResultCode(Activity.RESULT_OK);
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent blah = new Intent("BLAH");
                blah.putExtra("hello", "world");

                blah.setType("application/vnd.zonar.2020.OMIUSR.1");
                MyActivity.this.sendOrderedBroadcast(blah, null, lastGuy, null, Activity.RESULT_FIRST_USER, "0", null);

            }
        });
    }

    @Override
    protected void onResume() {
        IntentFilter myGuyFilter = new IntentFilter();
        myGuyFilter.addAction("BLAH");
        try {
            myGuyFilter.addDataType("application/vnd.zonar.2020.OMIUSR.1");
        } catch (IntentFilter.MalformedMimeTypeException e) {
            Log.e("BLAH", "error", e);
        }
        myGuyFilter.setPriority(2);
        registerReceiver(myGuy, myGuyFilter);
        super.onResume();
    }
}
