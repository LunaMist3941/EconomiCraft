# DOCS_RULES_JA

Tier: 1 (Constitution)
Status: Stable
Depends On:
- DESIGN_PHILOSOPHY.md

---

# 目的

この文書は、EconomiCraft プロジェクトにおける文書管理、階層構造、および保守方針を定義します。

目的:

- 長期的な一貫性を維持する。
- 仕様の重複を防止する。
- 文書間の優先順位を明確化する。
- Single Source of Truth を徹底する。
- 将来的な保守と拡張を容易にする。

---

# 1. 文書階層 (Tier System)

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

# 2. 文書の優先順位

下位Tierの文書は、上位Tierの文書を上書きしてはなりません。

例:

BANK.md は UI_GUIDELINES.md に従う必要があります。

SHOP.md は GAME_RULES.md に従う必要があります。

Implementation 文書は System Specifications に従います。

---

# 3. 必須ヘッダー形式

すべての文書は以下の形式で開始します。

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

# 4. Status 定義

Draft

開発中。

Review

承認待ち。

Stable

正式採用済み。

Deprecated

廃止済み。

---

# 5. 命名規則

ファイル名は大文字スネークケースを使用します。

例:

- GAME_RULES.md
- UI_GUIDELINES.md
- TEAM.md

禁止例:

- GameRules.md
- game_rules.md
- TeamSystem.md

---

# 6. ディレクトリ構成

```text
docs/

constitution/
systems/
implementation/
development/
```

---

# 7. 相対リンクのみ使用

内部参照は必ず相対パスを利用します。

例:

```md
See:
- ../constitution/GAME_RULES.md
```

GitHub URL などを内部参照として使用してはいけません。

---

# 8. Single Source of Truth

1つの仕様は、1つの文書だけに記載します。

例:

Interest Rate
→ GAME_RULES.md

Death Penalty
→ GAME_RULES.md

Back Button Behavior
→ UI_GUIDELINES.md

他の文書では重複記載せず、参照のみを行います。

---

# 9. RFC 形式の変更手順

Tier 1 文書の変更は、

Discussion

↓

Agreement

↓

Implementation

の順で実施します。

対象:

- DOCS_RULES.md
- UI_GUIDELINES.md
- GAME_RULES.md
- ADDONS.md

---

# 10. 言語・翻訳ポリシー

Tier 1 (Constitution) 文書は、英語版と日本語版の両方を必須とします。

例:

- DOCS_RULES.md / DOCS_RULES_JA.md
- UI_GUIDELINES.md / UI_GUIDELINES_JA.md
- GAME_RULES.md / GAME_RULES_JA.md
- ADDONS.md / ADDONS_JA.md

英語版を正本 (Canonical Source) とします。

日本語版は公式翻訳として扱い、英語版と同時に更新しなければなりません。

Tier 2 以下では日本語版は必須ではありません。

必要に応じて後から追加可能です。

---

# 11. アドオン継承ルール

公式アドオンも本ルールに従います。

例:

- EconomiCraft Storage
- EconomiCraft TeamPlus

アドオン側で独自拡張を行うことは可能ですが、Tier 1 の原則を破ってはなりません。

---

# 12. 将来的な拡張

プロジェクトの成長後も、すべての文書は以下を維持します。

- Tier
- Status
- Depends On

これにより、文書間の関係性を長期的に明確に保ちます。