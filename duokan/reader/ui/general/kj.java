package com.duokan.reader.ui.general;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class kj implements Runnable {
    kj() {
    }

    public void run() {
        if (kq.g() != null) {
            kq.g().f();
        }
        deprecatedDkTextView.j();
        for (ArrayList it : deprecatedDkTextView.c.values()) {
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) ((WeakReference) it2.next()).get();
                if (!(com_duokan_reader_ui_general_deprecatedDkTextView == null || deprecatedDkTextView.f == com_duokan_reader_ui_general_deprecatedDkTextView || !(com_duokan_reader_ui_general_deprecatedDkTextView.E instanceof km))) {
                    ((km) com_duokan_reader_ui_general_deprecatedDkTextView.E).f();
                    com_duokan_reader_ui_general_deprecatedDkTextView.postInvalidate();
                }
            }
        }
        Iterator it3 = deprecatedDkTextView.d.iterator();
        while (it3.hasNext()) {
            com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) ((WeakReference) it3.next()).get();
            if (!(com_duokan_reader_ui_general_deprecatedDkTextView == null || deprecatedDkTextView.f == com_duokan_reader_ui_general_deprecatedDkTextView || !(com_duokan_reader_ui_general_deprecatedDkTextView.E instanceof km))) {
                ((km) com_duokan_reader_ui_general_deprecatedDkTextView.E).f();
                com_duokan_reader_ui_general_deprecatedDkTextView.postInvalidate();
            }
        }
        System.gc();
    }
}
