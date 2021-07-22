package me.onebone.watchahomework.model

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class TrackSerializeTest {
	@Test
	fun testTrackDeserialization() {
		val json = Json { ignoreUnknownKeys = true }
		val track = json.decodeFromString<Track>(TestJson)
		assertEquals("Track", Expected, track)
	}
}

private val Expected = Track(
	wrapperType = WrapperType.Track,
	kind = Kind.Song,
	trackName = "Upside Down",
	artistName = "Jack Johnson",
	collectionName = "Sing-a-Longs and Lullabies for the Film Curious George",
	artworkUrl100 = "http://a1.itunes.apple.com/r10/Music/3b/6a/33/mzi.qzdqwsel.100x100-75.jpg",
	artworkUrl60 = "http://a1.itunes.apple.com/r10/Music/3b/6a/33/mzi.qzdqwsel.60x60-50.jpg",
	previewUrl = "http://a1099.itunes.apple.com/r10/Music/f9/54/43/mzi.gqvqlvcq.aac.p.m4p",
	trackTimeMillis = 210743
)

private const val TestJson = """
{
  "wrapperType": "track",
  "kind": "song",
  "artistId": 909253,
  "collectionId": 120954021,
  "trackId": 120954025,
  "artistName": "Jack Johnson",
  "collectionName": "Sing-a-Longs and Lullabies for the Film Curious George",
  "trackName": "Upside Down",
  "collectionCensoredName": "Sing-a-Longs and Lullabies for the Film Curious George",
  "trackCensoredName": "Upside Down",
  "artistViewUrl": "https://itunes.apple.com/WebObjects/MZStore.woa/wa/viewArtist?id=909253",
  "collectionViewUrl": "https://itunes.apple.com/WebObjects/MZStore.woa/wa/viewAlbum?i=120954025&id=120954021&s=143441",
  "trackViewUrl": "https://itunes.apple.com/WebObjects/MZStore.woa/wa/viewAlbum?i=120954025&id=120954021&s=143441",
  "previewUrl": "http://a1099.itunes.apple.com/r10/Music/f9/54/43/mzi.gqvqlvcq.aac.p.m4p",
  "artworkUrl60": "http://a1.itunes.apple.com/r10/Music/3b/6a/33/mzi.qzdqwsel.60x60-50.jpg",
  "artworkUrl100": "http://a1.itunes.apple.com/r10/Music/3b/6a/33/mzi.qzdqwsel.100x100-75.jpg",
  "collectionPrice": 10.99,
  "trackPrice": 0.99,
  "collectionExplicitness": "notExplicit",
  "trackExplicitness": "notExplicit",
  "discCount": 1,
  "discNumber": 1,
  "trackCount": 14,
  "trackNumber": 1,
  "trackTimeMillis": 210743,
  "country": "USA",
  "currency": "USD",
  "primaryGenreName": "Rock"
}
"""
