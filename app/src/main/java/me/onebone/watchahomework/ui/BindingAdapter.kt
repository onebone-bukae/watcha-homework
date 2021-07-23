package me.onebone.watchahomework.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("srcUri")
fun ImageView.setImageWithGlide(uri: String?) {
	Glide.with(this)
		.load(uri)
		.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
		.into(this)
}
