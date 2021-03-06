package com.duokan.reader.ui.general.p053b;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.duokan.reader.ui.general.CustomGlideUrl;
import java.io.InputStream;


public class Factory implements ModelLoaderFactory<CustomGlideUrl, InputStream> {
    public ModelLoader<CustomGlideUrl, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
        return new HttpUrlGlideUrlLoader(context);
    }

    public void teardown() {
    }
}
