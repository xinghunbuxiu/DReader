package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;

import com.duokan.core.sys.AsyncCache;
import com.duokan.core.sys.ap;
import com.duokan.core.sys.t;

import org.apache.http.HttpStatus;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;

public abstract class dv {
    public static final ap a = new dw();
    public static final ap b = new eh();
    public static final ap c = new ei();
    public static final ap d = new ej();
    public static final ap e = new ek();
    public static final ap f = new el();
    public static final ap g = new em();
    public static final ap h = new en();
    public static final ap i = new eo();
    public static final ap j = new dx();
    public static final ap k = new dy();
    public static final ap l = new dz();
    public static final AsyncCache m = new AsyncCache();
    static final /* synthetic */ boolean n = (!dv.class.desiredAssertionStatus());
    private static float o = Float.NaN;
    private static float p = Float.NaN;

    public static final void a(View view, Callable callable) {
        if (view != null && callable != null) {
            ea eaVar = new ea(view, callable);
        }
    }

    public static final void a(View view, Runnable runnable) {
        if (view != null && runnable != null) {
            a(view, new eb(runnable));
        }
    }

    public static void a(View view, int i) {
        if (view != null) {
            t.b(new ec(view, i));
        }
    }

    public static void a(View view) {
        a(view, 1);
    }

    public static void a(Context context, int i) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        try {
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            inputMethodManager.hideSoftInputFromWindow(((View) declaredField.get(inputMethodManager)).getWindowToken(), i);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context) {
        a(context, 0);
    }

