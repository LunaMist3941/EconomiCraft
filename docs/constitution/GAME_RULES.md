# GAME_RULES

Tier: 1 (Constitution)
Status: Stable
Depends On:
- DESIGN_PHILOSOPHY.md
- DOCS_RULES.md
- UI_GUIDELINES.md

---

# Purpose

This document defines the core gameplay and economic principles of EconomiCraft.

All Tier 2 and lower documents must follow these rules.

Examples:

- BANK.md
- SHOP.md
- AUCTION.md
- TEAM.md
- NPC.md

This document establishes:

- Economic philosophy
- Currency behavior
- Banking principles
- Team systems
- Market rules
- Expansion compatibility

UI behavior must be defined in `UI_GUIDELINES.md`.

---

# 1. Economic Philosophy

EconomiCraft follows these principles:

- Convenience First
- Vanilla Survival Compatibility
- Hypixel SkyBlock Inspired, Not Replicated
- Player-Driven Economy
- Sustainable Coin Sinks
- Long-Term Server Stability
- Addon Extensibility

The project prioritizes improving gameplay without breaking Minecraft immersion.

---

# 2. Currency Rules

## 2.1 Currency Unit

The official currency is:

```text
Coin
````

Only integer values are supported.

Fractional coins are not allowed.

---

## 2.2 Negative Balances

Core EconomiCraft does not support negative balances.

Rules:

* Wallets cannot drop below zero.
* Shop purchases require sufficient funds.
* Auctions require sufficient funds.
* Bank accounts only accumulate positive interest.

Advanced financial systems are intentionally excluded from the Core module.

Future support may be provided through:

```text
EconomiCraft MoneyPlus
```

---

## 2.3 Administrative Coin Management

Authorized administrators may use:

```text
/coin give <player> <amount>

/coin remove <player> <amount>

/coin history <player>
```

All administrative actions must be recorded in transaction history.

---

## 3. Bank Rules

## 3.1 Interest Rate

Default interest rate:

```text
3% per cycle
```

The system uses compound interest.

Servers may adjust this value through configuration.

---

## 3.2 Deposit and Withdrawal

Supported options:

```text
ALL
50%
25%
Custom
```

Custom amounts use Sign GUI input.

---

## 3.3 History

Visible history:

```text
15 entries
```

Internal storage:

```text
150 entries
```

Older records may be discarded automatically.

---

## 3.4 Fees

Default rules:

```text
Deposit Fee: 0%
Withdrawal Fee: 0%
```

Future systems may introduce configurable fees.

---

# 4. Team Rules

## 4.1 Team Size

Default maximum members:

```text
5 Players
```

This limit is inspired by the default maximum size of a Hypixel Party.

---

## 4.2 Team Bank

TeamBank exists independently from personal banks.

Rules:

* Separate balance
* Separate history
* Separate permissions

TeamBank administration is restricted to authorized members.

---

## 4.3 Team Disbanding

When a team is deleted:

```text
TeamBank
↓
Owner Bank
```

All transferred funds must be recorded in history logs.

---

## 4.4 Team Chat

Supported commands:

```text
/teamchat

/teamchat <message>
```

Team chat behavior follows traditional Minecraft conventions.

---

## 4.5 Team Members Command

Official commands:

```text
/tm

