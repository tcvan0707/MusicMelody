package com.example.musicmelody.ui.charts;

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
import com.example.musicmelody.model.charts.ChartsModel;
import com.example.musicmelody.model.charts.Track;
import com.example.musicmelody.remote.ApiClient;
import com.example.musicmelody.remote.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartsFragment extends Fragment {

    RecyclerView rv_charts;
    ApiInterface apiInterface;
    String TAG = "ChartsFragment";
    ArrayList<Track> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_charts, container, false);

        rv_charts = view.findViewById(R.id.recyclerview_charts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rv_charts.setLayoutManager(linearLayoutManager);
        callApi();
        return view;

    }

    private void callApi() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ChartsModel> call = apiInterface.getcharts();
        call.enqueue(new Callback<ChartsModel>() {
            @Override
            public void onResponse(Call<ChartsModel> call, Response<ChartsModel> response) {
                Log.d(TAG,"data from server : "+response.code());
                try {
                ChartsModel data = response.body();
                Log.d(TAG,"size of tracks :"+data.getTracks().size());
                list = (ArrayList<Track>) data.getTracks();
                ChartsAdapter customAdapter = new ChartsAdapter(getActivity(), list);
                rv_charts.setAdapter(customAdapter);
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ChartsModel> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG,"Error in Charts : "+t.getMessage());
                Toast.makeText(getView().getContext(), "Error : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}