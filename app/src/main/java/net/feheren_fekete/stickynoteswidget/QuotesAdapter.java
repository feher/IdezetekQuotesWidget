package net.feheren_fekete.stickynoteswidget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;


public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {

    private List<Quote> mQuotes;
    private QuotesModel mQuotesModel;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.text_view);
        }
    }

    public QuotesAdapter(QuotesModel quotesModel) {
        mQuotes = Collections.emptyList();
        mQuotesModel = quotesModel;
    }

    public void loadAllItems() {
        Task.callInBackground(new Callable<List<Quote>>() {
            @Override
            public List<Quote> call() {
                return mQuotesModel.loadAllQuotes();
            }
        }).continueWith(new Continuation<List<Quote>, Void>() {
            @Override
            public Void then(Task<List<Quote>> task) {
                mQuotes = task.getResult();
                notifyDataSetChanged();
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mQuotes.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

}
