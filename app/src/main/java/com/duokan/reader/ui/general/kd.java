package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.duokan.kernel.txtlib.DktRenderTextInfo;
import com.duokan.reader.ui.general.deprecatedDkTextView.TruncateMode;

class kd extends ke {
    /* renamed from: a */
    final /* synthetic */ deprecatedDkTextView f7525a;
    /* renamed from: c */
    private final char[] f7526c;
    /* renamed from: d */
    private final PointF f7527d;
    /* renamed from: e */
    private final RectF f7528e;
    /* renamed from: f */
    private int f7529f;

    private kd(deprecatedDkTextView deprecateddktextview) {
        this.f7525a = deprecateddktextview;
        super(deprecateddktextview);
        this.f7526c = new char[1];
        this.f7527d = new PointF();
        this.f7528e = new RectF();
        this.f7529f = -1;
    }

    /* renamed from: a */
    public void mo1803a() {
    }

    /* renamed from: b */
    public void mo1807b() {
    }

    /* renamed from: a */
    public void mo1804a(Context context, Canvas canvas, Rect rect) {
        Rect a = this.f7525a.f7082o;
        Rect b = this.f7525a.f7072A;
        DktRenderTextInfo c = this.f7525a.f7084q;
        Paint b2 = deprecatedDkTextView.f7066h;
        this.f7529f = -1;
        int paddingLeft = this.f7525a.getPaddingLeft();
        int paddingTop = this.f7525a.getPaddingTop();
        float f = 2.14748365E9f;
        int length;
        int length2;
        int i;
        float f2;
        if (this.f7525a.f7093z && this.f7525a.f7092y == TruncateMode.END_WITH_SPACING) {
            length = c.mChars.length();
            length2 = c.mChars.length() - 1;
            while (length2 >= 0) {
                float f3;
                this.f7526c[0] = c.mChars.charAt(length2);
                i = length2 << 1;
                this.f7527d.x = c.mCharXYs[i];
                this.f7527d.y = c.mCharXYs[i + 1];
                this.f7527d.offset((float) paddingLeft, (float) paddingTop);
                this.f7528e.left = c.mCharTopLefts[i];
                this.f7528e.top = c.mCharTopLefts[i + 1];
                this.f7528e.right = c.mCharBottomRights[i];
                this.f7528e.bottom = c.mCharBottomRights[i + 1];
                this.f7528e.offset((float) paddingLeft, (float) paddingTop);
                if (!this.f7528e.intersects((float) a.left, (float) a.top, (float) a.right, (float) a.bottom)) {
                    i = length;
                    f3 = f;
                } else if (this.f7528e.intersect((float) b.left, (float) b.top, (float) b.right, (float) b.bottom)) {
                    i = length - 1;
                    f3 = f;
                } else {
                    m10923a(canvas, b2, this.f7526c, 0, 1, c.mCharCharsets[length2]);
                    if (f == this.f7528e.bottom || !this.f7525a.f7073B) {
                        i = length;
                        f3 = f;
                    } else {
                        f2 = this.f7528e.bottom;
                        canvas.drawLine((float) (a.left + this.f7525a.getPaddingLeft()), f2 + 1.0f, (float) (a.right - this.f7525a.getPaddingRight()), f2 + 2.0f, b2);
                        f3 = f2;
                        i = length;
                    }
                }
                length2--;
                length = i;
                f = f3;
            }
            if (length < c.mChars.length()) {
                i = length << 1;
                this.f7527d.x = c.mCharXYs[i];
                this.f7527d.y = c.mCharXYs[i + 1];
                this.f7527d.offset((float) paddingLeft, (float) paddingTop);
                this.f7528e.left = c.mCharTopLefts[i];
                this.f7528e.top = c.mCharTopLefts[i + 1];
                this.f7528e.right = c.mCharBottomRights[i];
                this.f7528e.bottom = c.mCharBottomRights[i + 1];
                this.f7528e.offset((float) paddingLeft, (float) paddingTop);
                m10923a(canvas, b2, "...".toCharArray(), 0, 3, 0);
                if (f != this.f7528e.bottom && this.f7525a.f7073B) {
                    f2 = this.f7528e.bottom;
                    canvas.drawLine((float) (a.left + this.f7525a.getPaddingLeft()), f2 + 1.0f, (float) (a.right - this.f7525a.getPaddingRight()), f2 + 2.0f, b2);
                }
            }
        } else {
            length2 = c.mChars.length();
            length = 0;
            while (length < length2) {
                this.f7526c[0] = c.mChars.charAt(length);
                i = length << 1;
                this.f7527d.x = c.mCharXYs[i];
                this.f7527d.y = c.mCharXYs[i + 1];
                this.f7527d.offset((float) paddingLeft, (float) paddingTop);
                this.f7528e.left = c.mCharTopLefts[i];
                this.f7528e.top = c.mCharTopLefts[i + 1];
                this.f7528e.right = c.mCharBottomRights[i];
                this.f7528e.bottom = c.mCharBottomRights[i + 1];
                this.f7528e.offset((float) paddingLeft, (float) paddingTop);
                if (this.f7528e.intersects((float) a.left, (float) a.top, (float) a.right, (float) a.bottom)) {
                    m10923a(canvas, b2, this.f7526c, 0, 1, c.mCharCharsets[length]);
                    if (f == this.f7528e.bottom || !this.f7525a.f7073B) {
                        f2 = f;
                    } else {
                        f2 = this.f7528e.bottom;
                        canvas.drawLine((float) (a.left + this.f7525a.getPaddingLeft()), f2 + 1.0f, (float) (a.right - this.f7525a.getPaddingRight()), f2 + 2.0f, b2);
                    }
                } else {
                    f2 = f;
                }
                length++;
                f = f2;
            }
        }
        this.f7529f = -1;
    }

    /* renamed from: a */
    private void m10923a(Canvas canvas, Paint paint, char[] cArr, int i, int i2, int i3) {
        if (this.f7529f != i3) {
            this.f7529f = i3;
            paint.setTypeface(this.f7529f == 0 ? this.f7525a.getEnTypeface() : deprecatedDkTextView.f7070l);
        }
        canvas.drawText(cArr, i, i2, this.f7527d.x, this.f7527d.y, paint);
    }

    /* renamed from: a */
    public void mo1805a(Canvas canvas) {
    }

    /* renamed from: c */
    public void mo1808c() {
    }

    /* renamed from: a */
    public boolean mo1806a(Rect rect) {
        return false;
    }

    /* renamed from: d */
    public boolean mo1809d() {
        return true;
    }
}
