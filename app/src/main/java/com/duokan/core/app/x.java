package com.duokan.core.app;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

public abstract class x extends ContextWrapper implements y {
    private final l a = new l();
    private Configuration b;
    private Resources c;

    protected x(Activity activity) {
        super(activity);
        if (activity == null) {
            throw new IllegalArgumentException();
        }
    }

    public static y a(Context context) {
        Activity activity = context;
        while (activity != null && !(activity instanceof y)) {
            if (activity instanceof Activity) {
                activity = activity;
                activity = activity.getParent() != null ? activity.getParent() : activity.getApplication();
            } else {
                activity = activity instanceof Service ? ((Service) activity).getApplication() : activity instanceof ContextWrapper ? activity.getBaseContext() : null;
            }
        }
        return (y) activity;
    }

    public void a(Configuration configuration) {
        if (this.c == null && this.b == null) {
            this.b = new Configuration(configuration);
        }
    }

    public Resources getResources() {
        if (this.c != null) {
            return this.c;
        }
        if (this.b == null) {
            this.c = super.getResources();
            return this.c;
        }
        this.c = createConfigurationContext(this.b).getResources();
        return this.c;
    }

    public k queryFeature(Class cls) {
        k a = a(cls);
        return a != null ? a : a().queryFeature(cls);
    }

    public k a(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.a.a(cls);
    }

    public boolean a(k kVar) {
        return this.a.a(kVar);
    }

    public boolean b(k kVar) {
        return this.a.b(kVar);
    }

    public boolean registerGlobalFeature(k kVar) {
        if (kVar == null) {
            return false;
        }
        return a().registerGlobalFeature(kVar);
    }

    public boolean unregisterGlobalFeature(k kVar) {
        return a().unregisterGlobalFeature(kVar);
    }

    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            return LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return super.getSystemService(str);
    }

    protected final y a() {
        return (y) getBaseContext().getApplicationContext();
    }
}
