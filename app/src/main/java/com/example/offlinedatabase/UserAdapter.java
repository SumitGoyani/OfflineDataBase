package com.example.offlinedatabase;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<User> userlist;

    public UserAdapter(Activity activity, ArrayList<User> userlist) {
        this.activity = activity;
        this.userlist = userlist;
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(activity).inflate(R.layout.user_item_layout,viewGroup,false);

        TextView textView = view.findViewById(R.id.textView);

        User user = userlist.get(i);
        int id = user.getId();
        String name = user.getName();
        String contact = user.getContact();

        textView.setText(""+id+"\n"+name+"\n"+contact);

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                PopupMenu popupMenu = new PopupMenu(activity,textView);

                activity.getMenuInflater().inflate(R.menu.edit_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        if(menuItem.getItemId()==R.id.update)
                        {

                        }
                        else if(menuItem.getItemId()==R.id.delete){

                            DBHelper dbHelper = new DBHelper(activity);

                            dbHelper.deleteData(id);

                            userlist.remove(i);

                            notifyDataSetChanged();

//                            Intent intent = new Intent(activity, FirstActivity.class);
//                            activity.startActivity(intent);
//                            activity.finish();
                        }

                        return false;
                    }
                });

                popupMenu.show();


                return false;
            }
        });


        return view;
    }
}
