package com.example.musicmelody.ui.search;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicmelody.MainActivity;
import com.example.musicmelody.R;
import com.example.musicmelody.local.MusicDatabase;
import com.example.musicmelody.model.charts.ChartsModel;
import com.example.musicmelody.model.charts.Track;
import com.example.musicmelody.model.save.Music;
import com.example.musicmelody.model.search.Hit;
import com.example.musicmelody.model.search.SearchModel;
import com.example.musicmelody.remote.ApiClient;
import com.example.musicmelody.remote.ApiInterface;
import com.example.musicmelody.ui.charts.ChartsAdapter;
import com.example.musicmelody.util.OnItemClickListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    RecyclerView rv_search;
    ApiInterface apiInterface;
    String TAG = "SearchFragment";
    ArrayList<Hit> list = new ArrayList<>();
    EditText ed_search;
    Button btn_search;
    private MusicDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_search, container, false);

        rv_search = view.findViewById(R.id.recyclerview_search);
        ed_search = view.findViewById(R.id.ed_search);
        btn_search = view.findViewById(R.id.btn_search);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rv_search.setLayoutManager(linearLayoutManager);
        db = MusicDatabase.getInstance(getActivity());

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ed_search.getText().toString();
                if(text.isEmpty()){
                    Toast.makeText(getActivity(), "Please enter text to search.", Toast.LENGTH_SHORT).show();
                    return;
                }
                callApi(text);
            }
        });

        return view;
    }
    private void callApi(String text) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<SearchModel> call = apiInterface.getSearch(text);
        call.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                Log.d(TAG,"data from server : "+response.code());
                try {
                    SearchModel data = response.body();
                    list = (ArrayList<Hit>) data.getTracks().getHits();
                    if(list.size()<=0){
                        Toast.makeText(getActivity(), "No data Found", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    SearchAdapter customAdapter = new SearchAdapter(getActivity(), list, new OnItemClickListener(){

                        @Override
                        public void onItemClick(int position) {
                            Log.d(TAG,"clicked on : "+list.get(position).getTrack().getKey()+" "+list.get(position).getTrack().getTitle()+" "+list.get(position).getTrack().getSubtitle());
                            String id = list.get(position).getTrack().getKey();
                            String title = list.get(position).getTrack().getTitle();
                            String subtitle = list.get(position).getTrack().getSubtitle();
                            saveData(id,title,subtitle);

                        }
                    } );
                    rv_search.setAdapter(customAdapter);
                }catch (Exception e ){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG,"Error in Search : "+t.getMessage());
                Toast.makeText(getView().getContext(), "Error : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveData(String id,String song,String artist) {

        final String sId = id;
        final String sSong = song;
        final String sartist = artist;


        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                Music m = new Music();
                m.musicID = sId;
                m.title = sSong;
                m.subtitle= sartist;

                //adding to database
                db.getMusicDao().insert(m);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_LONG).show();
            }
        }
        SaveTask st = new SaveTask();
        st.execute();
    }


}