package com.duokan.reader.ui.general.web;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.duokan.core.sys.as;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;

class fh implements as {
    /* renamed from: a */
    final /* synthetic */ String[] f7831a;
    /* renamed from: b */
    final /* synthetic */ fg f7832b;

    fh(fg fgVar, String[] strArr) {
        this.f7832b = fgVar;
        this.f7831a = strArr;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7832b.f7830b.f7581b.mPageHeaderView != null) {
            this.f7832b.f7830b.f7581b.mPageHeaderView.m10145a();
            View inflate = LayoutInflater.from(this.f7832b.f7830b.f7581b.getContext()).inflate(C0256h.store__header_view__right_button_container, this.f7832b.f7830b.f7581b.mPageHeaderView, false);
            ImageView imageView = (ImageView) inflate.findViewById(C0255g.store__title_view__right_button);
            imageView.setImageResource(C0254f.store__shared__more);
            imageView.setContentDescription(this.f7832b.f7830b.f7581b.getString(C0258j.store__title_view__right_button__more));
            this.f7832b.f7830b.f7581b.mPageHeaderView.m10146a(inflate);
            inflate.setOnClickListener(new fi(this, inflate));
        }
    }
}
