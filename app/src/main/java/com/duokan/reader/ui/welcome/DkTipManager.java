package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.core.app.AppContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class DkTipManager extends C1540p {
    /* renamed from: a */
    private final LinkedList<C1550q> f11597a = new LinkedList();
    /* renamed from: b */
    private ViewGroup f11598b = null;
    /* renamed from: c */
    private WeakReference<View> f11599c = null;

    public enum UserInput {
        CREATE_BOOK_CATEGORY,
        DO_BOOK_MARK,
        DO_BOOK_MARK_GESTURE_START,
        DO_BOOK_MARK_GESTURE,
        SHOW_BOOK_NAVIGATION,
        SHOW_BOOK_NAVIGATION_GESTURE,
        SEEK_READING_BRIGHTNESS,
        SEEK_READING_BRIGHTNESS_GESTURE,
        READING_SHOW_OPTION,
        READING_FAST_OPERATION,
        READING_FAST_OPERATION_GESTURE,
        READING_SHOW_CARTOON,
        READING_SHOW_CARTOON_GESTURE,
        RESTORE_ALL_GUIDES
    }

    public DkTipManager(AppContext appContext, ViewGroup viewGroup) {
        this.f11598b = viewGroup;
        this.f11597a.addLast(new C1551j(appContext));
    }

    /* renamed from: a */
    public void mo2564a(Context context, UserInput userInput) {
        C1550q c1550q;
        Iterator it = this.f11597a.iterator();
        while (it.hasNext()) {
            c1550q = (C1550q) it.next();
            if (c1550q.mo2568a(context, userInput)) {
                break;
            }
        }
        c1550q = null;
        if (c1550q != null) {
            m15553a(c1550q.mo2567a(this.f11598b, userInput));
        }
    }

    /* renamed from: a */
    public void m15553a(View view) {
        if (this.f11599c != null) {
            View view2 = (View) this.f11599c.get();
            if (view2 != null && view2.getParent() == this.f11598b) {
                this.f11598b.removeViewInLayout(view2);
            }
        }
        this.f11599c = new WeakReference(view);
    }
}
