package com.duokan.reader.ui.account;

import android.text.TextUtils;

import com.duokan.core.app.IFeature;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.store.DkShareBook;

import java.util.ArrayList;
import java.util.List;

public class bv extends bz {
    private String[] i;
    private String[] j;
    private final boolean k;

    public bv(IFeature featrue, boolean z, String str, String str2, String str3, String str4, String str5, String[] strArr, String[] strArr2, ce ceVar) {
        super(featrue, str, str2, str3, str4, str5, ceVar);
        this.k = z;
        this.i = strArr;
        this.j = strArr2;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (!z) {
            return;
        }
        if (this.k) {
            f();
        } else {
            b();
        }
    }

    private void f() {
        d();
        this.a = new bw(this);
        this.a.open();
    }

    protected void a(String str) {
        int i = 0;
        while (i < this.i.length && i < this.j.length) {
            a.d().a(this.i[i], this.j[i], str);
            i++;
        }
    }

    protected void a() {
        this.a = new bx(this, new ArrayList());
        this.a.open();
    }

    private void a(List list) {
        if (!list.isEmpty()) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = p.i().a(this.i);
            }
            if (TextUtils.isEmpty(this.d)) {
                String title;
                if (list.size() == 1) {
                    title = ((DkShareBook) list.get(0)).getTitle();
                } else {
                    title = String.format(getString(j.share__book_to_weixin_multi_title), new Object[]{Integer.valueOf(list.size())});
                }
                this.d = title;
            }
            if (TextUtils.isEmpty(this.f)) {
                this.f = ((DkShareBook) list.get(0)).mCoverUri;
            }
            if (TextUtils.isEmpty(this.e)) {
                this.e = b(list);
            }
        }
    }

    private String b(List list) {
        String string;
        if (list.size() == 1) {
            string = getString(j.share__book_to_weixin_single);
        } else {
            string = getString(j.share__book_to_weixin_multi);
        }
        int i = 0;
        String str = string;
        while (i < list.size()) {
            DkShareBook dkShareBook = (DkShareBook) list.get(i);
            if (list.size() > 1) {
                if (i < 5) {
                    str = str + String.format(getString(j.general__shared__book_title_marks), new Object[]{dkShareBook.getTitle()});
                    if (i < list.size() - 1 && i < 4) {
                        str = str + "、";
                    }
                } else if (i == 5) {
                    str = str + "...";
                }
            }
            i++;
        }
        return str;
    }

    private void c(List list) {
        String str;
        String str2 = "";
        if (list.size() == 1) {
            str = str2 + String.format(getContext().getString(j.share__book_to_sys_single), new Object[]{((DkShareBook) list.get(0)).getTitle()}) + this.c;
        } else if (list.isEmpty()) {
            str = str2 + getContext().getString(j.share__book_to_sys_zero) + this.c;
        } else {
            str = str2 + String.format(getContext().getString(j.share__book_to_sys_multi), new Object[]{Integer.valueOf(list.size())}) + this.c;
        }
        for (DkShareBook dkShareBook : list) {
            a.d().a(dkShareBook.getBookUuid(), dkShareBook.getTraceId(), "system");
        }
        b(str);
    }
}
