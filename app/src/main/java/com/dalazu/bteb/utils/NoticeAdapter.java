package com.dalazu.bteb.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dalazu.bteb.R;
import com.dalazu.bteb.model.Notice;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private List<Notice> noticeList;
    private OnNoticeClickListener listener;

    public NoticeAdapter(List<Notice> noticeList, OnNoticeClickListener listener) {
        this.noticeList = noticeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoticeAdapter.NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_notice, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.NoticeViewHolder holder, int position) {
        Notice notice = noticeList.get(position);
        holder.bind(notice);
    }

    @Override
    public int getItemCount() {
        return noticeList.size();
    }

    public interface OnNoticeClickListener {
        void onItemClick(Notice notice);

    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDetails, tvDate;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_notice_title);
            tvDetails = itemView.findViewById(R.id.tv_details);
            tvDate = itemView.findViewById(R.id.tv_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(noticeList.get(getAdapterPosition()));
                }
            });
        }

        public void bind(Notice notice) {
            tvTitle.setText(notice.getTitle());
            tvDetails.setText(notice.getDescription());
            tvDate.setText(notice.getDate());

        }

    }
}
