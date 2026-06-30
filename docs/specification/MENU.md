# Menu Specification

> Last Updated: 2026-06-30

This document defines the unified menu system of EconomiCraft.

---

# Philosophy

EconomiCraft uses a centralized menu system inspired by Hypixel SkyBlock.

The menu provides quick access to all major systems without requiring dedicated locations or commands.

Design goals:

- Fast access
- Consistent navigation
- Portable usability
- Future addon support
- Minimal player confusion

The menu should feel like a natural extension of vanilla Minecraft interfaces.

---

# Access Methods

Players may access the menu through:

```text
/eco

/economy

Keybinds

NPC Interactions
```

All methods must open the same interface.

No feature-specific menu implementations should exist.

---

# Main Menu

The main menu uses a six-row chest interface.

```text
Slots:
54
```

Example:

```text
EconomiCraft Menu

├── Bank
├── Team
├── Shop
├── Auction
├── Quest
├── Storage
├── Settings
└── Decorative Elements
```

Unused slots should contain decorative items.

Glass panes and custom icons are recommended.

---

# Navigation Rules

Menu navigation must remain consistent.

Rules:

- Left click selects an entry.
- Right click also selects an entry.
- Both mouse buttons behave identically.
- No hidden click combinations should exist.
- Every submenu must include a back button.

Players should never need to memorize different click behaviors.

---

# Back Button

Submenus must include a dedicated back button.

Recommended implementation:

```text
Item:
Barrier

Display Name:
← Back
```

Behavior:

```text
Current Menu
        ↓
Back Button
        ↓
Previous Menu
```

The system should preserve menu history whenever possible.

---

# Bank Menu

Example structure:

```text
Bank

├── Deposit
├── Withdraw
├── Transaction History
├── Interest Information
├── Team Bank
└── Back
```

Deposit and withdraw actions must use separate buttons.

No click-based shortcuts should exist.

---

# Team Menu

Example structure:

```text
Team

├── Team Information
├── Team Members
├── Team Bank
├── Team Management
├── Team Logs
└── Back
```

Available options depend on player permissions.

---

# Shop Menu

Example structure:

```text
Shop

├── NPC Shops
├── Player Markets
├── Featured Offers
└── Back
```

Future systems may expand this menu.

---

# Auction Menu

Example structure:

```text
Auction

├── Browse Auctions
├── Create Listing
├── Active Listings
├── Transaction History
└── Back
```

Auction fees and taxes remain server-side configurations.

---

# Quest Menu

Example structure:

```text
Quest

├── Active Quests
├── Completed Quests
├── Rewards
└── Back
```

Quest implementations may vary between servers.

---

# Storage Integration

Storage functionality belongs to the official addon:

```text
EconomiCraft Storage
```

When installed:

```text
EconomiCraft Menu

├── Bank
├── Team
├── Shop
├── Auction
├── Quest
├── Storage
└── Settings
```

When absent:

```text
EconomiCraft Menu

├── Bank
├── Team
├── Shop
├── Auction
├── Quest
└── Settings
```

The menu should adapt automatically.

---

# Settings Menu

Settings are divided into server settings and player settings.

Server settings:

```text
Configuration Files
```

Player settings:

```text
Settings

├── Notifications
├── Sound Effects
├── Personal Preferences
├── Quick Actions
├── Addons
└── Back
```

Players may only modify personal preferences.

Game balance and economy values remain server controlled.

---

# Addons Menu

The addons page is reserved for player-facing addons.

Example:

```text
Addons

├── UI Themes
├── Overlay Systems
├── Client Enhancements
└── Back
```

Core gameplay addons should integrate directly into the main menu instead.

Examples:

```text
Storage
Guilds
Industries
Trading
```

These systems should appear as normal menu entries.

---

# Addon Registration

Future addons may register new pages.

Example:

```text
EconomiCraft Menu

├── Bank
├── Team
├── Shop
├── Auction
├── Quest
├── Storage
├── Guilds
└── Settings
```

Addon pages should behave identically to core pages.

No special handling should be required from players.

---

# Visual Design

The menu system follows these principles:

```text
Hypixel SkyBlock Inspired

Vanilla Compatible

Chest GUI Based

Resource Pack Friendly
```

Recommended decorative elements:

```text
Glass Panes

Custom Icons

Lore Descriptions

Consistent Slot Placement
```

Visual consistency is more important than visual complexity.

---

# Future Expansion

Potential future integrations:

```text
Guilds

Industries

Trading Networks

Player Markets

Expansion Packs
```

The menu architecture must support additional systems without redesigning existing interfaces.

---

# Final Principle

> Every major EconomiCraft system should be accessible from a single, intuitive, and consistent interface.
> 