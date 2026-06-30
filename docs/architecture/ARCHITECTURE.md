# EconomiCraft Architecture

> Last Updated: 2026-06-30
>
> This document describes the overall architecture and design principles of EconomiCraft.

---

# Overview

EconomiCraft is a modular economy mod for Minecraft NeoForge.

The project is designed around the following principles:

- Modular systems
- Multi-version compatibility
- Clear responsibility separation
- Configuration-first development
- Extensibility for future integrations

---

# Core Modules

EconomiCraft consists of independent modules.

```text
EconomiCraft
│
├── Economy
├── Shop
├── Bank
├── Auction
├── Quest
├── Coin
└── API
```

Each module can be enabled or disabled through configuration files.

---

# Package Structure

```text
io.github.lunamist3941.economicraft
│
├── api
│
├── client
│   ├── event
│   ├── key
│   ├── renderer
│   └── screen
│
├── command
│
├── config
│   ├── client
│   ├── common
│   └── server
│
├── economy
├── gui
├── network
├── registry
├── shop
├── util
│
└── EconomiCraft
```

Every package must have a clear responsibility.

Cross-package dependencies should be minimized whenever possible.

---

# Configuration System

The configuration system is separated into three categories.

```text
config
│
├── client
│   ├── ClientConfig
│   └── GuiConfig
│
├── common
│   ├── EconomiCraftConfig
│   ├── EconomyConfig
│   ├── ShopConfig
│   ├── BankConfig
│   ├── AuctionConfig
│   ├── QuestConfig
│   └── CoinConfig
│
└── server
    ├── DatabaseConfig
    ├── PermissionConfig
    ├── BackupConfig
    └── LogConfig
```

Development workflow:

```text
Create Config
    ↓
Register Config
    ↓
Implement Feature
    ↓
Read Config Values
```

No feature should be implemented without a corresponding configuration.

---

# Registry System

All registrations are centralized.

```text
registry
│
├── BlockRegistry
├── ItemRegistry
├── MenuRegistry
├── DataComponentRegistry
├── ScreenRegistry
├── SoundRegistry
└── NetworkRegistry
```

Direct registration outside the registry package is prohibited.

---

# Client Architecture

Client-only functionality is isolated.

```text
client
│
├── event
├── key
├── renderer
├── screen
└── EconomiCraftClient
```

EconomiCraftClient is responsible only for:

- Client initialization
- Config screen registration
- Client event setup

Game logic must remain outside the client package.

---

# Economy Architecture

Planned structure:

```text
economy
│
├── AccountManager
├── WalletManager
├── BalanceManager
├── TransactionManager
├── CurrencyManager
└── HistoryManager
```

Responsibilities:

| Component | Responsibility |
|-----------|---------------|
| AccountManager | Player accounts |
| WalletManager | Coin and wallet storage |
| BalanceManager | Money operations |
| TransactionManager | Transaction processing |
| CurrencyManager | Currency definitions |
| HistoryManager | Transaction history |

---

# Shop Architecture

Planned structure:

```text
shop
│
├── ShopManager
├── ShopEntry
├── ShopCategory
├── PriceProvider
├── BuyHandler
└── SellHandler
```

Features:

- Item purchasing
- Item selling
- Command registration
- GUI integration
- Other mod item compatibility

---

# Coin System

The Coin system follows these rules:

- Custom item implementation
- No vanilla item replacements
- Texture replacement support
- Data Component support
- Cross-mod compatibility

Coins are treated as a physical representation of currency.

---

# Multi-Version Strategy

EconomiCraft is designed for future multi-version support.

Target strategy:

```text
common
platform
version
```

Version-specific implementations should remain isolated.

Core business logic must avoid direct dependencies on Minecraft internals whenever possible.

---

# Design Principles

## Single Responsibility Principle

One class should have one responsibility.

---

## Configuration First

Every feature must have configuration support.

---

## Registry Centralization

Registrations must occur inside registry classes only.

---

## Manager-Based Logic

Complex systems should be implemented through managers.

---

## Client-Server Separation

Client rendering and UI must never contain server-side logic.

---

## Extensibility

Future integrations with other mods should require minimal changes to existing code.

---

# Future Extensions

Planned integrations:

- JEI
- EMI
- KubeJS
- FTB Mods
- External Economy APIs

Additional modules may be added without changing the core architecture.

---

# AI-Assisted Development

EconomiCraft is designed and developed with assistance from ChatGPT.

AI assistance includes:

- Software architecture
- Development planning
- Documentation
- Code review
- Refactoring suggestions

Final decisions and implementations remain under the control of the project maintainer.