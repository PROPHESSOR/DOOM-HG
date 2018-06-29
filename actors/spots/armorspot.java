// TODO: Можно проще через константу dropitem
Actor SmallArmorSpot : SummonerSpot %ID% {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("ArmorCharge", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}

Actor MediumArmorSpot : SummonerSpot %ID% {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("ArmorBooster", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}

Actor LargeArmorSpot : SummonerSpot %ID% {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("ArmorPlate", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}

Actor ExtraArmorSpot : SummonerSpot %ID% {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("ExtraArmor", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}

Actor GreenArmorSpot : SummonerSpot %ID% {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("GreenArmor", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}
Actor BlueArmorSpot : SummonerSpot %ID% {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("BlueArmor", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}
Actor RedArmorSpot : SummonerSpot %ID% {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("RedArmor", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}

Actor RegenSpot : SummonerSpot 15038 {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("PortableMedkit", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}