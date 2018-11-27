package edu.uncw.whereami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    Box<LocationRecording> locationBox;
    LocationRecordAdapter adapter;


    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationBox = ((App) getApplication()).getBoxStore().boxFor(LocationRecording.class);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LocationRecordAdapter(locationBox);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    public void recordClick(View view) {
        Toast.makeText(this, "This button does nothing useful!", Toast.LENGTH_SHORT).show();
    }


    public void clearHistory(View view) {
        locationBox.removeAll();
        adapter.notifyDataSetChanged();
    }
}
