package ca.yorku.eecs.mack.demobuttons71179;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Demo_Button - with modifications by...
 *
 * Login ID - chrisaug
 * Student ID - 215971179
 * Last name - Augustyn
 * First name(s) - Christian
 */

public class DemoButtons71179Activity extends Activity {
    private final static String MYDEBUG = "MYDEBUG"; // for Log.i messages
    View view;
    Button b, r;
    CheckBox cb;
    RadioButton rb1, rb2, rb3;
    ToggleButton tb;
    ImageButton backspaceButton;
    TextView buttonClickStatus, checkBoxClickStatus, radioButtonClickStatus, toggleButtonClickStatus,
            backspaceButtonClickStatus;

    String buttonClickString, backspaceString;
    boolean checkStatus;
    boolean rb1Status, rb2Status, rb3Status;
    boolean tbStatus;

    static final String STATE_CLICK_STRING = "clickString";
    static final String STATE_BACKSPACE_STRING = "backspaceString";
    static final String STATE_RESET_STRING = "resetString";
    static final String STATE_CHECK_STATUS = "checkStatus";
    static final String STATE_RB1_STATUS = "rb1Status";
    static final String STATE_RB2_STATUS = "rb2Status";
    static final String STATE_RB3_STATUS = "rb3Status";
    static final String STATE_TB_STATUS = "tbStatus";

    // called when the activity is first created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(STATE_CLICK_STRING, buttonClickString);
        savedInstanceState.putString(STATE_BACKSPACE_STRING, backspaceString);
        savedInstanceState.putBoolean(STATE_CHECK_STATUS, checkStatus);
        savedInstanceState.putBoolean(STATE_RB1_STATUS, rb1Status);
        savedInstanceState.putBoolean(STATE_RB2_STATUS, rb2Status);
        savedInstanceState.putBoolean(STATE_RB3_STATUS, rb3Status);
        savedInstanceState.putBoolean(STATE_TB_STATUS, tbStatus);
        super.onSaveInstanceState(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        //obtains the current view and sets its background colour
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.background);

        b = (Button) findViewById(R.id.button);
        r = (Button) findViewById(R.id.resetbutton);
        cb = (CheckBox) findViewById(R.id.checkbox);
        rb1 = (RadioButton) findViewById(R.id.radiobutton1);
        rb2 = (RadioButton) findViewById(R.id.radiobutton2);
        rb3 = (RadioButton) findViewById(R.id.radiobutton3);
        rb1.toggle();
        tb = (ToggleButton) findViewById(R.id.togglebutton);
        backspaceButton = (ImageButton) findViewById(R.id.backspacebutton);

        buttonClickStatus = (TextView) findViewById(R.id.buttonclickstatus);
        checkBoxClickStatus = (TextView) findViewById(R.id.checkboxclickstatus);
        radioButtonClickStatus = (TextView) findViewById(R.id.radiobuttonclickstatus);
        toggleButtonClickStatus = (TextView) findViewById(R.id.togglebuttonclickstatus);
        backspaceButtonClickStatus = (TextView) findViewById(R.id.backspacebuttonclickstatus);

        if (savedInstanceState != null) {
            buttonClickString = savedInstanceState.getString(STATE_CLICK_STRING);
            backspaceString = savedInstanceState.getString(STATE_BACKSPACE_STRING);
            checkStatus = savedInstanceState.getBoolean(STATE_CHECK_STATUS);
            rb1Status = savedInstanceState.getBoolean(STATE_RB1_STATUS);
            rb2Status = savedInstanceState.getBoolean(STATE_RB2_STATUS);
            rb3Status = savedInstanceState.getBoolean(STATE_RB3_STATUS);
            tbStatus = savedInstanceState.getBoolean(STATE_TB_STATUS);

        } else {
            buttonClickString = "";
            backspaceString = "";
            rb1Status = true;
//            radioButtonClickStatus.setText(R.string.red);
//            radioButtonClickStatus.setTextColor(Color.RED);
        }

        buttonClickStatus.setText(buttonClickString);
        backspaceButtonClickStatus.setText(backspaceString);
        checkBoxClickStatus.setText(checkStatus ? R.string.checked : R.string.unchecked);
        if (rb1Status) {
            radioButtonClickStatus.setText(R.string.red);
            radioButtonClickStatus.setTextColor(Color.RED);
        } else if (rb2Status) {
            radioButtonClickStatus.setText(R.string.green);
            radioButtonClickStatus.setTextColor(Color.GREEN);
        } else {
            radioButtonClickStatus.setText(R.string.blue);
            radioButtonClickStatus.setTextColor(Color.BLUE);
        }
        toggleButtonClickStatus.setText(tbStatus ? R.string.on : R.string.off);
    }

    // handle button clicks
    public void buttonClick(View v) {
        if(v == r) {
            buttonClickString = "";
            backspaceString = "";
            rb1Status = true;
            rb2Status = false;
            rb3Status = false;
            buttonClickStatus.setText(buttonClickString);
            backspaceButtonClickStatus.setText(backspaceString);
            checkBoxClickStatus.setText(R.string.unchecked);
            radioButtonClickStatus.setText(R.string.red);
            radioButtonClickStatus.setTextColor(Color.RED);
            toggleButtonClickStatus.setText(R.string.off);
            cb.setChecked(false);
            rb1.setChecked(true);
        }

        // plain button
        if (v == b) {
            buttonClickString += ".";
            buttonClickStatus.setText(buttonClickString);
        }

        // checkbox
        else if (v == cb) {
            if (cb.isChecked()) {
                cb.setChecked(true);
                checkBoxClickStatus.setText(R.string.checked);
                checkStatus = true;
            } else {
                checkStatus = false;
                cb.setChecked(false);
                checkBoxClickStatus.setText(R.string.unchecked);
            }
        }

        // radio button #1 (RED)
        else if (v == rb1) {
            rb1Status = true;
            rb2Status = false;
            rb3Status = false;
            rb1.setChecked(true);
            radioButtonClickStatus.setText(R.string.red);
            radioButtonClickStatus.setTextColor(Color.RED);
        }

        // radio button #2 (GREEN)
        else if (v == rb2) {
            rb1Status = false;
            rb2Status = true;
            rb3Status = false;
            rb2.setChecked(true);
            radioButtonClickStatus.setText(R.string.green);
            radioButtonClickStatus.setTextColor(Color.GREEN);
        }

        // radio button #3 (BLUE)
        else if (v == rb3) {
            rb1Status = false;
            rb2Status = false;
            rb3Status = true;
            rb3.setChecked(true);
            radioButtonClickStatus.setText(R.string.blue);
            radioButtonClickStatus.setTextColor(Color.BLUE);
        }

        // toggle button
        else if (v == tb) {
            tb.setActivated(tb.isChecked());
            if (tb.isChecked()) {
                tbStatus = true;
                System.out.println(tbStatus);
                toggleButtonClickStatus.setText(R.string.on);
            } else {
                tbStatus = false;
                toggleButtonClickStatus.setText(R.string.off);
            }
        }

        // backspace button
        else if (v == backspaceButton) {
            backspaceString += "BK ";
            backspaceButtonClickStatus.setText(backspaceString);
        }

        // exit button
//        else if (v == exitButton) {
//            this.finish();
//        }
    }

}