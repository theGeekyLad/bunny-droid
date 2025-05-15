package com.thegeekylad.bunnydroid.data

import android.content.Context
import com.thegeekylad.bunnydroid.model.CommandData
import com.thegeekylad.bunnydroid.repository.ICommand
import javax.inject.Inject

class CommandLoader @Inject constructor(
    private val commands: Map<String, @JvmSuppressWildcards ICommand>
) {
    private fun parse(commandStr: String): CommandData {
        val _commandStr = commandStr.trim()

        val separatorIndex = _commandStr.indexOf(' ');

        val cmd = _commandStr.substring(0, if (separatorIndex == -1) _commandStr.length else separatorIndex)
        val args = if (separatorIndex != -1) _commandStr.substring(separatorIndex + 1) else null

        return CommandData(cmd, args)
    }

    private fun preExec(context: Context, commandData: CommandData): CommandData {
        val cmdArr = commandData.cmd.split(".")
        var args = commandData.args

        // is a "compound" command: exec all sub-commands before
        // processing this one
        if (cmdArr.size > 1) {
            for (i in cmdArr.size - 1 downTo 1) {
                args = commands[cmdArr[i]]?.exec(context, args)
            }
        }

        return CommandData(cmdArr[0], args)
    }

    fun run(context: Context, commandStr: String): String? {
        var commandData = parse(commandStr)
        commandData = preExec(context, commandData)
        return commands[commandData.cmd]?.exec(context, commandData.args)
    }
}