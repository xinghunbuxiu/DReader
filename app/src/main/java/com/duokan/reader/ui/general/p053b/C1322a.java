package com.duokan.reader.ui.general.p053b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders.Builder;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.duokan.core.p027b.C0324a;
import com.duokan.reader.ui.general.C1342n;
import java.io.InputStream;
import org.apache.http.HttpHost;

/* renamed from: com.duokan.reader.ui.general.b.a */
public class C1322a implements StreamModelLoader<C1342n> {
    /* renamed from: a */
    private final Context f6949a;

    public /* synthetic */ DataFetcher getResourceFetcher(Object obj, int i, int i2) {
        return m10242a((C1342n) obj, i, i2);
    }

    public C1322a(Context context) {
        this.f6949a = context;
    }

    /* renamed from: a */
    public DataFetcher<InputStream> m10242a(C1342n c1342n, int i, int i2) {
        String b = c1342n.m10940b();
        if (!TextUtils.isEmpty(b)) {
            if (C0324a.m735a(b, HttpHost.DEFAULT_SCHEME_NAME, "https")) {
                return new C1323b(this, new GlideUrl(b, new Builder().addHeader("Accept-Encoding", "gzip,deflate,sdch").build()), c1342n);
            }
        }
        return new C1324c(this, this.f6949a, Uri.parse(c1342n.m10940b()), c1342n);
    }
}
