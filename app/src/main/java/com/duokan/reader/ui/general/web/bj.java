package com.duokan.reader.ui.general.web;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.dv;
import org.apache.http.HttpStatus;

class bj implements cg {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7630a;

    bj(StorePageController storePageController) {
        this.f7630a = storePageController;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        if (this.f7630a.mPageHeaderView != null && this.f7630a.mPageHeaderView.getHeight() != 0 && z) {
            TabState tabState;
            int max = Math.max(this.f7630a.mWebView.getViewportBounds().top + this.f7630a.getHeaderViewOffset(), 0);
            int a = this.f7630a.mImmersive ? this.f7630a.mWebView.getContentHeight() - this.f7630a.mBannerInfo.f7670a <= dv.getHeightPixels(this.f7630a.getContext()) - this.f7630a.getHeaderViewOffset() ? 0 : (int) (dv.getAlpha(((((float) max) - ((float) this.f7630a.mBannerInfo.f7670a)) / ((float) Math.min(this.f7630a.mBannerInfo.f7670a - this.f7630a.getHeaderViewOffset(), this.f7630a.getHeaderViewOffset()))) + 1.0f) * 255.0f) : 255;
            this.f7630a.mPageHeaderView.setBackgroundColor(Color.argb(a, 248, 248, 248));
            this.f7630a.mPageHeaderView.setBottomLineColor(Color.argb(a, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT));
            int b = dv.m1932b(this.f7630a.getContext(), 40.0f);
            if (a != 255 || this.f7630a.mTabsTitle.isEmpty() || this.f7630a.mWebView.getContentHeight() - this.f7630a.mSurfingBarOffset <= dv.getHeightPixels(this.f7630a.getContext()) - this.f7630a.getHeaderViewOffset()) {
                tabState = TabState.DEFAULT;
            } else if (max >= this.f7630a.mSurfingBarOffset - b && max < this.f7630a.mSurfingBarOffset - (b / 2)) {
                tabState = TabState.OVER_SURFING_BAR_HEAD;
            } else if (max >= this.f7630a.mSurfingBarOffset - (b / 2) && max < this.f7630a.mSurfingBarOffset) {
                tabState = TabState.OVER_HALF_SURFING_BAR;
            } else if (max >= this.f7630a.mSurfingBarOffset) {
                tabState = TabState.OVER_SURFING_BAR;
            } else {
                tabState = TabState.DEFAULT;
            }
            View centerTitleView = this.f7630a.mPageHeaderView.getCenterTitleView();
            ViewGroup centerButtonView = this.f7630a.mPageHeaderView.getCenterButtonView();
            if (tabState == TabState.DEFAULT) {
                centerTitleView.setAlpha(dv.getAlpha(((float) a) / 255.0f));
                centerButtonView.setVisibility(4);
                centerTitleView.setVisibility(0);
                return;
            }
            if (this.f7630a.mHasTabsTitleChange) {
                centerButtonView.removeAllViews();
                for (String str : this.f7630a.mTabsTitle.keySet()) {
                    this.f7630a.mPageHeaderView.m10147a(str, new bk(this, str));
                }
                this.f7630a.mHasTabsTitleChange = false;
            }
            switch (bu.f7648a[tabState.ordinal()]) {
                case 1:
                    centerTitleView.setVisibility(0);
                    centerButtonView.setVisibility(4);
                    centerTitleView.setAlpha(dv.getAlpha((((float) ((this.f7630a.mSurfingBarOffset - max) - (b / 2))) / ((float) b)) * 2.0f));
                    break;
                case 2:
                    centerButtonView.setVisibility(0);
                    centerTitleView.setVisibility(4);
                    float a2 = 1.0f - dv.getAlpha((((float) (((b / 2) + max) - this.f7630a.mSurfingBarOffset)) / ((float) b)) * 2.0f);
                    centerButtonView.setAlpha(1.0f - a2);
                    centerButtonView.setPadding(0, (int) (a2 * ((float) dv.m1932b(this.f7630a.getContext(), 20.0f))), 0, 0);
                    break;
                default:
                    centerButtonView.setAlpha(1.0f);
                    centerButtonView.setPadding(0, 0, 0, 0);
                    centerButtonView.setVisibility(0);
                    centerTitleView.setVisibility(4);
                    break;
            }
            if (this.f7630a.mWebView.getViewportBounds().bottom == this.f7630a.mWebView.getContentHeight()) {
                b = centerButtonView.getChildCount() - 1;
            } else {
                int i = 0;
                b = 0;
                while (i < centerButtonView.getChildCount() && max >= ((Integer) this.f7630a.mTabsTitle.get(((TextView) centerButtonView.getChildAt(i)).getText().toString())).intValue()) {
                    b = i;
                    i++;
                }
            }
            for (a = 0; a < centerButtonView.getChildCount(); a++) {
                if (a == b) {
                    centerButtonView.getChildAt(a).setSelected(true);
                } else {
                    centerButtonView.getChildAt(a).setSelected(false);
                }
            }
        }
    }
}
