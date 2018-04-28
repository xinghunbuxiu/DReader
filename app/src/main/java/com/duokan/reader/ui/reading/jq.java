package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.et;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.reading.p054a.C1422c;

class jq extends FrameLayout {
    /* renamed from: a */
    public Rect f10455a;
    /* renamed from: b */
    public int f10456b = 0;
    /* renamed from: c */
    final /* synthetic */ jn f10457c;
    /* renamed from: d */
    private final ViewGroup f10458d;
    /* renamed from: e */
    private int f10459e = Integer.MAX_VALUE;
    /* renamed from: f */
    private boolean f10460f = true;
    /* renamed from: g */
    private final Bitmap f10461g = BitmapFactory.decodeResource(getContext().getResources(), C0254f.reading__foot_annotation_bg);
    /* renamed from: h */
    private final BitmapDrawable f10462h = new BitmapDrawable(getContext().getResources(), this.f10461g);
    /* renamed from: i */
    private final et f10463i = new et();
    /* renamed from: j */
    private int f10464j = 0;

    public jq(jn jnVar, Context context) {
        this.f10457c = jnVar;
        super(context, null);
        setClickable(true);
        this.f10458d = new FrameLayout(context);
        this.f10463i.m2041a(new C1422c(new jr(this, jnVar)));
        addView(this.f10458d, new LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(C0256h.reading__note_view, this.f10458d);
    }

    /* renamed from: a */
    public View m14499a() {
        if (this.f10458d.getChildCount() == 1) {
            return this.f10458d.getChildAt(0);
        }
        return null;
    }

    /* renamed from: a */
    public final void m14502a(Animation animation) {
        startAnimation(animation);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            m14496b();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m14496b();
    }

    protected void onMeasure(int i, int i2) {
        if (this.f10457c.f10447c == null) {
            super.onMeasure(i, i2);
            return;
        }
        int size;
        int size2 = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) : Integer.MAX_VALUE;
        if (MeasureSpec.getMode(i2) != 0) {
            size = MeasureSpec.getSize(i2);
        } else {
            size = Integer.MAX_VALUE;
        }
        measureChildWithMargins(this.f10458d, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        setMeasuredDimension(Math.min(this.f10458d.getMeasuredWidth(), this.f10459e), this.f10458d.getMeasuredHeight());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(i, 1), this.f10462h.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(this.f10462h.getBitmap().getPixel(1, 1));
        int max = Math.max(i - this.f10462h.getIntrinsicWidth(), 0);
        canvas.drawRect(0.0f, 0.0f, (float) max, (float) this.f10462h.getIntrinsicHeight(), paint);
        canvas.drawBitmap(this.f10461g, (float) max, 0.0f, null);
        Bitmap createBitmap2 = Bitmap.createBitmap(Math.max(i, 1), Math.max(i2, 1), Config.ARGB_8888);
        canvas = new Canvas(createBitmap2);
        paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.REPEAT));
        canvas.drawRect(0.0f, 0.0f, (float) i, (float) i2, paint);
        this.f10458d.setBackgroundDrawable(new BitmapDrawable(m14492a(createBitmap2)));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f10458d.measure(MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        this.f10458d.layout(0, 0, i3 - i, i4 - i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f10463i.m2044a((View) this, motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f10463i.onTouch(this, motionEvent);
    }

    /* renamed from: a */
    private void m14493a(int i, int i2, int i3, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.initialize(0, 0, 0, 0);
        alphaAnimation.setDuration((long) i3);
        alphaAnimation.setAnimationListener(new jt(this, runnable));
        new ju(this, alphaAnimation, i, i2).run();
    }

    /* renamed from: b */
    private final void m14496b() {
        getViewTreeObserver().addOnPreDrawListener(new jv(this));
    }

    /* renamed from: a */
    public void m14501a(Rect rect) {
        this.f10455a = rect;
    }

    /* renamed from: a */
    public void m14500a(int i) {
        this.f10456b = i;
        if (i == 0) {
            this.f10458d.setPadding(dv.m1932b(getContext(), 20.0f), dv.m1932b(getContext(), 15.0f), dv.m1932b(getContext(), 25.0f), dv.m1932b(getContext(), 15.0f));
        } else {
            this.f10458d.setPadding(dv.m1932b(getContext(), 35.0f), dv.m1932b(getContext(), 15.0f), dv.m1932b(getContext(), 5.0f), dv.m1932b(getContext(), 15.0f));
        }
    }

    /* renamed from: a */
    private Bitmap m14492a(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setMaskFilter(new BlurMaskFilter((float) dv.m1932b(getContext(), 4.0f), Blur.SOLID));
        int[] iArr = new int[2];
        Bitmap extractAlpha = bitmap.extractAlpha(paint, iArr);
        Bitmap createBitmap = Bitmap.createBitmap(extractAlpha.getWidth(), extractAlpha.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        if (this.f10457c.f10445a.f10456b != 0) {
            canvas.rotate(180.0f, (float) (createBitmap.getWidth() / 2), (float) (createBitmap.getHeight() / 2));
            canvas.save();
        }
        paint.setColor(getResources().getColor(C0252d.general__shared__shadow));
        canvas.drawBitmap(extractAlpha, (float) iArr[0], 0.0f, paint);
        canvas.drawBitmap(bitmap, 0.0f, (float) (-iArr[1]), null);
        extractAlpha.recycle();
        return createBitmap;
    }
}
