# EconomiCraft Session Context

Repository:
https://github.com/LunaMist3941/EconomiCraft

## Current State

Project: EconomiCraft
Language: English is canonical, Japanese is official translation for Tier 1 documents.

Current phase:
- Documentation architecture and constitutional rules.
- Preparing for Milestone 1 completion.
- README rewrite planned after Milestone 1.
- README will include:
    - English version
    - Japanese version
    - Reference: Hypixel SkyBlock

---

# Documentation Rules

Tier hierarchy:

Tier 1:
- Constitution-level documents.
- Must always have EN + JA pairs.
- English version is canonical.
- Japanese version is an official translation.

Tier 2:
- System specifications.
- Normally English only unless necessary.

Tier 3:
- Implementation notes, examples, temporary documents.

Single Source of Truth:
- Lower tiers reference higher tiers.
- Values must not be duplicated.

Reference style:
- Prefer "See XXX.md" instead of repeating definitions.

Planned documents:
- GAME_RULES.md
- GAME_RULES_JA.md
- UI_GUIDELINES.md
- DOCS_RULES.md
- DESIGN_PHILOSOPHY.md

---

# ChatGPT Output Rules (Important)

These are NOT repository rules.

When generating files:

Order:
1. File name
2. Save location
3. Text body

Only the text body must be directly copy-pasteable.

The text body must:

- contain no ids
- contain no extra explanations
- contain no artifacts
- be immediately usable in GitHub
- be plain Markdown

File name and save location remain outside the copyable section.

---

# Core Philosophy

EconomiCraft principles:

- Convenience First
- Vanilla Compatibility
- Hypixel SkyBlock Inspired, Not Replicated
- Long-Term Server Stability
- Sustainable Coin Sinks
- Addon Extensibility

---

# Team System

Maximum team size:

5 players.

Reference:
Hypixel Party default size.

NOT SkyBlock Coop.

Team features:

- TeamBank
- TeamChat
- TeamColor (colored team names only)
- /tm
- /team members

Offline members are displayed.

TeamBank disband rule:

TeamBank
→ Owner Bank

All transfers are recorded in transaction history.

Bonus modes:

Small Team:
+3% per member.

Large Team:
First member:
+3%

Additional members:
+1%

---

# Bank System

Default interest:

3%

History:

Visible:
15 entries

Internal:
150 entries

Deposit/Withdraw options:

- ALL
- 50%
- 25%
- Custom

Custom uses Sign GUI.

NPC support is built into Core.

NPC behavior is controlled through:

- Config
- Profile

---

# Shop System

Inspired by:

Hypixel SkyBlock Bazaar.

Structure:

Main Menu
→ Categories
→ Subcategories
→ Item
→ Buy/Sell submenu

Buy fee:
5%

Sell fee:
10%

Search:

- Located inside Browse Menu
- Right click:
  Show all items
- Result limit:
  10 items

Favorites:

- Separate main menu category
- Registered from Buy/Sell screens

Pagination:

Not supported.

Instead:

Deep category hierarchy.

---

# Auction System

Purpose:

Rare items only.

Examples:

- Tools
- Armor
- Enchanted Books
- Custom Equipment
- Rare Items

Bulk materials belong exclusively to Shop.

BIN and Auction:

Both enabled.

Player selects listing type during listing creation.

Listing fee:

2%

Wallet:

Personal Wallet only.

Listing capacity:

Increases with team size.

Expired listings:

Manual retrieval.

Protection time:

2 minutes.

Failure:

Stored in Listings Storage.

Listing flow:

Select Item
→ Select Price
→ Select Duration
→ Confirm

Cancel buttons exist on every step.

System automatically determines BIN/Auction eligibility.

Rare items are determined through Config Lists.

---

# UI Rules

Primary interface:

Chest GUI.

Supplementary interfaces:

- Sign GUI
- Text input only when necessary

Default inventory size:

54 slots.

Smaller inventories may be used when appropriate.

Back button:

Usually bottom-right.

Avoid placement immediately beside dangerous actions.

Search:

Right-click:
Show all.

Empty input:
Cancel.

Sound design:

Vanilla sounds only.

No custom sound effects.

Icons:

Pixel art style.

Allowed resolutions:

- 16x16
- 32x32
- 64x64

Player options:

Mode A:
Custom GUI textures.

Mode B:
Vanilla item icons.

Examples:

- Arrow = Back
- Compass = Search

GUI items:

Cannot be permanently obtained.

If moved into inventories:

Automatically removed.

Interaction is based on normal Minecraft item-click behavior.

---

# Menu Item

A permanent Menu item exists.

Behavior:

- Fixed to the right-most hotbar slot.
- Right-click opens the main menu.
- Equivalent to /menu.

Default distribution:

First join.

Optional redistribution:

Respawn.

Death behavior:

Automatically restored.

Item name:

Menu

No separate Team Menu item exists.

Team features are accessed through the main menu.

Usage documentation will be written in future user-facing documents.

---

# MoneyPlus

Addon name:

EconomiCraft MoneyPlus

Core excludes:

- Debt
- Loans
- Taxes
- Government accounts
- Business accounts
- Credit systems

Core must expose:

- Generic transaction types
- Flexible history systems
- Event hooks

MoneyPlus will implement advanced finance systems later.

---

# Future Addons

Planned:

- EconomiCraft MoneyPlus
- EconomiCraft TeamPlus
- EconomiCraft Storage
- Quest systems
- Mail systems
- Guild systems

Core compatibility must always be preserved.

---

# Restart Instructions

When starting a new conversation:

1. Provide this file.
2. Provide the repository URL.
3. Continue from the latest documentation phase.
4. Assume all decisions recorded here are finalized unless explicitly changed.