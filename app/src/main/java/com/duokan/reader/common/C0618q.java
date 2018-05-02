package com.duokan.reader.common;

import android.content.Intent;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.OnActivityResultListener;
import java.util.ArrayList;

/* renamed from: com.duokan.reader.common.q */
class C0618q implements OnActivityResultListener {
    /* renamed from: a */
    final /* synthetic */ BaseActivity f2054a;
    /* renamed from: b */
    final /* synthetic */ C0616o f2055b;

    C0618q(C0616o c0616o, BaseActivity mActivity) {
        this.f2055b = c0616o;
        this.f2054a = mActivity;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001 && i2 == -1) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("android.speech.extra.RESULTS");
            if (arrayList.size() != 0) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    this.f2055b.m2811a((String) arrayList.get(i3));
                }
            } else {
                return;
            }
        }
        this.f2054a.removeOnActivityResultListener(this);
    }
}
