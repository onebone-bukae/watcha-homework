package me.onebone.watchahomework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
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
		): Boolean =
			oldItem.artistName == newItem.artistName &&
				oldItem.trackName == newItem.trackName && newItem.collectionName == oldItem.collectionName

		override fun areContentsTheSame(
			oldItem: TrackEntry, newItem: TrackEntry
		): Boolean = oldItem == newItem

		override fun getChangePayload(oldItem: TrackEntry, newItem: TrackEntry): Any {
			val diff = Bundle()

			if(oldItem.isFavorite != newItem.isFavorite)
				diff.putBoolean("isFavorite", newItem.isFavorite)

			if(oldItem.artworkUrl != newItem.artworkUrl)
				diff.putString("artworkUrl", newItem.artworkUrl)

			return diff
		}
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

			binding.toggleStar.setOnCheckedChangeListener { _, isChecked ->
				onStarToggled(entry, isChecked)
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
