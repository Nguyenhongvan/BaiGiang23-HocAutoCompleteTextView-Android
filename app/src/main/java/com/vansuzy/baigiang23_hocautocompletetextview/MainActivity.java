package com.vansuzy.baigiang23_hocautocompletetextview;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtTen;
    Button btnXacNhan;
    TextView txtThongTin;

    AutoCompleteTextView autoThucAn;
    String[] arrThucAn;
    ArrayAdapter<String> adapterThucAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addConstrols();
        addEvents();
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXacNhanThongTin();
            }
        });
    }

    private void xuLyXacNhanThongTin() {
        String s = txtTen.getText().toString() + "\n" + autoThucAn.getText().toString();
        txtThongTin.setText(s);
    }

    private void addConstrols() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);
        txtThongTin = (TextView) findViewById(R.id.txtThongTin);
        autoThucAn = (AutoCompleteTextView) findViewById(R.id.autoThucAn);

        arrThucAn = getResources().getStringArray(R.array.arrThucAn);
        adapterThucAn = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrThucAn
        );
        autoThucAn.setAdapter(adapterThucAn);
    }
}
