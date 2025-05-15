package com.thegeekylad.bunnydroid.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.thegeekylad.bunnydroid.repository.ICommand

class CommandExample: ICommand {
    override fun exec(context: Context, args: String?): String? {
        if (args == null) {
            val deepLink = "http://example.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

            return null
        }

        val deepLink = "http://example.com?query=${Uri.encode(args)}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

        return null
    }
}