package com.duokan.reader.ui.general;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class jt implements Runnable {
    jt() {
    }

    public void run() {
        if (ka.m10910g() != null) {
            ka.m10910g().m10919f();
        }
        deprecatedDkTextView.m10458j();
        for (ArrayList it : deprecatedDkTextView.f7061c.values()) {
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                deprecatedDkTextView deprecateddktextview = (deprecatedDkTextView) ((WeakReference) it2.next()).get();
                if (!(deprecateddktextview == null || deprecatedDkTextView.f7064f == deprecateddktextview || !(deprecateddktextview.f7076E instanceof jw))) {
                    ((jw) deprecateddktextview.f7076E).m10898f();
                    deprecateddktextview.postInvalidate();
                }
            }
        }
        Iterator it3 = deprecatedDkTextView.f7062d.iterator();
        while (it3.hasNext()) {
            deprecateddktextview = (deprecatedDkTextView) ((WeakReference) it3.next()).get();
            if (!(deprecateddktextview == null || deprecatedDkTextView.f7064f == deprecateddktextview || !(deprecateddktextview.f7076E instanceof jw))) {
                ((jw) deprecateddktextview.f7076E).m10898f();
                deprecateddktextview.postInvalidate();
            }
        }
        System.gc();
    }
}
