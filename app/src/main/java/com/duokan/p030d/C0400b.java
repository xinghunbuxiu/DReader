package com.duokan.p030d;

import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import java.io.File;

/* renamed from: com.duokan.d.b */
class C0400b extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ long f1348a;
    /* renamed from: b */
    final /* synthetic */ C0399a f1349b;

    C0400b(C0399a c0399a, long j) {
        this.f1349b = c0399a;
        this.f1348a = j;
    }

    public void onReceive(Context context, Intent intent) {
        Cursor cursor = null;
        if (this.f1348a == intent.getLongExtra("extra_download_id", -1)) {
            try {
                Query query = new Query();
                query.setFilterById(new long[]{this.f1348a});
                cursor = this.f1349b.f1347c.query(query);
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("local_filename"));
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.fromFile(new File(string)), "application/vnd.android.package-archive");
                    intent2.setFlags(268435456);
                    this.f1349b.f1346b.startActivity(intent2);
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
