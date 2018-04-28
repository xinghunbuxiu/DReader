package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

class bp implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f7637a;
    /* renamed from: b */
    final /* synthetic */ String f7638b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f7639c;

    bp(StorePageController storePageController, boolean z, String str) {
        this.f7639c = storePageController;
        this.f7637a = z;
        this.f7638b = str;
    }

    public void run() {
        if (this.f7639c.mPageHeaderView != null) {
            if (!this.f7637a) {
                this.f7639c.mPageHeaderView.m10145a();
            } else if (!TextUtils.isEmpty(this.f7638b)) {
                OnClickListener bqVar = new bq(this);
                if (this.f7639c.mHeaderViewRightButtonConditionMap.get(this.f7638b) != null) {
                    View inflate = LayoutInflater.from(this.f7639c.getContext()).inflate(C0256h.store__header_view__right_button_container, this.f7639c.mPageHeaderView, false);
                    ((ImageView) inflate.findViewById(C0255g.store__title_view__right_button)).setImageResource(((lo) this.f7639c.mHeaderViewRightButtonConditionMap.get(this.f7638b)).f8161b);
                    this.f7639c.mPageHeaderView.m10146a(inflate);
                    if (((lo) this.f7639c.mHeaderViewRightButtonConditionMap.get(this.f7638b)).f8160a != null) {
                        inflate.setOnClickListener(((lo) this.f7639c.mHeaderViewRightButtonConditionMap.get(this.f7638b)).f8160a);
                        return;
                    } else {
                        inflate.setOnClickListener(bqVar);
                        return;
                    }
                }
                this.f7639c.mPageHeaderView.m10148b(this.f7638b).setOnClickListener(bqVar);
            }
        }
    }
}
