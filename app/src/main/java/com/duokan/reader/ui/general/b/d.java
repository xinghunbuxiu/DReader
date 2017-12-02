package com.duokan.reader.ui.general.b;

import android.content.Context;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

public class d implements ModelLoaderFactory {
    public ModelLoader build(Context context, GenericLoaderFactory genericLoaderFactory) {
        return new a(context);
    }

    public void teardown() {
    }
}
