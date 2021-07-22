package me.onebone.watchahomework.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Track(
	val wrapperType: WrapperType,
	val kind: Kind,
	val trackName: String,
	val artistName: String,
	val collectionName: String,
	val artworkUrl100: String? = null,
	val artworkUrl60: String? = null,
	val previewUrl: String? = null,
	val trackTimeMillis: Long? = null
)

@Serializable
enum class WrapperType {
	@SerialName("track") Track,
	@SerialName("collection") Collection,
	@SerialName("artistFor") ArtistFor;
}

@Serializable
enum class Kind {
	@SerialName("book") Book,
	@SerialName("album") Album,
	@SerialName("coached-audio") CoachedAudio,
	@SerialName("feature-movie") FeatureMovie,
	@SerialName("interactive- booklet") InteractiveBooklet,
	@SerialName("music-video") MusicVideo,
	@SerialName("pdf podcast") PdfPodcast,
	@SerialName("podcast-episode") PodcastEpisode,
	@SerialName("software-package") SoftwarePackage,
	@SerialName("song") Song,
	@SerialName("tv- episode") TvEpisode,
	@SerialName("artistFor") ArtistFor
}