/team members
```

The command displays:

* Online members
* Offline members

---

## 4.6 Team Identity

Team names may use configurable colors.

The selected approach is:

```text
Colored Team Name
```

Player names themselves remain unchanged.

Example:

```text
[Emerald Guild] Player
```

---

# 5. TeamBank Bonus Rules

Two official bonus systems exist.

---

## 5.1 Small Team Mode

Formula:

```text
+3% per member
```

Examples:

```text
1 Member = 3%
3 Members = 9%
5 Members = 15%
```

---

## 5.2 Large Team Mode

Formula:

```text
First Member: +3%
Additional Members: +1%
```

Examples:

```text
1 Member = 3%
2 Members = 4%
3 Members = 5%
5 Members = 7%
```

Servers may select either mode.

---

# 6. Shop Rules

EconomiCraft Shop follows Bazaar-style principles.

---

## 6.1 Supported Items

Shop is intended for:

* Blocks
* Resources
* Farming materials
* Bulk items

Examples:

```text
Cobblestone
Iron
Coal
Wheat
Logs
```

---

## 6.2 Unsupported Items

Shop must not manage:

* Tools
* Armor
* Rare equipment
* Enchanted books
* Unique items

These belong to the Auction system.

---

## 6.3 Fees

Default values:

```text
Buy Fee: 5%
Sell Fee: 10%
```

Both values are configurable.

Administrative commands may also modify them.

---

# 7. Auction Rules

Auction is intended for valuable, individual items.

---

## 7.1 Supported Items

Examples:

* Tools
* Armor
* Enchanted Books
* Rare Items
* Custom Equipment

Rare item determination uses:

```text
Config Lists
```

Servers may customize these lists.

---

## 7.2 Sale Types

Supported options:

```text
BIN
Auction
```

Players choose the type during listing creation.

---

## 7.3 Listing Fees

Default listing fee:

```text
2%
```

The fee is calculated from the selected price.

---

## 7.4 Wallet Rules

Auction always uses:

```text
Personal Wallet Only
```

TeamBank integration is intentionally excluded.

---

## 7.5 Listing Capacity

Base limits may increase according to team size.

Additional members provide extra listing slots.

---

## 7.6 Expiration Rules

Expired items require manual retrieval.

Protection period:

```text
2 Minutes
```

If retrieval fails:

```text
Listings Storage
```

Players must free inventory space before claiming items.

---

# 8. NPC Rules

NPC systems belong to the Core module.

They are not distributed as separate addons.

---

## 8.1 Interaction

Talking to an NPC opens the same interface as:

```text
/menu
```

or other corresponding commands.

---

## 8.2 Configuration

NPC behavior is controlled through:

* Config files
* Profiles

This enables:

* RPG servers
* Hub servers
* Custom experiences

---

# 9. Future Expansion Rules

EconomiCraft is designed for long-term expansion.

Planned systems include:

```text
EconomiCraft Storage
EconomiCraft TeamPlus
EconomiCraft MoneyPlus
Quest Systems
Mail Systems
Guild Systems
```

Core systems must remain compatible with future additions.

---

# 10. EconomiCraft MoneyPlus Compatibility

Core intentionally excludes advanced financial mechanics.

These features belong to:

```text
EconomiCraft MoneyPlus
```

---

## 10.1 Planned Features

Examples:

* Debt Systems
* Loans
* Taxes
* Government Accounts
* Business Accounts
* Credit Systems
* Automatic Repayment

---

## 10.2 Core Requirements

Core must support future integration through:

### Generic Transaction Types

Examples:

```text
DEPOSIT
WITHDRAW
SHOP_BUY
SHOP_SELL
AUCTION_BUY
AUCTION_SELL

LOAN_RECEIVE
LOAN_REPAY
TAX_PAYMENT
GOVERNMENT_TRANSFER
```

### Flexible History Structures

Recommended fields:

```text
Player
Amount
TransactionType
Source
Target
Timestamp
Metadata
```

### Event-Based Integration

Examples:

```text
BeforeCoinChangeEvent
CoinChangeEvent
AfterCoinChangeEvent
```

These hooks enable future addons without modifying Core behavior.

---

# 11. Single Source of Truth

Economic constants should exist in only one authoritative location.

Examples:

* Default Interest Rate
* Team Size Limits
* Auction Fees
* Shop Fees
* History Capacities

Tier 2 documents must reference these values instead of redefining them.

---

# 12. Translation Policy

As a Tier 1 document:

The following files must always exist together:

```text
GAME_RULES.md
GAME_RULES_JA.md
```

The English version is the canonical source.

The Japanese version is an official translation and must remain synchronized.

---

# 13. Reference Policy

Hypixel SkyBlock may be used as a gameplay reference.

However:

* Direct replication is prohibited.
* Systems must fit survival gameplay.
* Vanilla integration takes priority.
* Original design decisions always override references.

Hypixel SkyBlock is a source of ideas, not a design requirement.

The team size limit specifically references the default maximum size of a Hypixel Party rather than SkyBlock cooperative teams.

---
