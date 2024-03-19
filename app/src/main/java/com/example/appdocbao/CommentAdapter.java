package com.example.appdocbao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<com.example.appdocbao.Comment> comments;

    public CommentAdapter(List<com.example.appdocbao.Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.authorTextView.setText(comment.getEmail());
        //holder.authorTextView.setText(comment.getAuthor() + " (" + comment.getEmail() + ")");
        holder.textView.setText(comment.getText());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView authorTextView;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            authorTextView = view.findViewById(R.id.authorTextView);
            textView = view.findViewById(R.id.textView);
        }
    }
}