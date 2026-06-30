# Economy Specification

> Last Updated: 2026-06-30

This document defines the core economic systems of EconomiCraft.

---

## Overview

EconomiCraft uses a single internal currency:

```
Coins
```

Coins exist only as data and are shared across all economic systems.

The economy is divided into two storage types:

```
Wallet
Bank
```

Each serves a different gameplay purpose.

---

## Player Economy Data

Each player owns an independent economy profile.

Structure:

```
PlayerEconomyData
├── walletBalance : long
├── bankBalance : long
└── lastInterestTick : long
```

Responsibilities:

- Store wallet funds.
- Store bank funds.
- Track interest calculations.
- Apply death penalties.
- Synchronize balances between client and server.

---

## Currency Rules

Coins:

- Exist only as internal data.
- Use the long data type.
- Cannot become physical items.
- Cannot overflow during normal gameplay.
- Are shared across every economic feature.

Negative balances are forbidden.

All transactions must be validated before execution.

---

## Wallet System

The wallet represents money carried by the player.

Purpose:

- Daily transactions.
- Shop purchases.
- Player payments.
- Auction participation.

Rules:

- No interest is generated.
- Coins are vulnerable to death penalties.
- Coins remain immediately accessible.

Wallet balances should encourage active spending rather than long-term storage.

---

## Bank System

The bank represents protected savings.

Purpose:

- Long-term wealth storage.
- Interest generation.
- Death protection.

Rules:

- Bank balances are never lost on death.
- Deposits and withdrawals are processed manually.
- Interest is applied automatically.

Players are encouraged to move excess funds into banks.

---

## Death Penalty

Wallet balances lose 25 percent upon death.

Formula:

```
remaining = balance * 75 / 100
```

Examples:

```
100 Coins
→ 75 Coins

1000 Coins
→ 750 Coins

100000 Coins
→ 75000 Coins
```

Rules:

- Only wallet balances are affected.
- Bank balances remain protected.
- Lost Coins are permanently removed.
- No physical drops are generated.
- keepInventory disables the penalty.

---

## Interest System

Banks generate compound interest.

Default values:

```
Interest Rate:
2%

Interval:
3 Minecraft Days

Tick Count:
72000
```

Formula:

```text
newBalance = currentBalance + (currentBalance × interestRate)
```

Examples:

```
1000 Coins
→ 1020 Coins

1020 Coins
→ 1040 Coins

1040 Coins
→ 1060 Coins
```

Rules:

- Interest uses compound calculations.
- No maximum limit exists.
- Interest applies only to bank balances.
- Wallet balances never generate interest.
- Server owners may configure all values.

---

## Economy Sinks

EconomiCraft removes currency from circulation through fees.

Examples:

```
Auction Fees
NPC Shop Fees
Transaction Taxes
Future Systems
```

Rules:

- Collected fees are permanently destroyed.
- No server treasury exists.
- No redistribution occurs.
- The purpose is economic stabilization.

This system balances unlimited compound interest.

---

## Configuration

Example configuration:

```toml
[economy]
maxWalletBalance = 1000000000
maxBankBalance = 10000000000

[wallet]
deathPenaltyEnabled = true
deathPenaltyPercent = 25

[bank]
interestEnabled = true
interestRate = 2.0
interestIntervalDays = 3
```

All values must remain configurable.

---

## Public API

Planned API methods:

```
getWalletBalance()

getBankBalance()

deposit()

withdraw()

transfer()

applyInterest()

applyDeathPenalty()
```

Public APIs must remain stable across minor releases.

---

## Compatibility Rules

Other mods may:

- Read balances.
- Reward Coins.
- Charge Coins.
- Create custom shops.
- Integrate with bank systems.

No hardcoded dependencies are allowed.

All integrations should rely on public interfaces.

---

## Design Philosophy

EconomiCraft follows these principles:

```
Risk
→ Wallet

Security
→ Bank

Growth
→ Interest

Balance
→ Fees
```

The economy should reward planning while preserving meaningful consequences.

---

## Final Principle

> Wealth should grow through intelligent management, not simply through accumulation.

Players who manage risk and invest through banks should be rewarded over time.