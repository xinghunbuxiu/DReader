package com.duokan.reader.ui.account;

import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.domain.store.DkShareBook;
import java.util.ArrayList;
import java.util.List;

public class bl extends bp {
    /* renamed from: i */
    private String[] f5872i;
    /* renamed from: j */
    private String[] f5873j;
    /* renamed from: k */
    private final boolean f5874k;

    public bl(IFeature mFeature, boolean z, String str, String str2, String str3, String str4, String str5, String[] strArr, String[] strArr2, bu buVar) {
        super(mFeature, str, str2, str3, str4, str5, buVar);
        this.f5874k = z;
        this.f5872i = strArr;
        this.f5873j = strArr2;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (!z) {
            return;
        }
        if (this.f5874k) {
            m8938f();
        } else {
            m8881b();
        }
    }

    /* renamed from: f */
    private void m8938f() {
        m8884d();
        this.a = new bm(this, C0643q.f2173a);
        this.a.open();
    }

    /* renamed from: a */
    protected void mo1571a(String str) {
        int i = 0;
        while (i < this.f5872i.length && i < this.f5873j.length) {
            C1167a.m8671d().m8679a(this.f5872i[i], this.f5873j[i], str);
            i++;
        }
    }

    /* renamed from: a */
    protected void mo1570a() {
        this.a = new bn(this, C0643q.f2173a, new ArrayList());
        this.a.open();
    }

    /* renamed from: a */
    private void m8931a(List<DkShareBook> list) {
        if (!list.isEmpty()) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = C0641o.m2934i().m2958a(this.f5872i);
            }
            if (TextUtils.isEmpty(this.d)) {
                String title;
                if (list.size() == 1) {
                    title = ((DkShareBook) list.get(0)).getTitle();
                } else {
                    title = String.format(getString(C0258j.share__book_to_weixin_multi_title), new Object[]{Integer.valueOf(list.size())});
                }
                this.d = title;
            }
            if (TextUtils.isEmpty(this.f)) {
                this.f = ((DkShareBook) list.get(0)).mCoverUri;
            }
            if (TextUtils.isEmpty(this.e)) {
                this.e = m8934b((List) list);
            }
        }
    }

    /* renamed from: b */
    private String m8934b(List<DkShareBook> list) {
        String string;
        if (list.size() == 1) {
            string = getString(C0258j.share__book_to_weixin_single);
        } else {
            string = getString(C0258j.share__book_to_weixin_multi);
        }
        int i = 0;
        String str = string;
        while (i < list.size()) {
            DkShareBook dkShareBook = (DkShareBook) list.get(i);
            if (list.size() > 1) {
                if (i < 5) {
                    str = str + String.format(getString(C0258j.general__shared__book_title_marks), new Object[]{dkShareBook.getTitle()});
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

    /* renamed from: c */
    private void m8937c(List<DkShareBook> list) {
        String str;
        String str2 = "";
        if (list.size() == 1) {
            str = str2 + String.format(getContext().getString(C0258j.share__book_to_sys_single), new Object[]{((DkShareBook) list.get(0)).getTitle()}) + this.c;
        } else if (list.isEmpty()) {
            str = str2 + getContext().getString(C0258j.share__book_to_sys_zero) + this.c;
        } else {
            str = str2 + String.format(getContext().getString(C0258j.share__book_to_sys_multi), new Object[]{Integer.valueOf(list.size())}) + this.c;
        }
        for (DkShareBook dkShareBook : list) {
            C1167a.m8671d().m8679a(dkShareBook.getBookUuid(), dkShareBook.getTraceId(), "system");
        }
        m8882b(str);
    }
}
