package com.duokan.d;

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

public class a {
    public static a a;
    private Context b;
    private DownloadManager c = ((DownloadManager) this.b.getSystemService("download"));

    private a(Context context) {
        this.b = context;
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public boolean a(String str, String str2) {
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
        long enqueue = this.c.enqueue(request);
        if (updateDownloadTaskId != -1) {
            try {
                this.c.remove(new long[]{updateDownloadTaskId});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ReaderEnv.get().setUpdateDownloadTaskId(enqueue);
        Query query = new Query();
        query.setFilterById(new long[]{enqueue});
        Cursor query2 = this.c.query(query);
        query2.moveToFirst();
        query2.close();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        this.b.registerReceiver(new b(this, enqueue), intentFilter);
        return true;
    }

    @SuppressLint({"NewApi"})
    public boolean a(String str, String str2, String str3) {
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
        long enqueue = this.c.enqueue(request);
        Query query = new Query();
        query.setFilterById(new long[]{enqueue});
        Cursor query2 = this.c.query(query);
        query2.moveToFirst();
        query2.close();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        this.b.registerReceiver(new c(this, str3, enqueue), intentFilter);
        return true;
    }
}
