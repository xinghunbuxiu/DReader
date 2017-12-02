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

class bk implements cg {
    final /* synthetic */ StorePageController a;

    bk(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    public void a(Scrollable scrollable, boolean z) {
        if (this.a.mPageHeaderView != null && this.a.mPageHeaderView.getHeight() != 0 && z) {
            TabState tabState;
            int max = Math.max(this.a.mWebView.getViewportBounds().top + this.a.getHeaderViewOffset(), 0);
            int a = this.a.mImmersive ? this.a.mWebView.getContentHeight() - this.a.mBannerInfo.a <= dv.k(this.a.getContext()) - this.a.getHeaderViewOffset() ? 0 : (int) (dv.a(((((float) max) - ((float) this.a.mBannerInfo.a)) / ((float) Math.min(this.a.mBannerInfo.a - this.a.getHeaderViewOffset(), this.a.getHeaderViewOffset()))) + 1.0f) * 255.0f) : 255;
            this.a.mPageHeaderView.setBackgroundColor(Color.argb(a, 248, 248, 248));
            this.a.mPageHeaderView.setBottomLineColor(Color.argb(a, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT));
            int b = dv.b(this.a.getContext(), 40.0f);
            if (a != 255 || this.a.mTabsTitle.isEmpty() || this.a.mWebView.getContentHeight() - this.a.mSurfingBarOffset <= dv.k(this.a.getContext()) - this.a.getHeaderViewOffset()) {
                tabState = TabState.DEFAULT;
            } else if (max >= this.a.mSurfingBarOffset - b && max < this.a.mSurfingBarOffset - (b / 2)) {
                tabState = TabState.OVER_SURFING_BAR_HEAD;
            } else if (max >= this.a.mSurfingBarOffset - (b / 2) && max < this.a.mSurfingBarOffset) {
                tabState = TabState.OVER_HALF_SURFING_BAR;
            } else if (max >= this.a.mSurfingBarOffset) {
                tabState = TabState.OVER_SURFING_BAR;
            } else {
                tabState = TabState.DEFAULT;
            }
            View centerTitleView = this.a.mPageHeaderView.getCenterTitleView();
            ViewGroup centerButtonView = this.a.mPageHeaderView.getCenterButtonView();
            if (tabState == TabState.DEFAULT) {
                centerTitleView.setAlpha(dv.a(((float) a) / 255.0f));
                centerButtonView.setVisibility(4);
                centerTitleView.setVisibility(0);
                return;
            }
            if (this.a.mHasTabsTitleChange) {
                centerButtonView.removeAllViews();
                for (String str : this.a.mTabsTitle.keySet()) {
                    this.a.mPageHeaderView.a(str, new bl(this, str));
                }
                this.a.mHasTabsTitleChange = false;
            }
            switch (bw.a[tabState.ordinal()]) {
                case 1:
                    centerTitleView.setVisibility(0);
                    centerButtonView.setVisibility(4);
                    centerTitleView.setAlpha(dv.a((((float) ((this.a.mSurfingBarOffset - max) - (b / 2))) / ((float) b)) * 2.0f));
                    break;
                case 2:
                    centerButtonView.setVisibility(0);
                    centerTitleView.setVisibility(4);
                    float a2 = 1.0f - dv.a((((float) (((b / 2) + max) - this.a.mSurfingBarOffset)) / ((float) b)) * 2.0f);
                    centerButtonView.setAlpha(1.0f - a2);
                    centerButtonView.setPadding(0, (int) (a2 * ((float) dv.b(this.a.getContext(), 20.0f))), 0, 0);
                    break;
                default:
                    centerButtonView.setAlpha(1.0f);
                    centerButtonView.setPadding(0, 0, 0, 0);
                    centerButtonView.setVisibility(0);
                    centerTitleView.setVisibility(4);
                    break;
            }
            if (this.a.mWebView.getViewportBounds().bottom == this.a.mWebView.getContentHeight()) {
                b = centerButtonView.getChildCount() - 1;
            } else {
                int i = 0;
                b = 0;
                while (i < centerButtonView.getChildCount() && max >= ((Integer) this.a.mTabsTitle.get(((TextView) centerButtonView.getChildAt(i)).getText().toString())).intValue()) {
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
