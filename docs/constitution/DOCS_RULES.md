# DOCS_RULES

Tier: 1 (Constitution)
Status: Stable
Depends On:
- DESIGN_PHILOSOPHY.md

---

# Purpose

This document defines the documentation rules, hierarchy, and maintenance policies for the EconomiCraft project.

The goals are:

- Maintain long-term consistency.
- Prevent duplicated specifications.
- Establish clear priorities between documents.
- Enforce the Single Source of Truth principle.
- Simplify future maintenance and expansion.

---

# 1. Document Tier System

Tier 0: Project Foundation

- README.md
- LICENSE
- DESIGN_PHILOSOPHY.md

Tier 1: Constitution

- DOCS_RULES.md
- UI_GUIDELINES.md
- GAME_RULES.md
- ADDONS.md

Tier 2: System Specifications

- BANK.md
- SHOP.md
- AUCTION.md
- TEAM.md
- MENU.md
- NPC.md

Tier 3: Implementation

- COMMANDS.md
- CONFIG.md
- PERMISSIONS.md
- API.md
- DATA_FORMAT.md

Tier 4: Development

- ROADMAP.md
- CHANGELOG.md
- MILESTONES.md
- CONTRIBUTING.md

---

# 2. Document Priority Rules

Lower-tier documents must never override higher-tier documents.

Examples:

BANK.md must follow UI_GUIDELINES.md.

SHOP.md must follow GAME_RULES.md.

Implementation documents must follow system specifications.

---

# 3. Mandatory Header Format

All documents must begin with:

```md
# TITLE

Tier: X (Category)
Status: Draft
Depends On:
- FILE_A.md
- FILE_B.md

---
```

---

# 4. Status Definitions

Draft

Document is under active development.

Review

Document is waiting for approval.

Stable

Document is officially adopted.

Deprecated

Document is no longer maintained.

---

# 5. Naming Conventions

Use uppercase snake-case filenames.

Valid examples:

- GAME_RULES.md
- UI_GUIDELINES.md
- TEAM.md

Invalid examples:

- GameRules.md
- game_rules.md
- TeamSystem.md

---

# 6. Directory Structure

```text
docs/

constitution/
systems/
implementation/
development/
```

---

# 7. Relative Links Only

Always use relative paths.

Example:

```md
See:
- ../constitution/GAME_RULES.md
```

Do not use repository URLs as internal references.

---

# 8. Single Source of Truth

Every rule must exist in exactly one document.

Examples:

Interest Rate
→ GAME_RULES.md

Death Penalty
→ GAME_RULES.md

Back Button Behavior
→ UI_GUIDELINES.md

Other documents should reference the source instead of duplicating information.

---

# 9. RFC Style Changes

Changes to Tier 1 documents require:

Discussion

↓

Agreement

↓

Implementation

Applies to:

- DOCS_RULES.md
- UI_GUIDELINES.md
- GAME_RULES.md
- ADDONS.md

---

# 10. Language and Translation Policy

Tier 1 (Constitution) documents must always provide both English and Japanese versions.

Examples:

- DOCS_RULES.md / DOCS_RULES_JA.md
- UI_GUIDELINES.md / UI_GUIDELINES_JA.md
- GAME_RULES.md / GAME_RULES_JA.md
- ADDONS.md / ADDONS_JA.md

English documents are the canonical source.

Japanese documents are official translations and must be updated together with their English counterparts.

Tier 2 and below do not require Japanese translations.

Japanese versions for lower tiers may be added later if necessary.

---

# 11. Addon Inheritance Rules

Official addons must follow these documentation rules.

Examples:

- EconomiCraft Storage
- EconomiCraft TeamPlus

Addon repositories may extend the rules, but must not violate Tier 1 principles.

---

# 12. Future Expansion

As the project grows, all documents must continue to use:

- Tier
- Status
- Depends On

This ensures that document relationships remain clear and maintainable over time.