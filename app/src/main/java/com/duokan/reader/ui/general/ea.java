package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ReaderEnv;
import org.apache.http.HttpStatus;

class ea extends Drawable {
    /* renamed from: a */
    final /* synthetic */ dr f7140a;

    ea(dr drVar) {
        this.f7140a = drVar;
    }

    public void draw(Canvas canvas) {
        if (ReaderEnv.get().forHd()) {
            this.f7140a.m10501a(canvas, this.f7140a.f7113k);
            return;
        }
        Drawable drawable = this.f7140a.getResources().getDrawable(C0243e.surfing__surfing_tab_view__search_dark);
        int min = Math.min(((this.f7140a.f7113k.getWidth() / 4) * 3) + (drawable.getIntrinsicWidth() / 2), this.f7140a.f7113k.getRight());
        int max = Math.max(0, min - drawable.getIntrinsicWidth());
        int min2 = Math.min(this.f7140a.f7113k.getWidth(), this.f7140a.f7113k.getHeight() - dv.m1932b(this.f7140a.getContext(), 17.0f));
        int max2 = Math.max(0, min2 - drawable.getIntrinsicHeight());
        float c = this.f7140a.mo2531c();
        Drawable colorDrawable = new ColorDrawable(Color.rgb(this.f7140a.m10493a(255, (int) HttpStatus.SC_PROCESSING, c), this.f7140a.m10493a(255, (int) HttpStatus.SC_PROCESSING, c), this.f7140a.m10493a(255, (int) HttpStatus.SC_PROCESSING, c)));
        colorDrawable.setAlpha((int) (this.f7140a.mo2532d() * 255.0f));
        eq eqVar = new eq(colorDrawable);
        eqVar.m10568a(drawable);
        eqVar.setBounds(max, max2, min, min2);
        eqVar.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
