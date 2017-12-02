package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;

import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.au;

public class jo extends fu {
    public jo(Context context, gn gnVar, Rect rect, ac acVar) {
        super(context, gnVar, rect, acVar);
        getWatchingView().setEnabled(true);
    }

    public void k() {
        getWatchingView().getShowingPic().k();
    }

    public void l() {
        getWatchingView().getShowingPic().l();
    }

    public void m() {
        getWatchingView().getShowingPic().m();
    }

    public void n() {
        getWatchingView().getShowingPic().n();
    }

    public float getZoomFactor() {
        return getWatchingView().getShowingPic().getZoomFactor();
    }

    public fy a(au auVar) {
        return new jp(getContext(), getPagePresenter(), (ac) auVar, getOriginBounds());
    }

    public void setGalleryShowingPicListener(jn jnVar) {
        getWatchingView().setGalleryShowingPicListener(jnVar);
    }

    public jp getWatchingView() {
        return (jp) super.getWatchingView();
    }
}
