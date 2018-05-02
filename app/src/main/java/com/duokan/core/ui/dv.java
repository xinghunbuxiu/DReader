package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Camera;
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
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;

import com.duokan.core.sys.AsyncCache;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.BaseAnimation;
import com.umeng.analytics.pro.C2295j;

import org.apache.http.HttpStatus;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;

public abstract class dv {
    public static final BaseAnimation<Camera> f1192a = new dw();
    public static final BaseAnimation<Paint> f1193b = new eh();
    public static final BaseAnimation<Transformation> f1194c = new ei();
    public static final BaseAnimation<Matrix> f1195d = new ej();
    public static final BaseAnimation<Point> f1196e = new ek();
    public static final BaseAnimation<PointF> f1197f = new el();
    public static final BaseAnimation<Rect> f1198g = new em();
    public static final BaseAnimation<RectF> f1199h = new en();
    public static final BaseAnimation<float[]> f1200i = new eo();
    public static final BaseAnimation<float[]> f1201j = new dx();
    public static final BaseAnimation<float[]> f1202k = new dy();
    public static final BaseAnimation<int[]> f1203l = new dz();
    public static final AsyncCache cathe = new AsyncCache();
    static final boolean assertionStatus = (!dv.class.desiredAssertionStatus());
    private static float xdpi = Float.NaN;
    private static float ydpi = Float.NaN;

    public static final void m1922a(View view, Callable<Boolean> callable) {
        if (view != null && callable != null) {
            ea eaVar = new ea(view, callable);
        }
    }


    public static final void m1921a(View view, Runnable runnable) {
        if (view != null && runnable != null) {
            m1922a(view, new eb(runnable));
        }
    }


    public static void m1920a(View view, int i) {
        if (view != null) {
            UThread.post(new ec(view, i));
        }
    }


    public static void m1915a(View view) {
        m1920a(view, 1);
    }


