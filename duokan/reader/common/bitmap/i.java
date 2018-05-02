package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

final class i implements j {
    final /* synthetic */ String a;

    i(String str) {
        this.a = str;
    }

    public Bitmap a() {
        return BitmapFactory.decodeFile(this.a);
    }
}
