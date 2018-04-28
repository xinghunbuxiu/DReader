package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.fp;
import java.util.concurrent.Callable;

class gz implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ String f7914a;
    /* renamed from: b */
    final /* synthetic */ String f7915b;
    /* renamed from: c */
    final /* synthetic */ ci f7916c;

    gz(ci ciVar, String str, String str2) {
        this.f7916c = ciVar;
        this.f7914a = str;
        this.f7915b = str2;
    }

    public /* synthetic */ Object call() {
        return m11164a();
    }

    /* renamed from: a */
    public String m11164a() {
        C0800c b = ai.m3980a().m3906b(this.f7914a);
        if (b != null) {
            return b.m4247s().name();
        }
        try {
            int[] iArr;
            if (TextUtils.isEmpty(this.f7915b)) {
                iArr = new int[0];
            } else {
                String[] split = this.f7915b.split(",");
                iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Integer.parseInt(split[i]);
                }
            }
            return fp.m4468a(iArr) ? "EPUB_OPF" : "EPUB";
        } catch (Throwable th) {
            return "EPUB";
        }
    }
}
