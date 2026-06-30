# Coin Specification

> Last Updated: 2026-06-30

This document defines the currency system of EconomiCraft.

---

## Overview

EconomiCraft uses an internal currency called:

```
Coins
```

Coins are not physical items.

The following implementations are intentionally forbidden:

```
Gold Ingot
Emerald
Diamond
Custom Coin Item
```

All balances are stored as player data.

---

## Currency Model

Coins exist only as internal values.

Example:

```
Player
└── Wallet
    └── Balance: 1250
```

No inventory slots are required.

No item entities are created.

No resource packs are needed for currency representation.

---

## Data Type

Player balances use:

```
long
```

Maximum value:

```
9,223,372,036,854,775,807
```

This allows:

- Large multiplayer economies
- High-value auctions
- Bank interest systems
- Future expansions
- Cross-mod integrations

Integer overflow should never occur during normal gameplay.

---

## Design Principles

Coins must:

- Remain independent from physical items.
- Support extremely large balances.
- Work across multiple Minecraft versions.
- Remain compatible with other mods.
- Avoid inventory limitations.
- Be fully configurable.

---

## Wallet System

Each player owns a personal wallet.

Responsibilities:

- Store available Coins.
- Handle purchases.
- Receive rewards.
- Process transactions.
- Apply death penalties.

Wallet data is saved with player data.

Wallet balances are always synchronized between client and server.

---

## Bank Integration

Banks provide protected storage.

Rules:

- Banked Coins are never lost on death.
- Wallet Coins remain at risk.
- Players are encouraged to deposit excess wealth.

Example:

```
Wallet: 1000 Coins
Bank: 4000 Coins

Death:

Wallet -> 750 Coins
Bank -> 4000 Coins
```

Only wallet balances are affected.

---

## Death Penalty

Default rules:

- Players lose 25 percent of their wallet balance upon death.
- Bank balances remain completely protected.
- Lost Coins are permanently removed.
- No physical items are dropped.
- keepInventory disables the penalty.

Formula:

```
remaining = balance * 75 / 100
```

Examples:

```
100 Coins
-> 75 Coins

1000 Coins
-> 750 Coins

100000 Coins
-> 75000 Coins
```

The system encourages players to use banks while preserving meaningful risk.

---

## Configuration

Common configuration:

```
[coin]
loseCoinsOnDeath = true
deathLossPercentage = 25
```

Rules:

```
Minimum: 0
Maximum: 100
Default: 25
```

Setting:

```
deathLossPercentage = 0
```

disables coin loss entirely.

---

## Future Features

Potential future additions:

```
dailyIncome
interest
taxation
multipleCurrencies
regionalEconomies
currencyExchange
```

Current policy:

```
Only one currency exists.
```

Additional systems must remain optional.

---

## Shop Integration

Coins are the primary currency for:

- Shop purchases
- Shop sales
- Bank deposits
- Bank withdrawals
- Auction transactions
- Quest rewards

All economic systems should rely on the same currency source.

---

## Commands

Planned commands:

```
/money balance
/money pay
/money set
/money add
/money remove
```

Administrative commands must respect permission levels.

Business logic belongs to manager classes.

---

## Compatibility Rules

Other mods may:

- Sell items using Coins.
- Reward Coins.
- Query balances through APIs.
- Integrate with EconomiCraft managers.

No hardcoded mod dependencies are allowed.

Public APIs should remain stable across minor releases.

---

## Final Principle

> Coins are an internal source of economic value, not physical items.

Players carry risk through their wallets and achieve security through banks.