    public static int b(View view) {
        if (view.getWindowToken() == null || view.getWindowVisibility() == 8) {
            return 8;
        }
        int visibility = view.getVisibility();
        if (visibility == 8) {
            return 8;
        }
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof View)) {
            int visibility2 = ((View) parent).getVisibility();
            if (visibility2 == 8) {
                visibility = 8;
                break;
            }
            visibility2 = visibility2 == 4 ? 4 : visibility;
            parent = parent.getParent();
            visibility = visibility2;
        }
        return visibility;
    }

    public static Rect a(Rect rect, View view, View view2) {
        RectF rectF = (RectF) h.a();
        a(rectF, view, view2);
        rectF.round(rect);
        h.a(rectF);
        return rect;
    }

    public static RectF a(RectF rectF, View view, View view2) {
        rectF.set((float) view.getScrollX(), (float) view.getScrollY(), (float) (view.getScrollX() + view.getWidth()), (float) (view.getScrollY() + view.getHeight()));
        b(rectF, view, view2);
        return rectF;
    }

    public static boolean a(RectF rectF, View view) {
        RectF rectF2 = (RectF) h.a();
        rectF.set((float) view.getScrollX(), (float) view.getScrollY(), (float) (view.getScrollX() + view.getWidth()), (float) (view.getScrollY() + view.getHeight()));
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof View)) {
            View view2 = (View) parent;
            rectF2.set((float) view2.getScrollX(), (float) view2.getScrollY(), (float) (view2.getScrollX() + view2.getWidth()), (float) (view2.getScrollY() + view2.getHeight()));
            b(rectF2, view2, view);
            if (!rectF.intersect(rectF2)) {
                rectF.setEmpty();
                break;
            }
            parent = parent.getParent();
        }
        h.a(rectF2);
        if (rectF.isEmpty()) {
            return false;
        }
        return true;
    }

    public static MotionEvent a(MotionEvent motionEvent, View view, View view2) {
        Matrix matrix = (Matrix) d.a();
        a(matrix, view, view2);
        matrix.preTranslate((float) view.getScrollX(), (float) view.getScrollY());
        if (view2 != null) {
            matrix.postTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        MotionEvent a = a(motionEvent, matrix);
        d.a(matrix);
        return a;
    }

    public static MotionEvent a(MotionEvent motionEvent, Matrix matrix) {
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        PointerCoords[] pointerCoordsArr = new PointerCoords[pointerCount];
        int metaState = motionEvent.getMetaState();
        float xPrecision = motionEvent.getXPrecision();
        float yPrecision = motionEvent.getYPrecision();
        int deviceId = motionEvent.getDeviceId();
        int edgeFlags = motionEvent.getEdgeFlags();
        int source = motionEvent.getSource();
        int flags = motionEvent.getFlags();
        PointF pointF = (PointF) f.a();
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            pointerCoordsArr[i] = new PointerCoords();
            motionEvent.getPointerCoords(i, pointerCoordsArr[i]);
            pointF.set(pointerCoordsArr[i].x, pointerCoordsArr[i].y);
            a(matrix, pointF);
            pointerCoordsArr[i].x = pointF.x;
            pointerCoordsArr[i].y = pointF.y;
        }
        f.a(pointF);
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, iArr, pointerCoordsArr, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }

    public static Rect[] a(Rect[] rectArr, View view, View view2) {
        for (Rect b : rectArr) {
            b(b, view, view2);
        }
        return rectArr;
    }

    public static Rect b(Rect rect, View view, View view2) {
        RectF rectF = (RectF) h.a();
        rectF.set(rect);
        b(rectF, view, view2);
        rectF.round(rect);
        h.a(rectF);
        return rect;
    }

    public static Point a(Point point, View view, View view2) {
        PointF pointF = (PointF) f.a();
        pointF.set((float) point.x, (float) point.y);
        a(pointF, view, view2);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.a(pointF);
        return point;
    }

    public static RectF b(RectF rectF, View view, View view2) {
        Matrix matrix = (Matrix) d.a();
        float[] fArr = (float[]) j.a();
        float[] fArr2 = (float[]) j.a();
        a(matrix, view, view2);
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        matrix.mapPoints(fArr);
        matrix.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        j.a(fArr2);
        j.a(fArr);
        d.a(matrix);
        return rectF;
    }

    public static PointF a(PointF pointF, View view, View view2) {
        Matrix matrix = (Matrix) d.a();
        float[] fArr = (float[]) i.a();
        a(matrix, view, view2);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        d.a(matrix);
        i.a(fArr);
        return pointF;
    }

    public static Rect a(Rect rect, View view) {
        RectF rectF = (RectF) h.a();
        rectF.set(rect);
        b(rectF, view);
        rectF.round(rect);
        h.a(rectF);
        return rect;
    }

    public static Point a(Point point, View view) {
        PointF pointF = (PointF) f.a();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        a(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.a(pointF);
        return point;
    }

    public static Point b(Point point, View view) {
        PointF pointF = (PointF) f.a();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        b(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.a(pointF);
        return point;
    }

    public static RectF b(RectF rectF, View view) {
        Matrix matrix = (Matrix) d.a();
        Matrix matrix2 = (Matrix) d.a();
        float[] fArr = (float[]) j.a();
        float[] fArr2 = (float[]) j.a();
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        a(matrix, view);
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        matrix2.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        j.a(fArr2);
        j.a(fArr);
        d.a(matrix2);
        d.a(matrix);
        return rectF;
    }

    public static PointF a(PointF pointF, View view) {
        PointF pointF2 = (PointF) f.a();
        b(pointF, view);
        b(pointF2, view);
        pointF.x -= pointF2.x;
        pointF.y -= pointF2.y;
        f.a(pointF2);
        return pointF;
    }

    public static PointF b(PointF pointF, View view) {
        Matrix matrix = (Matrix) d.a();
        Matrix matrix2 = (Matrix) d.a();
        float[] fArr = (float[]) i.a();
        a(matrix, view);
        matrix.invert(matrix2);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix2.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        i.a(fArr);
        d.a(matrix2);
        d.a(matrix);
        return pointF;
    }

    public static Rect b(Rect rect, View view) {
        RectF rectF = (RectF) h.a();
        rectF.set(rect);
        c(rectF, view);
        rectF.round(rect);
        h.a(rectF);
        return rect;
    }

    public static Point c(Point point, View view) {
        PointF pointF = (PointF) f.a();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        d(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.a(pointF);
        return point;
    }

    public static RectF c(RectF rectF, View view) {
        Matrix matrix = (Matrix) d.a();
        float[] fArr = (float[]) j.a();
        float[] fArr2 = (float[]) j.a();
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        a(matrix, view);
        matrix.mapPoints(fArr);
        matrix.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        j.a(fArr2);
        j.a(fArr);
        d.a(matrix);
        return rectF;
    }

    public static PointF c(PointF pointF, View view) {
        PointF pointF2 = (PointF) f.a();
        d(pointF, view);
        d(pointF2, view);
        pointF.x -= pointF2.x;
        pointF.y -= pointF2.y;
        f.a(pointF2);
        return pointF;
    }

    public static PointF d(PointF pointF, View view) {
        Matrix matrix = (Matrix) d.a();
        float[] fArr = (float[]) i.a();
        a(matrix, view);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        d.a(matrix);
        i.a(fArr);
        return pointF;
    }

    public static Matrix a(Matrix matrix, View view, View view2) {
        Matrix matrix2 = (Matrix) d.a();
        Matrix matrix3 = (Matrix) d.a();
        a(matrix2, view);
        a(matrix3, view2);
        matrix3.invert(matrix);
        matrix.preConcat(matrix2);
        d.a(matrix3);
        d.a(matrix2);
        return matrix;
    }

    @TargetApi(11)
    public static Matrix a(Matrix matrix, View view) {
        if (view != null) {
            while (true) {
                matrix.postTranslate((float) (-view.getScrollX()), (float) (-view.getScrollY()));
                if (VERSION.SDK_INT >= 11) {
                    matrix.postConcat(view.getMatrix());
                }
                ViewParent parent = view.getParent();
                if (parent instanceof fk) {
                    matrix.postConcat(((fk) parent).c(view));
                }
                matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            }
            int[] iArr = (int[]) l.a();
            iArr[0] = 0;
            iArr[1] = 0;
            view.getLocationOnScreen(iArr);
            matrix.postTranslate((float) iArr[0], (float) iArr[1]);
            l.a(iArr);
        }
        return matrix;
    }

    public static Rect a(Matrix matrix, Rect rect) {
        RectF rectF = (RectF) h.a();
        rectF.set(rect);
        a(matrix, rectF);
        rectF.round(rect);
        h.a(rectF);
        return rect;
    }

    public static PointF a(Matrix matrix, PointF pointF) {
        float[] fArr = (float[]) i.a();
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        i.a(fArr);
        return pointF;
    }

    public static RectF a(Matrix matrix, RectF rectF) {
        float[] fArr = (float[]) j.a();
        float[] fArr2 = (float[]) j.a();
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        matrix.mapPoints(fArr);
        matrix.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        j.a(fArr);
        j.a(fArr2);
        return rectF;
    }

    public static boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        return a(b(a(pointF, pointF2), d, d + 360.0d), d, d2);
    }

    public static boolean a(double d, double d2, double d3) {
        double b = b(d, d2, d2 + 360.0d);
        if (Double.compare(b, d2) >= 0 && Double.compare(b, d3) < 0) {
            return true;
        }
        b = b(180.0d + d, d2, d2 + 360.0d);
        if (Double.compare(b, d2) < 0 || Double.compare(b, d3) >= 0) {
            return false;
        }
        return true;
    }

    public static int a(int i, int i2, int i3) {
        return (int) b((double) i, (double) i2, (double) i3);
    }

    public static double b(double d, double d2, double d3) {
        if (!n && d2 >= d3) {
            throw new AssertionError();
        } else if (n || Double.compare(Math.abs(d3 - d2), 360.0d) == 0) {
            while (true) {
                if (Double.compare(d, d2) >= 0 && Double.compare(d, d3) < 0) {
                    return d;
                }
                if (Double.compare(d, d2) < 0) {
                    d += 360.0d;
                } else {
                    d -= 360.0d;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public static double a(PointF pointF, PointF pointF2) {
        double b = b(pointF, pointF2);
        if (Double.compare(b, 180.0d) > 0) {
            return b - 180.0d;
        }
        return b;
    }

    public static double b(PointF pointF, PointF pointF2) {
        return Math.toDegrees(c(pointF, pointF2));
    }

    public static double c(PointF pointF, PointF pointF2) {
        if (n || !(pointF == null || pointF2 == null)) {
            PointF pointF3 = new PointF(pointF.x, -pointF.y);
            PointF pointF4 = new PointF(pointF2.x, -pointF2.y);
            if (pointF4.x == pointF3.x) {
                if (pointF4.y > pointF3.y) {
                    return 1.5707963267948966d;
                }
                return 4.71238898038469d;
            } else if (pointF4.y != pointF3.y) {
                double atan = Math.atan(((double) (pointF4.y - pointF3.y)) / ((double) (pointF4.x - pointF3.x)));
                if (pointF4.x < pointF3.x && pointF4.y > pointF3.y) {
                    return 3.141592653589793d + atan;
                }
                if (pointF4.x >= pointF3.x || pointF4.y >= pointF3.y) {
                    return (pointF4.x <= pointF3.x || pointF4.y >= pointF3.y) ? atan : 6.283185307179586d + atan;
                } else {
                    return 3.141592653589793d + atan;
                }
            } else if (pointF4.x > pointF3.x) {
                return 0.0d;
            } else {
                return 3.141592653589793d;
            }
        }
        throw new AssertionError();
    }

    public static double d(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
    }

    public static int b(Context context) {
        return ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public static int c(Context context) {
        return ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static int a() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public static int d(Context context) {
        return ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public static int e(Context context) {
        return ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public static int b() {
        return ViewConfiguration.getJumpTapTimeout();
    }

    public static int c() {
        return ViewConfiguration.getTapTimeout();
    }

    public static int d() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    public static int e() {
        return ViewConfiguration.getPressedStateDuration();
    }

    public static int f(Context context) {
        return b(context, 40.0f);
    }

    public static int g(Context context) {
        return b(context, 40.0f);
    }

    public static int a(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * f);
    }

    public static int b(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }

    public static float b(Context context, int i) {
        return ((float) i) / context.getResources().getDisplayMetrics().density;
    }

    public static float c(Context context, float f) {
        return (h(context) * f) / 160.0f;
    }

    public static float d(Context context, float f) {
        return (i(context) * f) / 160.0f;
    }

    public static int e(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * f);
    }

    public static int f(Context context, float f) {
        return Math.round(c(context, f));
    }

    public static int g(Context context, float f) {
        return Math.round(d(context, f));
    }

    public static float h(Context context) {
        l(context);
        return o;
    }

    public static float i(Context context) {
        l(context);
        return p;
    }

    private static void l(Context context) {
        if (Float.isNaN(o) || Float.isNaN(p)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int round = Math.round((float) Math.sqrt((double) (displayMetrics.xdpi * displayMetrics.ydpi)));
            if (Float.compare(Math.abs((((float) Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / ((float) round)), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / ((float) round)), 2.0d))) / ((float) Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / ((float) displayMetrics.densityDpi)), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / ((float) displayMetrics.densityDpi)), 2.0d)))) - 1.0f), 0.3f) <= 0) {
                o = displayMetrics.xdpi;
                p = displayMetrics.ydpi;
                return;
            }
            float f = (float) displayMetrics.densityDpi;
            p = f;
            o = f;
        }
    }

    public static int j(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int k(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static void a(Canvas canvas, String str, RectF rectF, int i, Paint paint) {
        float f;
        float f2;
        Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Align.LEFT);
        Rect rect = (Rect) g.a();
        a(rect, paint, str, rectF.width());
        switch (i & 7) {
            case 3:
                f = rectF.left - ((float) rect.left);
                break;
            case 5:
                f = rectF.right - ((float) rect.right);
                break;
            default:
                f = rectF.centerX() - rect.exactCenterX();
                break;
        }
        switch (i & 112) {
            case j.a /*48*/:
                f2 = rectF.top - ((float) rect.top);
                break;
            case 80:
                f2 = rectF.bottom - ((float) rect.bottom);
                break;
            default:
                f2 = rectF.centerY() - rect.exactCenterY();
                break;
        }
        canvas.drawText(str, f, f2, paint);
        g.a(rect);
        paint.setTextAlign(textAlign);
    }

    public static void a(Canvas canvas, String str, Rect rect, int i, Paint paint) {
        RectF rectF = (RectF) h.a();
        rectF.set(rect);
        a(canvas, str, rectF, i, paint);
        h.a(rectF);
    }

    public static Rect a(Rect rect, Paint paint, String str, float f) {
        int breakText = paint.breakText(str, true, f, null);
        while (breakText < str.length()) {
            breakText--;
            if (breakText <= 0) {
                str = "";
                break;
            }
            String str2 = str.substring(0, breakText) + "…";
            if (Float.compare(paint.measureText(str2), f) <= 0) {
                str = str2;
                break;
            }
        }
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    public static void a(Canvas canvas, Drawable drawable, Rect rect, int i, int i2, int i3) {
        int i4;
        int i5;
        if (i < 0) {
            if ((i3 & 7) == 7) {
                i = rect.width();
            } else {
                i = drawable.getIntrinsicWidth();
            }
        }
        if (i2 < 0) {
            if ((i3 & 112) == 112) {
                i2 = rect.height();
            } else {
                i2 = drawable.getIntrinsicHeight();
            }
        }
        if ((i3 & 7) == 3) {
            i4 = rect.left;
        } else if ((i3 & 7) == 5) {
            i4 = rect.right - i;
        } else {
            i4 = (((rect.left + rect.right) - i) + 1) / 2;
        }
        if ((i3 & 112) == 48) {
            i5 = rect.top;
        } else if ((i3 & 112) == 80) {
            i5 = rect.bottom - i2;
        } else {
            i5 = (((rect.top + rect.bottom) - i2) + 1) / 2;
        }
        drawable.setBounds(i4, i5, i4 + i, i5 + i2);
        drawable.draw(canvas);
    }

    public static void a(Canvas canvas, Drawable drawable, Rect rect, int i) {
        a(canvas, drawable, rect, -1, -1, i);
    }

    public static void b(View view, Runnable runnable) {
        a(view, 0.0f, 1.0f, (int) HttpStatus.SC_OK, false, runnable);
    }

    public static void c(View view, Runnable runnable) {
        a(view, 1.0f, 0.0f, (int) HttpStatus.SC_OK, false, runnable);
    }

    public static void a(View view, float f, float f2, int i, boolean z, Runnable runnable) {
        a(view, f, f2, i, z, new AccelerateDecelerateInterpolator(), runnable);
    }

    public static void a(View view, float f, float f2, int i, boolean z, Interpolator interpolator, Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setAnimationListener(new ef(runnable));
        alphaAnimation.setInterpolator(interpolator);
        alphaAnimation.setFillEnabled(z);
        alphaAnimation.setFillAfter(z);
        view.startAnimation(alphaAnimation);
    }

    public static void d(View view, Runnable runnable) {
        a(view, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void e(View view, Runnable runnable) {
        a(view, 0.0f, 0.0f, 1.0f, 0.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void f(View view, Runnable runnable) {
        a(view, 0.0f, 0.0f, 0.0f, -1.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void g(View view, Runnable runnable) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void a(View view, float f, float f2, float f3, float f4, int i, boolean z, Runnable runnable) {
        a(view, f, f2, f3, f4, i, z, new AccelerateDecelerateInterpolator(), runnable);
    }

    public static void a(View view, float f, float f2, float f3, float f4, int i, boolean z, Interpolator interpolator, Runnable runnable) {
        Animation translateAnimation = new TranslateAnimation(1, f, 1, f2, 1, f3, 1, f4);
        translateAnimation.setDuration((long) i);
        translateAnimation.setAnimationListener(new eg(runnable));
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setFillEnabled(z);
        translateAnimation.setFillAfter(z);
        view.startAnimation(translateAnimation);
    }

    public static void h(View view, Runnable runnable) {
        a(view, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new OvershootInterpolator(), runnable);
    }

    public static float a(float f) {
        return Math.min(1.0f, Math.max(0.0f, f));
    }
}
