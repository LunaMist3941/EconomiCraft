# Bank Specification

> Last Updated: 2026-06-30

This document defines the banking system of EconomiCraft.

---

# Philosophy

The bank system exists to encourage long-term wealth management.

Design goals:

- Protect player assets
- Encourage saving
- Support multiplayer economies
- Remain fully configurable
- Integrate with RPG-style gameplay

---

# Core Principles

```text
Wallet
└── Immediate Spending

Bank
└── Long-Term Storage
```

Players are encouraged to store their wealth inside banks rather than carrying large amounts of COIN.

---

# Interest System

Interest type:

```text
Compound Interest
```

Default interest rate:

```text
3%
```

Interest interval:

```text
Every 3 Minecraft Days
```

---

## Internal Calculation

The bank stores values internally as floating-point numbers.

Example:

```text
1.00

↓

1.03

↓

1.0609
```

Displayed values are always rounded down.

Example:

```text
Internal:
1250.98

Displayed:
1250 COIN
```

---

## Minimum Interest

No minimum gain is guaranteed.

Example:

```text
1 COIN

↓

0.03 COIN

↓

Displayed:
0 COIN
```

---

# Balance Limits

Configuration:

```properties
bank.max_balance=-1
```

Special value:

```text
-1 = Unlimited
```

There is no hardcoded upper limit.

---

# Death Penalty Protection

Wallet COIN is affected by death penalties.

```text
Wallet:
Lose 25%
```

Banked COIN is always protected.

```text
Bank:
0% Loss
```

---

# Main Bank Menu

The bank uses a 54-slot chest GUI.

```text
Bank

├── Deposit
├── Withdraw
├── Transaction History
├── Interest Information
├── Team Bank
└── Back
```

---

# Deposit Menu

Players choose predefined percentages or enter custom amounts.

```text
Deposit

├── Deposit All
├── Deposit 50%
├── Deposit 25%
├── Custom Amount
└── Back
```

---

# Withdraw Menu

```text
Withdraw

├── Withdraw All
├── Withdraw 50%
├── Withdraw 25%
├── Custom Amount
└── Back
```

---

# Custom Amount Input

Custom values use a sign interface.

```text
Deposit
        ↓
Custom Amount
        ↓
Open Sign GUI
        ↓
Enter Value
```

Example:

```text
[ Enter COIN ]

100000
```

Reasons:

```text
Vanilla Friendly

RPG Compatible

No Chat Spam

Easy Numeric Input
```

---

# Interest Information Menu

Example:

```text
Current Balance:
1,250,000 COIN

Interest Rate:
3%

Next Interest:
1 Day Remaining

Expected Gain:
37,500 COIN
```

---

# Transaction History

Visible entries:

```properties
bank.history.visible_entries=15
```

Internal storage:

```properties
bank.history.max_entries=150
```

---

# Supported History Types

```text
Deposit

Withdraw

Interest

Admin Give

Admin Remove

Team Transfer

Team Delete Transfer
```

---

# Team Bank Integration

The Team Bank uses the same interaction model.

---

# Team Deposit Menu

```text
Deposit

├── Deposit All
├── Deposit 50%
├── Deposit 25%
├── Custom Amount
└── Back
```

---

# Team Withdraw Menu

```text
Withdraw

├── Withdraw All
├── Withdraw 50%
├── Withdraw 25%
├── Custom Amount
└── Back
```

---

# Team Interest Display

Players only see:

```text
Interest Rate:
6%
```

Administrative interest modes are hidden from normal users.

---

# Commands

---

## Player Commands

Open bank menu:

```text
/bank
```

No additional player subcommands exist.

The user interface is the primary interaction method.

---

# Administrative Commands

Generate COIN:

```text
/coin give <player> <amount>
```

Example:

```text
/coin give Steve 100000
```

---

Remove COIN:

```text
/coin remove <player> <amount>
```

Example:

```text
/coin remove Steve 50000
```

---

View internal history:

```text
/coin history <player>
```

Example:

```text
Player:
Steve

Latest 150 Entries

+100000
Admin Give

-50000
Admin Remove

+7500
Interest
```

---

# Permissions

Administrative commands require:

```text
economicraft.admin.coin
```

---

# NPC Integration

NPC systems are part of EconomiCraft Core.

---

# NPC Structure

```text
NPC

├── Banker
├── Shop Keeper
├── Auctioneer
└── Quest Master
```

---

# Banker NPC

Interaction:

```text
Right Click
        ↓
Open Bank Menu
```

---

# Configuration

Individual features are configured independently.

```properties
bank.enable_menu=true

bank.enable_commands=true

bank.enable_npc=true
```

This allows:

```text
UI Only

NPC Only

Command Only

Hybrid Systems
```

RPG maps and adventure worlds can therefore disable menu access while retaining physical bank locations.

---

# Logging

The following actions create logs:

```text
Deposit

Withdraw

Interest

Admin Give

Admin Remove

Team Transfer

Team Delete Transfer
```

---

# Final Principle

> Banks should reward long-term planning while protecting players from catastrophic losses.