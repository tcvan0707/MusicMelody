package com.example.musicmelody.ui.saved;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicmelody.R;
import com.example.musicmelody.local.MusicDatabase;
import com.example.musicmelody.model.charts.Track;
import com.example.musicmelody.model.save.Music;
import com.example.musicmelody.remote.ApiInterface;
import com.example.musicmelody.ui.search.SearchAdapter;
import com.example.musicmelody.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class SavedFragment extends Fragment {

    RecyclerView rv_saved;
    ApiInterface apiInterface;
    String TAG = "SavedFragment";
    private MusicDatabase db;
    SavedAdapter customAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_saved, container, false);
        rv_saved = view.findViewById(R.id.recyclerview_saved);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rv_saved.setLayoutManager(linearLayoutManager);
        db = MusicDatabase.getInstance(getActivity());

        GetTask g = new GetTask();
        g.execute();
        return view;
    }

    class GetTask extends AsyncTask<Void, Void, List<Music>> {

        @Override
        protected List<Music> doInBackground(Void... voids) {

            List<Music> taskList =
                    db
                    .getInstance(getActivity())
                    .getMusicDao().getAll();
            return taskList;
        }

        @Override
        protected void onPostExecute(List<Music> list) {
            super.onPostExecute(list);
            try {
                if (list.size() == 0) {
                    Toast.makeText(getActivity(), "No data yet", Toast.LENGTH_LONG).show();
                    return;
                }
                customAdapter = new SavedAdapter(getActivity(), list, new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        try {
                            String title = list.get(position).title;
                            db.getMusicDao().delete(list.get(position).musicID);
                            list.remove(position);
                            customAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), "Deleted "+title, Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                });
                rv_saved.setAdapter(customAdapter);
            }catch (Exception e ){
                Log.d(TAG,"error in display :"+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}