package com.duokan.reader.ui.surfing;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.PersonalPrefs.UserGender;

import org.apache.http.HttpStatus;

public class a extends j implements IActivityRunStatusChanged {
    private final ViewGroup a;
    private final ImageView b;
    private final View c;
    private final ImageView d;
    private final View e;
    private final View f;
    private final Runnable g;
    private View h = null;
    private boolean i = false;

    public a(Context context, Runnable runnable) {
        super(context);
        setContentView(h.general__choose_gender_view);
        this.a = (ViewGroup) getContentView();
        this.a.setOnTouchListener(new b(this));
        this.b = (ImageView) findViewById(g.general__choose_gender_view__male);
        this.c = findViewById(g.general__choose_gender_view__gender_labels);
        this.d = (ImageView) findViewById(g.general__choose_gender_view__female);
        this.e = findViewById(g.general__choose_gender_view__cancel);
        this.e.setOnClickListener(new c(this));
        this.f = findViewById(g.general__choose_gender_view__intro);
        this.g = runnable;
        setDimAmount(0.0f);
    }

    protected void onShow() {
        super.onShow();
        DkApp.get().addOnRunningStateChangedListener(this);
        DkApp.get().setReadyToSee();
    }

    protected void onDismiss() {
        super.onDismiss();
        DkApp.get().removeOnRunningStateChangedListener(this);
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.BACKGROUND) {
            UmengManager.get().onEvent("ASK_GENDER_V2", "HOME");
            com.duokan.reader.domain.statistics.a.k().b("home");
        }
    }

    protected boolean onBack() {
        PersonalPrefs.a().b(UserGender.UNSPECIFIED.ordinal(), true);
        UmengManager.get().onEvent("ASK_GENDER_V2", "BACK");
        com.duokan.reader.domain.statistics.a.k().b("back");
        a();
        return true;
    }

    private boolean a(View view, MotionEvent motionEvent, boolean z) {
        if ((this.h != null && view != this.h) || this.i) {
            return false;
        }
        this.h = view;
        view.setPivotX((float) (view.getWidth() / 2));
        view.setPivotY((float) (view.getHeight() / 2));
        if (motionEvent.getAction() == 0) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.1f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.1f});
            ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2}).setDuration(500).start();
            return true;
        } else if (motionEvent.getAction() != 1) {
            return false;
        } else {
            a(z);
            this.i = true;
            return true;
        }
    }

    private void a(boolean z) {
        UmengManager.get().onEvent("ASK_GENDER_V2", z ? "MALE" : "FEMALE");
        com.duokan.reader.domain.statistics.a.k().b(z ? "male" : "female");
        PersonalPrefs.a().b(z ? UserGender.MALE.ordinal() : UserGender.FEMALE.ordinal(), true);
        this.f.setVisibility(4);
        ImageView imageView = z ? this.b : this.d;
        UTools.addAnimation(z ? this.d : this.b, 1.0f, 0.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, true, null);
        UTools.addAnimation(this.c, 1.0f, 0.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, true, null);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, (-((((float) imageView.getRight()) - ((float) (UTools.getWidthPixels(getContext()) / 2))) - ((float) (imageView.getWidth() / 2)))) / ((float) imageView.getWidth()), 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(800);
        translateAnimation.setAnimationListener(new d(this));
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        imageView.startAnimation(translateAnimation);
    }

    private void a() {
        if (isShowing()) {
            dismiss();
            if (this.g != null) {
                this.g.run();
            }
        }
    }
}
