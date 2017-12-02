package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.common.b;

class ia implements OnClickListener {
    final /* synthetic */ hw a;

    ia(hw hwVar) {
        this.a = hwVar;
    }

    public void onClick(View view) {
        String format;
        if (this.a.c.f() == 0.0d) {
            format = String.format(this.a.getString(j.personal__experience_view__share_template_ranking_low), new Object[]{Long.valueOf(this.a.c.b()), b.a(this.a.c.c())});
        } else if (this.a.c.g() <= 0) {
            format = String.format(this.a.getString(j.personal__experience_view__share_template_no_latest_month_reading_record), new Object[]{b.a(this.a.c.f()), Long.valueOf(this.a.c.b()), b.a(this.a.c.c())});
        } else {
            format = String.format(this.a.getString(j.personal__experience_view__share_template), new Object[]{b.a(this.a.c.f()), Long.valueOf(this.a.c.b()), b.a(this.a.c.c()), b.a(this.a.c.g() / 30)});
        }
        this.a.a.a(this.a.getContext(), format, this.a.d());
    }
}
