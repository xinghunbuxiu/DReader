package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.bb;

public class TextSelectionAssistant {
    /* renamed from: a */
    private Point f9144a;
    /* renamed from: b */
    private Point f9145b;
    /* renamed from: c */
    private bb f9146c;
    /* renamed from: d */
    private bb f9147d;
    /* renamed from: e */
    private final int f9148e;
    /* renamed from: f */
    private final su f9149f;
    /* renamed from: g */
    private IndicatorStatus f9150g = IndicatorStatus.IDLE;
    /* renamed from: h */
    private int f9151h = -1;

    public enum IndicatorStatus {
        IDLE,
        HEADER_DRAGGED,
        FOOTER_DRAGGED
    }

    public TextSelectionAssistant(su suVar, int i) {
        this.f9149f = suVar;
        this.f9148e = i;
    }

    /* renamed from: a */
    public boolean m12540a(int i, int i2, int i3, View view) {
        if (!m12543d()) {
            this.f9146c = this.f9149f.mo2096b(i, i2);
            if (this.f9146c.m5817f()) {
                return false;
            }
            this.f9147d = this.f9146c;
            this.f9151h = this.f9149f.mo2010a(this.f9146c);
            Rect[] b = this.f9149f.mo2107b(this.f9146c);
            if (b == null || b.length == 0) {
                return false;
            }
            this.f9149f.setSelection(this.f9146c);
            Rect selectionStartIndicatorBounds = this.f9149f.getSelectionStartIndicatorBounds();
            Rect selectionEndIndicatorBounds = this.f9149f.getSelectionEndIndicatorBounds();
            this.f9145b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
            this.f9144a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
            return true;
        } else if (i3 == 0) {
            return m12536a(i, i2, view);
        } else {
            if (this.f9150g == IndicatorStatus.IDLE) {
                return false;
            }
            m12534a(new Point(i, i2), i3);
            return true;
        }
    }

    /* renamed from: a */
    public bb m12537a() {
        return this.f9146c;
    }

    /* renamed from: b */
    public Point m12541b() {
        return this.f9144a;
    }

    /* renamed from: c */
    public boolean m12542c() {
        return this.f9150g == IndicatorStatus.IDLE;
    }

    /* renamed from: d */
    public boolean m12543d() {
        return (this.f9146c == null || this.f9145b == null || this.f9144a == null) ? false : true;
    }

    /* renamed from: e */
    public void m12544e() {
        Rect selectionStartIndicatorBounds = this.f9149f.getSelectionStartIndicatorBounds();
        Rect selectionEndIndicatorBounds = this.f9149f.getSelectionEndIndicatorBounds();
        if (this.f9146c != null && !this.f9146c.m5817f() && this.f9147d != null && !this.f9147d.m5817f()) {
            if (this.f9150g == IndicatorStatus.HEADER_DRAGGED) {
                if (this.f9146c.mo1199h().mo1190c(this.f9147d.mo1199h()) && this.f9146c.mo1198g().m5782d(this.f9147d.mo1199h())) {
                    this.f9150g = IndicatorStatus.FOOTER_DRAGGED;
                    this.f9145b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
                    this.f9144a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
                } else {
                    this.f9145b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
                }
            } else if (this.f9150g == IndicatorStatus.FOOTER_DRAGGED) {
                if (this.f9146c.mo1198g().mo1188a(this.f9147d.mo1198g()) && this.f9146c.mo1199h().m5778b(this.f9147d.mo1198g())) {
                    this.f9150g = IndicatorStatus.HEADER_DRAGGED;
                    this.f9145b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
                    this.f9144a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
                } else {
                    this.f9144a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
                }
            }
            this.f9147d = this.f9146c;
        }
    }

    /* renamed from: f */
    public Point m12545f() {
        DocPageLayout M = this.f9149f.mo1996M();
        Rect selectionStartIndicatorBounds = this.f9149f.getSelectionStartIndicatorBounds();
        Rect selectionEndIndicatorBounds = this.f9149f.getSelectionEndIndicatorBounds();
        Point point = new Point();
        int centerX;
        if (this.f9150g == IndicatorStatus.HEADER_DRAGGED) {
            centerX = (M == DocPageLayout.LEFT_TO_RIGHT || M == DocPageLayout.TOP_TO_BOTTOM) ? selectionStartIndicatorBounds.centerX() : selectionStartIndicatorBounds.left;
            point.x = centerX;
            point.y = selectionStartIndicatorBounds.bottom;
        } else {
            point.x = selectionEndIndicatorBounds.centerX();
            centerX = (M == DocPageLayout.LEFT_TO_RIGHT || M == DocPageLayout.TOP_TO_BOTTOM) ? selectionEndIndicatorBounds.top : selectionEndIndicatorBounds.bottom;
            point.y = centerX - this.f9149f.mo1986A();
        }
        return point;
    }

