package com.duokan.reader.common.download;

import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;

interface l {
    void a(DownloadTask downloadTask, long j, long j2);

    void a(DownloadTask downloadTask, TaskState taskState);

    void a(DownloadTask downloadTask, TaskStatus taskStatus);

    void a(DownloadTask downloadTask, boolean z);
}
