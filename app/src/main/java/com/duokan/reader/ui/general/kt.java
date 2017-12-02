package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

import com.duokan.kernel.txtlib.DktRenderTextInfo;
import com.duokan.reader.ui.general.deprecatedDkTextView.TruncateMode;

class kt extends ku {
    final /* synthetic */ deprecatedDkTextView a;
    private final char[] c;
    private final PointF d;
    private final RectF e;
    private int f;

    private kt(deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView) {
        this.a = com_duokan_reader_ui_general_deprecatedDkTextView;
        super(com_duokan_reader_ui_general_deprecatedDkTextView);
        this.c = new char[1];
        this.d = new PointF();
        this.e = new RectF();
        this.f = -1;
    }

    public void a() {
    }

    public void b() {
    }

    public void a(Context context, Canvas canvas, Rect rect) {
        Rect a = this.a.o;
        Rect b = this.a.A;
        DktRenderTextInfo c = this.a.q;
        Paint b2 = deprecatedDkTextView.h;
        this.f = -1;
        int paddingLeft = this.a.getPaddingLeft();
        int paddingTop = this.a.getPaddingTop();
        float f = 2.14748365E9f;
        int length;
        int length2;
        int i;
        float f2;
        if (this.a.z && this.a.y == TruncateMode.END_WITH_SPACING) {
            length = c.mChars.length();
            length2 = c.mChars.length() - 1;
            while (length2 >= 0) {
                float f3;
                this.c[0] = c.mChars.charAt(length2);
                i = length2 << 1;
                this.d.x = c.mCharXYs[i];
                this.d.y = c.mCharXYs[i + 1];
                this.d.offset((float) paddingLeft, (float) paddingTop);
                this.e.left = c.mCharTopLefts[i];
                this.e.top = c.mCharTopLefts[i + 1];
                this.e.right = c.mCharBottomRights[i];
                this.e.bottom = c.mCharBottomRights[i + 1];
                this.e.offset((float) paddingLeft, (float) paddingTop);
                if (!this.e.intersects((float) a.left, (float) a.top, (float) a.right, (float) a.bottom)) {
                    i = length;
                    f3 = f;
                } else if (this.e.intersect((float) b.left, (float) b.top, (float) b.right, (float) b.bottom)) {
                    i = length - 1;
                    f3 = f;
                } else {
                    a(canvas, b2, this.c, 0, 1, c.mCharCharsets[length2]);
                    if (f == this.e.bottom || !this.a.B) {
                        i = length;
                        f3 = f;
                    } else {
                        f2 = this.e.bottom;
                        canvas.drawLine((float) (a.left + this.a.getPaddingLeft()), f2 + 1.0f, (float) (a.right - this.a.getPaddingRight()), f2 + 2.0f, b2);
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
                this.d.x = c.mCharXYs[i];
                this.d.y = c.mCharXYs[i + 1];
                this.d.offset((float) paddingLeft, (float) paddingTop);
                this.e.left = c.mCharTopLefts[i];
                this.e.top = c.mCharTopLefts[i + 1];
                this.e.right = c.mCharBottomRights[i];
                this.e.bottom = c.mCharBottomRights[i + 1];
                this.e.offset((float) paddingLeft, (float) paddingTop);
                a(canvas, b2, "...".toCharArray(), 0, 3, 0);
                if (f != this.e.bottom && this.a.B) {
                    f2 = this.e.bottom;
                    canvas.drawLine((float) (a.left + this.a.getPaddingLeft()), f2 + 1.0f, (float) (a.right - this.a.getPaddingRight()), f2 + 2.0f, b2);
                }
            }
        } else {
            length2 = c.mChars.length();
            length = 0;
            while (length < length2) {
                this.c[0] = c.mChars.charAt(length);
                i = length << 1;
                this.d.x = c.mCharXYs[i];
                this.d.y = c.mCharXYs[i + 1];
                this.d.offset((float) paddingLeft, (float) paddingTop);
                this.e.left = c.mCharTopLefts[i];
                this.e.top = c.mCharTopLefts[i + 1];
                this.e.right = c.mCharBottomRights[i];
                this.e.bottom = c.mCharBottomRights[i + 1];
                this.e.offset((float) paddingLeft, (float) paddingTop);
                if (this.e.intersects((float) a.left, (float) a.top, (float) a.right, (float) a.bottom)) {
                    a(canvas, b2, this.c, 0, 1, c.mCharCharsets[length]);
                    if (f == this.e.bottom || !this.a.B) {
                        f2 = f;
                    } else {
                        f2 = this.e.bottom;
                        canvas.drawLine((float) (a.left + this.a.getPaddingLeft()), f2 + 1.0f, (float) (a.right - this.a.getPaddingRight()), f2 + 2.0f, b2);
                    }
                } else {
                    f2 = f;
                }
                length++;
                f = f2;
            }
        }
        this.f = -1;
    }

    private void a(Canvas canvas, Paint paint, char[] cArr, int i, int i2, int i3) {
        if (this.f != i3) {
            this.f = i3;
            paint.setTypeface(this.f == 0 ? this.a.getEnTypeface() : deprecatedDkTextView.l);
        }
        canvas.drawText(cArr, i, i2, this.d.x, this.d.y, paint);
    }

    public void a(Canvas canvas) {
    }

    public void c() {
    }

    public boolean a(Rect rect) {
        return false;
    }

    public boolean d() {
        return true;
    }
}
