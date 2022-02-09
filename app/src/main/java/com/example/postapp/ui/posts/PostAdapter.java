package com.example.postapp.ui.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postapp.data.models.Post;
import com.example.postapp.databinding.ItemRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private OnClick click;
    private List<Post> posts = new ArrayList<>();

    public void setClick(OnClick click) {
        this.click = click;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerViewBinding binding = ItemRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));


    }
    public void removeItem(Post post, int p) {
        this.posts.remove(post);
        notifyItemRemoved(p);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    protected class PostViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerViewBinding binding;
        public PostViewHolder(@NonNull ItemRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;;
        }

        public void onBind(Post post) {
            binding.tvUserId.setText(String.valueOf(post.getUserId()));
            binding.tvContent.setText(post.getContent());
            binding.tvTitle.setText(post.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onClick(post);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    click.onLongClick(post,getAdapterPosition());
                        return true;
                }
            });
        }
    }

    public interface OnClick{
        void onClick(Post post);
        void onLongClick(Post post,int p);
    }
}


