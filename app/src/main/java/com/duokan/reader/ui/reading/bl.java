package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.C0931c;
import com.duokan.reader.ui.general.hc;

class bl extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ bk f9857a;
    /* renamed from: b */
    private final Paint f9858b = m13799a();
    /* renamed from: c */
    private final int f9859c;
    /* renamed from: d */
    private final int f9860d;
    /* renamed from: e */
    private final boolean f9861e;
    /* renamed from: f */
    private final xx f9862f;

    public bl(bk bkVar, Context context, C0931c c0931c) {
        this.f9857a = bkVar;
        super(context);
        setWillNotDraw(false);
        setClipChildren(false);
        this.f9861e = m13800a(c0931c);
        this.f9860d = dv.m1932b(context, 6.0f);
        this.f9859c = dv.m1932b(context, 20.0f);
        this.f9862f = new xx(context, c0931c.m6433e());
        this.f9862f.setMaxWidth((int) c0931c.m6431c());
        int b = dv.m1932b(context, 10.0f);
        this.f9862f.setTextSize(dv.m1932b(context, 18.0f));
        this.f9862f.setPadding(b, b, b, b);
        this.f9862f.setBackgroundDrawable(new hc((float) (b / 2), (float) (b / 2), -1));
        addView(this.f9862f, new LayoutParams(-2, -2));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (getMeasuredHeight() + (this.f9859c / 2)) + (this.f9860d * 2));
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.f9861e ? 0.0f : (float) (-getHeight()));
        Path path = new Path();
        if (this.f9861e) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (this.f9860d / 2), (float) (this.f9860d / 2), this.f9858b);
            path.moveTo((float) (getWidth() / 2), (float) (this.f9860d * 2));
            path.lineTo((float) ((getWidth() / 2) + (this.f9859c / 2)), (float) (this.f9859c + (this.f9860d * 2)));
            path.lineTo((float) ((getWidth() / 2) - (this.f9859c / 2)), (float) (this.f9859c + (this.f9860d * 2)));
        } else {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() - (this.f9860d / 2)), (float) (this.f9860d / 2), this.f9858b);
            path.moveTo((float) ((getWidth() / 2) - (this.f9859c / 2)), (float) ((getHeight() - (this.f9860d * 2)) - this.f9859c));
            path.lineTo((float) ((getWidth() / 2) + (this.f9859c / 2)), (float) ((getHeight() - (this.f9860d * 2)) - this.f9859c));
            path.lineTo((float) (getWidth() / 2), (float) (getHeight() - (this.f9860d * 2)));
        }
        path.close();
        canvas.drawPath(path, this.f9858b);
        super.draw(canvas);
        canvas.restore();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        float f;
        canvas.save();
        if (this.f9861e) {
            f = (float) ((this.f9859c / 2) + (this.f9860d * 2));
        } else {
            f = 0.0f;
        }
        canvas.translate(0.0f, f);
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    /* renamed from: a */
    private Paint m13799a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setStyle(Style.FILL);
        paint.setStrokeWidth((float) dv.m1932b(getContext(), 1.5f));
        return paint;
    }

    /* renamed from: a */
    private boolean m13800a(C0931c c0931c) {
        return Float.compare(c0931c.m6429b().y, c0931c.m6432d().y) <= 0;
    }
}
