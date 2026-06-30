# Configuration Specification

> Last Updated: 2026-06-30

This document defines the configuration system of EconomiCraft.

---

## Overview

EconomiCraft uses three configuration categories:

```
common
client
server
```

Each category has a specific responsibility.

---

## Common Configuration

File:

```
config/economicraft-common.toml
```

Responsibilities:

- Feature toggles
- Shared behavior
- Economy settings
- Cross-platform values

Example:

```
[shop]
enabled = true

[bank]
enabled = true

[auction]
enabled = false

[quest]
enabled = false
```

---

## Client Configuration

File:

```
config/economicraft-client.toml
```

Responsibilities:

- GUI settings
- Visual effects
- Animation options
- Tooltip behavior
- Client-only preferences

Planned options:

```
[gui]
showCoinTooltip = true
enableAnimations = true
compactShopLayout = false
```

Rules:

- Never affect gameplay.
- Never synchronize with servers.

---

## Server Configuration

File:

```
config/economicraft-server.toml
```

Responsibilities:

- Economy balancing
- Administrative settings
- Permission defaults
- Multiplayer behavior

Planned options:

```
[economy]
startingCoins = 100

[shop]
allowGlobalShops = true
```

Rules:

- Server values override client preferences when necessary.

---

## Feature Toggles

Every major system must provide:

```
enabled = true
```

Required systems:

```
shop
bank
auction
quest
```

Optional future systems:

```
mail
lottery
guild
market
```

---

## Compatibility Rules

Configuration files must remain compatible between minor versions.

Allowed:

```
0.1.0 -> 0.2.0
```

Migration may be required for:

```
0.x.x -> 1.0.0
```

---

## Default Philosophy

EconomiCraft defaults:

- Shop enabled
- Bank enabled
- Auction disabled
- Quest disabled

This minimizes resource usage while keeping essential systems available.

---

## Future Expansion

Potential additions:

```
currency
interest
tax
mail
market
integration
```

All future systems must follow the existing configuration hierarchy.

---

## Final Principle

> Every feature must be configurable.

Hardcoded behavior should be avoided whenever possible.