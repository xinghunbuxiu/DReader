package com.duokan.reader.ui.store;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.duokan.c.f;
import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.ITheme;

import org.apache.http.HttpStatus;

class l extends DkWebListView {
    final /* synthetic */ j a;
    private final PageHeaderView b;
    private final Paint c;
    private final int d;

    public l(j jVar, Context context) {
        this.a = jVar;
        super(context);
        setBackgroundResource(d.store__shared__bg);
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class);
        a(0, 0, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        this.c = new Paint();
        this.c.setStrokeWidth(0.0f);
        this.c.setColor(Color.rgb(HttpStatus.SC_MULTI_STATUS, HttpStatus.SC_MULTI_STATUS, HttpStatus.SC_MULTI_STATUS));
        setPullDownRefreshEnabled(false);
        this.b = new PageHeaderView(getContext());
        this.b.setHasBackButton(true);
        this.b.setLeftTitle(jVar.getString(j.store__change_log_view__title));
        setTitleView(this.b);
        setAdapter(new m(this, jVar));
        this.d = (UTools.closeAnimation(getContext(), 15.0f) + (getResources().getDrawable(f.store__change_log_view__icon1).getIntrinsicWidth() / 2)) - 1;
    }

    protected void dispatchDraw(Canvas canvas) {
        if (getAdapter().c() > 0) {
            canvas.drawLine((float) this.d, (float) this.b.getHeight(), (float) (this.d + 1), (float) getHeight(), this.c);
        }
        super.dispatchDraw(canvas);
    }
}
