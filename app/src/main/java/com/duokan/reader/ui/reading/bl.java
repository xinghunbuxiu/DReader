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
import com.duokan.reader.domain.document.c;
import com.duokan.reader.ui.general.hn;

class bl extends FrameLayout {
    final /* synthetic */ bk a;
    private final Paint b = a();
    private final int c;
    private final int d;
    private final boolean e;
    private final xk f;

    public bl(bk bkVar, Context context, c cVar) {
        this.a = bkVar;
        super(context);
        setWillNotDraw(false);
        setClipChildren(false);
        this.e = a(cVar);
        this.d = dv.b(context, 6.0f);
        this.c = dv.b(context, 20.0f);
        this.f = new xk(context, cVar.e());
        this.f.setMaxWidth((int) cVar.c());
        int b = dv.b(context, 10.0f);
        this.f.setTextSize(dv.b(context, 18.0f));
        this.f.setPadding(b, b, b, b);
        this.f.setBackgroundDrawable(new hn((float) (b / 2), (float) (b / 2), -1));
        addView(this.f, new LayoutParams(-2, -2));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (getMeasuredHeight() + (this.c / 2)) + (this.d * 2));
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.e ? 0.0f : (float) (-getHeight()));
        Path path = new Path();
        if (this.e) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (this.d / 2), (float) (this.d / 2), this.b);
            path.moveTo((float) (getWidth() / 2), (float) (this.d * 2));
            path.lineTo((float) ((getWidth() / 2) + (this.c / 2)), (float) (this.c + (this.d * 2)));
            path.lineTo((float) ((getWidth() / 2) - (this.c / 2)), (float) (this.c + (this.d * 2)));
        } else {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() - (this.d / 2)), (float) (this.d / 2), this.b);
            path.moveTo((float) ((getWidth() / 2) - (this.c / 2)), (float) ((getHeight() - (this.d * 2)) - this.c));
            path.lineTo((float) ((getWidth() / 2) + (this.c / 2)), (float) ((getHeight() - (this.d * 2)) - this.c));
            path.lineTo((float) (getWidth() / 2), (float) (getHeight() - (this.d * 2)));
        }
        path.close();
        canvas.drawPath(path, this.b);
        super.draw(canvas);
        canvas.restore();
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        float f;
        canvas.save();
        if (this.e) {
            f = (float) ((this.c / 2) + (this.d * 2));
        } else {
            f = 0.0f;
        }
        canvas.translate(0.0f, f);
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    private Paint a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setStyle(Style.FILL);
        paint.setStrokeWidth((float) dv.b(getContext(), 1.5f));
        return paint;
    }

    private boolean a(c cVar) {
        return Float.compare(cVar.b().y, cVar.d().y) <= 0;
    }
}
