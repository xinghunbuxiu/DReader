package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.general.cc;
import com.duokan.reader.ui.general.expandable.ViewMode;

class bx extends hd {
    /* renamed from: a */
    final /* synthetic */ bw f8381a;

    bx(bw bwVar) {
        this.f8381a = bwVar;
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8381a.f8379a.clear();
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f8381a.m11538a(i, false);
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        this.f8381a.m11538a(this.f8381a.f8379a.size() + 1, true);
        return true;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8381a.f8379a.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f8381a.f8379a.get(i);
    }

    /* renamed from: k */
    protected int mo1867k() {
        return 1;
    }

    /* renamed from: f */
    protected int mo1866f(int i) {
        return mo506c();
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        IFeature a = AppContext.getAppContext(this.f8381a.getContext());
        C1151k c1151k = (C1151k) this.f8381a.f8379a.get(i);
        View a2 = new ay(a, c1151k, view, viewGroup).m11432a();
        CheckBox checkBox = (CheckBox) a2.findViewById(C0255g.personal__feed_message_item_view__checkbox);
        if (mo1714f() == ViewMode.Edit) {
            checkBox.setVisibility(0);
            checkBox.setChecked(mo1713b(0, i));
        } else {
            checkBox.setVisibility(8);
        }
        a2.setOnClickListener(new by(this, i, c1151k, a));
        a2.setOnLongClickListener(new bz(this, i));
        return a2;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc(this.f8381a.getContext());
        ccVar.m10334a(C0254f.personal__no_message_icon);
        ccVar.m10335b(C0258j.personal__message_empty_view__no_message);
        ccVar.m10336c(C0258j.personal__message_empty_view__no_message_description);
        return ccVar.m10333a();
    }
}
