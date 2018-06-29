Actor TestSentry : ScoutDrone 15031 {
    //$Category "Test"
    //$Title TestSentry
    //$Sprite DRANA2
    Health 400
    Radius 28
    Height 40
    Translation "112:127=192:207"
    Scale 1
    DamageFactor "Marine", 0
    DamageFactor "Mine", 0
    DamageFactor "Legendary", 0
    DamageFactor "MechStep", 0
    Species "Player"
    +THRUSPECIES
    +NORADIUSDMG
    States {

    Spawn:
        DRAN ABCDEFEDCB 2 A_Look
        Goto See
    See:
        Goto Mine
    Mine:
        DRAN A 1 A_Stop
        DRAN AAAAA 1 A_SpawnItemEx("SentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("RangeSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("SniperSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("ShotgunSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("FlameSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("PlasmaSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("RocketSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("HeavySentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("RailgunSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        DRAN AAAAA 1 A_SpawnItemEx("MissileSentryBox",0,0,24,random(3,5),0,random(2,5),random(0,359))
        Goto Stopping
    Stopping:
        DRAN A 1 A_Die
    Goto See
    Death:
        DRAN A 7 A_NoBlocking
        DRAN AA 2 A_CustomMissile("Kaboom",random(8,24), random(20,-20), random(0,16), 2, random(0,360))
        DRAN A 8 A_Scream
        DRAN A 5 A_Gravity
        wait
    Crash:
        DRAN A 0 A_NoBlocking
        DRAN A 0 A_NoGravity
        TNT1 A 0 A_SpawnItemEx("Debris",0,0,0,Random(4,-4),Random(4,-4),Random(4,8),0,128)
        DRAN AAAAAA 4 A_CustomMissile("Kaboom", random(8,24), random(20,-20), random(0,16), 2, random(0,360))
        DRAN W 250
        Stop
    }
}