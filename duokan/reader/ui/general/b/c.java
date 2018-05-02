package com.duokan.reader.ui.general.b;

import android.content.Context;
import android.net.Uri;

import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.duokan.reader.ui.general.n;

class c extends StreamLocalUriFetcher {
    final /* synthetic */ n a;
    final /* synthetic */ a b;

    c(a aVar, Context context, Uri uri, n nVar) {
        this.b = aVar;
        this.a = nVar;
        super(context, uri);
    }

    public String getId() {
        return this.a.a();
    }
}
