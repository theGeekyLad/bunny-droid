package com.thegeekylad.bunnydroid.data.amazon

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.thegeekylad.bunnydroid.repository.ICommand

class CommandAmazonCart: ICommand {
    override fun exec(context: Context, args: String?): String? {
        val deepLink = "https://www.amazon.com/gp/cart/view.html"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

        return null
    }
}