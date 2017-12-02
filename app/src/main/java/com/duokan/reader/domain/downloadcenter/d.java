package com.duokan.reader.domain.downloadcenter;

import android.content.Intent;
import android.net.Uri;

import com.duokan.reader.DkApp;

class d implements Runnable {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public void run() {
        Intent intent = new Intent(this.a.c, DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("duokan-reader://bookshelf"));
        intent.addFlags(268435456);
        b.n().a(intent);
        Intent intent2 = new Intent(this.a.c, DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("duokan-reader://bookshelf"));
        intent2.addFlags(268435456);
        b.n().b(intent2);
        intent2 = new Intent(this.a.c, DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("duokan-reader://bookshelf"));
        intent2.addFlags(268435456);
        b.n().c(intent2);
        this.a.x();
    }
}
