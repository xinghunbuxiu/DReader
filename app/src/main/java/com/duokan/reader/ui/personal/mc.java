package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.reader.domain.cloud.C0840a;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hv;
import java.util.ArrayList;
import java.util.List;

public class mc extends oa {
    /* renamed from: a */
    private me f8924a;
    /* renamed from: l */
    private ne f8925l;
    /* renamed from: m */
    private ks f8926m;
    /* renamed from: n */
    private List<DkCloudStoreBook> f8927n = new ArrayList();

    public mc(Context context, C0840a c0840a, hv hvVar, ks ksVar) {
        super(context, hvVar);
        this.b.setLeftTitle(c0840a.m5258a());
        this.f8926m = ksVar;
        this.f8924a = new me(this, getContext());
        this.f8925l = new ne(context, hvVar);
        this.j = new md(this);
        setAdapter(this.f8924a);
        setSearchAdapter(this.f8925l);
        setData(c0840a);
        this.f.setPullDownRefreshEnabled(false);
    }

    /* renamed from: d */
    public void mo1903d() {
        this.f8924a.m8785a(false);
    }

    public void setData(C0840a c0840a) {
        this.f8924a.m12257a(c0840a);
    }

    /* renamed from: a */
    private boolean m12245a(DkCloudStoreBook dkCloudStoreBook, String str) {
        if (dkCloudStoreBook.getTitle().toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        Object authorLine = dkCloudStoreBook.getAuthorLine();
        if (!TextUtils.isEmpty(authorLine) && authorLine.toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        authorLine = dkCloudStoreBook.getEditorLine();
        if (TextUtils.isEmpty(authorLine) || !authorLine.toLowerCase().contains(str.toLowerCase())) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public void mo1941f() {
        super.mo1941f();
        this.f.setPullDownRefreshEnabled(false);
    }
}
