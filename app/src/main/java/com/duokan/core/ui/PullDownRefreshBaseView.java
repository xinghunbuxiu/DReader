package com.duokan.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class PullDownRefreshBaseView extends FrameLayout {
    
    private RefreshState f846a = RefreshState.NO_REFRESH;
    
    private Runnable f847b;

    public enum RefreshState {
        NO_REFRESH,
        DOWN_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        REFRESH_DONE
    }

    
    protected abstract void mo469a(RefreshState refreshState);

    
    protected abstract void mo470b();

    
    protected abstract void mo471c();

    
    protected abstract void mo472d();

    
    protected abstract void mo473e();

    public abstract void setRate(float f);

    public PullDownRefreshBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final RefreshState getRefreshState() {
        return this.f846a;
    }

    public final void setRefreshState(RefreshState refreshState) {
        RefreshState refreshState2 = this.f846a;
        if (refreshState2 != refreshState) {
            switch (bz.f1062a[refreshState2.ordinal()]) {
                case 1:
                    if (refreshState == RefreshState.DOWN_TO_REFRESH) {
                        this.f846a = refreshState;
                        break;
                    }
                    break;
                case 2:
                    if (refreshState == RefreshState.NO_REFRESH || refreshState == RefreshState.RELEASE_TO_REFRESH) {
                        this.f846a = refreshState;
                        break;
                    }
                case 3:
                    if (refreshState == RefreshState.DOWN_TO_REFRESH || refreshState == RefreshState.REFRESHING) {
                        this.f846a = refreshState;
                        break;
                    }
                case 4:
                    if (refreshState == RefreshState.REFRESH_DONE) {
                        this.f846a = refreshState;
                        break;
                    }
                    break;
                case 5:
                    if (refreshState == RefreshState.NO_REFRESH || refreshState == RefreshState.DOWN_TO_REFRESH) {
                        this.f846a = refreshState;
                        break;
                    }
            }
            if (refreshState2 != this.f846a) {
                m1285a(refreshState2, this.f846a);
            }
        }
    }

    
    public void m1286a() {
        if (this.f847b != null) {
            this.f847b.run();
            this.f847b = null;
        }
    }

    public void setOnRefreshDone(Runnable runnable) {
        this.f847b = runnable;
    }

    
    private final void m1285a(RefreshState refreshState, RefreshState refreshState2) {
        switch (bz.f1062a[refreshState2.ordinal()]) {
            case 1:
                mo470b();
                return;
            case 2:
                mo469a(refreshState);
                return;
            case 3:
                mo471c();
                return;
            case 4:
                mo472d();
                return;
            case 5:
                mo473e();
                return;
            default:
                return;
        }
    }
}
