# UI_GUIDELINES

Tier: 1 (Constitution)
Status: Stable
Depends On:
- DESIGN_PHILOSOPHY.md
- DOCS_RULES.md

---

# Purpose

This document defines the official user interface principles and interaction rules for EconomiCraft.

All Tier 2 and lower documents must follow these guidelines.

Examples:

- BANK.md
- SHOP.md
- AUCTION.md
- TEAM.md
- MENU.md
- NPC.md

Lower-tier documents must not override any rule defined here.

---

# 1. Design Philosophy

EconomiCraft follows these principles:

- Vanilla Extension First
- Convenience Without Breaking Immersion
- Chest GUI First
- Familiar Minecraft Interactions
- Hypixel SkyBlock Inspired, Not Replicated
- Resource Pack Friendly
- Addon Extensible

The goal is to feel like a natural extension of Minecraft rather than an external application.

---

# 2. GUI Standards

## 2.1 Primary Interface

The primary interface system is:

- Chest GUI

Secondary interfaces:

- Sign GUI

Chat-based input systems should be avoided whenever possible.

---

## 2.2 GUI Size Policy

Default size:

- 54 Slots (6 Rows)

Allowed reductions:

- 27 Slots
- 18 Slots
- 9 Slots

Rules:

- Prefer hierarchy over pagination.
- Pagination should only be used when absolutely necessary.
- Large systems must use category-based navigation.

---

# 3. Navigation Rules

## 3.1 Back Button

Default location:

- Bottom-right area

Rules:

- Avoid placing it directly next to the Close button.
- Keep at least one slot of separation whenever possible.
- Position may be adjusted when required by layout constraints.

---

## 3.2 Close Button

Default location:

- Bottom-right area

Rules:

- Must remain visually distinct from Back.
- Accidental clicks should be minimized.

---

## 3.3 Cancel Actions

Cancellation should return to a meaningful parent menu.

Examples:

- Listing Creation → Listings Menu
- Deposit Amount Selection → Deposit Menu

Returning one screen at a time should be avoided for long workflows.

---

# 4. Search System

Default icon:

- Compass

Interactions:

Left Click:

- Open Sign GUI search input.

Right Click:

- Display all available entries.

Rules:

- Empty input means cancellation.
- Search results should remain lightweight.
- Default maximum visible results: 10.

---

# 5. GUI Item Interaction Rules

EconomiCraft uses actual ItemStacks as GUI elements.

Players interact by attempting to take items.

This behavior is intentional.

---

## 5.1 Click Handling

Supported:

- Left Click
- Right Click

Unsupported:

- Shift Click
- Number Key Swap
- Drag Operations
- Double Click Collection

---

## 5.2 Item Retrieval Prevention

If a GUI item enters a player's inventory:

1. Execute the intended action.
2. Scan the player's inventory.
3. Detect EconomiCraft GUI items.
4. Remove them immediately.

Pseudo-flow:

```text
Click
↓
Action Executed
↓
Inventory Scan
↓
GUI Item Detected
↓
Delete Item
```

This preserves vanilla interaction expectations while preventing item duplication.

---

# 6. Sign GUI Usage

Sign GUIs are allowed for:

- Search Input
- Custom Amount Input
- Naming Operations

Examples:

- Auction Price
- Bank Custom Deposit
- Team Naming

Empty submissions must always be treated as cancellation.

---

# 7. Audio Guidelines

EconomiCraft uses vanilla Minecraft sounds.

Custom sound effects should not replace core interactions.

Reasons:

- Maintain immersion.
- Preserve Minecraft identity.
- Ensure consistency across addons.

---

# 8. Tooltip Policy

Tooltips should only be used when necessary.

Examples:

Allowed:

- Auction explanations
- Dangerous actions
- Team permissions

Avoid:

- Simple Back buttons
- Basic navigation elements
- Self-explanatory actions

---

# 9. Confirmation Dialog Policy

Confirmation screens are required for:

- Team deletion
- High-value transactions
- Irreversible actions
- Mass withdrawals
- Administrative actions

Normal actions should remain immediate.

Convenience takes priority whenever possible.

---

# 10. Loading Behavior

Dedicated loading screens should not exist.

Allowed behavior:

- Brief empty chest rendering
- Instant GUI replacement

The user experience should remain seamless.

---

# 11. Theme System

EconomiCraft supports multiple GUI themes.

Default themes:

- EconomiCraft
- Vanilla
- Hybrid

Future themes may include:

- Dark
- Classic RPG
- Custom Resource Pack Themes

Theme selection is handled through player settings.

---

# 12. Resource Pack Compatibility

GUI assets must support resource pack replacement.

Requirements:

- Texture replacement must be possible.
- Hardcoded visuals should be avoided.

Allowed resolutions:

- 16x16
- 32x32
- 64x64

Higher resolutions are permitted as long as pixel-art principles are maintained.

---

# 13. Icon Design Policy

Preferred style:

- Vanilla-inspired pixel art

Rules:

- Maintain Minecraft readability.
- Avoid realistic illustrations.
- Preserve item-like visual language.

GUI elements should feel native to Minecraft.

---

# 14. GUI Item Modes

Supported modes:

EconomiCraft Mode:

- Custom GUI items
- Dedicated textures

Vanilla Mode:

- Compass
- Arrow
- Barrier
- Other vanilla items

Hybrid Mode:

- Combination of both systems

Players may select their preferred mode.

---

# 15. Settings Menu Structure

Player Settings:

```text
Client Settings
Accessibility
Addon Settings
Back
Close
```

Operator Settings:

```text
Client Settings
Server Settings
Accessibility
Addon Settings
Back
Close
```

Server Settings must only appear to authorized users.

---

# 16. Addon Integration

Addon settings must exist within a dedicated menu.

Examples:

- EconomiCraft Storage
- EconomiCraft TeamPlus

Core systems and addons should remain visually separated.

---

# 17. Category Hierarchy

Hierarchy should be preferred over pagination.

Examples:

```text
Blocks
└── Diamond
    ├── Diamond
    ├── Diamond Ore
    └── Diamond Block
```

This improves discoverability and reduces navigation complexity.

---

# 18. Accessibility Principles

Interfaces should prioritize:

- Minimal clicks
- Clear navigation
- Familiar interactions
- Predictable behavior

Players should rarely need external explanations.

---

# 19. Hypixel SkyBlock Reference Policy

EconomiCraft may take inspiration from Hypixel SkyBlock.

However:

- Systems must be adapted to survival gameplay.
- Direct replication should be avoided.
- Vanilla integration takes priority.

Hypixel SkyBlock is a reference, not a requirement.

---

# 20. Translation Policy

As a Tier 1 document:

UI_GUIDELINES.md must always provide:

- UI_GUIDELINES.md
- UI_GUIDELINES_JA.md

The English version is the canonical source.

The Japanese version is an official translation and must remain synchronized.

---

# 21. Future Expansion

All future UI systems must follow this document.

Examples:

- Storage
- Quest
- Mail
- Guild
- TeamPlus

Extensions may add rules, but must never violate Tier 1 principles.

---

# 22. Personal Menu Item

EconomiCraft provides an optional menu item named "Menu".

Default behavior:

- Fixed to the rightmost hotbar slot.
- Opens the same interface as the /menu command.
- Uses right-click interaction.
- Automatically restores when missing.
- Cannot be dropped, stored, or transferred.
- Supports resource pack customization.

Configuration:

restore_mode:
- always (default)
- first_join
- disabled

The purpose of this item is to improve accessibility in survival environments where central hub locations are impractical.