package com.duokan.reader.ui.general;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.duokan.b.f;
import com.duokan.b.i;

class jr implements Runnable {
    final /* synthetic */ jq a;

    jr(jq jqVar) {
        this.a = jqVar;
    }

    public void run() {
        if (this.a.e == this) {
            ((Animatable) ((ImageView) this.a.findViewById(f.general__waiting_dialog_view__loading)).getDrawable()).start();
            if (TextUtils.isEmpty(this.a.b.getText())) {
                this.a.a(this.a.getContext().getResources().getString(i.general__shared__hard_working));
            }
            this.a.a.setVisibility(0);
            if (this.a.c != null) {
                this.a.a.startAnimation(this.a.c);
            }
            this.a.e = null;
        }
    }
}
