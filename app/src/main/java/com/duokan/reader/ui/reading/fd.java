package com.duokan.reader.ui.reading;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.duokan.b.g;
import com.duokan.common.i;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;

public class fd extends wk {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final ViewGroup b = ((ViewGroup) LayoutInflater.from(getContext()).inflate(g.reading__reading_options_view__custom_themes_list, null));
    private final ReadingTheme[] c;
    private final LinearLayout d;
    private final LinearLayout e;
    private final LinearLayout f;

    public fd(IFeature featrue) {
        int i;
        super(featrue);
        this.b.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? UTools.closeAnimation(getContext(), 400.0f) : -1, -2));
        setContentView(this.b);
        this.c = new ReadingTheme[]{ReadingTheme.THEME7, ReadingTheme.THEME1, ReadingTheme.THEME2, ReadingTheme.THEME3, ReadingTheme.THEME4, ReadingTheme.THEME6, ReadingTheme.THEME9, ReadingTheme.THEME8, ReadingTheme.THEME10, ReadingTheme.THEME11, ReadingTheme.THEME12, ReadingTheme.THEME17, ReadingTheme.THEME13, ReadingTheme.THEME15, ReadingTheme.THEME14, ReadingTheme.THEME16, ReadingTheme.THEME18};
        this.d = (LinearLayout) findViewById(f.reading__reading_options_view__theme_bar_1);
        for (i = 0; i < 6; i++) {
            this.d.addView(a(i));
        }
        this.e = (LinearLayout) findViewById(f.reading__reading_options_view__theme_bar_2);
        for (i = 6; i < 11; i++) {
            this.e.addView(a(i));
        }
        this.e.addView(b());
        this.f = (LinearLayout) findViewById(f.reading__reading_options_view__theme_bar_vine);
        for (i = 11; i < this.c.length; i++) {
            this.f.addView(b(i));
        }
        a();
    }

    private final void a() {
        int i;
        boolean z;
        ReadingTheme q = this.a.ae().q();
        for (i = 0; i < this.d.getChildCount(); i++) {
            boolean z2;
            View childAt = this.d.getChildAt(i);
            if (this.c[i] == q) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
        }
        for (i = 0; i < this.e.getChildCount() - 1; i++) {
            childAt = this.e.getChildAt(i);
            if (this.c[i + 6] == q) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
        }
        View childAt2 = this.e.getChildAt(this.e.getChildCount() - 1);
        if (q == ReadingTheme.CUSTOM) {
            z = true;
        } else {
            z = false;
        }
        childAt2.setSelected(z);
        for (i = 0; i < this.f.getChildCount(); i++) {
            childAt = this.f.getChildAt(i);
            if (this.c[i + 11] == q) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
        }
    }

    private final acz a(int i) {
        Drawable drawable;
        if (this.c[i] == ReadingTheme.THEME12) {
            drawable = getResources().getDrawable(e.reading__reading_themes_color__old_night_mode);
        } else {
            drawable = new ColorDrawable(this.a.ae().b(this.c[i]));
        }
        acz com_duokan_reader_ui_reading_acz = new acz(getContext(), drawable);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        int a = i.a(getContext(), 8.0f);
        com_duokan_reader_ui_reading_acz.setPadding(a, 0, a, 0);
        com_duokan_reader_ui_reading_acz.setLayoutParams(layoutParams);
        com_duokan_reader_ui_reading_acz.setOnClickListener(new fe(this, i));
        return com_duokan_reader_ui_reading_acz;
    }

    private final acz b(int i) {
        acz com_duokan_reader_ui_reading_acz = new acz(getContext(), this.a.ae().c(this.c[i]));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        int a = i.a(getContext(), 8.0f);
        com_duokan_reader_ui_reading_acz.setPadding(a, 0, a, 0);
        com_duokan_reader_ui_reading_acz.setLayoutParams(layoutParams);
        com_duokan_reader_ui_reading_acz.setOnClickListener(new ff(this, i));
        return com_duokan_reader_ui_reading_acz;
    }

    private View b() {
        View ezVar = new ez(getContext(), this.a.O(), this.a.P());
        int a = i.a(getContext(), 8.0f);
        ezVar.setPadding(a, 0, a, 0);
        ezVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        ezVar.setOnClickListener(new fg(this));
        ezVar.setOnLongClickListener(new fh(this));
        return ezVar;
    }
}
