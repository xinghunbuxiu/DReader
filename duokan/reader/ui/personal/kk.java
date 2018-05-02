package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.ui.general.be;

class kk implements a {
    final /* synthetic */ kj a;

    kk(kj kjVar) {
        this.a = kjVar;
    }

    public void a(Void voidR) {
        this.a.b.dismiss();
        be.a(this.a.e.getContext(), String.format(this.a.e.getString(j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.a.c.size())}), 1).show();
        if (this.a.d != null) {
            this.a.d.run();
        }
        this.a.e.c.a(this.a.c);
    }

    public void a(int i, String str) {
        this.a.b.dismiss();
        if (TextUtils.isEmpty(str)) {
            be.a(this.a.e.getContext(), j.bookshelf__shared__delete_fail, 1).show();
        } else {
            be.a(this.a.e.getContext(), (CharSequence) str, 1).show();
        }
        if (this.a.d != null) {
            this.a.d.run();
        }
    }
}
