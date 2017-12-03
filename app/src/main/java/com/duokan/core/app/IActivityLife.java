package com.duokan.core.app;

import android.app.Activity;
import android.os.Bundle;

public interface IActivityLife {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);
}
