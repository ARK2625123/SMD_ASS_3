//package com.example.smd_3;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.Locale;
//
//public class padapter extends RecyclerView.Adapter<padapter.ViewHolder> {
//
//    ArrayList<pwd> pwds;
//
//    public padapter(ArrayList<pwd> list)
//    {
//        this.pwds = list;
//
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater
//                .from(parent.getContext())
//                .inflate(R.layout.pwd, parent, false);
//        return new ViewHolder(v);
//    }
//
//
//
//    @Override
////    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
////        holder.tvrating.setText(filtrest.get(position).getRating());
////        holder.tvname.setText(filtrest.get(position).getName());
////        holder.tvlocation.setText(filtrest.get(position).getLocation());
////        holder.tvnumber.setText(filtrest.get(position).getNumber());
////        holder.tvdesc.setText(filtrest.get(position).getDecription());
////    }
//
//    @Override
//    public int getItemCount() {
//        return pwds.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder
//    {
//        TextView puser,ppass,purl;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            puser = itemView.findViewById(R.id.puser);
//            ppass = itemView.findViewById(R.id.ppass);
//            purl = itemView.findViewById(R.id.purl);
//
//
////            itemView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    Toast.makeText(itemView.getContext(), tvrating.getText().toString(), Toast.LENGTH_SHORT).show();
////                }
////            });
//        }
//    }
//}
