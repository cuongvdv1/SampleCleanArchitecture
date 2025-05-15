package com.example.samplecleanarchitecture.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.samplecleanarchitecture.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

fun ImageView.loadImage(url: String, placeholder: Int) {
    Glide.with(this.context)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .dontAnimate()
        .into(this)
}

fun ShapeableImageView.setCornerRadius(
    topLeft: Float = 0f,
    topRight: Float = 0f,
    bottomRight: Float = 0f,
    bottomLeft: Float = 0f
) {
    shapeAppearanceModel = shapeAppearanceModel
        .toBuilder()
        .setTopLeftCorner(CornerFamily.ROUNDED, topLeft)
        .setTopRightCorner(CornerFamily.ROUNDED, topRight)
        .setBottomRightCorner(CornerFamily.ROUNDED, bottomRight)
        .setBottomLeftCorner(CornerFamily.ROUNDED, bottomLeft)
        .build()
}
