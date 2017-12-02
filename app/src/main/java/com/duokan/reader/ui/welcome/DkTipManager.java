package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.app.x;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class DkTipManager extends p {
    private final LinkedList a = new LinkedList();
    private ViewGroup b = null;
    private WeakReference c = null;

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

    public DkTipManager(x xVar, ViewGroup viewGroup) {
        this.b = viewGroup;
        this.a.addLast(new j(xVar));
    }

    public void a(Context context, UserInput userInput) {
        q qVar;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            qVar = (q) it.next();
            if (qVar.a(context, userInput)) {
                break;
            }
        }
        qVar = null;
        if (qVar != null) {
            a(qVar.a(this.b, userInput));
        }
    }

    public void a(View view) {
        if (this.c != null) {
            View view2 = (View) this.c.get();
            if (view2 != null && view2.getParent() == this.b) {
                this.b.removeViewInLayout(view2);
            }
        }
        this.c = new WeakReference(view);
    }
}
