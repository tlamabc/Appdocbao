package com.example.appdocbao;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GiaitriFragment extends Fragment {
    private RecyclerView commentList;
    private EditText commentInput;
    private Button submitComment;
    private CommentAdapter commentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.giaitrifragment, container, false);

        commentList = v.findViewById(R.id.commentList);
        commentList.setLayoutManager(new LinearLayoutManager(getContext()));

        commentInput = v.findViewById(R.id.commentInput);
        submitComment = v.findViewById(R.id.submitComment);

        submitComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentText = commentInput.getText().toString();
                if (!TextUtils.isEmpty(commentText)) {
                    // Gửi bình luận lên Firebase Realtime Database
                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("comments");
                    String key = myRef.push().getKey();
                    Comment comment = new Comment(key, FirebaseAuth.getInstance().getCurrentUser().getDisplayName(), FirebaseAuth.getInstance().getCurrentUser().getEmail(), commentText);
                    myRef.child(key).setValue(comment);

                    // Xóa nội dung bình luận
                    commentInput.setText("");
                }
            }
        });

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("comments");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Comment> comments = new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Comment comment = snapshot.getValue(Comment.class);
                    comments.add(comment);
                }
                commentAdapter = new CommentAdapter(comments);
                commentList.setAdapter(commentAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Log.w("TrangchuFragment", "loadPost:onCancelled", databaseError.toException());
            }
        });

        return v;
    }
}