// == Sentry == \\

Actor SentryBox : CustomInventory 15019 {
  //$Category "Items/Utils"
  //$Title Sentry Box
  //$Sprite ITM2C0
  // IISE1A0
  +COUNTITEM
  +INVENTORY.INVBAR
  Inventory.MaxAmount 2
  Inventory.Icon "IISE1A0" // "SENTA0"
  Inventory.PickupMessage "SentryBox"
  Inventory.PickupSound "pickups/pmedkit"
  States {

  Spawn:
    SENB A -1
    Stop
  Use:
    // TNT1 A 0 A_JumpIf(ACS_ExecuteWithResult(3100,0,0,0) == 1 ,"Nope")
    TNT1 A 1 A_SpawnItemEx("SentryGun",56,0,8,0,0,0,0,1)
    Stop
  // Nope:
	//  TNT1 A 0 A_Print("Can't use this inventory now!")
	//  Fail
  }
}
// Actor SentryBox : SentryBox 15020 {
  // Inventory.Icon "ITM2C0" // "ITM2C0"
//   States {
//   Use:
//     TNT1 A 1 A_SpawnItemEx("SentryGun",56,0,8,0,0,0,0,1)
//     Stop
//   }
// }

Actor RangeSentryBox : SentryBox 15021 {
  //$Category "Items/Utils"
  //$Title RangeSentry Box
  //$Sprite IISE2A0
  // SET2A0
  Inventory.PickupMessage "RangeSentryBox"
  Inventory.Icon "IISE2A0" // "SET2A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("RangeSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor SniperSentryBox : SentryBox 15022 {
  //$Category "Items/Utils"
  //$Title SniperSentry Box
  //$Sprite IISE3A0
  // SET3A0
  Inventory.PickupMessage "SniperSentryBox"
  Inventory.Icon "IISE3A0" // "SET3A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("SniperSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor ShotgunSentryBox : SentryBox 15023 {
  //$Category "Items/Utils"
  //$Title ShotgunSentry Box
  //$Sprite IISE4A0
  // SET4A0
  Inventory.PickupMessage "ShotgunSentryBox"
  Inventory.Icon "IISE4A0" // "SET4A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("ShotgunSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor FlameSentryBox : SentryBox 15024 {
  //$Category "Items/Utils"
  //$Title FlameSentry Box
  //$Sprite IISE5A0
  // SET5A0
  Inventory.PickupMessage "FlameSentryBox"
  Inventory.Icon "IISE5A0" // "SET5A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("FlameSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor PlasmaSentryBox : SentryBox 15025 {
  //$Category "Items/Utils"
  //$Title PlasmaSentry Box
  //$Sprite IISE6A0
  // SET6A0
  Inventory.PickupMessage "PlasmaSentryBox"
  Inventory.Icon "IISE6A0" // "SET6A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("PlasmaSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor RocketSentryBox : SentryBox 15026 {
  //$Category "Items/Utils"
  //$Title RocketSentry Box
  //$Sprite IISE7A0
  // SET7A0
  Inventory.PickupMessage "RocketSentryBox"
  Inventory.Icon "IISE7A0" // "SET7A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("RocketSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor HeavySentryBox : SentryBox 15027 {
  //$Category "Items/Utils"
  //$Title HeavySentry Box
  //$Sprite IISE0A0
  // S3NTA0
  Inventory.PickupMessage "HeavySentryBox"
  Inventory.Icon "IISE0A0" // "S3NTA0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("HeavySentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor RailgunSentryBox : SentryBox 15028 {
  //$Category "Items/Utils"
  //$Title RailgunSentry Box
  //$Sprite IISE8A0
  // SET8A0
  Inventory.PickupMessage "RailgunSentryBox"
  Inventory.Icon "IISE8A0" // "SET8A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("RailgunSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

Actor MissileSentryBox : SentryBox 15029 {
  //$Category "Items/Utils"
  //$Title MissileSentry Box
  //$Sprite IISE9A0
  // SET9A0
  Inventory.PickupMessage "MissileSentryBox"
  Inventory.Icon "IISE9A0" // "SET9A0"
  States {
  Use:
    TNT1 A 1 A_SpawnItemEx("MissileSentryGun",56,0,8,0,0,0,0,1)
    Stop
  }
}

// == Support == \\

// == Droppers == \\

Actor MinerDrone : CustomInventory 15030 {
  +COUNTITEM
  +INVENTORY.INVBAR
  Inventory.MaxAmount 2
  Inventory.Icon "ITM2I0"
  Inventory.PickupMessage "Miner Drone"
  Inventory.PickupSound "drone/see"
  Scale 0.5
  States {

    Spawn:
      DRAN Z -1
      Stop
    Use:
      TNT1 A 0 A_JumpIf(ACS_ExecuteWithResult(3100,0,0,0) == 1 ,"Nope")
      TNT1 A 1 A_SpawnItemEx("MineDrone",48,0,8,0,0,0,0,1)
      Stop
    Nope:
    TNT1 A 0 A_Print("Can't use this inventory now!")
    Fail
  }
}
