# BunnyDroid 🐰

>tl;dr: A text-based deep link access tool on Android: directly launch supported pages inside apps. This repo accepts contributions to new commands.

The moniker BunnyDroid takes inspiration from a tech giant's search tool but for Android! BunyDroid let's you directly open pages inside apps without having to follow the traditional path of navigation. With just a characters, you can "hop" (hence the bunny reference) to the screen of your choice inside supported apps.

<img width=300 src="./demo.gif">

## Background

The motivation is for the shortcut-fanatics to be able to launch specific pages inside apps without having to _"launch-click-click-click-...-page"_. While that may sound like an exaggeration, BunnyDroid for Android will grow on you as you start using it.

Try `azo` to jump to your Amazon orders or `ym yellow` to listen to Coldplay's Yellow on YT Music all without having to hunt for these apps on your app drawer! 

## Setup

Head over to the [releases section](https://github.com/theGeekyLad/bunny-droid/releases) and grab the latest release. Just download and install _(use `adb` if you're feeling like a pro)_.

## Commands

Here's an exhaustive unsorted list of all supported commands: 

| Command | Descripation |
| --- | --- |
| `igu <USER_NAME>` | Instagram search for USER_NAME |
| `igdm` | Instagram DMs |
| `cc` | Google Calendar's create event page  |
| `tw <QUERY>` | Twitter search for QUERY |
| `twt` | Twitter's explore page |
| `gp <QUERY>` | Google Play Store search for QUERY |
| `g <QUERY>` | Google search for QUERY |
| `tt` | Google Tasks |
| `y <QUERY>` | YouTube search for QUERY |
| `ym <QUERY>` | YouTube Music search for QUERY |
| `pp <QUERY>` | Google Photos collections search for QUERY |
| `kk` | Google Keep new note |
| `az <ITEM>` | Amazon search for ITEM |
| `azc` | Amazon shopping cart |
| `azo` | Amazon orders |
| `mt <EMAIL>` | Gmail's compose to the provided EMAIL |
| `wut <TERM>` | Urban Dictionary search for TERM |
| `dd <ITEM>` | DoorDash search for ITEM |
| `qq <QUERY>` | ChatGPT search for QUERY |
| `go <PLACE>` | Go to PLACE on Google Maps |
| `eb <ITEM>` | eBay search for ITEM |

_**Note**: Contributors, please update this section whenever you add commands._

## Contributing

Let's consider an example of extending support to **Google search** with the command `g <QUERY>`:

1. Clone the `com/thegeekylad/bunnydroid/data/CommandExample.kt` template and call it `CommandGSearch.kt`.
2. Make relevant changes to the code to support search with and without arguments _(refer to the real `CommandGSearch.kt` to see how it's implemented)_.
3. Create a new entry in `com/thegeekylad/bunnydroid/di/CommandModule.kt` for DI like this:
```Kotlin
@Provides
@IntoMap
@StringKey("g")
fun commandGSearch(): ICommand = CommandGSearch()
```
4. Add an entry in the `README.md` to help users discover your command
5. Save, commit, and create a PR.

Overall, you only change two files. Thanks for helping BunnyDroid grow!

## Tech Stack

Hilt for dependency injection and Jetpack Compose for drawing views in Kotlin.

Made with ❤️ by `thegeekylad`
