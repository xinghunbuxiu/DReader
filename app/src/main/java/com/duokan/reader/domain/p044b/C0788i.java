package com.duokan.reader.domain.p044b;

import android.text.TextUtils;
import com.duokan.common.CommonUtils;
import java.io.File;
import java.io.FileFilter;

/* renamed from: com.duokan.reader.domain.b.i */
class C0788i implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C0781b f2640a;

    C0788i(C0781b c0781b) {
        this.f2640a = c0781b;
    }

    public boolean accept(File file) {
        String a = CommonUtils.m601a(file.getName());
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        if (a.equalsIgnoreCase("ttf") || a.equalsIgnoreCase("otf")) {
            return true;
        }
        return false;
    }
}
