package com.duokan.reader.ui.general.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders.Builder;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.duokan.core.b.UrlTools;
import com.duokan.reader.ui.general.n;

import org.apache.http.HttpHost;

public class a implements StreamModelLoader {
    private final Context a;

    public /* synthetic */ DataFetcher getResourceFetcher(Object obj, int i, int i2) {
        return a((n) obj, i, i2);
    }

    public a(Context context) {
        this.a = context;
    }

    public DataFetcher a(n nVar, int i, int i2) {
        String b = nVar.b();
        if (!TextUtils.isEmpty(b)) {
            if (UrlTools.compScheme(b, HttpHost.DEFAULT_SCHEME_NAME, "https")) {
                return new b(this, new GlideUrl(b, new Builder().addHeader("Accept-Encoding", "gzip,deflate,sdch").build()), nVar);
            }
        }
        return new c(this, this.a, Uri.parse(nVar.b()), nVar);
    }
}
