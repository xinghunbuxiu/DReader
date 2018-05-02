package com.duokan.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class PullDownRefreshBaseView extends FrameLayout {
    private RefreshState a = RefreshState.NO_REFRESH;
    private Runnable b;

    public enum RefreshState {
        NO_REFRESH,
        DOWN_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        REFRESH_DONE
    }

    protected abstract void a(RefreshState refreshState);

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    public abstract void setRate(float f);

    public PullDownRefreshBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final RefreshState getRefreshState() {
        return this.a;
    }

    public final void setRefreshState(RefreshState refreshState) {
        RefreshState refreshState2 = this.a;
        if (refreshState2 != refreshState) {
            switch (bz.a[refreshState2.ordinal()]) {
                case 1:
                    if (refreshState == RefreshState.DOWN_TO_REFRESH) {
                        this.a = refreshState;
                        break;
                    }
                    break;
                case 2:
                    if (refreshState == RefreshState.NO_REFRESH || refreshState == RefreshState.RELEASE_TO_REFRESH) {
                        this.a = refreshState;
                        break;
                    }
                case 3:
                    if (refreshState == RefreshState.DOWN_TO_REFRESH || refreshState == RefreshState.REFRESHING) {
                        this.a = refreshState;
                        break;
                    }
                case 4:
                    if (refreshState == RefreshState.REFRESH_DONE) {
                        this.a = refreshState;
                        break;
                    }
                    break;
                case 5:
                    if (refreshState == RefreshState.NO_REFRESH || refreshState == RefreshState.DOWN_TO_REFRESH) {
                        this.a = refreshState;
                        break;
                    }
            }
            if (refreshState2 != this.a) {
                a(refreshState2, this.a);
            }
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.run();
            this.b = null;
        }
    }

    public void setOnRefreshDone(Runnable runnable) {
        this.b = runnable;
    }

    private final void a(RefreshState refreshState, RefreshState refreshState2) {
        switch (bz.a[refreshState2.ordinal()]) {
            case 1:
                b();
                return;
            case 2:
                a(refreshState);
                return;
            case 3:
                c();
                return;
            case 4:
                d();
                return;
            case 5:
                e();
                return;
            default:
                return;
        }
    }
}
