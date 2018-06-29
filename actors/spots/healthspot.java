Actor SummonerSpot 15033 {
    //$Category Summoner
    //$Title Summoner spot
    //$Sprite DRANA2
    Health 400
    Radius 28
    Height 40
    Species "Summoner"
    +THRUSPECIES
    +NORADIUSDMG
    -SHOOTABLE
    var int user_count;
    States {

        Spawn:
            DRAN ABCDEFEDCB 0 A_Look
            Goto See
        See:
            TNT1 A 0
            TNT1 A 0 A_JumpIf(user_count >= Args[0],"Stopping") // 40
            TNT1 A 0 A_Jump(155,"Mine")
            TNT1 ABCDEFEDCB 2 A_Stop
        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("PortableMedkit", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
        Stopping:
            TNT1 A 0
            Stop
    }
}

// TODO: Можно проще через константу dropitem
Actor SmallHealthSpot : SummonerSpot 15034 {
    //$Category "Summoner/Health"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("HealthFlask", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}

Actor MediumHealthSpot : SummonerSpot 15035 {
    //$Category "Summoner/Health"
    //$Title Medium health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("StimKit", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}

Actor LargeHealthSpot : SummonerSpot 15036 {
    //$Category "Summoner/Health"
    //$Title Large health spot
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

Actor MedikitSpot : SummonerSpot 15037 {
    //$Category "Summoner/Health"
    //$Title Medikit spot
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

Actor RegenSpot : SummonerSpot 15038 {
    //$Category "Summoner/Health"
    //$Title Regen spot
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