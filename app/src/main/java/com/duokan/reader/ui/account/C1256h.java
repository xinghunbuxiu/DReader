package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.ui.general.gs;
import com.duokan.reader.ui.general.hp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.duokan.reader.ui.account.h */
public class C1256h extends gs {
    /* renamed from: a */
    private hp f5950a;
    /* renamed from: b */
    private String f5951b;
    /* renamed from: c */
    private String f5952c;
    /* renamed from: d */
    private String f5953d;
    /* renamed from: e */
    private List<DkCloudComment> f5954e;
    /* renamed from: f */
    private C0800c f5955f;
    /* renamed from: g */
    private HashMap<C0798a, C0901g> f5956g;
    /* renamed from: h */
    private ArrayList<C0798a> f5957h;

    public C1256h(IFeature mFeature, C0800c c0800c, HashMap<C0798a, C0901g> hashMap, ArrayList<C0798a> arrayList) {
        super(mFeature);
        View view = new View((Context) mFeature);
        view.setBackgroundColor(0);
        setContentView(view);
        this.f5955f = c0800c;
        this.f5956g = hashMap;
        this.f5957h = arrayList;
        m9000a();
    }

    public C1256h(IFeature mFeature, List<DkCloudComment> list, String str, String str2, String str3) {
        super(mFeature);
        View view = new View((Context) mFeature);
        view.setBackgroundColor(0);
        setContentView(view);
        this.f5951b = str;
        this.f5952c = str2;
        this.f5953d = str3;
        this.f5954e = list;
        m9000a();
    }

    /* renamed from: a */
    public void m9000a() {
        if (this.f5950a == null) {
            this.f5950a = new hp(getContext());
            this.f5950a.setOnDismissListener(new C1257i(this));
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f5950a.m9769b(C0258j.personal__output_entrance_view__yingxiang);
            this.f5950a.m9769b(C0258j.personal__output_entrance_view__email);
            this.f5950a.m9767a(new C1258j());
            this.f5950a.show();
        }
    }
}
