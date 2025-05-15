package com.thegeekylad.bunnydroid.data.instgaram

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.thegeekylad.bunnydroid.repository.ICommand

class CommandIgUserSearch: ICommand {
    override fun exec(context: Context, args: String?): String? {
        if (args == null) {
            Toast.makeText(context, "Please provide a username!", Toast.LENGTH_SHORT).show()
            return null
        }

        val deepLink = "instagram://user?username=${Uri.encode(args)}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

        return null
    }
}