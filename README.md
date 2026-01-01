# MeowHud
## Description:
    A almost fully customizable hud.
    Most of the can be customized via config.witchie file in ur config foulder.
        Theres few that a hard coded such as "delay_update".
    Made for minecraft version 1.21.10 with fabric loader.

    Not all features are added yet but the core is there.

    Made with Vim :3
    This was a around 7 day project (i think :P) from learning the basics of JAVA to a full mod.

## Latest update
    Added Keys
        %SETMOVMENT for custom movment msg
    
    Changed how Keys that contain mutiple values work.
    Now they are placed in {} with keys as for the values.

    %COLOR {
        %ALPHA
        255

        %RED
        255

        %GREEN
        255

        %BLUE
        255    
    }

    Meaning that u can set for example only %BLUE to the defaul value.

    Default color is now 0xFF000000 black to be able set color eazier with the new system.

## Install
    If ur IDE wont build it for you use:
        ./gradlew
        ./gradlew build

## Features
    Placment any where on the screen.
    Connection of keys with custom text:
        200 fps | 50 ms

        keys %FPS > 200, %PING > 50
        custom text "fps | ", " ms"

    Text coloring based on argb.
    More in confing.

## Config

###     Important!!!
        You have to create or copy config.witchie in to .minecraft/config else the mod will crash.

###     Rules:
        After a keyword the next line needs to be its value!!! (the code loads the vaule directly under the keyword)
        Dont create coloms and rows with a index that is out reach. (the game will crash as by desig)

        If your game crashes at start ur config is probaly writen wrongly.
        
###     Start:
        Start with a colom:
            colom {
                0
            }

        The code is made in such a way it ignores white space.
            colom {
                                            0
                        }

            valid ^^

                        colom {
            0



            }

            valid ^^

            colom{
                0
            }

            not valid ^^ "colom {" is a keyword
            
        Then you need to make row or rows:
            colom {
                0

                row {
                    0

                }

                row {
                    1

                }
            }

        With row we can start adding Keys whitch dictate what shows on the screen and where.

            colom {
                0

                row {
                    0

                    %POSX
                        1

                    %ALIGN
                        true

                    %NAME

                }
            } 
            

        Config like this will show the users name in the top middle of the screen. (look at ./config.witchie for more info)

###     Keys and keywords
        "colom {" declars start of a colom (values: index)
        "row {" declars start of a row (values: index)
        "}" delcalrs end of row or colom

        "%OFFSETX" sets row's x offset from x position (values: amount)
        "%OFFSETY" sets row's y offset from y position (values: amount)

        note: rows offset from each other

        "%POSX" sets row's starter x position (values: index[left = 0, center = 1, right = 2])
        "%POSY" sets row's starter y position (values: index[top = 0, center = 1, right = 2])

        "%COLOR {" color of the text in a row (vaules: %ALPHA, %RED, %GREEN, %BLUE)
        "%SETMOVMENT {" sets what %MOVMENT displayes in a row (values: %SWIM, %CROUCH, %SPRINT, %STAND) // only applays to the row that it is in
        "%ALIGN" text will be centred to its cords (vaules: bool)

        "%NAME" displayes user's name
        "%PING" displayes user's ping
        "%TPS" displayes server's tps (doesnt work as of now)
        "%FPS" displayes user's fps
        "%CORDSX" displayes user's X position
        "%CORDSY" displayes user's Y position
        "%CORDSZ" displayes user's Z position
        "%MOVMENT" displayes if user is swimming/crouching/sprinting (or set values with %SETMOVMENT)

        "%SPACE" insurts space
        "%TAP" insurets tap (4 spaces)

        custorm strings are created just by typing the the string (remember that the code is using String.trim())

        meow will display meow on the screen

        Not all Keys have to be set the only needed onces are ("colom {", "row {", "}")
        If Key is not set in config file default value will be used. (look at ./src/client/java/meow/code/conf/ConfigInfo.java)

# Special thanks
    to The Fabric Project discord
