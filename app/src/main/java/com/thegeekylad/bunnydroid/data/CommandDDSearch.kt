package com.thegeekylad.bunnydroid.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.thegeekylad.bunnydroid.repository.ICommand

class CommandDDSearch: ICommand {
    override fun exec(context: Context, args: String?): String? {
        if (args == null) {
            Toast.makeText(context, "Please provide a item / restaurant name!", Toast.LENGTH_SHORT).show()
            return null
        }

        val deepLink = "https://www.doordash.com/search/store/${Uri.encode(args)}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

        return null
    }
}