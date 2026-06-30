# Multi-Version Support

> Last Updated: 2026-06-30

This document describes the multi-version strategy of EconomiCraft.

---

# Overview

EconomiCraft is designed from the beginning to support multiple Minecraft versions.

The initial target is:

| Minecraft | NeoForge | Status |
|-----------|----------|---------|
| 1.21.1 | 21.1.x | In Development |

Future support may include:

| Minecraft | Status |
|-----------|---------|
| 1.21.4 | Planned |
| 1.22.x | Planned |
| Future LTS Releases | Planned |

---

# Design Goals

The multi-version architecture aims to:

- Minimize version-specific code.
- Isolate Minecraft internals.
- Reduce migration costs.
- Keep business logic independent.
- Support future platform integrations.

---

# Package Structure

Planned package layout:

```text
economicraft
│
├── common
│
├── platform
│   ├── neoforge
│   └── fabric
│
└── version
    ├── v1_21_1
    ├── v1_21_4
    └── v1_22_x
```

---

# common

```text
common
```

Responsibilities:

- Economy logic
- Shop logic
- Bank logic
- API definitions
- Shared models

Rules:

- No direct Minecraft implementation details.
- No version-dependent code.
- Maximum code reuse.

---

# platform

```text
platform
├── neoforge
└── fabric
```

Responsibilities:

- Loader initialization
- Platform APIs
- Event registration
- Networking implementations

Rules:

- Platform-specific code only.
- Never place game logic here.

---

# version

```text
version
├── v1_21_1
├── v1_21_4
└── v1_22_x
```

Responsibilities:

- Minecraft API differences
- Version-specific wrappers
- Compatibility layers

Examples:

- Data Components
- Menu APIs
- Packet APIs
- Registry changes

---

# Compatibility Strategy

The preferred approach:

```text
Business Logic
        ↓
Abstract Interface
        ↓
Version Implementation
```

Example:

```java
public interface ICurrencyStorage {

    long getBalance(UUID playerId);

    void setBalance(UUID playerId, long amount);

}
```

Version-specific implementations:

```text
v1_21_1/CurrencyStorageImpl
v1_21_4/CurrencyStorageImpl
```

---

# Rules

## Rule 1

Never mix version-specific code with business logic.

---

## Rule 2

Minecraft internals should be wrapped behind interfaces.

---

## Rule 3

Shared code belongs in common packages.

---

## Rule 4

Platform-dependent APIs belong in platform packages.

---

## Rule 5

When updating to a new Minecraft version:

```text
Create Version Package
        ↓
Implement Compatibility Layer
        ↓
Run Tests
        ↓
Release
```

---

# NeoForge Strategy

Current implementation target:

```text
platform/neoforge
```

Responsibilities:

- Deferred Registers
- Event Bus
- Networking
- Config Registration
- Menu Registration

---

# Fabric Support

Fabric support is not currently planned.

However, the architecture should remain flexible enough to support:

```text
platform/fabric
```

without major refactoring.

---

# Data Compatibility

EconomiCraft data formats should remain stable across versions.

Requirements:

- JSON compatibility
- Config migration support
- Save data upgrades
- Transaction history preservation

---

# Migration Policy

Version upgrades should prioritize:

1. Data safety
2. API stability
3. Backward compatibility
4. Minimal user intervention

---

# Future Possibilities

Potential future targets:

- NeoForge
- Fabric
- Quilt

The core architecture should remain independent of any specific mod loader.

---

# Long-Term Vision

EconomiCraft aims to become:

> A modular economy framework that can evolve alongside Minecraft without requiring large-scale rewrites.

Maintaining clear boundaries between:

- Business logic
- Platform code
- Version code

is essential to achieving this goal.