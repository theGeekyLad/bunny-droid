package com.thegeekylad.bunnydroid.repository

import android.content.Context

interface ICommand {
        fun exec(context: Context, args: String?): String?
}