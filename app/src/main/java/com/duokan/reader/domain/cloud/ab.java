package com.duokan.reader.domain.cloud;

class ab implements as {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.a.d.a(dkCloudReadingInfo, dkCloudReadingInfo2, str);
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.a.d.b(dkCloudReadingInfo, str, str2);
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.a.e.a(dkCloudReadingInfo2);
        DkUserReadingNotesManager.a().a(dkCloudReadingInfo2.getCloudId(), this.a.b);
        this.a.d.b(dkCloudReadingInfo, dkCloudReadingInfo2, str);
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.a.d.b(dkCloudReadingInfo, str, str2);
    }
}
