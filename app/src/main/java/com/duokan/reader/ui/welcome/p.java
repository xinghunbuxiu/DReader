package com.duokan.reader.ui.welcome;

import android.content.Context;

import com.duokan.core.app.FeatureListening;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

public abstract class p implements FeatureListening {
    public abstract void a(Context context, UserInput userInput);
}
