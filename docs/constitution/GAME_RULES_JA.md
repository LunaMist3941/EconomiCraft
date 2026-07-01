# GAME_RULES_JA

Tier: 1（憲法）
Status: Stable
Depends On:
- DESIGN_PHILOSOPHY.md
- DOCS_RULES.md
- UI_GUIDELINES.md

---

# 目的

本ドキュメントは、EconomiCraft におけるゲームデザインおよび経済システムの基本原則を定義します。

Tier 2 以下のすべての文書は、本ルールに従わなければなりません。

例:

- BANK.md
- SHOP.md
- AUCTION.md
- TEAM.md
- NPC.md

本書では以下を定義します。

- 経済思想
- 通貨の挙動
- 銀行システムの原則
- チームシステム
- マーケットルール
- 将来的な拡張互換性

UI の挙動は `UI_GUIDELINES.md` を参照してください。

---

# 1. 経済思想

EconomiCraft は以下の原則に基づいて設計されます。

- 利便性優先
- Vanilla Survival との互換性
- Hypixel SkyBlock を参考にするが再現はしない
- プレイヤー主導の経済
- 持続可能な Coin Sink
- 長期運営を前提とした安定性
- Addon による拡張性

Minecraft 本来の没入感を損なわず、利便性を向上させることを最優先とします。

---

# 2. 通貨ルール

## 2.1 通貨単位

正式な通貨単位は次の通りです。

```text
Coin
````

小数点はサポートしません。

整数のみを使用します。

---

## 2.2 負債システム

EconomiCraft Core は負債をサポートしません。

ルール:

* 所持金は 0 未満にならない
* Shop は十分な所持金が必要
* Auction は十分な所持金が必要
* Bank の利息は正の残高にのみ適用される

高度な金融機能は Core から意図的に除外します。

将来的な実装は以下が担当します。

```text
EconomiCraft MoneyPlus
```

---

## 2.3 管理者による通貨操作

権限を持つ管理者は以下を使用できます。

```text
/coin give <player> <amount>

/coin remove <player> <amount>

/coin history <player>
```

すべての操作は履歴へ記録されなければなりません。

---

# 3. 銀行ルール

## 3.1 利率

デフォルト利率:

```text
3% per cycle
```

複利方式を採用します。

サーバー管理者は Config で変更できます。

---

## 3.2 入出金

対応する選択肢:

```text
ALL
50%
25%
Custom
```

Custom は看板 UI を利用して入力します。

---

## 3.3 履歴

プレイヤーへ表示する履歴:

```text
15件
```

内部保存件数:

```text
150件
```

古いデータは自動的に削除される場合があります。

---

## 3.4 手数料

標準設定:

```text
Deposit Fee: 0%
Withdrawal Fee: 0%
```

将来的に Config による変更を許可します。

---

# 4. チームルール

## 4.1 チーム人数

標準最大人数:

```text
5人
```

この上限は、Hypixel Party の標準最大人数を参考にしています。

---

## 4.2 TeamBank

TeamBank は個人口座とは独立して存在します。

特徴:

* 残高が独立
* 履歴が独立
* 権限が独立

管理権限を持つメンバーのみが操作できます。

---

## 4.3 解散時

チーム解散時:

```text
TeamBank
↓
Owner Bank
```

すべての送金履歴は記録されなければなりません。

---

## 4.4 TeamChat

対応コマンド:

```text
/teamchat

/teamchat <message>
```

従来の Minecraft のチームチャット方式を採用します。

---

## 4.5 Team Members

正式コマンド:

```text
/tm

