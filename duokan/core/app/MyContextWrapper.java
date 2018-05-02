package com.duokan.core.app;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

public abstract class MyContextWrapper extends ContextWrapper implements IFeature {
    private final FeatureManage featureManage = new FeatureManage();
    private Configuration configuration;
    private Resources resources;

    protected MyContextWrapper(Activity activity) {
        super(activity);
        if (activity == null) {
            throw new IllegalArgumentException();
        }
    }

    public static IFeature getFeature(Context context) {
        Context activity = context;
        while (context != null && !(context instanceof IFeature)) {
            if (context instanceof Activity) {
                context = ((Activity) activity).getParent() != null ? ((Activity) activity).getParent() : ((Activity) activity).getApplication();
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

    @Override
    public Resources getResources() {
        if (this.resources != null) {
            return this.resources;
        }
        this.resources = getApplicationContext().getResources();
        return this.resources;
    }

    @Override
    public FeatureListening queryFeature(Class cls) {
        FeatureListening a = registerLocalFeature(cls);
        return a != null ? a : getFeature().queryFeature(cls);
    }

    public FeatureListening registerLocalFeature(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.featureManage.addFirst(cls);
    }

    public boolean addFirstLocalFeature(FeatureListening featurelistening) {
        return this.featureManage.addFirst(featurelistening);
    }

    public boolean removeFeatureListening(FeatureListening featurelistening) {
        return this.featureManage.remove(featurelistening);
    }

    @Override
    public boolean registerGlobalFeature(FeatureListening featurelistening) {
        if (featurelistening == null) {
            return false;
        }
        return getFeature().registerGlobalFeature(featurelistening);
    }

    @Override
    public boolean unregisterGlobalFeature(FeatureListening featurelistening) {
        return getFeature().unregisterGlobalFeature(featurelistening);
    }

    @Override
    public Object getSystemService(String serverName) {
        if (LAYOUT_INFLATER_SERVICE.equals(serverName)) {
            return LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return super.getSystemService(serverName);
    }

    protected IFeature getFeature() {
        return (IFeature) getBaseContext().getApplicationContext();
    }
}
