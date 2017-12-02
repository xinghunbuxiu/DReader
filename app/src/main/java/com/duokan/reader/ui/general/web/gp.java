package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.epub.DkFeature;

import java.util.Arrays;
import java.util.concurrent.Callable;

class gp implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ cg c;

    gp(cg cgVar, String str, String str2) {
        this.c = cgVar;
        this.a = str;
        this.b = str2;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        c b = ai.a().b(this.a);
        if (b != null) {
            return b.s().name();
        }
        if (!TextUtils.isEmpty(this.b)) {
            try {
                DkFeature[] values = DkFeature.values();
                for (String parseInt : Arrays.asList(this.b.split(","))) {
                    int parseInt2 = Integer.parseInt(parseInt);
                    if (parseInt2 < 0 || parseInt2 >= values.length) {
                        return "EPUB";
                    }
                    if (!values[parseInt2].isLinearizable()) {
                        return "EPUB";
                    }
                }
            } catch (Throwable th) {
                return "EPUB";
            }
        }
        return "EPUB_OPF";
    }
}
