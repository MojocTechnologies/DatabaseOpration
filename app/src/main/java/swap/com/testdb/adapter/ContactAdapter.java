package swap.com.testdb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import swap.com.testdb.R;
import swap.com.testdb.model.ContactModel;

/**
 * Created by PRANAY on 8/2/2017.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {


    private List<ContactModel> beautyTipsInfos;
    Context mContext;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        TextView txtSrNo;
        public Button btnEdit;
        public Button btnDelete;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.name);
            txtSrNo = (TextView) view.findViewById(R.id.txt_sr_no);
            btnEdit = (Button) view.findViewById(R.id.btn_edit);
            btnDelete = (Button) view.findViewById(R.id.btn_delete);

        }
    }


    public ContactAdapter(List<ContactModel> beautyTipsInfos1, Context c) {
        this.beautyTipsInfos = beautyTipsInfos1;
        this.mContext = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_contact_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ContactModel tipsInfo = beautyTipsInfos.get(position);
        holder.title.setText(tipsInfo.getName());
        holder.txtSrNo.setText(tipsInfo.getSrNo());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.txtSrNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "Click on image view", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return beautyTipsInfos.size();
    }
}