package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.duokan.c.g;
import com.duokan.c.h;

class bq implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ StorePageController c;

    bq(StorePageController storePageController, boolean z, String str) {
        this.c = storePageController;
        this.a = z;
        this.b = str;
    }

    public void run() {
        if (this.c.mPageHeaderView != null) {
            if (!this.a) {
                this.c.mPageHeaderView.a();
            } else if (!TextUtils.isEmpty(this.b)) {
                OnClickListener brVar = new br(this);
                if (this.c.mHeaderViewRightButtonConditionMap.get(this.b) != null) {
                    View inflate = LayoutInflater.from(this.c.getContext()).inflate(h.store__header_view__right_button_container, this.c.mPageHeaderView, false);
                    ((ImageView) inflate.findViewById(g.store__title_view__right_button)).setImageResource(((kj) this.c.mHeaderViewRightButtonConditionMap.get(this.b)).b);
                    this.c.mPageHeaderView.a(inflate);
                    if (((kj) this.c.mHeaderViewRightButtonConditionMap.get(this.b)).a != null) {
                        inflate.setOnClickListener(((kj) this.c.mHeaderViewRightButtonConditionMap.get(this.b)).a);
                        return;
                    } else {
                        inflate.setOnClickListener(brVar);
                        return;
                    }
                }
                this.c.mPageHeaderView.b(this.b).setOnClickListener(brVar);
            }
        }
    }
}
