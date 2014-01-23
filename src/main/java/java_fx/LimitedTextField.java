package java_fx;

import javafx.scene.control.TextField;

/**
 * Author: Daniel
 */
public class LimitedTextField extends TextField {
    private int maxLength=0;

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean textLengthIsMax() {
        return maxLength != 0 && getText() != null && getText().length() >= maxLength;
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if(text.length()==0 || getText() == null || getText().length() < maxLength) {
            super.replaceText(start, end, text);
        }
    }
}
