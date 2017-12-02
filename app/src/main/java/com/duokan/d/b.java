package com.duokan.d;

import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import java.io.File;

class b extends BroadcastReceiver {
    final /* synthetic */ long a;
    final /* synthetic */ a b;

    b(a aVar, long j) {
        this.b = aVar;
        this.a = j;
    }

    public void onReceive(Context context, Intent intent) {
        Cursor cursor = null;
        if (this.a == intent.getLongExtra("extra_download_id", -1)) {
            try {
                Query query = new Query();
                query.setFilterById(new long[]{this.a});
                cursor = this.b.c.query(query);
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("local_filename"));
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.fromFile(new File(string)), "application/vnd.android.package-archive");
                    intent2.setFlags(268435456);
                    this.b.b.startActivity(intent2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (cursor != null) {
            cursor.close();
        }
    }
}
