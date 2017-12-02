package com.duokan.reader.domain.tts;

import android.app.Activity;

public interface TtsEngine {
    boolean checkServiceInstalled();

    String getServiceApkUrl();

    String getSpeaker();

    float getSpeed();

    boolean isSpeaking();

    void pauseSpeaking();

    void resumeSpeaking();

    void setSpeaker(String str);

    void setSpeed(float f);

    void showSpeakers(Activity activity, int i);

    boolean startSpeaking(String str, SpeakingListener speakingListener);

    void stopSpeaking();
}
