# Git Rules

> Last Updated: 2026-06-30

This document defines the Git workflow and repository management rules for EconomiCraft.

---

# General Principles

Git history should be:

- Readable
- Consistent
- Traceable
- Feature-oriented

Every commit should represent a meaningful change.

---

# Commit Message Format

EconomiCraft uses the following format:

```text
type: description
```

Examples:

```text
feat: add coin item registration

feat: implement shop manager

fix: resolve packet synchronization issue

docs: add architecture documentation

refactor: split config packages

style: format source code

test: add wallet manager tests

chore: update gradle dependencies
```

---

# Commit Types

| Type | Description |
|--------|-------------|
| feat | New feature |
| fix | Bug fix |
| docs | Documentation |
| refactor | Code restructuring |
| style | Formatting only |
| test | Tests |
| chore | Maintenance |
| perf | Performance improvements |
| build | Build system changes |
| ci | Continuous integration |

---

# Commit Rules

## One Feature Per Commit

Good:

```text
feat: add coin item
```

Bad:

```text
feat: add coin item and bank system
```

---

## Avoid Mixed Changes

Do not combine:

- Refactoring
- Bug fixes
- Features

inside a single commit.

---

# Branch Strategy

Current workflow:

```text
main
```

Future workflow:

```text
main
develop

feature/shop-system
feature/bank-system
feature/auction-system

hotfix/critical-bug
```

---

# Branch Rules

## main

Stable releases only.

---

## develop

Integration branch.

---

## feature/*

One feature per branch.

Examples:

```text
feature/coin-item

feature/shop-gui

feature/economy-api
```

---

## hotfix/*

Critical fixes.

Examples:

```text
hotfix/save-data-corruption

hotfix/network-crash
```

---

# Pull Requests

Future requirements:

- Documentation updated
- Config added
- Tests implemented
- Code reviewed

---

# Documentation First

When changing architecture:

```text
Update Docs
        ↓
Implement Code
        ↓
Commit Changes
```

Documentation should always reflect the current state of the project.

---

# Release Tags

Format:

```text
vMAJOR.MINOR.PATCH
```

Examples:

```text
v0.1.0

v0.2.0

v1.0.0
```

---

# Version Meaning

## MAJOR

Breaking changes.

Examples:

- API redesign
- Save format changes

---

## MINOR

New features.

Examples:

- Shop system
- Bank system

---

## PATCH

Bug fixes.

Examples:

- Crash fixes
- UI corrections

---

# Milestone Tags

Optional milestone tags:

```text
milestone-1

milestone-2

milestone-3
```

Examples:

```bash
git tag milestone-1
```

---

# Changelog Rules

Every release must update:

```text
docs/development/CHANGELOG.md
```

Format:

```text
Added
Changed
Fixed
Removed
```

---

# Ignore Rules

Generated files must not be committed.

Examples:

```text
/build
/.gradle
/run
/out
```

---

# Large Files

Do not commit:

- Generated assets
- Temporary files
- Build outputs

Use Git LFS if necessary.

---

# AI-Assisted Development

Commits generated with AI assistance must still be:

- Reviewed
- Tested
- Understood by the maintainer

AI suggestions are not automatically accepted.

Final responsibility belongs to the project maintainer.

---

# Final Principle

> Git history should tell the story of the project.

Every commit should explain:

- What changed
- Why it changed
- Which feature it belongs to