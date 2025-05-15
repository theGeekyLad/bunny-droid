package com.thegeekylad.bunnydroid.data.instgaram

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.thegeekylad.bunnydroid.repository.ICommand

class CommandIgDm: ICommand {
    override fun exec(context: Context, args: String?): String? {
        val deepLink = "instagram://direct-inbox"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

        return null
    }
}