    public static void m1910a(Context context, int i) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        try {
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            inputMethodManager.hideSoftInputFromWindow(((View) declaredField.get(inputMethodManager)).getWindowToken(), i);
        } catch (Throwable th) {
        }
    }


    public static void m1909a(Context context) {
        m1910a(context, 0);
    }


    public static int m1933b(View view) {
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


    public static Rect m1904a(Rect rect, View view, View view2) {
        RectF rectF = (RectF) f1199h.addAnimation();
        m1906a(rectF, view, view2);
        rectF.round(rect);
        f1199h.clearAnimation(rectF);
        return rect;
    }


    public static RectF m1906a(RectF rectF, View view, View view2) {
        rectF.set((float) view.getScrollX(), (float) view.getScrollY(), (float) (view.getScrollX() + view.getWidth()), (float) (view.getScrollY() + view.getHeight()));
        m1939b(rectF, view, view2);
        return rectF;
    }


    public static boolean m1925a(RectF rectF, View view) {
        RectF rectF2 = (RectF) f1199h.addAnimation();
        rectF.set((float) view.getScrollX(), (float) view.getScrollY(), (float) (view.getScrollX() + view.getWidth()), (float) (view.getScrollY() + view.getHeight()));
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof View)) {
            View view2 = (View) parent;
            rectF2.set((float) view2.getScrollX(), (float) view2.getScrollY(), (float) (view2.getScrollX() + view2.getWidth()), (float) (view2.getScrollY() + view2.getHeight()));
            m1939b(rectF2, view2, view);
            if (!rectF.intersect(rectF2)) {
                rectF.setEmpty();
                break;
            }
            parent = parent.getParent();
        }
        f1199h.clearAnimation(rectF2);
        if (rectF.isEmpty()) {
            return false;
        }
        return true;
    }


    public static MotionEvent m1908a(MotionEvent motionEvent, View view, View view2) {
        Matrix matrix = (Matrix) f1195d.addAnimation();
        m1895a(matrix, view, view2);
        matrix.preTranslate((float) view.getScrollX(), (float) view.getScrollY());
        if (view2 != null) {
            matrix.postTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        MotionEvent a = m1907a(motionEvent, matrix);
        f1195d.clearAnimation(matrix);
        return a;
    }


    public static MotionEvent m1907a(MotionEvent motionEvent, Matrix matrix) {
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
        PointF pointF = (PointF) f1197f.addAnimation();
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            pointerCoordsArr[i] = new PointerCoords();
            motionEvent.getPointerCoords(i, pointerCoordsArr[i]);
            pointF.set(pointerCoordsArr[i].x, pointerCoordsArr[i].y);
            m1898a(matrix, pointF);
            pointerCoordsArr[i].x = pointF.x;
            pointerCoordsArr[i].y = pointF.y;
        }
        f1197f.clearAnimation(pointF);
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, iArr, pointerCoordsArr, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }


    public static Rect[] m1926a(Rect[] rectArr, View view, View view2) {
        for (Rect b : rectArr) {
            m1937b(b, view, view2);
        }
        return rectArr;
    }


    public static Rect m1937b(Rect rect, View view, View view2) {
        RectF rectF = (RectF) f1199h.addAnimation();
        rectF.set(rect);
        m1939b(rectF, view, view2);
        rectF.round(rect);
        f1199h.clearAnimation(rectF);
        return rect;
    }


    public static Point m1897a(Point point, View view, View view2) {
        PointF pointF = (PointF) f1197f.addAnimation();
        pointF.set((float) point.x, (float) point.y);
        m1900a(pointF, view, view2);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f1197f.clearAnimation(pointF);
        return point;
    }


    public static RectF m1939b(RectF rectF, View view, View view2) {
        Matrix matrix = (Matrix) f1195d.addAnimation();
        float[] fArr = (float[]) f1201j.addAnimation();
        float[] fArr2 = (float[]) f1201j.addAnimation();
        m1895a(matrix, view, view2);
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
        f1201j.clearAnimation(fArr2);
        f1201j.clearAnimation(fArr);
        f1195d.clearAnimation(matrix);
        return rectF;
    }


    public static PointF m1900a(PointF pointF, View view, View view2) {
        Matrix matrix = (Matrix) f1195d.addAnimation();
        float[] fArr = (float[]) f1200i.addAnimation();
        m1895a(matrix, view, view2);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        f1195d.clearAnimation(matrix);
        f1200i.clearAnimation(fArr);
        return pointF;
    }


    public static Rect m1903a(Rect rect, View view) {
        RectF rectF = (RectF) f1199h.addAnimation();
        rectF.set(rect);
        m1938b(rectF, view);
        rectF.round(rect);
        f1199h.clearAnimation(rectF);
        return rect;
    }


    public static Point m1896a(Point point, View view) {
        PointF pointF = (PointF) f1197f.addAnimation();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        m1899a(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f1197f.clearAnimation(pointF);
        return point;
    }


    public static Point m1934b(Point point, View view) {
        PointF pointF = (PointF) f1197f.addAnimation();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        m1935b(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f1197f.clearAnimation(pointF);
        return point;
    }


    public static RectF m1938b(RectF rectF, View view) {
        Matrix matrix = (Matrix) f1195d.addAnimation();
        Matrix matrix2 = (Matrix) f1195d.addAnimation();
        float[] fArr = (float[]) f1201j.addAnimation();
        float[] fArr2 = (float[]) f1201j.addAnimation();
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        m1894a(matrix, view);
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        matrix2.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        f1201j.clearAnimation(fArr2);
        f1201j.clearAnimation(fArr);
        f1195d.clearAnimation(matrix2);
        f1195d.clearAnimation(matrix);
        return rectF;
    }


    public static PointF m1899a(PointF pointF, View view) {
        PointF pointF2 = (PointF) f1197f.addAnimation();
        m1935b(pointF, view);
        m1935b(pointF2, view);
        pointF.x -= pointF2.x;
        pointF.y -= pointF2.y;
        f1197f.clearAnimation(pointF2);
        return pointF;
    }


    public static PointF m1935b(PointF pointF, View view) {
        Matrix matrix = (Matrix) f1195d.addAnimation();
        Matrix matrix2 = (Matrix) f1195d.addAnimation();
        float[] fArr = (float[]) f1200i.addAnimation();
        m1894a(matrix, view);
        matrix.invert(matrix2);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix2.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        f1200i.clearAnimation(fArr);
        f1195d.clearAnimation(matrix2);
        f1195d.clearAnimation(matrix);
        return pointF;
    }


    public static Rect m1936b(Rect rect, View view) {
        RectF rectF = (RectF) f1199h.addAnimation();
        rectF.set(rect);
        m1947c(rectF, view);
        rectF.round(rect);
        f1199h.clearAnimation(rectF);
        return rect;
    }


    public static Point m1945c(Point point, View view) {
        PointF pointF = (PointF) f1197f.addAnimation();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        m1953d(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f1197f.clearAnimation(pointF);
        return point;
    }


    public static RectF m1947c(RectF rectF, View view) {
        Matrix matrix = (Matrix) f1195d.addAnimation();
        float[] fArr = (float[]) f1201j.addAnimation();
        float[] fArr2 = (float[]) f1201j.addAnimation();
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        m1894a(matrix, view);
        matrix.mapPoints(fArr);
        matrix.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        f1201j.clearAnimation(fArr2);
        f1201j.clearAnimation(fArr);
        f1195d.clearAnimation(matrix);
        return rectF;
    }


    public static PointF m1946c(PointF pointF, View view) {
        PointF pointF2 = (PointF) f1197f.addAnimation();
        m1953d(pointF, view);
        m1953d(pointF2, view);
        pointF.x -= pointF2.x;
        pointF.y -= pointF2.y;
        f1197f.clearAnimation(pointF2);
        return pointF;
    }


    public static PointF m1953d(PointF pointF, View view) {
        Matrix matrix = (Matrix) f1195d.addAnimation();
        float[] fArr = (float[]) f1200i.addAnimation();
        m1894a(matrix, view);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        f1195d.clearAnimation(matrix);
        f1200i.clearAnimation(fArr);
        return pointF;
    }


    public static Matrix m1895a(Matrix matrix, View view, View view2) {
        Matrix matrix2 = (Matrix) f1195d.addAnimation();
        Matrix matrix3 = (Matrix) f1195d.addAnimation();
        m1894a(matrix2, view);
        m1894a(matrix3, view2);
        matrix3.invert(matrix);
        matrix.preConcat(matrix2);
        f1195d.clearAnimation(matrix3);
        f1195d.clearAnimation(matrix2);
        return matrix;
    }

    @TargetApi(11)
    public static Matrix m1894a(Matrix matrix, View view) {
        if (view != null) {
            while (true) {
                matrix.postTranslate((float) (-view.getScrollX()), (float) (-view.getScrollY()));
                if (VERSION.SDK_INT >= 11) {
                    matrix.postConcat(view.getMatrix());
                }
                ViewParent parent = view.getParent();
                if (parent instanceof fk) {
                    matrix.postConcat(((fk) parent).mo475c(view));
                }
                matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            }
            int[] iArr = (int[]) f1203l.addAnimation();
            iArr[0] = 0;
            iArr[1] = 0;
            view.getLocationOnScreen(iArr);
            matrix.postTranslate((float) iArr[0], (float) iArr[1]);
            f1203l.clearAnimation(iArr);
        }
        return matrix;
    }


    public static Rect m1901a(Matrix matrix, Rect rect) {
        RectF rectF = (RectF) f1199h.addAnimation();
        rectF.set(rect);
        m1905a(matrix, rectF);
        rectF.round(rect);
        f1199h.clearAnimation(rectF);
        return rect;
    }


    public static PointF m1898a(Matrix matrix, PointF pointF) {
        float[] fArr = (float[]) f1200i.addAnimation();
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        f1200i.clearAnimation(fArr);
        return pointF;
    }


    public static RectF m1905a(Matrix matrix, RectF rectF) {
        float[] fArr = (float[]) f1201j.addAnimation();
        float[] fArr2 = (float[]) f1201j.addAnimation();
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
        f1201j.clearAnimation(fArr);
        f1201j.clearAnimation(fArr2);
        return rectF;
    }


    public static boolean m1924a(PointF pointF, PointF pointF2, double d, double d2) {
        return m1923a(m1927b(m1889a(pointF, pointF2), d, d + 360.0d), d, d2);
    }


    public static boolean m1923a(double d, double d2, double d3) {
        double b = m1927b(d, d2, d2 + 360.0d);
        if (Double.compare(b, d2) >= 0 && Double.compare(b, d3) < 0) {
            return true;
        }
        b = m1927b(180.0d + d, d2, d2 + 360.0d);
        if (Double.compare(b, d2) < 0 || Double.compare(b, d3) >= 0) {
            return false;
        }
        return true;
    }


    public static int m1892a(int i, int i2, int i3) {
        return (int) m1927b((double) i, (double) i2, (double) i3);
    }


    public static double m1927b(double d, double d2, double d3) {
        if (!assertionStatus && d2 >= d3) {
            throw new AssertionError();
        } else if (assertionStatus || Double.compare(Math.abs(d3 - d2), 360.0d) == 0) {
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


    public static double m1889a(PointF pointF, PointF pointF2) {
        double b = m1928b(pointF, pointF2);
        if (Double.compare(b, 180.0d) > 0) {
            return b - 180.0d;
        }
        return b;
    }


    public static double m1928b(PointF pointF, PointF pointF2) {
        return Math.toDegrees(m1941c(pointF, pointF2));
    }


    public static double m1941c(PointF pointF, PointF pointF2) {
        if (assertionStatus || !(pointF == null || pointF2 == null)) {
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


    public static double m1949d(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
    }


    public static int getScaledMinimumFlingVelocity(Context context) {
        return ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }


    public static int getScaledMaximumFlingVelocity(Context context) {
        return ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }


    public static int getLongPressTimeout() {
        return ViewConfiguration.getLongPressTimeout();
    }


    public static int getScaledTouchSlop(Context context) {
        return ViewConfiguration.get(context).getScaledTouchSlop();
    }


    public static int getScaledPagingTouchSlop(Context context) {
        return ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }


    public static int getJumpTapTimeout() {
        return ViewConfiguration.getJumpTapTimeout();
    }


    public static int getTapTimeout() {
        return ViewConfiguration.getTapTimeout();
    }


    public static int getDoubleTapTimeout() {
        return ViewConfiguration.getDoubleTapTimeout();
    }


    public static int getPressedStateDuration() {
        return ViewConfiguration.getPressedStateDuration();
    }


    public static int m1959f(Context context) {
        return m1932b(context, 40.0f);
    }


    public static int m1962g(Context context) {
        return m1932b(context, 40.0f);
    }


    public static int getScaledDensity(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * f);
    }


    public static int m1932b(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }


    public static float m1929b(Context context, int i) {
        return ((float) i) / context.getResources().getDisplayMetrics().density;
    }


    public static float dpToPixel(Context context, float f) {
        return (m1965h(context) * f) / 160.0f;
    }


    public static float m1950d(Context context, float f) {
        return (m1967i(context) * f) / 160.0f;
    }


    public static int spToPixels(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * f);
    }


    public static int m1960f(Context context, float f) {
        return Math.round(dpToPixel(context, f));
    }


    public static int m1963g(Context context, float f) {
        return Math.round(m1950d(context, f));
    }


    public static float m1965h(Context context) {
        m1970l(context);
        return xdpi;
    }


    public static float m1967i(Context context) {
        m1970l(context);
        return ydpi;
    }


    private static void m1970l(Context context) {
        if (Float.isNaN(xdpi) || Float.isNaN(ydpi)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int round = Math.round((float) Math.sqrt((double) (displayMetrics.xdpi * displayMetrics.ydpi)));
            if (Float.compare(Math.abs((((float) Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / ((float) round)), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / ((float) round)), 2.0d))) / ((float) Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / ((float) displayMetrics.densityDpi)), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / ((float) displayMetrics.densityDpi)), 2.0d)))) - 1.0f), 0.3f) <= 0) {
                xdpi = displayMetrics.xdpi;
                ydpi = displayMetrics.ydpi;
                return;
            }
            float f = (float) displayMetrics.densityDpi;
            ydpi = f;
            xdpi = f;
        }
    }


    public static int getWidthPixels(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }


    public static int getHeightPixels(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }


    public static void m1914a(Canvas canvas, String str, RectF rectF, int i, Paint paint) {
        float f;
        float f2;
        Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Align.LEFT);
        Rect rect = (Rect) f1198g.addAnimation();
        getTextBounds(rect, paint, str, rectF.width());
        switch (i & 7) {
            case 3:
                f = rectF.left - rect.left;
                break;
            case 5:
                f = rectF.right - rect.right;
                break;
            default:
                f = rectF.centerX() - rect.exactCenterX();
                break;
        }
        switch (i & 112) {
            case C2295j.f14321a:
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
        f1198g.clearAnimation(rect);
        paint.setTextAlign(textAlign);
    }


    public static void m1913a(Canvas canvas, String str, Rect rect, int i, Paint paint) {
        RectF rectF = (RectF) f1199h.addAnimation();
        rectF.set(rect);
        m1914a(canvas, str, rectF, i, paint);
        f1199h.clearAnimation(rectF);
    }


    public static Rect getTextBounds(Rect rect, Paint paint, String str, float maxWidth) {
        int breakText = paint.breakText(str, true, maxWidth, null);
        while (breakText < str.length()) {
            breakText--;
            if (breakText <= 0) {
                str = "";
                break;
            }
            String str2 = str.substring(0, breakText) + "…";
            if (Float.compare(paint.measureText(str2), maxWidth) <= 0) {
                str = str2;
                break;
            }
        }
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }


    public static void m1912a(Canvas canvas, Drawable drawable, Rect rect, int width, int height, int i3) {
        int left;
        int top;
        if (width < 0) {
            if ((i3 & 7) == 7) {
                width = rect.width();
            } else {
                width = drawable.getIntrinsicWidth();
            }
        }
        if (height < 0) {
            if ((i3 & 112) == 112) {
                height = rect.height();
            } else {
                height = drawable.getIntrinsicHeight();
            }
        }
        if ((i3 & 7) == 3) {
            left = rect.left;
        } else if ((i3 & 7) == 5) {
            left = rect.right - width;
        } else {
            left = (((rect.left + rect.right) - width) + 1) / 2;
        }
        if ((i3 & 112) == 48) {
            top = rect.top;
        } else if ((i3 & 112) == 80) {
            top = rect.bottom - height;
        } else {
            top = ((rect.top + rect.bottom - height) + 1) / 2;
        }
        drawable.setBounds(left, top, left + width, top + height);
        drawable.draw(canvas);
    }


    public static void m1911a(Canvas canvas, Drawable drawable, Rect rect, int i) {
        m1912a(canvas, drawable, rect, -1, -1, i);
    }


    public static void showAnimation(View view, Runnable runnable) {
        startAlphaAnimation(view, 0.0f, 1.0f, (int) HttpStatus.SC_OK, false, runnable);
    }


    public static void hideAnimation(View view, Runnable runnable) {
        startAlphaAnimation(view, 1.0f, 0.0f, (int) HttpStatus.SC_OK, false, runnable);
    }


    public static void startAlphaAnimation(View view, float fromAlpha, float toAlpha, int durationMilli, boolean fillAfter, Runnable runnable) {
        startAlphaAnimation(view, fromAlpha, toAlpha, durationMilli, fillAfter, new AccelerateDecelerateInterpolator(), runnable);
    }


    public static void startAlphaAnimation(View view, float fromAlpha, float toAlpha, int durationMillis, boolean fillAfter, Interpolator interpolator, final Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(durationMillis);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                UThread.post(runnable);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        alphaAnimation.setInterpolator(interpolator);
        alphaAnimation.setFillEnabled(fillAfter);
        alphaAnimation.setFillAfter(fillAfter);
        view.startAnimation(alphaAnimation);
    }


    public static void m1954d(View view, Runnable runnable) {
        startTranslateAnimation(view, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_OK, false, runnable);
    }


    public static void m1958e(View view, Runnable runnable) {
        startTranslateAnimation(view, 0.0f, 0.0f, 1.0f, 0.0f, HttpStatus.SC_OK, false, runnable);
    }


    public static void m1961f(View view, Runnable runnable) {
        startTranslateAnimation(view, 0.0f, 0.0f, 0.0f, -1.0f, HttpStatus.SC_OK, false, runnable);
    }


    public static void loadSuccess(View view, Runnable runnable) {
        startTranslateAnimation(view, 0.0f, 0.0f, 0.0f, 1.0f, HttpStatus.SC_OK, false, runnable);
    }


    public static void startTranslateAnimation(View view, float fromXType, float fromXValue, float toXType, float toXValue, int fromYType, boolean fillEnabled, Runnable runnable) {
        startTranslateAnimation(view, fromXType, fromXValue, toXType, toXValue, fromYType, fillEnabled, new AccelerateDecelerateInterpolator(), runnable);
    }


    public static void startTranslateAnimation(View view, float fromXValue, float toXValue, float fromYValue, float toYValue, int durationMillis, boolean fillEnabled, Interpolator interpolator, final Runnable runnable) {
        Animation translateAnimation = new TranslateAnimation(1, fromXValue, 1, toXValue, 1, fromYValue, 1, toYValue);
        translateAnimation.setDuration(durationMillis);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                UThread.post(runnable);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setFillEnabled(fillEnabled);
        translateAnimation.setFillAfter(fillEnabled);
        view.startAnimation(translateAnimation);
    }


    public static void loadNetError(View view, Runnable runnable) {
        startTranslateAnimation(view, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new OvershootInterpolator(), runnable);
    }


    public static float getAlpha(float alpha) {
        return Math.min(1.0f, Math.max(0.0f, alpha));
    }
}
