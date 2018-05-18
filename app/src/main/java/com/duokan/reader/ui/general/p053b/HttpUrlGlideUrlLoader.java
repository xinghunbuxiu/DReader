package com.duokan.reader.ui.general.p053b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders.Builder;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.duokan.core.p027b.UrlTools;
import com.duokan.reader.ui.general.CustomGlideUrl;

import org.apache.http.HttpHost;

import java.io.InputStream;


public class HttpUrlGlideUrlLoader implements StreamModelLoader<CustomGlideUrl> {

    private final Context context;

    public HttpUrlGlideUrlLoader(Context context) {
        this.context = context;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(final CustomGlideUrl model, int width, int height) {
        String url = model.getSafeUrl();
        if (!TextUtils.isEmpty(url)) {
            if (UrlTools.equalsIgnoreCase(url, HttpHost.DEFAULT_SCHEME_NAME, "https")) {
                return new HttpUrlFetcher(new GlideUrl(url, new Builder().addHeader("Accept-Encoding", "gzip,deflate,sdch").build())) {
                    public String getId() {
                        return model.getId();
                    }
                };
            }
        }
        return new StreamLocalUriFetcher(this.context, Uri.parse(model.getSafeUrl())) {
            public String getId() {
                return model.getId();
            }
        };
    }
}
