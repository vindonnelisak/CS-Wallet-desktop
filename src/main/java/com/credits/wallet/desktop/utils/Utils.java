package com.credits.wallet.desktop.utils;

import com.credits.wallet.desktop.AppState;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by goncharov-eg on 26.01.2018.
 */
public class Utils {
    private static Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    private static final String digits="0123456789";

    public static void showError(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Error");
        alert.setHeaderText("Error!");
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static void showInfo(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static String correctNum(String s) {
        int i=0;
        boolean wasPoint=false;
        while (i<s.length()) {
            String c=s.substring(i,i+1);
            if (!(c.equals(AppState.decSep) && !wasPoint) && !digits.contains(c)) {
                if (i==0 && s.length()==1)
                    s="";
                else if (i==0)
                    s=s.substring(1);
                else if (i==s.length()-1)
                    s=s.substring(0,i);
                else
                    s=s.substring(0,i)+s.substring(i+1);
            } else
                i++;

            if (c.equals(AppState.decSep))
                wasPoint=true;
        }
        return s;
    }

    /**
     * Gets the subarray
     * @param array - source
     * @param offset - starts position
     * @param length - length
     * @return
     */
    public static byte[] parseSubarray(byte[] array, int offset, int length) {
        byte[] result = new byte[length];
        System.arraycopy(array, offset, result, 0, length);
        return result;
    }

    /**
     * Concatinate byte arrays
     * @param firstArr
     * @param secondArr
     * @return
     */
    public static byte[] concatinateArrays(byte[] firstArr, byte[] secondArr) {
        byte[] resultArr = new byte[firstArr.length + secondArr.length];
        System.arraycopy(firstArr, 0, resultArr, 0, firstArr.length);
        System.arraycopy(secondArr, 0, resultArr, firstArr.length, secondArr.length);
        return resultArr;
    }


    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

}
