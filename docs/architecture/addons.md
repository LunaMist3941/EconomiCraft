# Addon Architecture

> Last Updated: 2026-06-30

This document defines the addon architecture and extension principles of EconomiCraft.

---

# Philosophy

EconomiCraft follows a modular design.

The core mod should remain lightweight, maintainable, and independent from optional systems.

Additional features should be implemented through addons whenever possible.

Core responsibilities:

- Economy
- Bank
- Team
- Menu
- Shop
- Auction
- Quest

Large systems that significantly increase complexity should be developed separately.

---

# Supported Addons

Current addon roadmap:

```text
EconomiCraft Core
├── Economy
├── Bank
├── Team
├── Menu
├── Shop
├── Auction
└── Quest

EconomiCraft Storage
├── Team Shared Storage
├── Virtual Chests
├── Item Serialization
└── Future Inventory Systems
```

Future addons may include:

```text
EconomiCraft Guilds
EconomiCraft Industries
EconomiCraft Trading
EconomiCraft Expansion
```

---

# EconomiCraft Storage

Official name:

```text
EconomiCraft Storage
```

Mod ID:

```text
economicraft_storage
```

Purpose:

- Team shared inventories
- Virtual storage systems
- Persistent item serialization
- Portable storage interfaces
- Future warehouse systems

The storage addon depends on EconomiCraft Core.

Core must never depend on Storage.

Dependency direction:

```text
EconomiCraft Storage
        ↓
EconomiCraft Core
```

---

# Core Extension Points

The following systems must exist inside the core project to support future addons.

```text
Extension Points
├── Team UUID
├── Team Permission API
├── Menu Page API
├── Addon Detection
├── Team Events
└── TeamData Extensions
```

These APIs should remain stable across minor releases.

---

# Team Integration

Every team must own a unique identifier.

Structure:

```text
TeamData
├── teamId
├── teamName
├── owner
├── managers
├── members
├── bankBalance
└── extensions
```

The extensions section exists for addon compatibility.

Example:

```text
extensions
├── storage
├── guild
└── future_addons
```

Addons must store their custom data inside extension sections whenever possible.

---

# Permission System

The Team system provides shared permission handling.

Roles:

```text
Owner
├── Invite Members
├── Kick Members
├── Rename Team
├── Delete Team
├── Promote Managers
└── Full Access

Manager
├── Team Bank Access
├── Shared Storage Access
└── View Logs

Member
├── Deposit Team Bank
└── View Team Information
```

Future addons should integrate with existing permissions instead of creating independent systems.

---

# Menu Integration

EconomiCraft uses a unified menu architecture.

Example:

```text
EconomiCraft Menu
├── Bank
├── Team
├── Shop
├── Auction
├── Quest
└── Addons
```

Addons may register additional pages.

Example:

```text
EconomiCraft Menu
├── Bank
├── Team
├── Shop
├── Auction
├── Quest
└── Storage
```

Menu expansion should occur automatically when addons are installed.

No configuration options should exist for enabling or disabling core menu pages.

---

# Addon Detection

The core project provides addon detection utilities.

Example:

```text
AddonManager
├── isStorageLoaded()
├── getLoadedAddons()
└── registerAddon()
```

Purpose:

- Dynamic menu generation
- Conditional integrations
- Safe dependency handling
- Future expansion support

Core systems must continue functioning without any addons installed.

---

# Event System

Shared events allow addons to synchronize with core systems.

Planned events:

```text
TeamCreatedEvent

TeamDeletedEvent

MemberJoinedEvent

MemberLeftEvent
```

Examples:

```text
Delete Team
        ↓
Delete Team Storage
        ↓
Delete Team Assets
```

Events reduce direct dependencies between modules.

---

# API Stability

Public extension APIs must remain stable.

Allowed changes:

- New interfaces
- New optional methods
- Additional events

Forbidden changes:

- Breaking existing APIs
- Removing extension points
- Renaming public identifiers

Minor releases must preserve addon compatibility whenever possible.

---

# Dependency Rules

Allowed:

```text
Addon
        ↓
Core
```

Forbidden:

```text
Core
        ↓
Addon
```

Allowed:

```text
Storage
        ↓
Team API
```

Forbidden:

```text
Storage
        ↓
Internal Team Implementation
```

Addons should only interact with documented public interfaces.

---

# Future Expansion Policy

Before creating a new addon:

1. Define responsibilities.
2. Create documentation.
3. Design public APIs.
4. Establish dependency rules.
5. Integrate with the menu system.
6. Implement features.

Large systems should favor separate addons over expanding the core project.

---

# Final Principle

> The core should remain lightweight, while addons provide optional complexity and specialization.