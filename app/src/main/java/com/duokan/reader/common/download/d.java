package com.duokan.reader.common.download;

import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;

public interface d {
    void a(IDownloadTask iDownloadTask);

    void a(IDownloadTask iDownloadTask, TaskState taskState);

    void a(IDownloadTask iDownloadTask, TaskStatus taskStatus);
}
