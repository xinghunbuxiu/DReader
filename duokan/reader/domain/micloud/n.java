package com.duokan.reader.domain.micloud;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class n extends bf {
    private ArrayList a = new ArrayList();
    private boolean b;
    private ArrayList c = new ArrayList();

    public n(String str, String str2, List list, boolean z, int i) {
        super(str, str2, ((bi) list.get(0)).d(), 2, i);
        this.a.addAll(list);
        this.b = z;
    }

    protected void a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.a.addAll(bi.a(jSONObject.getJSONArray("delete_files_task__cloud_file_infos")));
        this.b = jSONObject.optBoolean("delete_files_task__permanent");
        this.c.addAll(bi.a(jSONObject.getJSONArray("delete_files_task__deleted_file_infos")));
    }

    protected void b(JSONObject jSONObject) {
        super.b(jSONObject);
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((bi) it.next()).a());
            }
            jSONObject.put("delete_files_task__cloud_file_infos", jSONArray);
            jSONObject.put("delete_files_task__permanent", this.b);
            jSONArray = new JSONArray();
            it = this.c.iterator();
            while (it.hasNext()) {
                jSONArray.put(((bi) it.next()).a());
            }
            jSONObject.put("delete_files_task__deleted_file_infos", jSONArray);
        } catch (JSONException e) {
        }
    }

    public List w() {
        return this.a;
    }

    public boolean x() {
        return this.b;
    }

    public List y() {
        return this.c;
    }

    public void a(bi biVar) {
        if (!this.c.contains(biVar)) {
            this.c.add(biVar);
        }
    }
}
