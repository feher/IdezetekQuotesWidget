package net.feheren_fekete.stickynoteswidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class QuotesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private QuotesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new QuotesAdapter(new QuotesModel("quotes.txt"));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.loadAllItems();
    }
}
