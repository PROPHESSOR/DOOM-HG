// TODO: Можно проще через константу dropitem
Actor SmallAmmoSpot : SummonerSpot 15047 {
    //$Category "Summoner/Ammo"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("AmmoPack", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}
Actor BackpackSpot : SummonerSpot 15048 {
    //$Category "Summoner/Ammo"
    //$Title Small health spot
    //$Sprite DRANA2
    States {

        Mine:
            TNT1 A 0 A_JumpIf(user_count >= 40,"Stopping")
            TNT1 A 0 A_SetUserVar("user_count",user_count+1)
            TNT1 A 0 A_Stop
            TNT1 A 0 A_SpawnItemEx("Backpack", random(0, 2), random(0, 2), 24, 0, 0, random(2,5), random(0,359))
            Goto See
    }
}