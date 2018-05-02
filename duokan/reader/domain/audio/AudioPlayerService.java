package com.duokan.reader.domain.audio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AudioPlayerService extends Service {
    public IBinder onBind(Intent intent) {
        return AudioPlayer.a();
    }
}
