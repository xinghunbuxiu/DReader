package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.View;

import com.duokan.core.ui.UTools;

public class lr extends View {
    private final Bitmap a = a.a(getContext(), f.reading__shared__magnifier);
    private final Bitmap b = a.a(getContext(), f.reading__shared__magnifier_mask);
    private final Bitmap c = a.b(this.a.getWidth(), this.a.getHeight(), Config.ARGB_8888);
    private final int d = UTools.closeAnimation(getContext(), 115.0f);
    private final int e = UTools.closeAnimation(getContext(), 100.0f);
    private final Canvas f = new Canvas(this.c);
    private final Paint g = new Paint();
    private View h;
    private Point i;
    private Point j;

    public lr(Context context) {
        super(context);
        this.g.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
    }

    public void a(Point point, Point point2) {
        this.j = point;
        this.i = point2;
    }

    public void setSourceView(View view) {
        if (view != null) {
            this.h = view;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h != null && this.i != null) {
            int max = Math.max(0, Math.min(this.j.x - (this.d / 2), this.h.getWidth() - this.d));
            int max2 = Math.max(0, Math.min(this.j.y - (this.e / 2), this.h.getHeight() - this.e));
            int i = this.i.y - this.a.getHeight() >= 0 ? 0 : 1;
            int max3 = Math.max(0, Math.min(this.i.x - (this.a.getWidth() / 2), this.h.getWidth() - this.a.getWidth()));
            int height = i == 0 ? this.i.y - this.a.getHeight() : this.i.y;
            this.c.eraseColor(0);
            this.f.save();
            this.f.translate((float) ((this.a.getWidth() - this.d) / 2), (float) ((this.a.getHeight() - this.e) / 2));
            this.f.translate((float) (-max), (float) (-max2));
            this.h.draw(this.f);
            this.f.translate((float) max, (float) max2);
            this.f.restore();
            this.f.save();
            if (i != 0) {
                this.f.translate(0.0f, (float) this.a.getHeight());
                this.f.scale(1.0f, -1.0f);
            }
            this.f.drawBitmap(this.b, 0.0f, 0.0f, this.g);
            this.f.drawBitmap(this.a, 0.0f, 0.0f, null);
            this.f.restore();
            canvas.drawBitmap(this.c, (float) max3, (float) height, null);
        }
    }
}
