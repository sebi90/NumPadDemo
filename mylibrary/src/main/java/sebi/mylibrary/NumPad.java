package sebi.mylibrary;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Sebi on 12.06.15.
 */
public class NumPad extends LinearLayout implements View.OnClickListener{
    public NumPad(Context context) {
        super(context);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }


    private void setup() {
        inflate(getContext(), R.layout.num_pad_layout, this);
        this.setOrientation(VERTICAL);

        findViewById(R.id.number0).setOnClickListener(this);
        findViewById(R.id.number1).setOnClickListener(this);
        findViewById(R.id.number2).setOnClickListener(this);
        findViewById(R.id.number3).setOnClickListener(this);
        findViewById(R.id.number4).setOnClickListener(this);
        findViewById(R.id.number5).setOnClickListener(this);
        findViewById(R.id.number6).setOnClickListener(this);
        findViewById(R.id.number7).setOnClickListener(this);
        findViewById(R.id.number8).setOnClickListener(this);
        findViewById(R.id.number9).setOnClickListener(this);
        findViewById(R.id.point).setOnClickListener(this);

        /*for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof LinearLayout) {
                LinearLayout layout = (LinearLayout) getChildAt(i);
                for (int j = 0; j < layout.getChildCount(); j++) {
                    if (layout.getChildAt(j) instanceof Button) {
                        Button button = (Button) layout.getChildAt(j);

                        button.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                onButtonClick(v);
                            }
                        });
                    }
                }
            }

        }*/

    }

    @Override
    public void onClick(View view) {

        Button button = (Button) view;
        char num = button.getText().charAt(0);

        Log.d(this.getClass().getName(), "onButtonClick: " + button.getId());

        if (mOnNumClickListener != null) {
            mOnNumClickListener.onNumClick(button, num);
        }


    }

    public interface OnNumClickListener {
        public void onNumClick(View v, char num);
    }

    private OnNumClickListener mOnNumClickListener = null;

    public void setOnNumClickListener(OnNumClickListener l) {
        mOnNumClickListener = l;
    }


}
