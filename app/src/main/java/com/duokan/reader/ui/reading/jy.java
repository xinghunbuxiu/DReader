package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.au;

public class jy extends fz {
    public jy(Context context, gs gsVar, Rect rect, ac acVar) {
        super(context, gsVar, rect, acVar);
        getWatchingView().setEnabled(true);
    }

    /* renamed from: k */
    public void mo2406k() {
        getWatchingView().getShowingPic().mo2406k();
    }

    /* renamed from: l */
    public void mo2407l() {
        getWatchingView().getShowingPic().mo2407l();
    }

    /* renamed from: m */
    public void mo2408m() {
        getWatchingView().getShowingPic().mo2408m();
    }

    /* renamed from: n */
    public void mo2409n() {
        getWatchingView().getShowingPic().mo2409n();
    }

    public float getZoomFactor() {
        return getWatchingView().getShowingPic().getZoomFactor();
    }

    /* renamed from: a */
    public gd mo2403a(au auVar) {
        return new jz(getContext(), getPagePresenter(), (ac) auVar, getOriginBounds());
    }

    public void setGalleryShowingPicListener(jx jxVar) {
        getWatchingView().setGalleryShowingPicListener(jxVar);
    }

    public jz getWatchingView() {
        return (jz) super.getWatchingView();
    }
}
