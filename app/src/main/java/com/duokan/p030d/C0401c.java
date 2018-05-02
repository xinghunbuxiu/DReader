package com.duokan.p030d;

import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.reading.su;
import java.io.File;

/* renamed from: com.duokan.d.c */
class C0401c extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ String f1350a;
    /* renamed from: b */
    final /* synthetic */ long f1351b;
    /* renamed from: c */
    final /* synthetic */ C0399a f1352c;

    C0401c(C0399a c0399a, String str, long j) {
        this.f1352c = c0399a;
        this.f1350a = str;
        this.f1351b = j;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (!ReaderEnv.get().onMiui()) {
                su suVar = (su) AppContext.getAppContext(context).queryFeature(su.class);
                if (suVar != null) {
                    if (suVar.bl() != null) {
                        suVar.bl().m12762c(this.f1350a);
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
        }
        Cursor cursor = null;
        if (this.f1351b == intent.getLongExtra("extra_download_id", -1)) {
            try {
                Query query = new Query();
                query.setFilterById(new long[]{this.f1351b});
                cursor = this.f1352c.f1347c.query(query);
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("local_filename"));
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.fromFile(new File(string)), "application/vnd.android.package-archive");
                    intent2.setFlags(268435456);
                    this.f1352c.f1346b.startActivity(intent2);
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
