package hcmute.spkt.trannhatquang19110442.bai12_datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editTextDate, editTextTime;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Anh Xa
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextTime =  (EditText)  findViewById(R.id.editTextTime);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });

        editTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonGio();
            }
        });

    }
    private void ChonNgay(){
        calendar = Calendar.getInstance();
        int Ngay = calendar.get(Calendar.DATE);
        int Thang = calendar.get(Calendar.MONTH);
        int Nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                editTextDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, Nam, Thang, Ngay );
        datePickerDialog.show();
    }

    private void ChonGio(){

        calendar = Calendar.getInstance();
        int Gio = calendar.get(Calendar.HOUR_OF_DAY);
        int Phut = calendar.get(Calendar.MINUTE);
        int Giay = calendar.get(Calendar.SECOND);


        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(0,0,0, i, i1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

                editTextTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, Gio, Phut, true );
        timePickerDialog.show();
    }
}