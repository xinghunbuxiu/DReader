package com.duokan.reader.ui.general;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0247i;

class jb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ja f7428a;

    jb(ja jaVar) {
        this.f7428a = jaVar;
    }

    public void run() {
        if (this.f7428a.f7426e == this) {
            ((Animatable) ((ImageView) this.f7428a.findViewById(C0244f.general__waiting_dialog_view__loading)).getDrawable()).start();
            if (TextUtils.isEmpty(this.f7428a.f7423b.getText())) {
                this.f7428a.m10843a(this.f7428a.getContext().getResources().getString(C0247i.general__shared__hard_working));
            }
            this.f7428a.f7422a.setVisibility(0);
            if (this.f7428a.f7424c != null) {
                this.f7428a.f7422a.startAnimation(this.f7428a.f7424c);
            }
            this.f7428a.f7426e = null;
        }
    }
}
