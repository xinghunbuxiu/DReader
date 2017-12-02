package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.bb;

public class TextSelectionAssistant {
    private Point a;
    private Point b;
    private bb c;
    private bb d;
    private final int e;
    private final sh f;
    private IndicatorStatus g = IndicatorStatus.IDLE;
    private int h = -1;

    public enum IndicatorStatus {
        IDLE,
        HEADER_DRAGGED,
        FOOTER_DRAGGED
    }

    public TextSelectionAssistant(sh shVar, int i) {
        this.f = shVar;
        this.e = i;
    }

    public boolean a(int i, int i2, int i3, View view) {
        if (!d()) {
            this.c = this.f.b(i, i2);
            if (this.c.f()) {
                return false;
            }
            this.d = this.c;
            this.h = this.f.a(this.c);
            Rect[] b = this.f.b(this.c);
            if (b == null || b.length == 0) {
                return false;
            }
            this.f.setSelection(this.c);
            Rect selectionStartIndicatorBounds = this.f.getSelectionStartIndicatorBounds();
            Rect selectionEndIndicatorBounds = this.f.getSelectionEndIndicatorBounds();
            this.b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
            this.a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
            return true;
        } else if (i3 == 0) {
            return a(i, i2, view);
        } else {
            if (this.g == IndicatorStatus.IDLE) {
                return false;
            }
            a(new Point(i, i2), i3);
            return true;
        }
    }

    public bb a() {
        return this.c;
    }

    public Point b() {
        return this.a;
    }

    public boolean c() {
        return this.g == IndicatorStatus.IDLE;
    }

    public boolean d() {
        return (this.c == null || this.b == null || this.a == null) ? false : true;
    }

    public void e() {
        Rect selectionStartIndicatorBounds = this.f.getSelectionStartIndicatorBounds();
        Rect selectionEndIndicatorBounds = this.f.getSelectionEndIndicatorBounds();
        if (this.c != null && !this.c.f() && this.d != null && !this.d.f()) {
            if (this.g == IndicatorStatus.HEADER_DRAGGED) {
                if (this.c.h().c(this.d.h()) && this.c.g().d(this.d.h())) {
                    this.g = IndicatorStatus.FOOTER_DRAGGED;
                    this.b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
                    this.a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
                } else {
                    this.b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
                }
            } else if (this.g == IndicatorStatus.FOOTER_DRAGGED) {
                if (this.c.g().a(this.d.g()) && this.c.h().b(this.d.g())) {
                    this.g = IndicatorStatus.HEADER_DRAGGED;
                    this.b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
                    this.a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
                } else {
                    this.a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
                }
            }
            this.d = this.c;
        }
    }

    public Point f() {
        DocPageLayout M = this.f.M();
        Rect selectionStartIndicatorBounds = this.f.getSelectionStartIndicatorBounds();
        Rect selectionEndIndicatorBounds = this.f.getSelectionEndIndicatorBounds();
        Point point = new Point();
        int centerX;
        if (this.g == IndicatorStatus.HEADER_DRAGGED) {
            centerX = (M == DocPageLayout.LEFT_TO_RIGHT || M == DocPageLayout.TOP_TO_BOTTOM) ? selectionStartIndicatorBounds.centerX() : selectionStartIndicatorBounds.left;
            point.x = centerX;
            point.y = selectionStartIndicatorBounds.bottom;
        } else {
            point.x = selectionEndIndicatorBounds.centerX();
            centerX = (M == DocPageLayout.LEFT_TO_RIGHT || M == DocPageLayout.TOP_TO_BOTTOM) ? selectionEndIndicatorBounds.top : selectionEndIndicatorBounds.bottom;
            point.y = centerX - this.f.A();
        }
        return point;
    }

    public Rect[] g() {
        Rect[] rectArr = new Rect[2];
        Rect[] b = this.f.b(this.c);
        if (b == null || b.length <= 0) {
            Rect rect = new Rect();
            rectArr[1] = rect;
            rectArr[0] = rect;
        } else {
            rectArr[0] = b[0];
            rectArr[1] = b[b.length - 1];
        }
        int max = Math.max(this.f.getSelectionStartIndicatorBounds().height(), this.f.getSelectionEndIndicatorBounds().height());
        Rect rect2 = rectArr[0];
        rect2.top -= max;
        rect2 = rectArr[1];
        rect2.bottom = max + rect2.bottom;
        return rectArr;
    }

