package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

public class ValidatorReturnObject {
    private String message;
    private Module modul;

    public ValidatorReturnObject(String message, Module modul) {
        this.message = message;
        this.modul = modul;
    }

    @Override
    public String toString() {
        return "ValidatorReturnObject [message=" + message + ", modul=" + modul + "]";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Module getModul() {
        return modul;
    }

    public void setModul(Module modul) {
        this.modul = modul;
    }
}
