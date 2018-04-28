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
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0254f;
import com.duokan.reader.common.bitmap.C0544a;

public class mb extends View {
    /* renamed from: a */
    private final Bitmap f10607a = C0544a.m2430a(getContext(), C0254f.reading__shared__magnifier);
    /* renamed from: b */
    private final Bitmap f10608b = C0544a.m2430a(getContext(), C0254f.reading__shared__magnifier_mask);
    /* renamed from: c */
    private final Bitmap f10609c = C0544a.m2444b(this.f10607a.getWidth(), this.f10607a.getHeight(), Config.ARGB_8888);
    /* renamed from: d */
    private final int f10610d = dv.m1932b(getContext(), 115.0f);
    /* renamed from: e */
    private final int f10611e = dv.m1932b(getContext(), 100.0f);
    /* renamed from: f */
    private final Canvas f10612f = new Canvas(this.f10609c);
    /* renamed from: g */
    private final Paint f10613g = new Paint();
    /* renamed from: h */
    private View f10614h;
    /* renamed from: i */
    private Point f10615i;
    /* renamed from: j */
    private Point f10616j;

    public mb(Context context) {
        super(context);
        this.f10613g.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
    }

    /* renamed from: a */
    public void m14631a(Point point, Point point2) {
        this.f10616j = point;
        this.f10615i = point2;
    }

    public void setSourceView(View view) {
        if (view != null) {
            this.f10614h = view;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10614h != null && this.f10615i != null) {
            int max = Math.max(0, Math.min(this.f10616j.x - (this.f10610d / 2), this.f10614h.getWidth() - this.f10610d));
            int max2 = Math.max(0, Math.min(this.f10616j.y - (this.f10611e / 2), this.f10614h.getHeight() - this.f10611e));
            int i = this.f10615i.y - this.f10607a.getHeight() >= 0 ? 0 : 1;
            int max3 = Math.max(0, Math.min(this.f10615i.x - (this.f10607a.getWidth() / 2), this.f10614h.getWidth() - this.f10607a.getWidth()));
            int height = i == 0 ? this.f10615i.y - this.f10607a.getHeight() : this.f10615i.y;
            this.f10609c.eraseColor(0);
            this.f10612f.save();
            this.f10612f.translate((float) ((this.f10607a.getWidth() - this.f10610d) / 2), (float) ((this.f10607a.getHeight() - this.f10611e) / 2));
            this.f10612f.translate((float) (-max), (float) (-max2));
            this.f10614h.draw(this.f10612f);
            this.f10612f.translate((float) max, (float) max2);
            this.f10612f.restore();
            this.f10612f.save();
            if (i != 0) {
                this.f10612f.translate(0.0f, (float) this.f10607a.getHeight());
                this.f10612f.scale(1.0f, -1.0f);
            }
            this.f10612f.drawBitmap(this.f10608b, 0.0f, 0.0f, this.f10613g);
            this.f10612f.drawBitmap(this.f10607a, 0.0f, 0.0f, null);
            this.f10612f.restore();
            canvas.drawBitmap(this.f10609c, (float) max3, (float) height, null);
        }
    }
}
