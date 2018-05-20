package com.duokan.p030d;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;

import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.reading.su;

import java.io.File;


public class DownloadUtil {

    public static DownloadUtil downloadUtil;

    private Context context;

    private DownloadManager downloadManager = ((DownloadManager) this.context.getSystemService(Context.DOWNLOAD_SERVICE));

    private DownloadUtil(Context context) {
        this.context = context;
    }


    public static DownloadUtil init(Context context) {
        if (downloadUtil == null) {
            downloadUtil = new DownloadUtil(context);
        }
        return downloadUtil;
    }

    @SuppressLint({"NewApi"})

    public boolean downloadAPK(String url, String title) {
        File file;
        Uri parse = Uri.parse(url);
        long updateDownloadTaskId = ReaderEnv.get().getUpdateDownloadTaskId();
        Request request = new Request(parse);
        request.setTitle(title);
        if (parse.getLastPathSegment().contains(".apk")) {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment().replace(".apk", ".pkg"));
        } else {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment());
        }
        request.setDestinationUri(Uri.fromFile(file));
        request.setVisibleInDownloadsUi(false);
        long enqueue = this.downloadManager.enqueue(request);
        if (updateDownloadTaskId != -1) {
            try {
                this.downloadManager.remove(new long[]{updateDownloadTaskId});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ReaderEnv.get().setUpdateDownloadTaskId(enqueue);
        Query query = new Query();
        query.setFilterById(new long[]{enqueue});
        Cursor query2 = this.downloadManager.query(query);
        query2.moveToFirst();
        query2.close();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        this.context.registerReceiver(new DownLoadReceiver(this, enqueue), intentFilter);
        return true;
    }

    class DownLoadReceiver extends BroadcastReceiver {

        final long download_id;

        final DownloadUtil downloadUtil;

        DownLoadReceiver(DownloadUtil downloadUtil, long download_id) {
            this.downloadUtil = downloadUtil;
            this.download_id = download_id;
        }

        public void onReceive(Context context, Intent intent) {
            Cursor cursor = null;
            if (this.download_id == intent.getLongExtra("extra_download_id", -1)) {
                try {
                    Query query = new Query();
                    query.setFilterById(new long[]{this.download_id});
                    cursor = this.downloadUtil.downloadManager.query(query);
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndex("local_filename"));
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(Uri.fromFile(new File(string)), "application/vnd.android.package-archive");
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        this.downloadUtil.context.startActivity(intent2);
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
    @SuppressLint({"NewApi"})
    public boolean downloadAPK(String url, String title, String fileName) {
        File file;
        Uri parse = Uri.parse(url);
        Request request = new Request(parse);
        request.setTitle(title);
        if (parse.getLastPathSegment().contains(".apk")) {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment().replace(".apk", ".pkg"));
        } else {
            file = new File(ReaderEnv.get().getCacheDirectory(), parse.getLastPathSegment());
        }
        request.setDestinationUri(Uri.fromFile(file));
        request.setVisibleInDownloadsUi(false);
        request.setAllowedNetworkTypes(2);
        long enqueue = this.downloadManager.enqueue(request);
        Query query = new Query();
        query.setFilterById(new long[]{enqueue});
        Cursor query2 = this.downloadManager.query(query);
        query2.moveToFirst();
        query2.close();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        this.context.registerReceiver(new DownLoadStatusReceive(this, fileName, enqueue), intentFilter);
        return true;
    }


    class DownLoadStatusReceive extends BroadcastReceiver {

        final String fileName;

        final long download_id;

        final DownloadUtil downloadUtil;

        DownLoadStatusReceive(DownloadUtil downloadUtil, String fileName, long download_id) {
            this.downloadUtil = downloadUtil;
            this.fileName = fileName;
            this.download_id = download_id;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (!ReaderEnv.get().onMiui()) {
                    su suVar = (su) AppContext.getAppContext(context).queryFeature(su.class);
                    if (suVar != null) {
                        if (suVar.bl() != null) {
                            suVar.bl().m12762c(this.fileName);
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Cursor cursor = null;
            if (this.download_id == intent.getLongExtra("extra_download_id", -1)) {
                try {
                    Query query = new Query();
                    query.setFilterById(new long[]{this.download_id});
                    cursor = this.downloadUtil.downloadManager.query(query);
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndex("local_filename"));
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(Uri.fromFile(new File(string)), "application/vnd.android.package-archive");
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        this.downloadUtil.context.startActivity(intent2);
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
}