    public void a(Point point) {
        if (this.g == IndicatorStatus.HEADER_DRAGGED) {
            this.b = point;
        } else if (this.g == IndicatorStatus.FOOTER_DRAGGED) {
            this.a = point;
        }
        this.d = this.c;
        this.c = a(this.b.x, this.b.y, this.a.x, this.a.y);
    }

    public void a(Point point, Point point2, IndicatorStatus indicatorStatus) {
        this.b = point;
        this.a = point2;
        this.g = indicatorStatus;
        this.d = this.c;
        this.c = a(this.b.x, this.b.y, this.a.x, this.a.y);
    }

    public int h() {
        return this.e;
    }

    private void a(Point point, int i) {
        Point point2;
        Point point3;
        if (this.g == IndicatorStatus.HEADER_DRAGGED) {
            point2 = new Point(point.x, point.y);
            point3 = this.a;
            a(point2, null);
            bb a = a(point2.x, point2.y, point3.x, point3.y);
            if (!a.f()) {
                if (!(a.h().c(this.c.h()) && a.g().d(this.c.h()))) {
                    this.b = point2;
                    this.d = this.c;
                    this.c = a;
                    return;
                }
            }
            return;
        } else if (this.g == IndicatorStatus.FOOTER_DRAGGED) {
            point2 = this.b;
            point3 = new Point(point.x, point.y);
            a(null, point3);
            bb a2 = a(point2.x, point2.y, point3.x, point3.y);
            if (!a2.f()) {
                if (!(a2.g().a(this.c.g()) && a2.h().b(this.c.g()))) {
                    this.a = point3;
                    this.d = this.c;
                    this.c = a2;
                    return;
                }
            }
            return;
        }
        a(point);
    }

    private bb a(int i, int i2, int i3, int i4) {
        if (this.h < 0) {
            return this.f.b(i, i2, i3, i4);
        }
        ac a = this.f.a(this.h);
        return a != null ? a.a(new Point(i, i2), new Point(i3, i4)) : this.c;
    }

    private boolean a(int i, int i2, View view) {
        if (!d()) {
            return false;
        }
        Rect selectionStartIndicatorBounds = this.f.getSelectionStartIndicatorBounds();
        Rect selectionEndIndicatorBounds = this.f.getSelectionEndIndicatorBounds();
        if (selectionStartIndicatorBounds.contains(i, i2)) {
            this.g = IndicatorStatus.HEADER_DRAGGED;
        } else if (selectionEndIndicatorBounds.contains(i, i2)) {
            this.g = IndicatorStatus.FOOTER_DRAGGED;
        } else {
            this.g = IndicatorStatus.IDLE;
            return false;
        }
        this.b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
        this.a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
        a(this.b, this.a);
        if (selectionStartIndicatorBounds.isEmpty()) {
            this.b = this.f.M() == DocPageLayout.LEFT_TO_RIGHT ? new Point(1, 1) : new Point(view.getWidth() - 1, 1);
        }
        if (selectionEndIndicatorBounds.isEmpty()) {
            this.a = this.f.M() == DocPageLayout.LEFT_TO_RIGHT ? new Point(view.getWidth() - 1, view.getHeight() - 1) : new Point(1, view.getHeight() - 1);
        }
        return true;
    }

    private void a(Point point, Point point2) {
        Rect[] b = this.f.b(this.c);
        DocPageLayout M = this.f.M();
        if (b.length >= 1) {
            if (point != null) {
                point.x++;
                point.y = (M == DocPageLayout.RIGHT_TO_LEFT ? b[0].width() / 3 : b[0].height() / 3) + point.y;
            }
            if (point2 != null) {
                int width;
                point2.x--;
                int i = point2.y;
                if (M == DocPageLayout.RIGHT_TO_LEFT) {
                    width = b[b.length - 1].width() / 3;
                } else {
                    width = b[b.length - 1].height() / 3;
                }
                point2.y = i - width;
            }
        }
    }
}
