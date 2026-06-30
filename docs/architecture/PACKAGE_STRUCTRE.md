# Package Structure

> Last Updated: 2026-06-30

This document defines the package structure and responsibilities of EconomiCraft.

---

# Root Package

```text
io.github.lunamist3941.economicraft
```

All source code must exist under this namespace.

---

# Package Overview

```text
economicraft
│
├── api
├── client
├── command
├── config
├── economy
├── gui
├── network
├── registry
├── shop
├── util
└── EconomiCraft
```

---

# api

```text
api
├── economy
├── shop
├── bank
└── event
```

Responsibilities:

- Public APIs
- External mod integrations
- Event definitions
- Stable interfaces

Rules:

- No internal implementation details.
- No direct access to manager internals.
- API compatibility should be maintained across versions.

---

# client

```text
client
│
├── event
├── key
├── renderer
└── screen
```

Responsibilities:

- Rendering
- GUI screens
- Key bindings
- Client events

Rules:

- Never store server-side data.
- Never implement game logic.
- Must only run on physical clients.

---

# command

```text
command
├── economy
├── shop
├── bank
├── auction
└── quest
```

Responsibilities:

- Command registration
- Command argument parsing
- Permission handling

Rules:

- Business logic belongs in managers.
- Commands should only call service methods.

---

# config

```text
config
├── client
├── common
└── server
```

Responsibilities:

- Feature configuration
- User customization
- Server settings

Rules:

- Every major feature must have a configuration class.
- Configuration values should never be hardcoded.

---

# economy

```text
economy
├── manager
├── model
├── storage
└── transaction
```

Responsibilities:

- Wallets
- Balances
- Currency handling
- Transaction history

Rules:

- Core economy logic must remain independent from GUI code.

---

# gui

```text
gui
├── menu
├── screen
├── widget
└── texture
```

Responsibilities:

- Menu types
- Screens
- Custom widgets
- GUI assets

Rules:

- GUI state synchronization belongs in the network package.

---

# network

```text
network
├── packet
├── handler
└── payload
```

Responsibilities:

- Packet registration
- Client/server synchronization
- Custom payload handling

Rules:

- Packets must be version-safe.
- Business logic belongs outside packet handlers.

---

# registry

```text
registry
├── ItemRegistry
├── BlockRegistry
├── MenuRegistry
├── DataComponentRegistry
├── SoundRegistry
└── NetworkRegistry
```

Responsibilities:

- Centralized registrations

Rules:

- No registration code outside this package.
- DeferredRegister usage is mandatory.

---

# shop

```text
shop
├── manager
├── model
├── command
└── gui
```

Responsibilities:

- Shop entries
- Buying
- Selling
- Price handling

Rules:

- Support items from other mods.
- Avoid direct dependencies on vanilla items.

---

# util

```text
util
├── math
├── text
├── item
└── resource
```

Responsibilities:

- Helper classes
- Utility methods
- Shared constants

Rules:

- Utility classes must remain stateless.
- Avoid feature-specific code.

---

# Main Class

```
EconomiCraft.java
```

Responsibilities:

- Mod initialization
- Event bus registration
- Registry startup

Rules:

- No business logic.
- No client-specific code.
- No command implementations.

---

# Dependency Rules

Allowed dependencies:

```text
command  → economy
shop     → economy
gui      → network
client   → gui
api      → economy
```

Forbidden dependencies:

```text
economy  ✗→ client
economy  ✗→ gui
network  ✗→ shop
client   ✗→ economy internals
```

---

# General Rules

## Single Responsibility

One package should represent one domain.

---

## Feature Isolation

Features should be independent whenever possible.

---

## Cross-Version Compatibility

Version-specific code must remain isolated.

---

## Extensibility

New systems must fit into the existing structure without major refactoring.

---

# Future Packages

Planned additions:

```text
integration
platform
version
database
```

These packages will support:

- JEI
- EMI
- KubeJS
- Multi-version compatibility
- External storage systems