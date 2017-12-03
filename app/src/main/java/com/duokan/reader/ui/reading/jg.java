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
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.et;
import com.duokan.reader.ui.reading.a.c;

class jg extends FrameLayout {
    public Rect a;
    public int b = 0;
    final /* synthetic */ jd c;
    private final ViewGroup d;
    private int e = Integer.MAX_VALUE;
    private boolean f = true;
    private final Bitmap g = BitmapFactory.decodeResource(getContext().getResources(), f.reading__foot_annotation_bg);
    private final BitmapDrawable h = new BitmapDrawable(getContext().getResources(), this.g);
    private final et i = new et();
    private int j = 0;

    public jg(jd jdVar, Context context) {
        this.c = jdVar;
        super(context, null);
        setClickable(true);
        this.d = new FrameLayout(context);
        this.i.a(new c(new jh(this, jdVar)));
        addView(this.d, new LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(h.reading__note_view, this.d);
    }

    public View a() {
        if (this.d.getChildCount() == 1) {
            return this.d.getChildAt(0);
        }
        return null;
    }

    public final void a(Animation animation) {
        startAnimation(animation);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            b();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    protected void onMeasure(int i, int i2) {
        if (this.c.c == null) {
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
        measureChildWithMargins(this.d, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        setMeasuredDimension(Math.min(this.d.getMeasuredWidth(), this.e), this.d.getMeasuredHeight());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(i, 1), this.h.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(this.h.getBitmap().getPixel(1, 1));
        int max = Math.max(i - this.h.getIntrinsicWidth(), 0);
        canvas.drawRect(0.0f, 0.0f, (float) max, (float) this.h.getIntrinsicHeight(), paint);
        canvas.drawBitmap(this.g, (float) max, 0.0f, null);
        Bitmap createBitmap2 = Bitmap.createBitmap(Math.max(i, 1), Math.max(i2, 1), Config.ARGB_8888);
        canvas = new Canvas(createBitmap2);
        paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.REPEAT));
        canvas.drawRect(0.0f, 0.0f, (float) i, (float) i2, paint);
        this.d.setBackgroundDrawable(new BitmapDrawable(a(createBitmap2)));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.d.measure(MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        this.d.layout(0, 0, i3 - i, i4 - i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.i.a((View) this, motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.i.onTouch(this, motionEvent);
    }

    private void a(int i, int i2, int i3, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.initialize(0, 0, 0, 0);
        alphaAnimation.setDuration((long) i3);
        alphaAnimation.setAnimationListener(new jj(this, runnable));
        new jk(this, alphaAnimation, i, i2).run();
    }

    private final void b() {
        getViewTreeObserver().addOnPreDrawListener(new jl(this));
    }

    public void a(Rect rect) {
        this.a = rect;
    }

    public void a(int i) {
        this.b = i;
        if (i == 0) {
            this.d.setPadding(UTools.closeAnimation(getContext(), 20.0f), UTools.closeAnimation(getContext(), 15.0f), UTools.closeAnimation(getContext(), 25.0f), UTools.closeAnimation(getContext(), 15.0f));
        } else {
            this.d.setPadding(UTools.closeAnimation(getContext(), 35.0f), UTools.closeAnimation(getContext(), 15.0f), UTools.closeAnimation(getContext(), 5.0f), UTools.closeAnimation(getContext(), 15.0f));
        }
    }

    private Bitmap a(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setMaskFilter(new BlurMaskFilter((float) UTools.closeAnimation(getContext(), 4.0f), Blur.SOLID));
        int[] iArr = new int[2];
        Bitmap extractAlpha = bitmap.extractAlpha(paint, iArr);
        Bitmap createBitmap = Bitmap.createBitmap(extractAlpha.getWidth(), extractAlpha.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        if (this.c.a.b != 0) {
            canvas.rotate(180.0f, (float) (createBitmap.getWidth() / 2), (float) (createBitmap.getHeight() / 2));
            canvas.save();
        }
        paint.setColor(getResources().getColor(d.general__shared__shadow));
        canvas.drawBitmap(extractAlpha, (float) iArr[0], 0.0f, paint);
        canvas.drawBitmap(bitmap, 0.0f, (float) (-iArr[1]), null);
        extractAlpha.recycle();
        return createBitmap;
    }
}
