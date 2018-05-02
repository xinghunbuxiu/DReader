package com.duokan.core.app;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

public abstract class AppContext extends ContextWrapper implements IFeature {
    private final FeatureManage featureManage = new FeatureManage();
    private Configuration configuration;
    private Resources resources;

    protected AppContext(Activity activity) {
        super(activity);
        if (activity == null) {
            throw new IllegalArgumentException();
        }
    }

    public static IFeature getAppContext(Context activity) {
        while (activity != null && !(activity instanceof IFeature)) {
            if (activity instanceof Activity) {
                activity = ((Activity) activity).getParent() != null ? ((Activity) activity).getParent() : ((Activity) activity).getApplication();
            } else {
                activity = activity instanceof Service ? ((Service) activity).getApplication() : activity instanceof ContextWrapper ? ((Activity) activity).getBaseContext() : null;
            }
        }
        return (IFeature) activity;
    }

    public void initConfiguration(Configuration configuration) {
        if (this.resources == null && this.configuration == null) {
            this.configuration = new Configuration(configuration);
        }
    }

    public Resources getResources() {
        if (this.resources != null) {
            return this.resources;
        }
        if (this.configuration == null) {
            this.resources = super.getResources();
            return this.resources;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            this.resources = createConfigurationContext(this.configuration).getResources();
        }
        return this.resources;
    }

    public <T extends FeatureListening> T queryFeature(Class<T> cls) {
        T t = isContainsListener(cls);
        return t != null ? t : getAppContext().queryFeature(cls);
    }

    public <T extends FeatureListening> T isContainsListener(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return this.featureManage.isContainsListener(cls);
    }

    public boolean addFeatureListener(FeatureListening featureListening) {
        return this.featureManage.addFeatureListener(featureListening);
    }

    public boolean removeFeatureListener(FeatureListening featureListening) {
        return this.featureManage.removeFeatureListener(featureListening);
    }

    public boolean registerGlobalFeature(FeatureListening featureListening) {
        if (featureListening == null) {
            return false;
        }
        return getAppContext().registerGlobalFeature(featureListening);
    }

    public boolean unregisterGlobalFeature(FeatureListening featureListening) {
        return getAppContext().unregisterGlobalFeature(featureListening);
    }

    public Object getSystemService(String str) {
        if (LAYOUT_INFLATER_SERVICE.equals(str)) {
            return LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return super.getSystemService(str);
    }

    protected final IFeature getAppContext() {
        return (IFeature) getBaseContext().getApplicationContext();
    }
}
