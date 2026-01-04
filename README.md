# MeowHud
## Description:
Almost fully customizable hud.
Most of the can be customized via config.witchie file in ur config foulder.
Theres few that a hard coded such as "delay_update".
Made for minecraft version 1.21.10 with fabric loader.

Not all features are added yet but the core is there.

Made with Vim :3
This was a around 7 day project (i think :P) from learning the basics of JAVA to a full mod.
Im still adding stuff to the base tho.

## Latest update
Fixed coloms
Standartized the code base
Added how to mod the mod to readme
Readme changed

## Install
If ur IDE wont build it for you use:
    ./gradlew
    ./gradlew build

Then make or copy config.witchie in to .minecraft/config/

## Features
Elements can be placed anywhere on the screen.
Format customization.
Text coloring based on argb.
Supported modding of the mod.

## Config

### Important!!!
You have to create or copy config.witchie in to .minecraft/config
String.trim() is used so white space will be ignored.
Value has to be under a key. (if key accepts values)
Not all keys have to be set.
Not all values have to be set in multi-value keys. 
For every key exist default value. (see DefaultConfig.java)

### Keys
"colom {" start of a colom
"row {" start of a row
"}" end of multi-value keys

"%OFFSETX" sets row's x offset (values: int)
"%OFFSETY" sets row's y offset (values: int)

note: rows offsets in the same colom efect each other 

"%POSX" sets row's starter x position (values: index[left = 0, center = 1, right = 2])
"%POSY" sets row's starter y position (values: index[top = 0, center = 1, right = 2])

"%COLOR {" sets row's text color (vaules: %TRANS, %RED, %GREEN, %BLUE)
"%SETMOVMENT {" sets row's %MOVMENT values (values: %SWIM, %CROUCH, %SPRINT, %STAND)
"%ALIGN" sets if text is centred (vaules: bool)

"%NAME" displayes user's name
"%PING" displayes user's ping
"%TPS" displayes server's tps (doesnt work as of now)
"%FPS" displayes user's fps
"%CORDSX" displayes user's X position
"%CORDSY" displayes user's Y position
"%CORDSZ" displayes user's Z position
"%MOVMENT" displayes if user is swimming/crouching/sprinting (set by %SETMOVMENT)

"%SPACE" insurts space
"%TAP" insurets tap (4 spaces)

### Custom strings
Custom string will be automaticli created from text in config file that isnt a key.

## Example
look at config.witchie

# Modding 
Will be writen soon im to lazy rn :3
# Special thanks
to The Fabric Project discord
