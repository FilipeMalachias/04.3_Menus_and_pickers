package com.filipe.malachias.droidcafe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String message = "Order: " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);

        Spinner spinner = findViewById(R.id.label_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLUE);
                ((TextView) parent.getChildAt(0)).setTextSize(15);

                if (position == 0)
                {
                    displayToast("Home Selected");
                } else if (position == 1)
                {
                    displayToast("Work Selected");
                } else if (position == 2)
                {
                    displayToast("Mobile Selected");
                } else if (position == 3)
                {
                    displayToast("Other Selected");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void displayToast (String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view)
    {
        // When radioButton is tapped
        RadioButton selected = (RadioButton) view;

        // check if the button is checked;
        boolean checked =  selected.isChecked();

        if (selected.getId() == R.id.sameday)
        {
            if (checked)
            {
                displayToast("Same day service selected");
            }
        } else if (selected.getId() == R.id.nextday)
        {
            if (checked)
            {
                displayToast("Next day service selected");
            }
        } else if (selected.getId() == R.id.pickup)
        {
            if (checked)
            {
                displayToast("Pick up service selected");
            }
        } else {

        }

    }
}