/team members
```

表示内容:

* オンラインメンバー
* オフラインメンバー

---

## 4.6 TeamColor

採用方針:

```text
Team 名のみ着色
```

プレイヤー名そのものは変更しません。

例:

```text
[Emerald Guild] Player
```

---

# 5. TeamBank ボーナス

公式には 2 種類のモードを提供します。

---

## 5.1 Small Team Mode

計算式:

```text
+3% × 人数
```

例:

```text
1人 = 3%
3人 = 9%
5人 = 15%
```

---

## 5.2 Large Team Mode

計算式:

```text
最初の1人 = +3%
以降 = +1%
```

例:

```text
1人 = 3%
2人 = 4%
3人 = 5%
5人 = 7%
```

Config により切り替え可能です。

---

# 6. Shop ルール

EconomiCraft Shop は Bazaar 方式を採用します。

---

## 6.1 対応アイテム

大量取引向けアイテム:

* ブロック
* 資源
* 農作物
* 一般素材

例:

```text
Cobblestone
Iron
Coal
Wheat
Logs
```

---

## 6.2 非対応アイテム

以下は Shop で扱いません。

* Tool
* Armor
* Rare Item
* Enchanted Book
* Unique Item

これらは Auction の担当です。

---

## 6.3 手数料

標準設定:

```text
Buy Fee: 5%
Sell Fee: 10%
```

Config および管理者コマンドで変更可能です。

---

# 7. Auction ルール

Auction は高価値アイテム向けです。

---

## 7.1 対応アイテム

例:

* Tool
* Armor
* Enchanted Book
* Rare Item
* Custom Equipment

Rare Item の判定は:

```text
Config List
```

によって管理します。

---

## 7.2 販売方式

対応形式:

```text
BIN
Auction
```

出品時に選択します。

---

## 7.3 出品手数料

標準:

```text
2%
```

設定価格を基準に計算します。

---

## 7.4 Wallet

Auction は常に:

```text
Personal Wallet Only
```

を使用します。

TeamBank との連携は行いません。

---

## 7.5 出品上限

チーム人数に応じて増加可能です。

追加メンバーごとに出品枠を増加できます。

---

## 7.6 期限切れ

期限切れアイテムは手動回収です。

保護時間:

```text
2分
```

失敗時:

```text
Listings Storage
```

へ移動します。

---

# 8. NPC ルール

NPC は Core 標準機能です。

Addon として分離しません。

---

## 8.1 操作

会話時:

```text
/menu
```

と同一の UI を開きます。

---

## 8.2 設定

以下で制御します。

* Config
* Profile

RPG サーバーや Hub サーバー向けの調整を可能にします。

---

# 9. 将来拡張

予定中:

```text
EconomiCraft Storage
EconomiCraft TeamPlus
EconomiCraft MoneyPlus
Quest Systems
Mail Systems
Guild Systems
```

Core はこれらとの互換性を維持します。

---

# 10. EconomiCraft MoneyPlus 互換

高度な金融システムは:

```text
EconomiCraft MoneyPlus
```

が担当します。

---

## 10.1 提供予定

例:

* Debt Systems
* Loans
* Taxes
* Government Accounts
* Business Accounts
* Credit Systems
* Automatic Repayment

---

## 10.2 Core の責務

### 汎用 TransactionType

例:

```text
DEPOSIT
WITHDRAW
SHOP_BUY
SHOP_SELL
AUCTION_BUY
AUCTION_SELL

LOAN_RECEIVE
LOAN_REPAY
TAX_PAYMENT
GOVERNMENT_TRANSFER
```

### 汎用 History 構造

推奨項目:

```text
Player
Amount
TransactionType
Source
Target
Timestamp
Metadata
```

### Event Hook

例:

```text
BeforeCoinChangeEvent
CoinChangeEvent
AfterCoinChangeEvent
```

Addon はこれらを利用して機能拡張を行います。

---

# 11. Single Source of Truth

経済定数は必ず一箇所のみで定義します。

例:

* 利率
* チーム人数上限
* Auction 手数料
* Shop 手数料
* History 保存件数

Tier 2 以下は再定義せず参照のみを行います。

---

# 12. 翻訳ポリシー

Tier 1 文書は必ずペアで管理します。

```text
GAME_RULES.md
GAME_RULES_JA.md
```

英語版を正式版とし、日本語版は公式翻訳として同期を維持します。

---

# 13. 参考ポリシー

Hypixel SkyBlock はゲームデザイン上の参考資料として利用できます。

ただし:

* 完全再現は禁止
* Survival への適合を優先
* Vanilla との統合を優先
* 最終判断は独自設計を採用

Hypixel SkyBlock は参考元であり、設計上の義務ではありません。

なお、チーム人数の上限については SkyBlock Coop ではなく、Hypixel Party の標準最大人数を参考としています。

---
