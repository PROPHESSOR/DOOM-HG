Actor ScoutDrone {
    //$Category "Utils/Sentry"
    //$Title ScoutDrone
    //$Sprite DRONA4
    Obituary "%o was betrayed."
    Monster
    Health 50
    Radius 12
    Height 28
    Mass 100
    Speed 15
    +FRIENDLY
    +QUICKTORETALIATE
    +LOOKALLAROUND
    +NEVERRESPAWN
    +MISSILEMORE
    +MISSILEEVENMORE
    +NOBLOCKMONST
    +FLOAT
    +NOGRAVITY
    +NOBLOOD
    +NOPAIN
    -COUNTKILL
    AttackSound ""
    DeathSound ""
    Decal "BulletChip"
    DamageFactor "Marine", 0
    DamageFactor "Legendary", 0
    DamageFactor "MechStep", 0
    DamageFactor "Mine", 0
    Species "Player"
    SeeSound "drone/see"               
    DeathSound "drone/die"
    ActiveSound "drone/act"
    var int user_delay;
    var int user_script;
    Scale 0.6
    States {
  
      Spawn:
        DRON A 4 A_Look
        Loop
      See:
        DRON A 0 A_JumpIf(user_delay >= 1700,"Done")
        DRON A 2 A_Chase   
        DRON A 0 A_SetUserVar("user_delay",user_delay+1)
        Loop
      Missile:
        DRON A 0 A_JumpIf(user_delay >= 1700,"Done")
        DRON BBBB 2 A_FaceTarget
        DRON C 0 A_PlaySound("drone/fire")
        DRON C 3 Bright A_CustomMissile("DroneProj",15,0,random(-3,3))
        DRON C 0 A_PlaySound("drone/fire")
        DRON C 3 Bright A_CustomMissile("DroneProj",15,0,random(-3,3))
        DRON C 0 A_PlaySound("drone/fire")
        DRON C 3 Bright A_CustomMissile("DroneProj",15,0,random(-3,3))
        Goto See
      Done:
        DRON AAA 35 A_PlaySound("sentry/warn")
        DRON A 1 A_Die
        Goto See
      Death:
        DRON D 7 A_NoBlocking
        DRON E 8 A_Scream
        DRON F 5 A_Gravity
        Wait
      Crash:
      DRON GHI 4
      DRON J 250
      Stop
    }
}
  
Actor DroneProj : FastProjectile 15015 {
    Speed 350
    Radius 6
    Height 6
    Damage 2
    Renderstyle Add
    DeathSound "weapons/demontechex"
    //+MTHRUSPECIES
    MissileType "DroneProjTrail"
    Decal DoomImpScorch
    DamageType "Marine"
    States {

    Spawn:
        TNT1 A 1
        Loop
    Death:
        TNT1 AA 0 A_SpawnItemEx("RedParticleSpawner",0,0,0,0,0,0,0,128)
        TNT1 AAAA 0 A_CustomMissile("Kaboom10",0,0,random(0,360),2,random(0,360))
        TNT1 A 1
        Stop
    }
}

Actor DroneProjTrail {
    RenderStyle Add
    Scale 0.05
    Alpha 1
    +CLIENTSIDEONLY
    +NOINTERACTION
    +NOGRAVITY
    States {

    Spawn:
        //YAE4 AA 2 Bright
    Fly:
        YAE4 A 0
        YAE4 A 1 Bright A_FadeOut(0.295)
        Loop
    }
}

Actor MineDrone : ScoutDrone 15016 {
    //$Category "Utils/Sentry"
    //$Title MineDrone
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
    var int user_mine;
    States {

        Spawn:
        DRAN ABCDEFEDCB 2 A_Look
        Goto See
        See:
        TNT1 A 0
        TNT1 A 0 A_JumpIf(user_mine >= 10,"Stopping") // 40
        TNT1 A 0 A_Jump(155,"Mine")
        DRAN ABCDEFEDCB 2 A_Stop
        /*TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN A 2 A_Recoil(-5)
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN B 2 A_Recoil(-5)
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN C 2 A_Recoil(-5)
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN D 2 A_Recoil(-5)
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN E 2 A_Recoil(-5)
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN F 2 A_Recoil(-5)
        TNT1 A 0 A_Jump(64,"Mine")
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN E 2 A_Recoil(-5)
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN D 2 A_Recoil(-5)
        TNT1 A 0 A_SetAngle(random(0,359))
        TNT1 A 0 A_Stop
        DRAN C 2 A_Recoil(-5)
        TNT1 A 0 A_Stop
        TNT1 A 0 A_SetAngle(random(0,359))
        DRAN B 2 A_Recoil(-5)*/
        Mine:
        TNT1 A 0 A_JumpIf(user_mine >= 40,"Stopping")
        TNT1 A 0 A_SetUserVar("user_mine",user_mine+5)
        DRAN A 1 A_Stop
        DRAN AAAAA 2 A_SpawnItemEx("DroneThrownMine",0,0,24,random(3,5),0,random(2,5),random(0,359))
        Goto See
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

Actor DroneThrownMine : ThrownMine 15017 {
    Damagetype "Marine"
    States {

    Death:
        LMIN A 1
        LMIN A 1 A_SpawnItem("MineAmmo")
        Stop
    }
}

Actor DroneLiveMine : LiveMine 15018 {
    Damagetype "Marine"
    ReactionTime 120
    -SHOOTABLE
    States {

    Spawn:
        LMIN A 30 A_ChangeFlag(NOBLOCKMAP,0)
        LMIB B 0 A_CountDown
        LMIN B 10 Bright A_ChangeFlag(NOBLOCKMAP,1)
        Loop
    }
}