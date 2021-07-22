package me.onebone.watchahomework.ui.tracks

import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.onebone.watchahomework.model.Track

class TracksAdapter: PagingDataAdapter<Track, TracksAdapter.ViewHolder>(
	diffCallback = object: DiffUtil.ItemCallback<Track>() {
		override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean = oldItem == newItem

		override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean = oldItem == newItem
	}
) {
	inner class ViewHolder(private val textView: TextView): RecyclerView.ViewHolder(textView) {
		fun bind(track: Track?) {
			// null may come in for displaying placeholder (i.e. loading state),
			// however, placeholder is set off in paging configuration so we just skip the null values
			if(track == null) return

			textView.text = track.trackName
		}
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(getItem(position))
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		// TODO temporary layout
		return ViewHolder(TextView(parent.context).apply {
			layoutParams = ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT
			)

			setPadding(80)
		})
	}
}
