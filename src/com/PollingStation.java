package com;

import javafx.scene.control.ProgressBar;

public class PollingStation {
    String name;
    ProgressBar progressBar;

    public PollingStation(){
        this.name = "PollingStation";
        this.progressBar = new ProgressBar();

    }

    public PollingStation(String name, ProgressBar progressBar) {
        this.name = name;
        this.progressBar = progressBar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }
}
