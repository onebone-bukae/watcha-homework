package me.onebone.watchahomework.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.onebone.watchahomework.databinding.ItemTrackEntryBinding

class TracksAdapter(
	private val onStarToggled: TracksAdapter.(TrackEntry, Boolean) -> Unit
): PagingDataAdapter<TrackEntry, TracksAdapter.ViewHolder>(
	diffCallback = object: DiffUtil.ItemCallback<TrackEntry>() {
		override fun areItemsTheSame(
			oldItem: TrackEntry, newItem: TrackEntry
		): Boolean = oldItem == newItem

		override fun areContentsTheSame(
			oldItem: TrackEntry, newItem: TrackEntry
		): Boolean = oldItem == newItem
	}
) {
	inner class ViewHolder(
		private val binding: ItemTrackEntryBinding
	): RecyclerView.ViewHolder(binding.root) {
		fun bind(entry: TrackEntry?) {
			// null may come in for displaying placeholder (i.e. loading state),
			// however, placeholder is disabled in paging configuration so we just skip the null values
			if(entry == null) return

			binding.entry = entry

			binding.rbStar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { _, v, _ ->
				val isFavorite = v == 1f

				onStarToggled(entry, isFavorite)

				// better idea?? possibly using flow?
				// Room seems to support observable read queries for this purpose
				entry.isFavorite = isFavorite
			}
		}
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(getItem(position))
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(ItemTrackEntryBinding.inflate(
			LayoutInflater.from(parent.context), parent, false
		))
	}
}
