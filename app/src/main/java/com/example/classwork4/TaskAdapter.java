package com.example.classwork4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    List<Model_task> list = new ArrayList<>();
    OnItenClickListener onItenClickListener;

    public void setList(List<Model_task> list) {
        this.list = list;
    }

    public void addData(Model_task model_task){
        list.add(model_task);
        notifyDataSetChanged();

    }

    public void setOnItenClickListener (OnItenClickListener onItenClickListener){
        this.onItenClickListener = onItenClickListener ;
    }
    OnItenClickListener onItenClicklistener ;

    public void updateData (Model_task model, int position){
        list.set(position, model);
        notifyDataSetChanged();
    }


    public void deleteTask(int position){
        list.remove(position);
        notifyDataSetChanged();
    }

    public TaskAdapter (Context context,MainActivity activity){

    }
    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kam,parent,false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder( TaskAdapter.TaskHolder holder, int position) {
        holder.bind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class TaskHolder extends RecyclerView.ViewHolder{
        TextView titleTxt, descriptionTxt;


        private TaskHolder(  View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.title_txt);
            descriptionTxt = itemView.findViewById(R.id.description_txt);
        }

        public void bind(Model_task model_task) {
            titleTxt.setText(model_task.getTitle());
            descriptionTxt.setText(model_task.getDescription());
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog dialog = new AlertDialog.Builder(itemView.getContext()).create();
                    dialog.setTitle("Внимание ");
                    dialog.setMessage("Вы действительно хотите удалить ? ");
                    dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteTask(getAdapterPosition());

                        }
                    });
                    dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                    return false;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItenClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
};
