Actor SentryGun 15001 {
  //$Category "Utils/Sentry"
  //$Title SentryGun
  //$Sprite SENTA0
    +FLOORCLIP
    +FRIENDLY
    +MISSILEMORE
    +MISSILEEVENMORE
    +QUICKTORETALIATE
    +NOBLOOD
    +LOOKALLAROUND
    +NEVERRESPAWN
    -NOBLOCKMONST
    +DROPOFF
    +STANDSTILL
    +USESPECIAL
    +SOLID
    -COUNTKILL
    Activation THINGSPEC_ThingActs
    Monster
    Obituary "%o was ventilated by an auto-sentry."
    Health 300
    Radius 16
    Height 56
    Mass 100000
    Speed 0
    MaxTargetRange 1024
    AttackSound "m60/fire"
    DeathSound "sentry/die"
    Decal "BulletChip"
    DamageFactor "Marine", 0
    DamageFactor "Legendary", 0
    DamageFactor "MechStep", 0
    DamageFactor "Mine", 0.0
    RadiusDamageFactor 0.5
    Species "Player"
    var int user_delay;
    var int user_script;
    States {
  
    Spawn:
      SENT A 0 A_JumpIf(user_script == 1,3)
      // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
      TNT1 A 0 A_SetUserVar("user_script",1)
      SENT A 0 A_JumpIf(user_delay >= 65,"Done")
      SENT AAAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
      SENT A 0 A_SetUserVar("user_delay",user_delay+1)
      SENT A 0 A_PlaySound("sentry/beep")
      SENT A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
      Loop
    Unmount:
      TNT1 A 1 A_SpawnItemEx("SentryBox",0,0,16,0,0,4,0)
      TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
      TNT1 A 1 A_NoBlocking
      Stop
    See:
      TNT1 A 0 A_JumpIf(user_script == 1,3)
      // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
      TNT1 A 0 A_SetUserVar("user_script",1)
      SENT A 0 A_JumpIf(user_delay >= 65,"Done")
      SENT AAAAAAAAAAAAAAAA 1 A_Chase
      SENT AAAAAAAAAAAAAAAA 1 A_Chase
      SENT AAAAAAAAAAAAAAAA 1 A_Chase
      SENT AAAAAAAAAAAAAAAA 1 A_Chase
      SENT A 0 A_SetUserVar("user_delay",user_delay+1)
      SENT A 0 A_PlaySound("sentry/beep")
      SENT A 0 A_ClearTarget
      Loop
    Missile:
      SENT A 0 A_PlaySound("sentry/see")
      SENT A 1 A_FaceTarget   
      SENT B 0 A_CustomMissile("MonsterTracer",Random(38,42),0,Random(5,-5),0)
      SENT B 0 A_SpawnItemEx("RifleCasing", 12, 6, 30, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
      SENT B 1 Bright A_CustomBulletAttack(3,3,1,random(1,5)*3,"MarineBulletPuff")
      SENT B 0 A_Jump(16,"See")
      SENT B 1 A_CPosRefire 
      Goto Missile+1
    Done:
      SENT AAA 35 A_PlaySound("sentry/warn")
      SENT A 1 A_Die
      Goto See
    Death:
      TNT1 A 0 A_SpawnItemEx("OrangeParticleSpawner", 0, 0, 0, 0, 0, 0, 0, 128) 
      TNT1 AAA 0 A_CustomMissile("Kaboom3", 0, 0, random(0,360), 2, random(0,360))
      TNT1 AAA 0 A_CustomMissile("SmokeFX2", 0, 0, random(0,360), 2, random(0,360))
      TNT1 AAAA 0 A_SpawnItemEx("Debris",0,0,0,Random(4,-4),Random(4,-4),Random(4,8),0,128)
      TNT1 A 0 A_PlaySound("weapons/rocklx")
      TNT1 A 1 A_SpawnItem("RocketEx",0,32)
      SENT C 0 A_NoBlocking
      SENT C 0 A_Scream
      SENT C 250
      Stop
    }
  }



Actor SentryGun2 : SentryGun 15002 {
  //$Category "Utils/Sentry"
  //$Title SentryGun2
  //$Sprite SENTA0
  States {

  Spawn:
    SENT A 0 A_JumpIf(user_delay >= 65,"Done")
    SENT AAAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SENT A 0 A_SetUserVar("user_delay",user_delay+1)
    SENT A 0 A_PlaySound("sentry/beep")
    SENT A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("SentryBox",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    SENT A 0 A_JumpIf(user_delay >= 65,"Done")
    SENT AAAAAAAAAAAAAAAA 1 A_Chase
    SENT AAAAAAAAAAAAAAAA 1 A_Chase
    SENT AAAAAAAAAAAAAAAA 1 A_Chase
    SENT AAAAAAAAAAAAAAAA 1 A_Chase
    SENT A 0 A_SetUserVar("user_delay",user_delay+1)
    SENT A 0 A_PlaySound("sentry/beep")
    SENT A 0 A_ClearTarget
    Loop
  }
}

Actor RangeSentryGun : SentryGun 15003 {
  //$Category "Utils/Sentry"
  //$Title RangeSentryGun
  //$Sprite SET2A0
  MaxTargetRange 2048
  Health 250
  AttackSound "weapons/arifle"
  States {

  Spawn:
    SET2 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)
    // SET2 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET2 AAAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET2 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET2 A 0 A_PlaySound("sentry/beep")
    SET2 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("RangeSentryBox",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    // SET2 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET2 AAAAAAAAAAAAAAAA 1 A_Chase
    SET2 AAAAAAAAAAAAAAAA 1 A_Chase
    SET2 AAAAAAAAAAAAAAAA 1 A_Chase
    SET2 AAAAAAAAAAAAAAAA 1 A_Chase
    SET2 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET2 A 0 A_PlaySound("sentry/beep")
    SET2 A 0 A_ClearTarget
    Loop
  Missile:
    SET2 A 0 A_PlaySound("sentry/see")
    SET2 A 10 A_FaceTarget   
    SET2 B 0 A_SpawnItemEx("RifleCasing", 12, 6, 30, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET2 B 2 Bright A_CustomBulletAttack(1,1,1,random(1,5)*2,"MarineBulletPuff")
    SET2 C 2 A_FaceTarget
    SET2 B 0 A_SpawnItemEx("RifleCasing", 12, 6, 30, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET2 B 2 Bright A_CustomBulletAttack(1,1,1,random(1,5)*2,"MarineBulletPuff")
    SET2 C 2 A_FaceTarget
    SET2 B 0 A_SpawnItemEx("RifleCasing", 12, 6, 30, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET2 B 2 Bright A_CustomBulletAttack(1,1,1,random(1,5)*2,"MarineBulletPuff")
    SET2 C 2 A_FaceTarget	
    SET2 A 0 A_Jump(16,"See")
    SET2 A 1 A_CPosRefire 
    Goto Missile+1
  Done:
    SET2 AAA 35 A_PlaySound("sentry/warn")
    SET2 A 1 A_Die
    Goto See
  }
}

Actor SniperSentryGun : SentryGun 15004 {
  //$Category "Utils/Sentry"
  //$Title SniperSentryGun
  //$Sprite SET3A0
  MaxTargetRange 3072
  AttackSound "sniper/fire"
  States {

  Spawn:
    SET3 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET3 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET3 AAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET3 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET3 A 0 A_PlaySound("sentry/beep")
    SET3 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("SniperSentryBox",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1) 
    SET3 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET3 AAAAAAAAAAAAAAAA 1 A_Chase
    SET3 AAAAAAAAAAAAAAAA 1 A_Chase
    SET3 AAAAAAAAAAAAAAAA 1 A_Chase
    SET3 AAAAAAAAAAAAAAAA 1 A_Chase
    SET3 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET3 A 0 A_PlaySound("sentry/beep")
    SET3 A 0 A_ClearTarget
    Loop
  Missile:
    SET3 A 0 A_PlaySound("sentry/see")
    SET3 AAA 4 A_FaceTarget
    SET3 B 6 Bright A_CustomBulletAttack(1,1,1,random(1,5)*20,"MarineBulletPuff")
    SET3 CCAA 2 A_FaceTarget
    TNT1 A 0 A_SpawnItemEx("RifleCasing", 12, 6, 30, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET3 A 10 A_PlaySound("sniper/clip")
    SET3 AAA 3 A_FaceTarget
    SET3 A 1 A_CPosRefire 
    Goto Missile+1
  Done:
    SET3 AAA 35 A_PlaySound("sentry/warn")
    SET3 A 1 A_Die
    Goto See
  }
}

Actor ShotgunSentryGun : SentryGun 15005 {
  //$Category "Utils/Sentry"
  //$Title ShotgunSentryGun
  //$Sprite SET4A0
  AttackSound ""
  States {

  Spawn:
    SET4 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    SET4 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET4 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET4 AAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET4 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET4 A 0 A_PlaySound("sentry/beep")
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("ShotgunSentryBox",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET4 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET4 AAAAAAAAAAAAAAAA 1 A_Chase
    SET4 AAAAAAAAAAAAAAAA 1 A_Chase
    SET4 AAAAAAAAAAAAAAAA 1 A_Chase
    SET4 AAAAAAAAAAAAAAAA 1 A_Chase
    SET4 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET4 A 0 A_PlaySound("sentry/beep")
    SET4 A 0 A_ClearTarget
    Loop
  Missile:
    SET4 A 0 A_PlaySound("Turret/sight")
    SET4 A 1 A_Jump(256,"AssautShotgun","DoubleShotgun","QuadShotgun")
    Goto See
  AssautShotgun:
    SET4 A 5 A_FaceTarget
    TNT1 A 0 A_PlaySound("asg/fire")
    TNT1 A 0 A_SpawnItemEx("ShellCasing", -8, 7, 30, 4, 0, (0.1)*Random(30, 40), Random(-80, -90), 128)
    TNT1 AAAA 0 Bright A_CustomMissile("MonsterTracer2",Random(28,34),0,Random(6,-6),0)
    SET4 E 13 Bright A_CustomBulletAttack(22.5,0,5,4,"MarineBulletPuff")
    TNT1 A 0 A_PlaySound("asg/fire")
    TNT1 A 0 A_SpawnItemEx("ShellCasing", -8, 7, 30, 4, 0, (0.1)*Random(30, 40), Random(-80, -90), 128)
    TNT1 AAAA 0 Bright A_CustomMissile("MonsterTracer2",Random(28,34),0,Random(6,-6),0)
    SET4 F 13 Bright A_CustomBulletAttack(22.5,0,5,4,"MarineBulletPuff")
    TNT1 A 0 A_PlaySound("asg/fire")
    TNT1 A 0 A_SpawnItemEx("ShellCasing", -8, 7, 30, 4, 0, (0.1)*Random(30, 40), Random(-80, -90), 128)
    TNT1 AAAA 0 Bright A_CustomMissile("MonsterTracer2",Random(28,34),0,Random(6,-6),0)
    SET4 G 13 Bright A_CustomBulletAttack(22.5,0,5,4,"MarineBulletPuff")
    TNT1 A 0 A_PlaySound("asg/fire")
    TNT1 A 0 A_SpawnItemEx("ShellCasing", -8, 7, 30, 4, 0, (0.1)*Random(30, 40), Random(-80, -90), 128)
    TNT1 AAAA 0 Bright A_CustomMissile("MonsterTracer2",Random(28,34),0,Random(6,-6),0)
    SET4 H 13 Bright A_CustomBulletAttack(22.5,0,5,4,"MarineBulletPuff")	
    SET4 A 6 A_CposRefire
    Goto Missile+1
  DoubleShotgun:
    SET4 A 5 A_FaceTarget
    TNT1 A 0 A_PlaySound("weapons/sshotf")
    TNT1 AAAAAAAA 0 Bright A_CustomMissile("MonsterTracer2",Random(28,34),0,Random(6,-6),0)
    SET4 B 5 Bright A_CustomBulletAttack(13.8,9.6,10,Random(1,4)*3,"MarineBulletPuff")
    SET4 A 15 A_FaceTarget
    SET4 A 6 A_PlaySound("weapons/sawedopen")
    SET4 A 0 A_SpawnItemEx("ShellCasing", -10, 6, 36, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET4 A 1 A_SpawnItemEx("ShellCasing", -10, 6, 36, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET4 A 6 A_PlaySound("weapons/shellslide")
    SET4 A 6 A_PlaySound("weapons/sawedclose")
    SET4 A 6 A_CposRefire
    Goto Missile+1
  QuadShotgun:
    SET4 A 5 A_FaceTarget
    TNT1 A 0 A_PlaySound("weapons/qsgfire")
    TNT1 AAAAAAAAAAAA 0 Bright A_CustomMissile("MonsterTracer2",Random(28,34),0,Random(6,-6),0)
    SET4 C 5 Bright A_CustomBulletAttack(15.4,10.6,24,Random(1,4)*3,"MarineBulletPuff")
    SET4 A 25 A_FaceTarget
    TNT1 A 0 A_PlaySound("weapons/qsgopen")	
    SET4 A 15 A_FaceTarget
    SET4 A 0 A_SpawnItemEx("ShellCasing", -8, 6, 36, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET4 A 1 A_SpawnItemEx("ShellCasing", -8, 6, 36, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET4 A 0 A_SpawnItemEx("ShellCasing", -8, 6, 36, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET4 A 2 A_SpawnItemEx("ShellCasing", -8, 6, 36, Random(2, 6), 0, Random(1, 3), Random(-80, -90), 128)
    SET4 A 12 A_PlaySound("weapons/qsgshellslide")
    SET4 A 8
    SET4 A 12 A_PlaySound("weapons/qsgshellslide")
    SET4 A 8
    SET4 A 10 A_PlaySound("weapons/qsgclose")
    SET4 A 2 A_CposRefire
    Goto Missile+1
  Done:
    SET4 AAA 35 A_PlaySound("sentry/warn")
    SET4 A 1 A_Die
    Goto See
  }
}

Actor FlameSentryGun : SentryGun 15006 {
  //$Category "Utils/Sentry"
  //$Title FlameSentryGun
  //$Sprite SET5A0
  MaxTargetRange 354
  Health 400
  AttackSound ""
  States {

  Spawn:
    SET5 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET5 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET5 AAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET5 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET5 A 0 A_PlaySound("sentry/beep")
    Loop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET5 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET5 AAAAAAAAAAAAAAAA 1 A_Chase
    SET5 AAAAAAAAAAAAAAAA 1 A_Chase
    SET5 AAAAAAAAAAAAAAAA 1 A_Chase
    SET5 AAAAAAAAAAAAAAAA 1 A_Chase
    SET5 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET5 A 0 A_PlaySound("sentry/beep")
    SET5 A 0 A_ClearTarget
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("FlameSentryBox",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  Missile:
    SET5 A 0 A_PlaySound("sentry/see")
    SET5 A 1 A_JumpIfCloser(455,1)
    Goto See
    SET5 AA 2 A_FaceTarget
    SET5 A 3 A_PlayWeaponSound("hectebus/flameready")
    SET5 AA 4 A_FaceTarget
    SET5 B 0 A_PlaySound("monsters/fatsofire")
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget	
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget
    SET5 B 3 Bright A_CustomMissile("SentryFlame",46,0,random(-1,1))
    SET5 A 2 A_FaceTarget	
    SET5 A 4 A_CPosRefire 
    Goto Missile+1
  Done:
    SET5 AAA 35 A_PlaySound("sentry/warn")
    SET5 A 1 A_Die
    Goto See
  }
}

Actor SentryFlame : PoisonSoulCloud 15007 { 
    Radius 10
    Height 10
    Scale 0.55
    Speed 14
    DamageType "Marine"
    Species "Player"
    PROJECTILE
    +THRUSPECIES
    -THRUActorS
    -SKYEXPLODE
    Decal Scorch
    States {
 
    Spawn: 
        FIR1 LKJIHGFEDCB 2 Bright A_Explode(5,68) 
    Death:
        FIR1 AA 2 Bright A_FadeOut(0.25)
        Stop
        } 
}

Actor PlasmaSentryGun : SentryGun 15008 {
  //$Category "Utils/Sentry"
  //$Title PlasmaSentryGun
  //$Sprite SET6A0
  AttackSound ""
  MaxTargetRange 1536
  States {

  Spawn:
    SET6 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET6 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET6 AAAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET6 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET6 A 0 A_PlaySound("sentry/beep")
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("PlasmaSentryBox",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET6 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET6 AAAAAAAAAAAAAAAA 1 A_Chase
    SET6 AAAAAAAAAAAAAAAA 1 A_Chase
    SET6 AAAAAAAAAAAAAAAA 1 A_Chase
    SET6 AAAAAAAAAAAAAAAA 1 A_Chase
    SET6 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET6 A 0 A_PlaySound("sentry/beep")
    SET6 A 0 A_ClearTarget
    Loop
  Missile:
    SET6 A 0 A_PlaySound("sentry/see")
    SET6 A 1 A_FaceTarget 
    SET6 B 0 A_PlayWeaponSound("weapons/hrfire")
    SET6 B 2 Bright A_CustomMissile("NewPlasmaBall",40,0,random(-3,3))
    SET6 B 0 A_Jump(32,"See")
    SET6 B 1 A_CPosRefire 
    Goto Missile+2
  Done:
    SET6 AAA 35 A_PlaySound("sentry/warn")
    SET6 A 1 A_Die
    Goto See
  }
}

Actor RocketSentryGun : SentryGun 15009 {
  //$Category "Utils/Sentry"
  //$Title RocketSentryGun
  //$Sprite SET7A0
  AttackSound ""
  Health 500
  MaxTargetRange 2048
  States {

  Spawn:
    SET7 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET7 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET7 AAAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET7 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET7 A 0 A_PlaySound("sentry/beep")
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("RocketSentryBox",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    SET7 A 0 A_JumpIf(user_delay >= 65,"Done")
    SET7 AAAAAAAAAAAAAAAA 1 A_Chase
    SET7 AAAAAAAAAAAAAAAA 1 A_Chase
    SET7 AAAAAAAAAAAAAAAA 1 A_Chase
    SET7 AAAAAAAAAAAAAAAA 1 A_Chase
    SET7 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET7 A 0 A_PlaySound("sentry/beep")
    SET7 A 0 A_ClearTarget
    Loop
  Missile:
    SET7 A 0 A_PlaySound("sentry/see")
    SET7 A 5 A_FaceTarget
    SET7 B 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 2 A_FaceTarget
    SET7 C 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 2 A_FaceTarget
    SET7 D 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 2 A_FaceTarget
    SET7 E 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 2 A_FaceTarget
    SET7 F 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 2 A_FaceTarget
    SET7 G 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 2 A_FaceTarget
    SET7 H 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 2 A_FaceTarget
    SET7 I 4 Bright A_CustomMissile("MiniRocket",random(24,34),0,random(-6,6))
    SET7 A 6 A_CPosRefire 
    Goto Missile+1
  Done:
    SET7 AAA 35 A_PlaySound("sentry/warn")
    SET7 A 1 A_Die
    Goto See	
  }
}


Actor MiniRocket {
  Projectile
  Damage 5
  Height 5
  Radius 6
  Damagetype "Marine"
  Species "Player"
  +THRUSPECIES
  //+NOTIMEFREEZE
  Speed 48
  SeeSound ""
  DeathSound "MiniRocketExpl"
  States {

  Spawn:
      MICR A 1 Bright A_SpawnItemEx("MissileTrail",0,0,0)
      TNT1 A 0 A_PlaySound("MiniRocketFly",0,1.0,0)
      Loop
  Death:
      TNT1 A 0
      TNT1 A 0 A_SpawnItemEx("OrangeParticleSpawner", 0, 0, 1, 0, 0, 0, 0, 128)
      TNT1 AAAA 0 A_CustomMissile("Kaboom9", 0, 0, random(0,360), 2, random(0,360))
      TNT1 AAAA 0 A_CustomMissile("SmokeFX4", 0, 0, random(0,360), 2, random(0,360))
      TNT1 A 0 A_Explode(10,30)
      TNT1 A 0 A_SetTranslucent(0.85,1)
      H2BL JKLMN 4 Bright
      Stop
  }
}

Actor HeavySentryGun : SentryGun 15010 {
  //$Category "Utils/Sentry"
  //$Title HeavySentryGun
  //$Sprite S3NTA0
  Health 650
  MaxTargetRange 3072
  DamageFactor 0.75
  RadiusDamageFactor 0.8
  AttackSound ""
  Scale 1.25
  var int user_slot;
  States {

  Spawn:
    S3NT A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    TNT1 A 0
    TNT1 A 0 A_StopSoundEx("SoundSlot6")
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)
    TNT1 A 0 A_JumpIf(user_slot == 1,4)
    TNT1 AA 0 A_SpawnItemEx("UtilityActorSlot",0,0,0,0,0,0,0,SXF_NOCHECKPOSITION|SXF_SETMASTER)
    TNT1 A 0 A_SetUserVar("user_slot",1)
    S3NT A 0 A_JumpIf(user_delay >= 135,"Done")
    S3NT AAAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    S3NT A 0 A_SetUserVar("user_delay",user_delay+1)
    S3NT A 0 A_PlaySound("sentry/beep")
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("HeavySentryGun",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0
    TNT1 A 0 A_StopSoundEx("SoundSlot6")
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)
    TNT1 A 0 A_JumpIf(user_slot == 1,4)
    TNT1 A 0 A_SpawnItemEx("UtilityActorSlot",0,0,0,0,0,0,0,SXF_NOCHECKPOSITION|SXF_SETMASTER)
    TNT1 A 0 A_SetUserVar("user_slot",1)
    S3NT A 0 A_JumpIf(user_delay >= 135,"Done")
    S3NT AAAAAAAAAAAAAAAA 1 A_Chase
    S3NT AAAAAAAAAAAAAAAA 1 A_Chase
    S3NT AAAAAAAAAAAAAAAA 1 A_Chase
    S3NT AAAAAAAAAAAAAAAA 1 A_Chase
    S3NT A 0 A_SetUserVar("user_delay",user_delay+1)
    S3NT A 0 A_PlaySound("sentry/beep")
    S3NT A 0 A_ClearTarget
    Loop
  Missile:
    S3NT A 0 A_PlaySound("sentry/see")
    S3NT A 1 A_FaceTarget 
    S3NT A 0 A_SpawnItemEx("RifleCasing",12,6,30,Random(2,6),0,Random(1,3),Random(-80,-90),128)
    S3NT A 0 A_PlaySoundEx("hminigun/fire2","SoundSlot6",1)
    S3NT A 0 A_SpawnItemEx("TurretFlash",35,-3,44)
    S3NT A 0 A_SpawnItemEx("TurretFlash",35,3,44)
    S3NT A 0 A_CustomMissile("HeavySentryGunProj",46,-8,random(-2,2))
    S3NT A 1 Bright A_CustomMissile("HeavySentryGunProj",46,8,random(-2,2))
    S3NT A 0 A_Jump(4,"See")
    S3NT A 1 A_CPosRefire 
    Goto Missile+1
  Done:
    TNT1 A 0
    TNT1 A 0 A_StopSoundEx("SoundSlot6")
    S3NT AAA 35 A_PlaySound("sentry/warn")
    S3NT A 1 A_Die
    Goto See
  Death:
    TNT1 A 0
    TNT1 A 0 A_StopSoundEx("SoundSlot6")
    TNT1 A 0 A_SpawnItemEx("OrangeParticleSpawner", 0, 0, 0, 0, 0, 0, 0, 128) 
    TNT1 AAA 0 A_CustomMissile("Kaboom3", 0, 0, random(0,360), 2, random(0,360))
    TNT1 AAA 0 A_CustomMissile("SmokeFX2", 0, 0, random(0,360), 2, random(0,360))
    TNT1 AAAA 0 A_SpawnItemEx("Debris",0,0,0,Random(4,-4),Random(4,-4),Random(4,8),0,128)
    TNT1 A 0 A_PlaySound("weapons/rocklx")
    TNT1 A 1 A_SpawnItem("RocketEx",0,32)
    SENT C 0 A_KillChildren
    SENT C 0 A_NoBlocking
    SENT C 0 A_Scream
    SENT C 250
    Stop
  }
}

Actor HeavySentryGunProj : FastProjectile 15011 {
  Radius 2
  Height 0
  Speed 220
  Damage 3
  RenderStyle Add
  DamageType "Marine"
  Alpha 1.0
  Decal "BulletChip"
  Scale 1.0
  +MISSILE
  +RANDOMIZE
  +BLOODSPLATTER
  +NODAMAGETHRUST
  States {

   Spawn: 
    TNT1 A 0
    TNT1 A 0 ThrustThingZ(0,random(-8,8),0,1)
   Fly:
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail2",(2 *momx)/-35.0,-(2*momy)/-35.0,2+(2*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail3",(4 *momx)/-35.0,-(4*momy)/-35.0,2+(4*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail4",(6 *momx)/-35.0,-(6*momy)/-35.0,2+(6*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail5",(8 *momx)/-35.0,-(8*momy)/-35.0,2+(8*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail6",(10*momx)/-35.0,-(10*momy)/-35.0,2+(10*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail7",(12*momx)/-35.0,-(12*momy)/-35.0,2+(12*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail8",(14*momx)/-35.0,-(14*momy)/-35.0,2+(14*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail9",(16*momx)/-35.0,-(16*momy)/-35.0,2+(16*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail10",(18*momx)/-35.0,-(18*momy)/-35.0,2+(18*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail11",(20*momx)/-35.0,-(20*momy)/-35.0,2+(20*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    TNT1 A 0 A_SpawnItemEx("UACTankDefaultTurretProjTrail12",(22*momx)/-35.0,-(22*momy)/-35.0,2+(22*momz)/-35.0,0,0,0, 0,SXF_ABSOLUTEANGLE)
    MG74 A 1 Bright
    Loop
   Death:
    TNT1 A 0 A_SpawnItem("BulletPuff")
    TNT1 A 1
    Stop
  }
}

Actor RailgunSentryGun : SentryGun 15012 {
  //$Category "Utils/Sentry"
  //$Title RailgunSentryGun
  //$Sprite SET8A0
  Health 1000
  MaxTargetRange 3072
  DamageFactor 0.75
  RadiusDamageFactor 0.8
  AttackSound ""
  Scale 1.5
  var int user_slot;
  States {

  Spawn:
    SET8 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    TNT1 A 0 A_JumpIf(user_slot == 1,4)
    TNT1 AA 0 A_SpawnItemEx("UtilityActorSlot",0,0,0,0,0,0,0,SXF_NOCHECKPOSITION|SXF_SETMASTER)
    TNT1 A 0 A_SetUserVar("user_slot",1)
    SET8 A 0 A_JumpIf(user_delay >= 135,"Done")
    SET8 AAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET8 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET8 A 0 A_PlaySound("sentry/beep")
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("RailgunSentryGun",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1) 
    TNT1 A 0 A_JumpIf(user_slot == 1,4)
    TNT1 AA 0 A_SpawnItemEx("UtilityActorSlot",0,0,0,0,0,0,0,SXF_NOCHECKPOSITION|SXF_SETMASTER)
    TNT1 A 0 A_SetUserVar("user_slot",1)
    SET8 A 0 A_JumpIf(user_delay >= 135,"Done")
    SET8 AAAAAAAAAAAAAAAA 1 A_Chase
    SET8 AAAAAAAAAAAAAAAA 1 A_Chase
    SET8 AAAAAAAAAAAAAAAA 1 A_Chase
    SET8 AAAAAAAAAAAAAAAA 1 A_Chase
    SET8 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET8 A 0 A_PlaySound("sentry/beep")
    SET8 A 0 A_ClearTarget
    Loop
  Missile:
    SET8 A 0 A_PlaySound("sentry/see")
    SET8 A 4 A_FaceTarget
    SET8 A 0 A_PlayWeaponSound("weapons/rgcharge")
    SET8 AAAAAAAAAA 5 Bright A_FaceTarget
    SET8 B 0 A_PlayWeaponSound("monsters/darkcyberrail")
    SET8 B 10 Bright A_CustomMissile("MRailgunProj",60,0,random(-1,1))
    SET8 AA 3 A_FaceTarget
    SET8 A 1 A_CPosRefire 
    Goto Missile+2
  Done:
    SET8 AAA 35 A_PlaySound("sentry/warn")
    SET8 A 1 A_Die
    Goto See
  Death:
    TNT1 A 0 A_SpawnItemEx("OrangeParticleSpawner", 0, 0, 0, 0, 0, 0, 0, 128) 
    TNT1 AAA 0 A_CustomMissile("Kaboom3", 0, 0, random(0,360), 2, random(0,360))
    TNT1 AAA 0 A_CustomMissile("SmokeFX2", 0, 0, random(0,360), 2, random(0,360))
    TNT1 AAAA 0 A_SpawnItemEx("Debris",0,0,0,Random(4,-4),Random(4,-4),Random(4,8),0,128)
    TNT1 A 0 A_PlaySound("weapons/rocklx")
    TNT1 A 1 A_SpawnItem("RocketEx",0,32)
    SENT C 0 A_KillChildren
    SENT C 0 A_NoBlocking
    SENT C 0 A_Scream
    SENT C 250
    Stop	
  }
}

Actor MRailgunProj : FastProjectile 15013 {
  Radius 6
  Height 6
  Speed 300
  Damage (Random(120,150))
  DeathSound "cyberrail/impact"
  MissileType "RailgunTrail"
  Damagetype "Marine"
  +RIPPER
  +THRUSPECIES
  +EXTREMEDEATH
  +BLOODLESSIMPACT
  States {

  Spawn:
      TNT1 A 1
      Loop
  Death:
      TNT1 A 0
      TNT1 AA 0 A_CustomMissile("SmokeFX3",0,0,random(0,360),2,random(0,360))
      TNT1 AAAA 0 A_CustomMissile("Kaboom24",0,0,random(0,360),2,random(0,360))	
      TNT1 A 0 A_Explode(32,256,0)
      TNT1 A 1 A_SpawnItem("RailgunImpact")
      Stop
    }
}

Actor MissileSentryGun : SentryGun 15014 {
  //$Category "Utils/Sentry"
  //$Title MissileSentryGun
  //$Sprite SET9A0
  Health 2200
  Scale 1.5
  MaxTargetRange 6144
  DamageFactor 0.75
  RadiusDamageFactor 0.25
  AttackSound ""
  var int user_slot;
  States {

  Spawn:
    SET9 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    TNT1 A 0 A_JumpIf(user_slot == 1,9)
    TNT1 AAAAAAA 0 A_SpawnItemEx("UtilityActorSlot",0,0,0,0,0,0,0,SXF_NOCHECKPOSITION|SXF_SETMASTER)
    TNT1 A 0 A_SetUserVar("user_slot",1)
    SET9 A 0 A_JumpIf(user_delay >= 270,"Done")
    SET9 AAAAAAAAAAAAAAA 4 A_LookEx(LOF_NOSOUNDCHECK|LOF_NOSEESOUND)
    SET9 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET9 A 0 A_PlaySound("sentry/beep")
    SET9 A 0 Thing_SetSpecial(0,226,2994,0,0) // Unmount on use
    Loop
  Unmount:
    TNT1 A 1 A_SpawnItemEx("MissileSentryGun",0,0,16,0,0,4,0)
    TNT1 A 1 A_ChangeFlag("USESPECIAL", 0)
    TNT1 A 1 A_NoBlocking
    Stop
  See:
    TNT1 A 0 A_JumpIf(user_script == 1,3)
    // TNT1 A 0 ACS_ExecuteAlways(3601,0,0,0,0)
    TNT1 A 0 A_SetUserVar("user_script",1)  
    TNT1 A 0 A_JumpIf(user_slot == 1,9)
    TNT1 AAAAAAA 0 A_SpawnItemEx("UtilityActorSlot",0,0,0,0,0,0,0,SXF_NOCHECKPOSITION|SXF_SETMASTER)
    TNT1 A 0 A_SetUserVar("user_slot",1)
    SET9 A 0 A_JumpIf(user_delay >= 270,"Done")
    SET9 AAAAAAAAAAAAAAAA 1 A_Chase
    SET9 AAAAAAAAAAAAAAAA 1 A_Chase
    SET9 AAAAAAAAAAAAAAAA 1 A_Chase
    SET9 AAAAAAAAAAAAAAAA 1 A_Chase
    SET9 A 0 A_SetUserVar("user_delay",user_delay+1)
    SET9 A 0 A_PlaySound("sentry/beep")
    SET9 A 0 A_ClearTarget
    Loop	
  Missile:
    SET9 A 0 A_PlaySound("sentry/see")
    SET9 AA 6 A_FaceTarget
    SET9 A 0 A_PlayWeaponSound("mrl/fire")
    SET9 A 3 Bright A_CustomMissile("MissileSentryGunRocket",random(60,100),random(-16,16))
    SET9 A 2 A_FaceTarget
    SET9 A 1 A_CPosRefire 
    Goto Missile+3
  Done:
    SET9 AAA 35 A_PlaySound("sentry/warn")
    SET9 A 1 A_Die
    Goto See
  Death:
    SET9 AAAAAA 2 Bright A_CustomMissile("Kaboom", random(10,60), random(30,-30), random(0,360), 2, random(0,360))
    SET9 AAAAAA 2 Bright A_CustomMissile("Kaboom", random(10,60), random(30,-30), random(0,360), 2, random(0,360))	
    TNT1 A 0 A_PlaySound("weapons/rocklx")
    TNT1 AAA 0 A_SpawnItemEx("Debris",0,0,0,Random(4,-4),Random(4,-4),Random(4,8),0,128)
    TNT1 A 0 A_KillChildren
    TNT1 A 0 A_NoBlocking
    TNT1 A 0 A_Scream
    TNT1 A 1
    Stop
  }
}

Actor MissileSentryGunRocket {
  Radius 11
  Height 8
  Projectile
  Speed 86
  Damage 10
  Obituary "%o ate %k's Rocket."
  +RANDOMIZE
  +DEHEXPLOSION
  +SKYEXPLODE
  +MTHRUSPECIES
  +NOTIMEFREEZE
  DeathSound "weapons/rocklx"
  Damagetype "Marine"
  States {

  Spawn:
      MIS7 A 0 A_CustomMissile("RocketSmoke",Random(4,6),Random(-2,2)) 
      MIS7 AAA 0 A_CustomMissile("NewRockeParticleTrail",Random(4,6),Random(-2,2)) 
      MIS7 A 0 A_ChangeVelocity(1,0.5*random(-3,3),0.5*random(-2,2),CVF_RELATIVE)
      MIS7 A 1 Bright A_PlaySoundEx("rpg/fly","SoundSlot7",1)
      Loop
  Death:
      MIS7 A 0 A_StopSoundEx("SoundSlot7")
      TNT1 AAAA 0 A_SpawnItemEx("Debris",0,0,0,Random(4,-4),Random(4,-4),Random(4,8),0,128)
      TNT1 AAA 0 A_SpawnItemEx("OrangeParticleSpawner",0,0,0,0,0,0,0,128)  
      TNT1 AAA 0 A_CustomMissile("SmokeFX3",0,0,random(0,360),2,random(0,360))
      TNT1 AAAAAA 0 A_CustomMissile("Kaboom",0,0,random(0,360),2,random(0,360))
      MISL B 4 Bright A_Explode(64,158,0)
      MISL CD 4 Bright A_SetTranslucent(0.75,1)
      Stop
  }
}