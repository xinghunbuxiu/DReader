package com.duokan.reader.ui.general.p053b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.duokan.reader.ui.general.C1342n;

/* renamed from: com.duokan.reader.ui.general.b.c */
class C1324c extends StreamLocalUriFetcher {
    /* renamed from: a */
    final /* synthetic */ C1342n f6952a;
    /* renamed from: b */
    final /* synthetic */ C1322a f6953b;

    C1324c(C1322a c1322a, Context context, Uri uri, C1342n c1342n) {
        this.f6953b = c1322a;
        this.f6952a = c1342n;
        super(context, uri);
    }

    public String getId() {
        return this.f6952a.m10939a();
    }
}
