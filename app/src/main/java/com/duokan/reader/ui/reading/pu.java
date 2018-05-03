package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.duokan.core.ui.AnimUtils;
import org.apache.http.HttpStatus;

class pu implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ Point f10834a;
    /* renamed from: b */
    final /* synthetic */ pt f10835b;

    pu(pt ptVar, Point point) {
        this.f10835b = ptVar;
        this.f10834a = point;
    }

    public boolean onPreDraw() {
        Point point = new Point(0, 0);
        AnimUtils.m1945c(point, this.f10835b.f10824a);
        Point point2 = new Point(this.f10834a.x - point.x, this.f10834a.y - point.y);
        AnimUtils.m1896a(point2, this.f10835b.f10826c);
        this.f10835b.f10826c.m1354a(this.f10835b.f10826c.getScrollX() - point2.x, this.f10835b.f10826c.getScrollY() - point2.y);
        this.f10835b.f10826c.setThumbEnabled(false);
        this.f10835b.f10826c.m1360b(0.0f, 0.0f, 1.0f, null, null);
        this.f10835b.f10825b.m1831a(this.f10835b.f10828e, this.f10835b.f10829f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.f10835b.f10825b.m1831a(this.f10835b.f10830g, this.f10835b.f10831h, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.f10835b.f10825b.m1832a(this.f10835b.f10826c, this.f10835b.f10832i, HttpStatus.SC_INTERNAL_SERVER_ERROR, new pv(this), null);
        this.f10835b.f10825b.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
