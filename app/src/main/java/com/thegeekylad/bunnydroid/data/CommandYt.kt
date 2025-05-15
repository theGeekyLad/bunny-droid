package com.thegeekylad.bunnydroid.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.thegeekylad.bunnydroid.repository.ICommand

class CommandYt: ICommand {
    override fun exec(context: Context, args: String?): String? {
        val deepLink = "https://www.youtube.com/results?search_query=${if (args != null) Uri.encode(args) else ""}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

        return null
    }
}