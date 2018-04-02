package edu.stanford.protege.server.admin.model;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class Detail {
    private String name, value;
    private boolean isLabel = true, isTextArea = false, isLast = false;

    /**
     * Constructor
     *
     * @param name  Detail name
     * @param value Detail value
     */
    public Detail(String name, String value) {
        this.name = checkNotNull(name);
        this.value = checkNotNull(value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean isLabel() {
        return isLabel;
    }

    public boolean isTextArea() {
        return isTextArea;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setIsLabel(boolean isLabel) {
        this.isLabel = checkNotNull(isLabel);
        isTextArea = !isLabel;
    }

    public void setIsTextArea(boolean isTextArea) {
        this.isTextArea = checkNotNull(isTextArea);
        isLabel = !isTextArea;
    }

    public void setIsLast(boolean isLast) {
        this.isLast = checkNotNull(isLast);
    }
}
