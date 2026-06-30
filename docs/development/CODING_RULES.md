# Coding Rules

> Last Updated: 2026-06-30

This document defines the coding standards and development principles of EconomiCraft.

---

## General Principles

EconomiCraft follows these principles:

- Readability over cleverness.
- Maintainability over short-term convenience.
- Extensibility over hardcoded solutions.
- Configuration-first development.
- Multi-version compatibility.

---

## Naming Conventions

### Packages

Use lowercase only.

Example:

```text
io.github.lunamist3941.economicraft.shop.manager
```

### Classes

Use PascalCase.

Examples:

```
ShopManager
WalletManager
CoinItem
```

### Methods

Use camelCase.

Examples:

```
getBalance()

registerCommands()

openShopScreen()
```

### Variables

Use camelCase.

Examples:

```
playerBalance

shopEntries

walletManager
```

### Constants

Use UPPER_SNAKE_CASE.

Examples:

```
MOD_ID

DEFAULT_INTEREST_RATE

MAX_TRANSACTION_HISTORY
```

---

## Class Responsibilities

One class should have one responsibility.

Bad:

```text
ShopManager
    - GUI
    - Commands
    - Transactions
```

Good:

```text
ShopManager
ShopCommand
ShopScreen
TransactionManager
```

---

## Package Responsibilities

One package should represent one domain.

Examples:

```text
economy
shop
network
gui
config
```

Cross-package dependencies should be minimized.

---

## Configuration First Development

Every major feature must follow this process:

```text
Create Config
        ↓
Register Config
        ↓
Implement Feature
        ↓
Use Config Values
```

No feature should exist without configuration support.

---

## Registry Rules

All registrations belong to the `registry` package.

Allowed:

```text
registry
├── ItemRegistry
├── MenuRegistry
└── SoundRegistry
```

Forbidden:

```
public class ShopManager {

    public static final Item ITEM = ...;

}
```

Always use DeferredRegister.

---

## Manager Rules

Business logic belongs in manager classes.

Examples:

```text
BalanceManager
WalletManager
ShopManager
AuctionManager
```

Responsibilities:

- State management
- Validation
- Processing
- Data access

Managers must not:

- Render GUIs
- Register commands
- Send packets directly

---

## Command Rules

Commands should only:

- Parse arguments
- Check permissions
- Call managers

Business logic inside command classes is forbidden.

---

## GUI Rules

GUI components are separated into:

```text
gui
├── menu
├── screen
├── widget
└── texture
```

Rules:

- Screens display information.
- Menus synchronize inventories.
- Widgets provide reusable components.

Game logic must remain outside GUI classes.

---

## Network Rules

Packets should only:

- Transfer data
- Synchronize state
- Trigger manager methods

Heavy processing inside packet handlers is forbidden.

---

## Client Rules

Client-only code belongs in:

```text
client
```

Examples:

- Rendering
- Keybindings
- Effects
- Client events

Never place server logic inside client packages.

---

## Multi-Version Rules

Version-dependent code belongs in:

```text
version
```

Platform-dependent code belongs in:

```text
platform
```

Business logic belongs in:

```text
common
```

---

## Comments

Comments should explain:

```text
WHY
```

Not:

```text
WHAT
```

Bad:

```
// Increment the balance
balance++;
```

Good:

```
// The transaction fee must be applied before updating
// the player's visible balance.
balance++;
```

---

## Javadoc Rules

Public classes should include Javadoc.

Example:

```
/**
 * Handles player wallet operations.
 */
public class WalletManager {

}
```

Public APIs must always have Javadoc.

---

## Utility Classes

Utility classes:

- Must be stateless.
- Should only contain static methods.
- Must not depend on game state.

Examples:

```text
MoneyUtils
TextUtils
ResourceUtils
```

---

## Dependency Rules

Allowed:

```text
command -> manager

gui -> network

shop -> economy
```

Forbidden:

```text
economy -> client

network -> gui

manager -> renderer
```

---

## Future-Proofing

When adding new systems:

1. Create documentation.
2. Create configuration.
3. Create registry entries.
4. Implement managers.
5. Implement GUI.
6. Implement commands.

---
---

## Documentation Rules

Markdown documents should avoid language-specific code fences.

Preferred:

```
Example Code
```

Avoid:

```
Example Code
```

This improves compatibility across editors, linters, and future documentation tools.

## Final Principle

> Code should be easy to understand, easy to extend, and easy to maintain.

Long-term maintainability is always preferred over short-term convenience.