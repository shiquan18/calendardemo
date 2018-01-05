package demowx.com.calendardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import demowx.com.calendardemo.Calendar.CalendarUtil;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    private TextView mTextView;
    private Calendar calCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.asdf);
        mTextView = (TextView) findViewById(R.id.textView);
        calCalendar = Calendar.getInstance();
        calCalendar.setTime(new Date());
        CalendarUtil calendarUtil = new CalendarUtil(calCalendar);
        mTextView.setText(calendarUtil.getHoliday());
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat mounthFormat = new SimpleDateFormat("yy-MM-dd");
                Date mDate = null;
                try {
                    mDate = mounthFormat.parse(mEditText.getText().toString().trim());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
                if (mDate != null)
                    calCalendar.setTime(mDate);
                CalendarUtil calendarUtil = new CalendarUtil(calCalendar);
                mTextView.setText(calendarUtil.getHoliday());
            }
        });
    }
}
