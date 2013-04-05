package com.example.receiverShow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: BenMonro
 * Date: 4/1/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class fromMani extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle resultExtras = getResultExtras(false);
        ;
        Log.d("BLAH", "Blah from mani = " + resultExtras.get("myExtra") + " " + resultExtras.getBoolean("myBoolean", false));
    }
}
