package swap.com.testdb.activity;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import swap.com.testdb.R;
import swap.com.testdb.fragment.FragmentDisplayRecords;
import swap.com.testdb.fragment.InsertFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnInsert;
    private Button btnDisplay;
    private FragmentTransaction transactionpayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button) findViewById(R.id.btn_insert);
        btnDisplay = (Button) findViewById(R.id.btn_display);

        transactionpayment = getSupportFragmentManager().beginTransaction();
        transactionpayment.replace(R.id.frm_container, new InsertFragment());
        transactionpayment.commit();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transactionpayment = getSupportFragmentManager().beginTransaction();
                transactionpayment.replace(R.id.frm_container, new InsertFragment());
                transactionpayment.commit();
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*transactionpayment.replace(R.id.frm_container, new FragmentDisplayRecords());
                transactionpayment.commit();*/

                FragmentTransaction transactionpayment = getSupportFragmentManager().beginTransaction();
                transactionpayment.replace(R.id.frm_container, new FragmentDisplayRecords());
                transactionpayment.commit();
            }
        });
    }
}
