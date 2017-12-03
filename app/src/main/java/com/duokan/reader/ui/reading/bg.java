package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.az;
import com.duokan.reader.ui.general.deprecatedDkTextView;

public class bg implements bb {
    private final sh a;
    private bd b = null;
    private Activity c = null;
    private final int d;

    public bg(Activity activity, sh shVar, Runnable runnable) {
        this.c = activity;
        this.a = shVar;
        this.b = new bd(this.c);
        this.b.setCancelOnTouchOutside(false);
        this.b.a(runnable);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.c.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.d = displayMetrics.widthPixels - UTools.closeAnimation(this.c, 115.0f);
    }

    public void a(Rect rect, ab abVar) {
        if (!a()) {
            if (abVar.b() == null) {
                a(rect, abVar.a(), false);
            } else {
                a(rect, abVar.b());
            }
        }
    }

    public void a(Rect rect, az azVar) {
        View xkVar = new xk(this.c, azVar);
        xkVar.setTextSize(this.a.C());
        xkVar.setTextColor(this.c.getResources().getColor(d.reading__shared__note_background));
        xkVar.setMaxWidth(this.d);
        xkVar.measure(MeasureSpec.makeMeasureSpec(this.d, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.b.a(xkVar, xkVar.getMeasuredWidth(), xkVar.getMeasuredHeight(), true);
        this.b.a(rect);
    }

    public void a(Rect rect, String str, boolean z) {
        View com_duokan_reader_ui_general_deprecatedDkTextView = new deprecatedDkTextView(this.c);
        com_duokan_reader_ui_general_deprecatedDkTextView.setUseBitmapCache(true);
        com_duokan_reader_ui_general_deprecatedDkTextView.setUsePartialDraw(true);
        if (!z) {
            com_duokan_reader_ui_general_deprecatedDkTextView.setChsToChtChars(this.a.ae().P());
        }
        com_duokan_reader_ui_general_deprecatedDkTextView.setTextSize(this.a.C());
        com_duokan_reader_ui_general_deprecatedDkTextView.setText(str);
        com_duokan_reader_ui_general_deprecatedDkTextView.setGravity(119);
        com_duokan_reader_ui_general_deprecatedDkTextView.setTextColor(this.c.getResources().getColor(d.reading__shared__note_background));
        com_duokan_reader_ui_general_deprecatedDkTextView.setMaxWidth(this.d);
        com_duokan_reader_ui_general_deprecatedDkTextView.measure(MeasureSpec.makeMeasureSpec(this.d, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.b.a(com_duokan_reader_ui_general_deprecatedDkTextView, com_duokan_reader_ui_general_deprecatedDkTextView.getMeasuredWidth(), com_duokan_reader_ui_general_deprecatedDkTextView.getMeasuredHeight(), true);
        this.b.a(rect);
    }

    public boolean a() {
        return this.b.isShowing();
    }
}
