package com.example.tablelayoutsample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.view.View;
import android.widget.Button;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public MainActivity mainActivity;
    @Before
    public void setUp() {
        mainActivity = new MainActivity();
    }
    public void onFuncClck_ButtonMC_ResetsMemoryValue() {
        mainActivity.onFuncClck(mockButton("MC"));
        assertEquals(0, mainActivity.memoryValue, 0);
    }

    @Test
    public void onFuncClck_ButtonMS_SetsMemoryValueFromCurrentInput() {
        mainActivity.currentInput = "8";
        mainActivity.onFuncClck(mockButton("MS"));
        assertEquals(8, mainActivity.memoryValue, 0);
    }
    @Test
    public void onFuncClck_ButtonMPlus_AddsCurrentInputToMemory() {
        mainActivity.memoryValue = 3;
        mainActivity.currentInput = "2";
        mainActivity.onFuncClck(mockButton("M+"));
        assertEquals(5, mainActivity.memoryValue, 0);
    }


    private View mockButton(String buttonText) {
        Button mockButton = new Button(mainActivity);
        mockButton.setText(buttonText);
        return mockButton;
}