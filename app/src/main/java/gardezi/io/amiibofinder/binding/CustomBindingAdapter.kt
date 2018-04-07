package gardezi.io.amiibofinder.binding

import android.databinding.BindingAdapter
import android.widget.ImageView

import com.bumptech.glide.Glide

@BindingAdapter("bind:image")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}

