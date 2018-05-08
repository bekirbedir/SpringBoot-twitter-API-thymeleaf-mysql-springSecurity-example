package com.example.gradledemo.Domain;

public class FormCommand {
    String textField;

    String textareaField;

    String datetimeField;

    String colorField;

    boolean singleCheckboxField;

    String[] multiCheckboxSelectedValues;

    String radioButtonSelectedValue;
    String dropdownSelectedValue;

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public String getTextareaField() {
        return textareaField;
    }

    public void setTextareaField(String textareaField) {
        this.textareaField = textareaField;
    }

    public String getDatetimeField() {
        return datetimeField;
    }

    public void setDatetimeField(String datetimeField) {
        this.datetimeField = datetimeField;
    }

    public String getColorField() {
        return colorField;
    }

    public void setColorField(String colorField) {
        this.colorField = colorField;
    }

    public boolean isSingleCheckboxField() {
        return singleCheckboxField;
    }

    public void setSingleCheckboxField(boolean singleCheckboxField) {
        this.singleCheckboxField = singleCheckboxField;
    }

    public String[] getMultiCheckboxSelectedValues() {
        return multiCheckboxSelectedValues;
    }

    public void setMultiCheckboxSelectedValues(String[] multiCheckboxSelectedValues) {
        this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
    }

    public String getRadioButtonSelectedValue() {
        return radioButtonSelectedValue;
    }

    public void setRadioButtonSelectedValue(String radioButtonSelectedValue) {
        this.radioButtonSelectedValue = radioButtonSelectedValue;
    }

    public String getDropdownSelectedValue() {
        return dropdownSelectedValue;
    }

    public void setDropdownSelectedValue(String dropdownSelectedValue) {
        this.dropdownSelectedValue = dropdownSelectedValue;
    }
}