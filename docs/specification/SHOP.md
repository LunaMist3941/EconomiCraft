# Shop Specification

> Last Updated: 2026-06-30

This document defines the shop system of EconomiCraft.

---

# Philosophy

The shop system provides stable item trading through fixed prices.

Design goals:

- Easy to understand
- Fast access through GUI and NPCs
- Fully configurable
- Compatible with RPG maps
- Future support for dynamic markets

---

# Core Principles

```text
EconomiCraft Core
└── Fixed Prices

EconomiCraft Market
└── Dynamic Prices
```

The core mod only provides fixed-price trading.

Dynamic economies are handled by future addons.

---

# Access Methods

Players may access shops through multiple methods.

```properties
shop.enable_menu=true
shop.enable_npc=true
```

---

# Shop Keeper NPC

Interaction:

```text
Right Click
        ↓
Open Shop Menu
```

This allows RPG worlds to disable direct menu access while retaining physical shops.

---

# Main Menu

The shop system follows the Hypixel SkyBlock Bazaar design philosophy.

```text
Shop

├── Blocks
├── Farming
├── Mining
├── Combat
├── Food
├── Misc
├── Favorites
├── Search
└── Back
```

---

# Category Structure

Pagination is intentionally not supported.

Instead, categories are divided into subcategories.

Example:

```text
Mining

├── Coal
├── Iron
├── Gold
├── Redstone
├── Diamond
├── Emerald
└── Back
```

---

# Subcategories

Example:

```text
Diamond

├── Diamond
├── Diamond Ore
├── Deepslate Diamond Ore
├── Diamond Block
└── Back
```

---

# Item Detail Menu

Each item has its own menu.

Example:

```text
Diamond

Current Price:
500 COIN

Buy Fee:
5%

Sell Fee:
10%

Final Buy Price:
525 COIN

Final Sell Price:
450 COIN
```

---

# Item Actions

```text
Diamond

├── Buy
├── Sell
├── Add To Favorites
└── Back
```

---

# Buy Menu

```text
Buy

├── Buy 1
├── Buy 16
├── Buy 64
├── Buy All Possible
├── Custom Amount
└── Back
```

---

# Sell Menu

```text
Sell

├── Sell 1
├── Sell 16
├── Sell Stack
├── Sell All
├── Custom Amount
└── Back
```

---

# Custom Amount Input

Custom values use the sign interface.

Example:

```text
[ Enter Amount ]

512
```

---

# Search System

The search system also uses a sign interface.

Flow:

```text
Search
        ↓
Open Sign GUI
        ↓
diamond
        ↓
Results
```

---

# Search Limits

```properties
shop.search.max_results=10
```

---

# Example Results

```text
Results

Diamond

Diamond Ore

Deepslate Diamond Ore

Diamond Block
```

---

# Favorites System

Players may save frequently used items.

---

# Favorites Menu

```text
Favorites

├── Diamond
├── Coal
├── Bread
└── Back
```

---

# Adding Favorites

Favorites are added from item detail menus.

Example:

```text
Diamond

├── Buy
├── Sell
├── Add To Favorites
└── Back
```

---

# Favorite Limits

```properties
shop.favorites.max_entries=20
```

---

# Trading Fees

Default values:

```properties
shop.buy_fee=0.05
shop.sell_fee=0.10
```

---

# Example

```text
Base Price:
100 COIN

Buy:
105 COIN

Sell:
90 COIN
```

---

# Purpose Of Fees

Fees prevent COIN from functioning as infinite item storage.

```text
Items
≠
Money
```

---

# Administrative Commands

---

## Reload Shop Data

```text
/shop reload
```

---

## Change Buy Fee

```text
/shop fee buy <value>
```

Example:

```text
/shop fee buy 0.07
```

---

## Change Sell Fee

```text
/shop fee sell <value>
```

Example:

```text
/shop fee sell 0.15
```

---

# Permissions

```text
economicraft.admin.shop
```

---

# Supported Categories

```text
Blocks

Farming

Mining

Combat

Food

Misc
```

---

# Unsupported Items

The following items are intentionally excluded:

```text
Tools

Armor

NBT Items

Damaged Items

Custom Named Items
```

These belong to the auction system.

---

# Data Format

EconomiCraft Core uses JSON.

Example:

```json
{
  "minecraft:diamond": {
    "category": "mining",
    "subcategory": "diamond",
    "buy": 500,
    "sell": 450
  }
}
```

---

# Directory Structure

```text
config/economicraft/shop/

├── blocks.json
├── farming.json
├── mining.json
├── combat.json
├── food.json
└── misc.json
```

---

# Future Addons

EconomiCraft Market will support datapacks.

Example:

```text
data/economicraft_market/shop/
```

This enables:

```text
Supply

Demand

Price History

Weekly Trends

Dynamic Economies
```

---

# Final Principle

> Shops should provide stable, predictable, and accessible trading for every player.