package me.onebone.watchahomework.ui.favorites

import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.onebone.watchahomework.database.TrackEntity

class FavoritesAdapter: PagingDataAdapter<TrackEntity, FavoritesAdapter.ViewHolder>(
	diffCallback = object: DiffUtil.ItemCallback<TrackEntity>() {
		override fun areItemsTheSame(oldItem: TrackEntity, newItem: TrackEntity) = oldItem == newItem

		override fun areContentsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean = oldItem == newItem
	}
) {
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.textView.text = getItem(position)?.trackName
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		// TODO temporary layout
		return ViewHolder(TextView(parent.context).apply {
			layoutParams = ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT
			)
		})
	}

	inner class ViewHolder(
		val textView: TextView
	): RecyclerView.ViewHolder(textView)
}
