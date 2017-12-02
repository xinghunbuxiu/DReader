package com.duokan.d;

import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import com.duokan.core.app.x;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.reading.sh;

import java.io.File;

class c extends BroadcastReceiver {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ a c;

    c(a aVar, String str, long j) {
        this.c = aVar;
        this.a = str;
        this.b = j;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (!ReaderEnv.get().onMiui()) {
                sh shVar = (sh) x.a(context).queryFeature(sh.class);
                if (shVar != null) {
                    if (shVar.bk() != null) {
                        shVar.bk().c(this.a);
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
        }
        Cursor cursor = null;
        if (this.b == intent.getLongExtra("extra_download_id", -1)) {
            try {
                Query query = new Query();
                query.setFilterById(new long[]{this.b});
                cursor = this.c.c.query(query);
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("local_filename"));
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.fromFile(new File(string)), "application/vnd.android.package-archive");
                    intent2.setFlags(268435456);
                    this.c.b.startActivity(intent2);
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
