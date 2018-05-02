package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.core.sys.af;

public class ao extends af {
    private Object a;

    protected ao() {
    }

    public void a(Object obj) {
        super.a(obj);
        this.a = null;
    }

    public boolean d() {
        boolean z = true;
        if (!(this.a instanceof String)) {
            if (this.a == null) {
                z = false;
            }
            return z;
        } else if (TextUtils.isEmpty((String) this.a)) {
            return false;
        } else {
            return true;
        }
    }

    public Object e() {
        return this.a;
    }

    public void c(Object obj) {
        this.a = obj;
    }
}
