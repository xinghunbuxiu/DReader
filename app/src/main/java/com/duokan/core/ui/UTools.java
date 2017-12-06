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
import android.view.ViewGroup;
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
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ap;

import org.apache.http.HttpStatus;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;

import static android.content.Context.WINDOW_SERVICE;

public abstract class UTools {
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
    public static final AsyncCache async = new AsyncCache();
    static final boolean assertionStatus = (!UTools.class.desiredAssertionStatus());
    private static float xPixels = Float.NaN;
    private static float yPixels = Float.NaN;

    public static final void creatCallTask(View view, Callable callable) {
        if (view != null && callable != null) {
            ea eaVar = new ea(view, callable);
        }
    }

    public static final void creatCallTask(View view, Runnable runnable) {
        if (view != null && runnable != null) {
            creatCallTask(view, new MyCallable(runnable));
        }
    }

    public static void PostTask(View view, int i) {
        if (view != null) {
            TaskHandler.PostTask(new ec(view, i));
        }
    }

    public static void PostTask(View view) {
        PostTask(view, 1);
    }

    public static void hideSoftInputFromWindow(Context context, int flag) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            inputMethodManager.hideSoftInputFromWindow(((View) declaredField.get(inputMethodManager)).getWindowToken(), flag);
        } catch (Throwable th) {
        }
    }

    public static void hideSoftInputFromWindow(Context context) {
        hideSoftInputFromWindow(context, InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

    public static int getVisible(View view) {
        if (view.getWindowToken() == null || view.getWindowVisibility() == 8) {
            return View.GONE;
        }
        int visibility = view.getVisibility();
        if (visibility == View.GONE) {
            return View.GONE;
        }
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof View)) {
            int visibility2 = ((View) parent).getVisibility();
            if (visibility2 == View.GONE) {
                visibility = View.GONE;
                break;
            }
            visibility2 = visibility2 == View.INVISIBLE ? View.INVISIBLE : visibility;
            parent = parent.getParent();
            visibility = visibility2;
        }
        return visibility;
    }

    public static Rect getRect(Rect rect, View view, View view2) {
        RectF rectF = (RectF) h.getRect();
        getRectF(rectF, view, view2);
        rectF.round(rect);
        h.getRect(rectF);
        return rect;
    }

    public static RectF getRectF(RectF rectF, View view, View view2) {
        rectF.set((float) view.getScrollX(), (float) view.getScrollY(), (float) (view.getScrollX() + view.getWidth()), (float) (view.getScrollY() + view.getHeight()));
        getMatrixPoint(rectF, view, view2);
        return rectF;
    }

    /**
     * 是否在当前范围
     *
     * @param rectF
     * @param view
     * @return
     */
    public static boolean isInRange(RectF rectF, View view) {
        RectF rectF2 = (RectF) h.getRect();
        rectF.set(view.getScrollX(), view.getScrollY(), (view.getScrollX() + view.getWidth()), view.getScrollY() + view.getHeight());
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof View)) {
            View view2 = (View) parent;
            rectF2.set(view2.getScrollX(), view2.getScrollY(), view2.getScrollX() + view2.getWidth(), view2.getScrollY() + view2.getHeight());
            getMatrixPoint(rectF2, view2, view);
            if (!rectF.intersect(rectF2)) {
                rectF.setEmpty();
                break;
            }
            parent = parent.getParent();
        }
        h.getRect(rectF2);
        if (rectF.isEmpty()) {
            return false;
        }
        return true;
    }

    public static MotionEvent resetMotionEvent(MotionEvent motionEvent, View view, View view2) {
        Matrix matrix = (Matrix) d.getRect();
        getTempMatrix(matrix, view, view2);
        matrix.preTranslate((float) view.getScrollX(), (float) view.getScrollY());
        if (view2 != null) {
            matrix.postTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        MotionEvent a = resetMotionEvent(motionEvent, matrix);
        d.getRect(matrix);
        return a;
    }

    public static MotionEvent resetMotionEvent(MotionEvent motionEvent, Matrix matrix) {
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
        PointF pointF = (PointF) f.getRect();
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            pointerCoordsArr[i] = new PointerCoords();
            motionEvent.getPointerCoords(i, pointerCoordsArr[i]);
            pointF.set(pointerCoordsArr[i].x, pointerCoordsArr[i].y);
            addAnimation(matrix, pointF);
            pointerCoordsArr[i].x = pointF.x;
            pointerCoordsArr[i].y = pointF.y;
        }
        f.getRect(pointF);
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, iArr, pointerCoordsArr, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }

    public static Rect[] addAnimation(Rect[] rectArr, View view, View view2) {
        for (Rect b : rectArr) {
            closeAnimation(b, view, view2);
        }
        return rectArr;
    }

    public static Rect closeAnimation(Rect rect, View view, View view2) {
        RectF rectF = (RectF) h.getRect();
        rectF.set(rect);
        getMatrixPoint(rectF, view, view2);
        rectF.round(rect);
        h.getRect(rectF);
        return rect;
    }

    /**
     * 获取单次触及
     * @param point
     * @param view
     * @param view2
     * @return
     */
    public static Point getTouchPoint(Point point, View view, View view2) {
        PointF pointF = (PointF) f.getRect();
        pointF.set((float) point.x, (float) point.y);
        addAnimation(pointF, view, view2);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.getRect(pointF);
        return point;
    }

    /**
     *  获取多点选择点
     * @param rectF
     * @param view
     * @param view2
     * @return
     */
    public static RectF getMatrixPoint(RectF rectF, View view, View view2) {
        Matrix matrix = (Matrix) d.getRect();
        float[] fArr = (float[]) j.getRect();
        float[] fArr2 = (float[]) j.getRect();
        getTempMatrix(matrix, view, view2);
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
        j.getRect(fArr2);
        j.getRect(fArr);
        d.getRect(matrix);
        return rectF;
    }

    public static PointF addAnimation(PointF pointF, View view, View view2) {
        Matrix matrix = (Matrix) d.getRect();
        float[] fArr = (float[]) i.getRect();
        getTempMatrix(matrix, view, view2);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        d.getRect(matrix);
        i.getRect(fArr);
        return pointF;
    }

    public static Rect addAnimation(Rect rect, View view) {
        RectF rectF = (RectF) h.getRect();
        rectF.set(rect);
        closeAnimation(rectF, view);
        rectF.round(rect);
        h.getRect(rectF);
        return rect;
    }

    public static Point addAnimation(Point point, View view) {
        PointF pointF = (PointF) f.getRect();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        addAnimation(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.getRect(pointF);
        return point;
    }

    public static Point closeAnimation(Point point, View view) {
        PointF pointF = (PointF) f.getRect();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        closeAnimation(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.getRect(pointF);
        return point;
    }

    public static RectF closeAnimation(RectF rectF, View view) {
        Matrix matrix = (Matrix) d.getRect();
        Matrix matrix2 = (Matrix) d.getRect();
        float[] fArr = (float[]) j.getRect();
        float[] fArr2 = (float[]) j.getRect();
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        addAnimation(matrix, view);
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        matrix2.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        j.getRect(fArr2);
        j.getRect(fArr);
        d.getRect(matrix2);
        d.getRect(matrix);
        return rectF;
    }

    public static PointF addAnimation(PointF pointF, View view) {
        PointF pointF2 = (PointF) f.getRect();
        closeAnimation(pointF, view);
        closeAnimation(pointF2, view);
        pointF.x -= pointF2.x;
        pointF.y -= pointF2.y;
        f.getRect(pointF2);
        return pointF;
    }

    public static PointF closeAnimation(PointF pointF, View view) {
        Matrix matrix = (Matrix) d.getRect();
        Matrix matrix2 = (Matrix) d.getRect();
        float[] fArr = (float[]) i.getRect();
        addAnimation(matrix, view);
        matrix.invert(matrix2);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix2.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        i.getRect(fArr);
        d.getRect(matrix2);
        d.getRect(matrix);
        return pointF;
    }

    public static Rect closeAnimation(Rect rect, View view) {
        RectF rectF = (RectF) h.getRect();
        rectF.set(rect);
        showAnimation(rectF, view);
        rectF.round(rect);
        h.getRect(rectF);
        return rect;
    }

    public static Point showAnimation(Point point, View view) {
        PointF pointF = (PointF) f.getRect();
        pointF.x = (float) point.x;
        pointF.y = (float) point.y;
        getScaledTouchSlop(pointF, view);
        point.x = Math.round(pointF.x);
        point.y = Math.round(pointF.y);
        f.getRect(pointF);
        return point;
    }

    public static RectF showAnimation(RectF rectF, View view) {
        Matrix matrix = (Matrix) d.getRect();
        float[] fArr = (float[]) j.getRect();
        float[] fArr2 = (float[]) j.getRect();
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.top;
        fArr2[0] = rectF.left;
        fArr2[1] = rectF.bottom;
        fArr2[2] = rectF.right;
        fArr2[3] = rectF.bottom;
        addAnimation(matrix, view);
        matrix.mapPoints(fArr);
        matrix.mapPoints(fArr2);
        rectF.left = Math.min(Math.min(fArr[0], fArr[2]), Math.min(fArr2[0], fArr2[2]));
        rectF.top = Math.min(Math.min(fArr[1], fArr[3]), Math.min(fArr2[1], fArr2[3]));
        rectF.right = Math.max(Math.max(fArr[0], fArr[2]), Math.max(fArr2[0], fArr2[2]));
        rectF.bottom = Math.max(Math.max(fArr[1], fArr[3]), Math.max(fArr2[1], fArr2[3]));
        j.getRect(fArr2);
        j.getRect(fArr);
        d.getRect(matrix);
        return rectF;
    }

    public static PointF showAnimation(PointF pointF, View view) {
        PointF pointF2 = (PointF) f.getRect();
        getScaledTouchSlop(pointF, view);
        getScaledTouchSlop(pointF2, view);
        pointF.x -= pointF2.x;
        pointF.y -= pointF2.y;
        f.getRect(pointF2);
        return pointF;
    }

    public static PointF getScaledTouchSlop(PointF pointF, View view) {
        Matrix matrix = (Matrix) d.getRect();
        float[] fArr = (float[]) i.getRect();
        addAnimation(matrix, view);
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        d.getRect(matrix);
        i.getRect(fArr);
        return pointF;
    }

    public static Matrix getTempMatrix(Matrix matrix, View view, View view2) {
        Matrix matrix2 = (Matrix) d.getRect();
        Matrix matrix3 = (Matrix) d.getRect();
        addAnimation(matrix2, view);
        addAnimation(matrix3, view2);
        matrix3.invert(matrix);
        matrix.preConcat(matrix2);
        d.getRect(matrix3);
        d.getRect(matrix2);
        return matrix;
    }

    @TargetApi(11)
    public static Matrix addAnimation(Matrix matrix, View view) {
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
            int[] iArr = (int[]) l.getRect();
            iArr[0] = 0;
            iArr[1] = 0;
            view.getLocationOnScreen(iArr);
            matrix.postTranslate((float) iArr[0], (float) iArr[1]);
            l.getRect(iArr);
        }
        return matrix;
    }

    public static Rect addAnimation(Matrix matrix, Rect rect) {
        RectF rectF = (RectF) h.getRect();
        rectF.set(rect);
        addAnimation(matrix, rectF);
        rectF.round(rect);
        h.getRect(rectF);
        return rect;
    }

    public static PointF addAnimation(Matrix matrix, PointF pointF) {
        float[] fArr = (float[]) i.getRect();
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        matrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        i.getRect(fArr);
        return pointF;
    }

    public static RectF addAnimation(Matrix matrix, RectF rectF) {
        float[] fArr = (float[]) j.getRect();
        float[] fArr2 = (float[]) j.getRect();
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
        j.getRect(fArr);
        j.getRect(fArr2);
        return rectF;
    }

    public static boolean addAnimation(PointF pointF, PointF pointF2, double d, double d2) {
        return addAnimation(getAngle(getDegrees(pointF, pointF2), d, d + 360.0d), d, d2);
    }

    public static boolean addAnimation(double d, double d2, double d3) {
        double b = getAngle(d, d2, d2 + 360.0d);
        if (Double.compare(b, d2) >= 0 && Double.compare(b, d3) < 0) {
            return true;
        }
        b = getAngle(180.0d + d, d2, d2 + 360.0d);
        if (Double.compare(b, d2) < 0 || Double.compare(b, d3) >= 0) {
            return false;
        }
        return true;
    }

    public static int get_Angle(int i, int i2, int i3) {
        return (int) getAngle(i, i2, i3);
    }

    /**
     * 获取角度
     *
     * @param d
     * @param d2
     * @param d3
     * @return
     */
    public static double getAngle(double d, double d2, double d3) {
        if (!assertionStatus && d2 >= d3) {
            throw new AssertionError();
        } else if (assertionStatus || Double.compare(Math.abs(d3 - d2), 360.0d) == 0) {

            if (Double.compare(d, d2) >= 0 && Double.compare(d, d3) < 0) {
                return d;
            }
            if (Double.compare(d, d2) < 0) {
                d += 360.0d;
            } else {
                d -= 360.0d;
            }

        } else {
            throw new AssertionError();
        }
    }

    /**
     * 获取两点之间的角度
     *
     * @param pointF
     * @param pointF2
     * @return
     */
    public static double getDegrees(PointF pointF, PointF pointF2) {
        double b = toDegrees(pointF, pointF2);
        if (Double.compare(b, 180.0d) > 0) {
            return b - 180.0d;
        }
        return b;
    }

    //参数转化为角度
    public static double toDegrees(PointF pointF, PointF pointF2) {
        return Math.toDegrees(getScale(pointF, pointF2));
    }

    /**
     * 获取系数
     *
     * @param pointF
     * @param pointF2
     * @return
     */
    public static double getScale(PointF pointF, PointF pointF2) {
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
                    return Math.PI + atan;
                }
                if (pointF4.x >= pointF3.x || pointF4.y >= pointF3.y) {
                    return (pointF4.x <= pointF3.x || pointF4.y >= pointF3.y) ? atan : 6.283185307179586d + atan;
                } else {
                    return Math.PI + atan;
                }
            } else if (pointF4.x > pointF3.x) {
                return 0.0d;
            } else {
                return Math.PI;
            }
        }
        throw new AssertionError();
    }

    /**
     * 获取两点之间的距离
     *
     * @param pointF
     * @param pointF2
     * @return
     */
    public static double getTriangleEdge(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow((pointF.x - pointF2.x), 2.0d) + Math.pow((pointF.y - pointF2.y), 2.0d));
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

    public static int getScaledTouchSlop() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    public static int getScaledPagingTouchSlop() {
        return ViewConfiguration.getPressedStateDuration();
    }

    public static int defaultClose(Context context) {
        return closeAnimation(context, 40.0f);
    }

    public static int g(Context context) {
        return closeAnimation(context, 40.0f);
    }

    public static int addAnimation(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * f);
    }

    public static int closeAnimation(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }

    public static float closeAnimation(Context context, int i) {
        return ((float) i) / context.getResources().getDisplayMetrics().density;
    }

    public static float showAnimation(Context context, float f) {
        return (getPhysicalXPixels(context) * f) / 160.0f;
    }

    public static float getScaledTouchSlop(Context context, float f) {
        return (getPhysicalYPixels(context) * f) / 160.0f;
    }

    public static int getScaledPagingTouchSlop(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * f);
    }

    public static int f(Context context, float f) {
        return Math.round(showAnimation(context, f));
    }

    public static int g(Context context, float f) {
        return Math.round(getScaledTouchSlop(context, f));
    }

    public static float getPhysicalXPixels(Context context) {
        initDeviceDensity(context);
        return xPixels;
    }

    public static float getPhysicalYPixels(Context context) {
        initDeviceDensity(context);
        return yPixels;
    }

    private static void initDeviceDensity(Context context) {
        if (Float.isNaN(xPixels) || Float.isNaN(yPixels)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int round = Math.round((float) Math.sqrt((double) (displayMetrics.xdpi * displayMetrics.ydpi)));
            if (Float.compare(Math.abs((((float) Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / ((float) round)), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / ((float) round)), 2.0d))) / ((float) Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / ((float) displayMetrics.densityDpi)), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / ((float) displayMetrics.densityDpi)), 2.0d)))) - 1.0f), 0.3f) <= 0) {
                xPixels = displayMetrics.xdpi;
                yPixels = displayMetrics.ydpi;
                return;
            }
            float densityDpi = (float) displayMetrics.densityDpi;
            yPixels = densityDpi;
            xPixels = densityDpi;
        }
    }

    public static int getWidthPixels(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getHeightPixels(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static void addAnimation(Canvas canvas, String str, RectF rectF, int i, Paint paint) {
        float x;
        float y;
        Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Align.LEFT);
        Rect rect = (Rect) g.getRect();
        addAnimation(rect, paint, str, rectF.width());
        switch (i & 7) {
            case 3:
                x = rectF.left - ((float) rect.left);
                break;
            case 5:
                x = rectF.right - ((float) rect.right);
                break;
            default:
                x = rectF.centerX() - rect.exactCenterX();
                break;
        }
        switch (i & 112) {
            case 48 /*48*/:
                y = rectF.top - ((float) rect.top);
                break;
            case 80:
                y = rectF.bottom - ((float) rect.bottom);
                break;
            default:
                y = rectF.centerY() - rect.exactCenterY();
                break;
        }
        canvas.drawText(str, x, y, paint);
        g.getRect(rect);
        paint.setTextAlign(textAlign);
    }

    public static void addAnimation(Canvas canvas, String str, Rect rect, int i, Paint paint) {
        RectF rectF = (RectF) h.getRect();
        rectF.set(rect);
        addAnimation(canvas, str, rectF, i, paint);
        h.getRect(rectF);
    }

    public static Rect addAnimation(Rect rect, Paint paint, String text, float maxWidth) {
        int breakText = paint.breakText(text, true, maxWidth, null);
        while (breakText < text.length()) {
            breakText--;
            if (breakText <= 0) {
                text = "";
                break;
            }
            String str2 = text.substring(0, breakText) + "…";
            if (Float.compare(paint.measureText(str2), maxWidth) <= 0) {
                text = str2;
                break;
            }
        }
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }

    public static void setDrawable(Canvas canvas, Drawable drawable, Rect rect, int width, int height, int i3) {
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
            top = (((rect.top + rect.bottom) - height) + 1) / 2;
        }
        drawable.setBounds(left, top, left + width, top + height);
        drawable.draw(canvas);
    }

    public static void addAnimation(Canvas canvas, Drawable drawable, Rect rect, int durationMillis) {
        setDrawable(canvas, drawable, rect, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, durationMillis);
    }

    public static void closeAnimation(View view, Runnable runnable) {
        addAnimation(view, 0.0f, 1.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void showAnimation(View view, Runnable runnable) {
        addAnimation(view, 1.0f, 0.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void addAnimation(View view, float fromAlpha, float toAlpha, int durationMillis, boolean fillEnabled, Runnable runnable) {
        addAnimation(view, fromAlpha, toAlpha, durationMillis, fillEnabled, new AccelerateDecelerateInterpolator(), runnable);
    }

    public static void addAnimation(View view, float fromAlpha, float toAlpha, int durationMillis, boolean fillEnabled, Interpolator interpolator, Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration((long) durationMillis);
        alphaAnimation.setAnimationListener(new ef(runnable));
        alphaAnimation.setInterpolator(interpolator);
        alphaAnimation.setFillEnabled(fillEnabled);
        alphaAnimation.setFillAfter(fillEnabled);
        view.startAnimation(alphaAnimation);
    }

    public static void getScaledTouchSlop(View view, Runnable runnable) {
        addAnimation(view, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void getScaledPagingTouchSlop(View view, Runnable runnable) {
        addAnimation(view, 0.0f, 0.0f, 1.0f, 0.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void f(View view, Runnable runnable) {
        addAnimation(view, 0.0f, 0.0f, 0.0f, -1.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void g(View view, Runnable runnable) {
        addAnimation(view, 0.0f, 0.0f, 0.0f, 1.0f, HttpStatus.SC_OK, false, runnable);
    }

    public static void addAnimation(View view, float fromAlpha, float toAlpha, float f3, float f4, int durationMillis, boolean fillEnabled, Runnable runnable) {
        addAnimation(view, fromAlpha, toAlpha, f3, f4, durationMillis, fillEnabled, new AccelerateDecelerateInterpolator(), runnable);
    }

    public static void addAnimation(View view, float fromAlpha, float toAlpha, float f3, float f4, int durationMillis, boolean fillEnabled, Interpolator interpolator, Runnable runnable) {
        Animation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, fromAlpha, Animation.RELATIVE_TO_SELF, toAlpha, Animation.RELATIVE_TO_SELF, f3, Animation.RELATIVE_TO_SELF, f4);
        translateAnimation.setDuration((long) durationMillis);
        translateAnimation.setAnimationListener(new eg(runnable));
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setFillEnabled(fillEnabled);
        translateAnimation.setFillAfter(fillEnabled);
        view.startAnimation(translateAnimation);
    }

    public static void getPhysicalXPixels(View view, Runnable runnable) {
        addAnimation(view, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new OvershootInterpolator(), runnable);
    }

    public static float addAnimation(float fromAlpha) {
        return Math.min(1.0f, Math.max(0.0f, fromAlpha));
    }
}
