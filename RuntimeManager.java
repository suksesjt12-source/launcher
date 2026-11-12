package com.pcrecomp.launcher;

public class RuntimeManager {

    public static final String WINE = "Wine";
    public static final String HANGOVER = "Hangover";
    public static final String HYBRID = "Hybrid";

    private String selectedRuntime = HYBRID;

    public void setRuntime(String runtime) {
        selectedRuntime = runtime;
    }

    public String getRuntime() {
        return selectedRuntime;
    }

    public boolean isRuntimeAvailable() {
        return false;
    }

    public String getStatus() {
        return "Runtime belum terintegrasi";
    }
}
