package com.duokan.p030d;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import com.duokan.reader.ReaderEnv;
import java.io.File;

/* renamed from: com.duokan.d.a */
public class C0399a {
    /* renamed from: a */
    public static C0399a f1345a;
    /* renamed from: b */
    private Context f1346b;
    /* renamed from: c */
    private DownloadManager f1347c = ((DownloadManager) this.f1346b.getSystemService("download"));

    private C0399a(Context context) {
        this.f1346b = context;
    }

    /* renamed from: a */
    public static C0399a m2174a(Context context) {
        if (f1345a == null) {
            f1345a = new C0399a(context);
        }
        return f1345a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public boolean m2176a(String str, String str2) {
        File file;
        Uri parse = Uri.parse(str);
        long updateDownloadTaskId = ReaderEnv.get().getUpdateDownloadTaskId();
        Request request = new Request(parse);
        request.setTitle(str2);
        if (parse.getLastPathSegment().contains(".apk")) {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment().replace(".apk", ".pkg"));
        } else {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment());
        }
        request.setDestinationUri(Uri.fromFile(file));
        request.setVisibleInDownloadsUi(false);
        long enqueue = this.f1347c.enqueue(request);
        if (updateDownloadTaskId != -1) {
            try {
                this.f1347c.remove(new long[]{updateDownloadTaskId});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ReaderEnv.get().setUpdateDownloadTaskId(enqueue);
        Query query = new Query();
        query.setFilterById(new long[]{enqueue});
        Cursor query2 = this.f1347c.query(query);
        query2.moveToFirst();
        query2.close();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        this.f1346b.registerReceiver(new C0400b(this, enqueue), intentFilter);
        return true;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public boolean m2177a(String str, String str2, String str3) {
        File file;
        Uri parse = Uri.parse(str);
        Request request = new Request(parse);
        request.setTitle(str2);
        if (parse.getLastPathSegment().contains(".apk")) {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment().replace(".apk", ".pkg"));
        } else {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment());
        }
        request.setDestinationUri(Uri.fromFile(file));
        request.setVisibleInDownloadsUi(false);
        request.setAllowedNetworkTypes(2);
        long enqueue = this.f1347c.enqueue(request);
        Query query = new Query();
        query.setFilterById(new long[]{enqueue});
        Cursor query2 = this.f1347c.query(query);
        query2.moveToFirst();
        query2.close();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        this.f1346b.registerReceiver(new C0401c(this, str3, enqueue), intentFilter);
        return true;
    }
}
