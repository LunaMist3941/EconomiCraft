# EconomiCraft

A modular economy framework for Minecraft: NeoForge.

EconomiCraft is designed to provide flexible economy systems that can be enabled or disabled depending on server requirements.

This project currently targets Minecraft 1.21.1 and NeoForge 21.1.x.

---

## Features

Planned systems:

- Coin-based economy
- Shop system
- Bank system
- Auction system
- Quest rewards
- Public API
- Multi-version architecture
- Other mod item compatibility

Each system can be individually enabled or disabled through configuration files.

---

## Current Status

Current Version:

```
v0.1.0
```

Development Stage:

```
Milestone 1 — Foundation
```

Current Progress:

1. [ ] NeoForge project setup
2. [ ] Java 21 support
3. [ ] Documentation system
4. [ ] Multi-version architecture
5. [ ] Configuration architecture
6. [ ] Registry system
7. [ ] Internal coin system
8. [ ] Player wallet data
9. [ ] Data Components
10. [ ] GUI foundation
11. [ ] Network foundation

---

## Supported Platforms

### Current Support

| Minecraft | Loader | Status |
|------------|---------|---------|
| 1.21.1 | NeoForge 21.1.x | In Development |

### Planned Support

| Minecraft | Status |
|------------|---------|
| 1.21.4 | Planned |
| 1.22.x | Planned |
---

## Project Structure

```
docs
├── architecture
├── development
└── specification

src/main/java
└── io/github/lunamist3941/economicraft
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
    ├── version
    └── platform
```

---

## Documentation

### Architecture

- docs/architecture/ARCHITECTURE.md
- docs/architecture/PACKAGE_STRUCTURE.md
- docs/architecture/MULTI_VERSION.md
- docs/architecture/addons.md

### Specifications

- docs/specification/COIN.md
- docs/specification/MENU.md
- docs/specification/TEAM.md
- docs/specification/BANK.md

### Development

- CODING_RULES.md

---

## Building

Requirements:

- Java 21
- NeoForge 21.1.x
- Gradle 9.x

Build:

```
gradlew build
```

Run Client:

```
gradlew runClient
```

Run Server:

```
gradlew runServer
```

---

## Development Philosophy

EconomiCraft follows these principles:

- Readability over cleverness
- Maintainability over convenience
- Configuration-first development
- Multi-version compatibility
- Modular feature design

---

## AI-Assisted Development

EconomiCraft is developed with assistance from ChatGPT.

AI-generated code, documentation, and suggestions are always reviewed, tested, and approved by the project maintainer before being included in official releases.

Final responsibility for all project content belongs to the maintainer.

---

## Roadmap

Planned milestones:

- Milestone 1 — Foundation
- Milestone 2 — Economy Core
- Milestone 3 — Shop System
- Milestone 4 — Bank System
- Milestone 5 — Auction System
- Milestone 6 — Quest System
- Milestone 7 — Public API
- Milestone 8 — Multi-Version Support

See:

```
docs/development/ROADMAP.md
```

for details.

---

## License

This project is licensed under the MIT License.

See:

```
LICENSE
```

for details.

---

## Author

LunaMist3941

Developer and maintainer of EconomiCraft.