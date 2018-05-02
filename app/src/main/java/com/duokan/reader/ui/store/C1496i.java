package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.deprecatedDkTextView;

/* renamed from: com.duokan.reader.ui.store.i */
class C1496i extends bo {
    /* renamed from: a */
    final /* synthetic */ C1495h f11445a;

    C1496i(C1495h c1495h) {
        this.f11445a = c1495h;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return mo1556c(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f11445a.getContext()).inflate(C0256h.store__toc_item_view, null);
        }
        DkStoreBookTocInfo c = mo1556c(i);
        if (c != null) {
            ((TextView) view.findViewById(C0255g.store__toc_item_view__title)).setText(c.mTitle);
            deprecatedDkTextView deprecateddktextview = (deprecatedDkTextView) view.findViewById(C0255g.store__toc_item_view__preview);
            deprecateddktextview.setText(c.mPreview);
            deprecateddktextview.setUseBitmapCache(true);
            deprecateddktextview = (deprecatedDkTextView) view.findViewById(C0255g.store__toc_item_view__second);
            deprecateddktextview.setText(c.getChilidLine());
            deprecateddktextview.setUseBitmapCache(true);
        }
        return view;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f11445a.f11444b == null ? 0 : this.f11445a.f11444b.length;
    }

    /* renamed from: c */
    public DkStoreBookTocInfo mo1556c(int i) {
        if (this.f11445a.f11444b == null || this.f11445a.f11444b.length <= i) {
            return null;
        }
        return this.f11445a.f11444b[i];
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
    }

    /* renamed from: b */
    protected void mo1555b() {
    }
}