    /* renamed from: g */
    public Rect[] m12546g() {
        Rect[] rectArr = new Rect[2];
        Rect[] b = this.f9149f.mo2107b(this.f9146c);
        if (b == null || b.length <= 0) {
            Rect rect = new Rect();
            rectArr[1] = rect;
            rectArr[0] = rect;
        } else {
            rectArr[0] = b[0];
            rectArr[1] = b[b.length - 1];
        }
        int max = Math.max(this.f9149f.getSelectionStartIndicatorBounds().height(), this.f9149f.getSelectionEndIndicatorBounds().height());
        Rect rect2 = rectArr[0];
        rect2.top -= max;
        rect2 = rectArr[1];
        rect2.bottom = max + rect2.bottom;
        return rectArr;
    }

    /* renamed from: a */
    public void m12538a(Point point) {
        if (this.f9150g == IndicatorStatus.HEADER_DRAGGED) {
            this.f9145b = point;
        } else if (this.f9150g == IndicatorStatus.FOOTER_DRAGGED) {
            this.f9144a = point;
        }
        this.f9147d = this.f9146c;
        this.f9146c = m12533a(this.f9145b.x, this.f9145b.y, this.f9144a.x, this.f9144a.y);
    }

    /* renamed from: a */
    public void m12539a(Point point, Point point2, IndicatorStatus indicatorStatus) {
        this.f9145b = point;
        this.f9144a = point2;
        this.f9150g = indicatorStatus;
        this.f9147d = this.f9146c;
        this.f9146c = m12533a(this.f9145b.x, this.f9145b.y, this.f9144a.x, this.f9144a.y);
    }

    /* renamed from: h */
    public int m12547h() {
        return this.f9148e;
    }

    /* renamed from: a */
    private void m12534a(Point point, int i) {
        Point point2;
        Point point3;
        if (this.f9150g == IndicatorStatus.HEADER_DRAGGED) {
            point2 = new Point(point.x, point.y);
            point3 = this.f9144a;
            m12535a(point2, null);
            bb a = m12533a(point2.x, point2.y, point3.x, point3.y);
            if (!a.m5817f()) {
                if (!(a.mo1199h().mo1190c(this.f9146c.mo1199h()) && a.mo1198g().m5782d(this.f9146c.mo1199h()))) {
                    this.f9145b = point2;
                    this.f9147d = this.f9146c;
                    this.f9146c = a;
                    return;
                }
            }
            return;
        } else if (this.f9150g == IndicatorStatus.FOOTER_DRAGGED) {
            point2 = this.f9145b;
            point3 = new Point(point.x, point.y);
            m12535a(null, point3);
            bb a2 = m12533a(point2.x, point2.y, point3.x, point3.y);
            if (!a2.m5817f()) {
                if (!(a2.mo1198g().mo1188a(this.f9146c.mo1198g()) && a2.mo1199h().m5778b(this.f9146c.mo1198g()))) {
                    this.f9144a = point3;
                    this.f9147d = this.f9146c;
                    this.f9146c = a2;
                    return;
                }
            }
            return;
        }
        m12538a(point);
    }

    /* renamed from: a */
    private bb m12533a(int i, int i2, int i3, int i4) {
        if (this.f9151h < 0) {
            return this.f9149f.mo2097b(i, i2, i3, i4);
        }
        ac a = this.f9149f.mo2015a(this.f9151h);
        return a != null ? a.mo1382a(new Point(i, i2), new Point(i3, i4)) : this.f9146c;
    }

    /* renamed from: a */
    private boolean m12536a(int i, int i2, View view) {
        if (!m12543d()) {
            return false;
        }
        Rect selectionStartIndicatorBounds = this.f9149f.getSelectionStartIndicatorBounds();
        Rect selectionEndIndicatorBounds = this.f9149f.getSelectionEndIndicatorBounds();
        if (selectionStartIndicatorBounds.contains(i, i2)) {
            this.f9150g = IndicatorStatus.HEADER_DRAGGED;
        } else if (selectionEndIndicatorBounds.contains(i, i2)) {
            this.f9150g = IndicatorStatus.FOOTER_DRAGGED;
        } else {
            this.f9150g = IndicatorStatus.IDLE;
            return false;
        }
        this.f9145b = new Point(selectionStartIndicatorBounds.centerX(), selectionStartIndicatorBounds.bottom);
        this.f9144a = new Point(selectionEndIndicatorBounds.centerX(), selectionEndIndicatorBounds.top);
        m12535a(this.f9145b, this.f9144a);
        if (selectionStartIndicatorBounds.isEmpty()) {
            this.f9145b = this.f9149f.mo1996M() == DocPageLayout.LEFT_TO_RIGHT ? new Point(1, 1) : new Point(view.getWidth() - 1, 1);
        }
        if (selectionEndIndicatorBounds.isEmpty()) {
            this.f9144a = this.f9149f.mo1996M() == DocPageLayout.LEFT_TO_RIGHT ? new Point(view.getWidth() - 1, view.getHeight() - 1) : new Point(1, view.getHeight() - 1);
        }
        return true;
    }

    /* renamed from: a */
    private void m12535a(Point point, Point point2) {
        Rect[] b = this.f9149f.mo2107b(this.f9146c);
        DocPageLayout M = this.f9149f.mo1996M();
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
