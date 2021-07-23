package me.onebone.watchahomework.ui.tracks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.onebone.watchahomework.databinding.ItemTrackEntryBinding
import me.onebone.watchahomework.shared.repository.TracksPagingSource

class TracksAdapter(
	private val onStarToggled: (TracksPagingSource.TrackAndFavorite, Boolean) -> Unit
): PagingDataAdapter<TracksPagingSource.TrackAndFavorite, TracksAdapter.ViewHolder>(
	diffCallback = object: DiffUtil.ItemCallback<TracksPagingSource.TrackAndFavorite>() {
		override fun areItemsTheSame(
			oldItem: TracksPagingSource.TrackAndFavorite,
			newItem: TracksPagingSource.TrackAndFavorite
		): Boolean = oldItem == newItem

		override fun areContentsTheSame(
			oldItem: TracksPagingSource.TrackAndFavorite,
			newItem: TracksPagingSource.TrackAndFavorite
		): Boolean = oldItem == newItem
	}
) {
	inner class ViewHolder(
		private val binding: ItemTrackEntryBinding
	): RecyclerView.ViewHolder(binding.root) {
		fun bind(entry: TracksPagingSource.TrackAndFavorite?) {
			// null may come in for displaying placeholder (i.e. loading state),
			// however, placeholder is disabled in paging configuration so we just skip the null values
			if(entry == null) return

			binding.entry = entry

			binding.rbStar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { _, v, _ ->
				onStarToggled(entry, v == 1f)
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
