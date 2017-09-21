package swap.com.testdb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import swap.com.testdb.R;
import swap.com.testdb.adapter.ContactAdapter;
import swap.com.testdb.database.Dbhelper;
import swap.com.testdb.model.ContactModel;


public class InsertFragment extends Fragment {

    private List<ContactModel> beautyTipsInfoArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactAdapter mAdapter;
    Dbhelper db;
    private EditText edtSrNo;
    private EditText edtName;
    private EditText edtMobileNo;
    private Button btnSubmit;

    public static InsertFragment newInstance() {
        InsertFragment fragment = new InsertFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.activity_login, container, false);
        View rootView = inflater.inflate(R.layout.fragment_insert_contact, container, false);
        db = new Dbhelper(getActivity().getApplicationContext());

        edtSrNo = (EditText) rootView.findViewById(R.id.edt_sr_no);
        edtName = (EditText) rootView.findViewById(R.id.edt_name);
        edtMobileNo = (EditText) rootView.findViewById(R.id.edt_mobile);
        btnSubmit = (Button) rootView.findViewById(R.id.btn_submit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validate()) {
                    insertDataToDatabase();
                }
            }
        });
        return  rootView;
    }

    private boolean validate() {
        if(edtSrNo.equals("")){
            Toast.makeText(getActivity(), "Enter SrNo please...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edtName.equals("")){
            Toast.makeText(getActivity(), "Enter Name please...", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edtMobileNo.equals("")){
            Toast.makeText(getActivity(), "Enter Mobile please...", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void insertDataToDatabase() {
        db.insertVoterInfo(edtSrNo.getText().toString(), edtName.getText().toString(), edtMobileNo.getText().toString());
    }


}
