package swap.com.testdb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import swap.com.testdb.R;
import swap.com.testdb.adapter.ContactAdapter;
import swap.com.testdb.database.Dbhelper;
import swap.com.testdb.model.ContactModel;


public class FragmentDisplayRecords extends Fragment {

    private List<ContactModel> beautyTipsInfoArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactAdapter mAdapter;
    private Dbhelper db;

    public static FragmentDisplayRecords newInstance() {
        FragmentDisplayRecords fragment = new FragmentDisplayRecords();
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
        View rootView = inflater.inflate(R.layout.fragment_beauty_tips, container,
                false);
        db = new Dbhelper(getActivity().getApplicationContext());

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        beautyTipsInfoArrayList = db.getAllContactList();

        mAdapter = new ContactAdapter(beautyTipsInfoArrayList,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        return  rootView;
    }


    @Override
    public void setUserVisibleHint(boolean visible)
    {
        super.setUserVisibleHint(visible);
        if (visible && isResumed())
        {
            //Only manually call onResume if fragment is already visible
            //Otherwise allow natural fragment lifecycle to call onResume
            onResume();
        }else{
            db = new Dbhelper(getActivity().getApplicationContext());
            beautyTipsInfoArrayList = db.getAllContactList();
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (!getUserVisibleHint())
        {
            return;
        }

        //INSERT CUSTOM CODE HERE
    }
}
